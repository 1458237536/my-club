package com.liang.auth.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.auth.basic.entity.AuthRole;
import com.liang.auth.basic.mapper.AuthRoleDao;
import com.liang.auth.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限模块-角色表(AuthRole)表服务实现类
 *
 * @author yzy
 * @since 2023-11-04 00:22:36
 */
@Service("authRoleService")
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleDao, AuthRole> implements AuthRoleService {

    /**
     * 身份验证角色 DAO
     */
    @Resource
    private AuthRoleDao authRoleDao;

    @Override
    public AuthRole queryByCondition(AuthRole authRole) {
        return authRoleDao.queryAllByLimit(authRole);
    }
}

