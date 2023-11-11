package com.liang.auth.basic.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.auth.basic.entity.AuthRolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * 权限模块-角色权限关联表(AuthRolePermission)表数据库访问层
 *
 * @author yzy
 * @since 2023-11-04 00:26:46
 */
public interface AuthRolePermissionDao extends BaseMapper<AuthRolePermission> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthRolePermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AuthRolePermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthRolePermission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthRolePermission> entities);

    /**
     * 查询指定行数据
     *
     * @param authRolePermission 查询条件
     * @return 结果
     */
    List<AuthRolePermission> queryAllByLimit(AuthRolePermission authRolePermission);
}

