package com.liang.auth.service.impl;

import com.liang.auth.basic.entity.AuthRole;
import com.liang.auth.basic.service.AuthRoleService;
import com.liang.auth.convert.AuthRoleBOConverter;
import com.liang.auth.entity.AuthRoleBO;
import com.liang.auth.enums.IsDeletedFlagEnum;
import com.liang.auth.service.AuthRoleDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色领域服务实现类
 *
 * @author yzy
 * @date 2023/11/04
 */
@Service
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    /**
     * 角色服务
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 新增角色
     */
    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        return authRoleService.save(authRole);
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        return authRole.updateById();
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return authRole.updateById();
    }
}
