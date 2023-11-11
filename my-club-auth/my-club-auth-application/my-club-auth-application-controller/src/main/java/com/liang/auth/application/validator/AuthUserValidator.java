package com.liang.auth.application.validator;

import com.google.common.base.Preconditions;
import com.liang.auth.application.dto.AuthUserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户验证器
 *
 * @author yzy
 * @date 2023/11/03
 */
public class AuthUserValidator {

    /**
     * 查看用户信息
     *
     * @param authUserDTO auth 用户 dto
     */
    public void checkUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getEmail()), "邮件地址不能为空");
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getPassword()), "密码不能为空");
    }

    public void validateUserAdd(@RequestBody AuthUserDTO authUserDTO) {

    }


}
