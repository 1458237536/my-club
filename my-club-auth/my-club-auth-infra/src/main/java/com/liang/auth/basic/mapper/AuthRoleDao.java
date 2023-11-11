package com.liang.auth.basic.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.auth.basic.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

/**
 * 权限模块-角色表(AuthRole)表数据库访问层
 *
 * @author yzy
 * @since 2023-11-04 00:22:34
 */
public interface AuthRoleDao extends BaseMapper<AuthRole> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<AuthRole> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<AuthRole> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<AuthRole> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<AuthRole> entities);

    /**
     * 按条件查询
     *
     * @param authRole 身份验证角色
     * @return 结果
     */
    AuthRole queryAllByLimit(AuthRole authRole);
}

