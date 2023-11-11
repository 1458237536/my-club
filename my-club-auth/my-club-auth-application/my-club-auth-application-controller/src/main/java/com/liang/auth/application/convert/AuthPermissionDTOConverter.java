package com.liang.auth.application.convert;


import com.liang.auth.application.dto.AuthPermissionDTO;
import com.liang.auth.application.dto.AuthRolePermissionDTO;
import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限dto转换器
 * 
 * @author: ChickenWing
 * @date: 2023/10/8
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);
    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);



}
