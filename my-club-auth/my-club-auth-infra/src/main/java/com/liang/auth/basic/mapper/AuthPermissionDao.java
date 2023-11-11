package com.liang.auth.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.auth.basic.entity.AuthPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限模块-权限表(AuthPermission)表数据库访问层
 *
 * @author yzy
 * @since 2023-11-04 00:23:28
 */
public interface AuthPermissionDao extends BaseMapper<AuthPermission> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthPermission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AuthPermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthPermission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthPermission> entities);

}

