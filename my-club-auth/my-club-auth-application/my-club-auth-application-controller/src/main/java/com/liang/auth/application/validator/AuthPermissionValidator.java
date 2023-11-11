package com.liang.auth.application.validator;

import com.google.common.base.Preconditions;
import com.liang.auth.application.dto.AuthPermissionDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * 权限验证器
 *
 * @author yzy
 * @date 2023/11/04
 */
public class AuthPermissionValidator {
    public void validateAuthPermissionAdd(AuthPermissionDTO authPermissionDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authPermissionDTO.getName()), "权限名称不能为空");
        Preconditions.checkNotNull(authPermissionDTO.getParentId(), "权限父id不能为空");
    }

    public void validateAuthPermissionUpdate(AuthPermissionDTO authPermissionDTO) {
        Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
    }

    public void validateAuthPermissionDelete(AuthPermissionDTO authPermissionDTO) {
        Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
    }
}
