package com.liang.auth.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.auth.basic.entity.AuthRole;

/**
 * 权限模块-角色表(AuthRole)表服务接口
 *
 * @author yzy
 * @since 2023-11-04 00:22:36
 */
public interface AuthRoleService extends IService<AuthRole> {

    /**
     * 按条件查询
     *
     * @param authRole 身份验证角色
     * @return 结果
     */
    AuthRole queryByCondition(AuthRole authRole);
}

