package com.liang.auth.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.liang.auth.basic.entity.*;
import com.liang.auth.basic.service.*;
import com.liang.auth.constants.AuthConstant;
import com.liang.auth.convert.AuthUserBOConverter;
import com.liang.auth.entity.AuthUserBO;
import com.liang.auth.enums.AuthUserStatusEnum;
import com.liang.auth.enums.IsDeletedFlagEnum;
import com.liang.auth.redis.RedisUtil;
import com.liang.auth.service.AuthUserDomainService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户领域服务实现类
 *
 * @author yzy
 * @date 2023/11/04
 */
@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    /**
     * 用户服务
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * 用户角色服务
     */
    @Resource
    private AuthUserRoleService authUserRoleService;

    /**
     * 角色服务
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 权限服务
     */
    @Resource
    private AuthPermissionService authPermissionService;

    /**
     * 角色权限服务
     */
    @Resource
    private AuthRolePermissionService authRolePermissionService;

    /**
     * Redis 工具类
     */
    @Resource
    private RedisUtil redisUtil;

    /**
     * 身份验证权限前缀
     */
    private final String authPermissionPrefix = "auth.permission";

    /**
     * 身份验证角色前缀
     */
    private final String authRolePrefix = "auth.role";

    /**
     * 加盐
     */
    private final String salt = "yzy";


    /**
     * 登录前缀
     */
    private static final String LOGIN_PREFIX = "loginCode";

    /**
     * 注册用户 用户密码需要使用 MD5 加密和加盐
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {

        // 用户
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        // 密码 加密 加盐
        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        boolean count = authUserService.save(authUser);

        // 角色
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);

        // 用户角色关联
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(authUser.getId());
        authUserRole.setRoleId(roleResult.getId());
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.save(authUserRole);

        // 角色缓存
        cacheRoleToRedis(authUser, roleResult);

        // 权限缓存
        cachePermissionToRedis(roleResult, authUser);

        return count;
    }

    private void cachePermissionToRedis(AuthRole roleResult, AuthUser authUser) {
        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(roleResult.getId());
        authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        // 根据roleId查权限
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.queryByCondition(authRolePermission);
        List<String> permissionIdList = rolePermissionList.stream()
                .map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        List<AuthPermission> authPermissions = authPermissionService.listByIds(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey,new Gson().toJson(authPermissions));
    }

    private void cacheRoleToRedis(AuthUser authUser, AuthRole roleResult) {
        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(roleResult);
        redisUtil.set(roleKey, new Gson().toJson(roleList));
    }


    /**
     * 更新用户
     */
    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        return authUserService.updateById(authUser);
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        return StpUtil.getTokenInfo();
    }
}
