package com.liang.auth.application.dto;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * 权限dto
 * 
 * @author: yzy
 * @date: 2023/11/3
 */
@Data
public class AuthPermissionDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父 ID
     */
    private Long parentId;

    /**
     * 权限类型 0菜单 1操作
     */
    private Integer type;

    /**
     * 菜单 URL
     */
    private String menuUrl;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 展示状态 0展示 1隐藏
     */
    private Integer showStatus;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限密钥
     */
    private String permissionKey;
}

