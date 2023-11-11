package com.liang.auth.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.auth.basic.entity.AuthPermission;
import com.liang.auth.basic.mapper.AuthPermissionDao;
import com.liang.auth.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限模块-权限表(AuthPermission)表服务实现类
 *
 * @author yzy
 * @since 2023-11-04 00:23:28
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionDao, AuthPermission> implements AuthPermissionService {

}

