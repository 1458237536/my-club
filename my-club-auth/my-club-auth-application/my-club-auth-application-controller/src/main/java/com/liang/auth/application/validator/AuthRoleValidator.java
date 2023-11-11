package com.liang.auth.application.validator;

import com.google.common.base.Preconditions;
import com.liang.auth.application.dto.AuthRoleDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * 角色验证
 *
 * @author yzy
 * @date 2023/11/04
 */
public class AuthRoleValidator {

    /**
     * 验证角色添加
     */
    public void validateRoleAdd(AuthRoleDTO authRoleDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authRoleDTO.getRoleKey()), "角色key不能为空");
        Preconditions.checkArgument(!StringUtils.isBlank(authRoleDTO.getRoleName()), "角色名称不能为空");
    }

    /**
     * 验证角色更新
     */
    public void validateRoleUpdate(AuthRoleDTO authRoleDTO) {
        Preconditions.checkNotNull(authRoleDTO.getId(), "角色id不能为空");
    }
}
