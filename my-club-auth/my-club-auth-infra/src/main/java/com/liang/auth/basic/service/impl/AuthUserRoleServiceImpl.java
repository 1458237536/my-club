package com.liang.auth.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liang.auth.basic.entity.AuthUserRole;
import com.liang.auth.basic.mapper.AuthUserRoleDao;
import com.liang.auth.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 权限模块-用户角色关联表(AuthUserRole)表服务实现类
 *
 * @author yzy
 * @since 2023-11-04 00:26:46
 */
@Service("authUserRoleService")
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleDao, AuthUserRole> implements AuthUserRoleService {

}

