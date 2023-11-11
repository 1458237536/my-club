package com.liang.auth.service;

import com.liang.auth.entity.AuthPermissionBO;

/**
 * 权限领域服务
 *
 * @author yzy
 * @date 2023/11/04
 */
public interface AuthPermissionDomainService {

    /**
     * 新增权限
     *
     * @param authPermissionBO auth 权限 bo
     * @return 结果
     */
    Boolean add(AuthPermissionBO authPermissionBO);

    /**
     * 更新权限
     *
     * @param authPermissionBO auth 权限 bo
     * @return 结果
     */
    Boolean update(AuthPermissionBO authPermissionBO);

    /**
     * 删除权限
     *
     * @param authPermissionBO auth 权限 bo
     * @return 结果
     */
    Boolean delete(AuthPermissionBO authPermissionBO);
}
