package com.liang.auth.entity;

import lombok.Data;

/**
 * auth 角色权限 bo
 *
 * @author yzy
 * @date 2023/11/04
 */
@Data
public class AuthRolePermissionBO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;
}
