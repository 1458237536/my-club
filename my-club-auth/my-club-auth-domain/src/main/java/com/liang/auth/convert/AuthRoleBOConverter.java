package com.liang.auth.convert;

import com.liang.auth.basic.entity.AuthRole;
import com.liang.auth.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色bo转换器
 *
 * @author yzy
 * @date 2023/11/04
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    /**
     * bo 转 实体类
     *
     * @param authRoleBO 角色 bo
     * @return 结果
     */
    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
