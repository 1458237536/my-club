package com.liang.auth.basic.entity;


import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限模块-角色表(AuthRole)表实体类
 *
 * @author yzy
 * @since 2023-11-04 00:22:34
 */
@SuppressWarnings("serial")
@Data
public class AuthRole extends Model<AuthRole> {
    /**
    * 主键
    */
    private Long id;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色唯一标识
    */
    private String roleKey;

    /**
    * 角色状态 0启动 1禁用
    */
    private String status;

    /**
    * 1 符合部门权限的所有数据 2本部门
    */
    private String dataRange;

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
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

