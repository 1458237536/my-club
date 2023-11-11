package com.liang.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.liang.auth.entity.AuthUserBO;

/**
 * 用户领域服务
 *
 * @author yzy
 * @date 2023/11/04
 */
public interface AuthUserDomainService {

    /**
     * 用户注册
     *
     * @param authUserBO 用户 bo
     * @return 结果
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     *
     * @param authUserBO 用户 bo
     * @return 结果
     */
    Boolean update(AuthUserBO authUserBO);

    /**
     * 登录
     *
     * @param validCode 验证码
     * @return 结果
     */
    SaTokenInfo doLogin(String validCode);
}
