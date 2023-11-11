package com.liang.auth.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liang.auth.basic.entity.AuthRolePermission;
import com.liang.auth.basic.mapper.AuthRolePermissionDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限模块-角色权限关联表(AuthRolePermission)表服务接口
 *
 * @author yzy
 * @since 2023-11-04 00:26:49
 */
public interface AuthRolePermissionService extends IService<AuthRolePermission> {

    /**
     * 按条件查询
     *
     * @param authRolePermission 角色权限实体
     * @return 结果
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);
}

