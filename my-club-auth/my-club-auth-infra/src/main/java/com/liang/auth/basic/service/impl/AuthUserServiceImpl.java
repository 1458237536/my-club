package com.liang.auth.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.auth.basic.mapper.AuthUserDao;
import com.liang.auth.basic.entity.AuthUser;
import com.liang.auth.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限模块-用户信息表(AuthUser)表服务实现类
 *
 * @author yzy
 * @since 2023-11-03 23:15:53
 */
@Service("authUserService")
public class AuthUserServiceImpl extends ServiceImpl<AuthUserDao, AuthUser> implements AuthUserService {

    @Resource
    private AuthUserDao authUserDao;

}

