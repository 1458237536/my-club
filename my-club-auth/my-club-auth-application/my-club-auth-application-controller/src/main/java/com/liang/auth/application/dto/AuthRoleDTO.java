package com.liang.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色dto
 *
 * @author: ChickenWing
 * @date: 2023/11/2
 */
@Data
public class AuthRoleDTO implements Serializable {

    /**
     * 编号
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色密钥
     */
    private String roleKey;

}

