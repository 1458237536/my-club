package com.liang.auth.service;

import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.entity.AuthRolePermissionBO;

/**
 * 角色权限领域服务
 *
 * @author yzy
 * @date 2023/11/04
 */
public interface AuthRolePermissionDomainService {

    /**
     * 新增角色权限关联关系
     *
     * @param authPermissionBO auth 权限 bo
     * @return 结果
     */
    Boolean add(AuthRolePermissionBO authPermissionBO);
}
