package com.liang.auth.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.auth.basic.entity.AuthRolePermission;
import com.liang.auth.basic.mapper.AuthRolePermissionDao;
import com.liang.auth.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限模块-角色权限关联表(AuthRolePermission)表服务实现类
 *
 * @author yzy
 * @since 2023-11-04 00:26:50
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl extends ServiceImpl<AuthRolePermissionDao, AuthRolePermission> implements AuthRolePermissionService {

    /**
     * auth 角色权限 dao
     */
    @Resource
    private AuthRolePermissionDao authRolePermissionDao;


    /**
     * 按条件查询
     */
    @Override
    public List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission) {
        return authRolePermissionDao.queryAllByLimit(authRolePermission);
    }
}

