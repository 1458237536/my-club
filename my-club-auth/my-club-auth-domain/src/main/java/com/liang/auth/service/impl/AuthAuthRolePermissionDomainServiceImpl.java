package com.liang.auth.service.impl;

import com.liang.auth.basic.service.AuthRolePermissionService;
import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.entity.AuthRolePermissionBO;
import com.liang.auth.service.AuthRolePermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色权限领域服务实现类
 *
 * @author yzy
 * @date 2023/11/04
 */
@Service
@Slf4j
public class AuthAuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    /**
     * 角色权限服务
     */
    @Resource
    private AuthRolePermissionService authRolePermissionService;

    /**
     * 新增角色权限关联关系
     */
    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        return null;
    }
}
