package com.liang.auth.application.convert;

import com.liang.auth.application.dto.AuthRoleDTO;
import com.liang.auth.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色dto转换器
 * 
 * @author: ChickenWing
 * @date: 2023/10/8
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

}
