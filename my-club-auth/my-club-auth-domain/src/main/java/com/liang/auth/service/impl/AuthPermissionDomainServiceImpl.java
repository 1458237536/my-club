package com.liang.auth.service.impl;

import com.liang.auth.basic.service.AuthPermissionService;
import com.liang.auth.convert.AuthPermissionBOConverter;
import com.liang.auth.basic.entity.AuthPermission;
import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.enums.IsDeletedFlagEnum;
import com.liang.auth.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限领域服务实现类
 *
 * @author yzy
 * @date 2023/11/04
 */
@Service
@Slf4j
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    /**
     * 权限服务
     */
    @Resource
    private AuthPermissionService authPermissionService;

    /**
     * 新增权限
     */
    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        return authPermissionService.save(authPermission);
    }

    /**
     * 更新权限
     */
    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        return authPermission.updateById();
    }

    /**
     * 删除权限
     * 使用逻辑删除
     */
    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setId(authPermissionBO.getId());
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return authPermission.updateById();
    }
}
