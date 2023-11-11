package com.liang.auth.application.dto;

import lombok.Data;

/**
 * auth 角色权限 dto
 *
 * @author yzy
 * @date 2023/11/04
 */
@Data
public class AuthRolePermissionDTO {

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
