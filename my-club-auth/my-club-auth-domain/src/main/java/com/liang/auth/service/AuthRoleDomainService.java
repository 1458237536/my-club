package com.liang.auth.service;

import com.liang.auth.entity.AuthRoleBO;

/**
 * 角色领域服务
 *
 * @author yzy
 * @date 2023/11/04
 */
public interface AuthRoleDomainService {
    /**
     * 新增角色
     *
     * @param authRoleBO 身份验证角色 bo
     * @return 结果
     */
    Boolean add(AuthRoleBO authRoleBO);

    /**
     * 更新角色
     *
     * @param authRoleBO 身份验证角色 bo
     * @return 结果
     */
    Boolean update(AuthRoleBO authRoleBO);

    /**
     * 删除角色
     *
     * @param authRoleBO 身份验证角色 bo
     * @return {@code Boolean}
     */
    Boolean delete(AuthRoleBO authRoleBO);
}
