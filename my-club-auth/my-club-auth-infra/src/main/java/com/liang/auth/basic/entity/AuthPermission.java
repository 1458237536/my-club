package com.liang.auth.basic.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限模块-权限表(AuthPermission)表实体类
 *
 * @author yzy
 * @since 2023-11-04 00:23:28
 */
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
@Data
public class AuthPermission extends Model<AuthPermission> {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 权限类型 0菜单 1操作
     */
    private String type;

    /**
     * 菜单路由
     */
    private String menuUrl;

    /**
     * 状态 0启动 1禁用
     */
    private String status;

    /**
     * 展示状态 0展示 1隐藏
     */
    private String showStatus;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限唯一标识
     */
    private String permissionKey;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除 0未删除 1已删除
     */
    private Integer isDeleted;


    /**
     * 获取主键值
     *
     * @return 主键值
     */

}

