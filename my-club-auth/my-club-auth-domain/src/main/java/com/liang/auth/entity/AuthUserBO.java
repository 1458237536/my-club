package com.liang.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用戶信息dto
 *
 * @author: ChickenWing
 * @date: 2023/11/1
 */
@Data
public class AuthUserBO implements Serializable {

    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态 0启动 1禁用
     */
    private Integer status;

    /**
     * 个人介绍
     */
    private String introduce;

    /**
     * 特殊字段 json
     */
    private String extJson;

}

