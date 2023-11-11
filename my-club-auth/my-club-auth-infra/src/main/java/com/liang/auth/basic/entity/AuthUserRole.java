package com.liang.auth.basic.entity;


import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限模块-用户角色关联表(AuthUserRole)表实体类
 *
 * @author yzy
 * @since 2023-11-04 00:26:45
 */
@SuppressWarnings("serial")
@Data
public class AuthUserRole extends Model<AuthUserRole> {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createTime;

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
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

