package com.liang.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.liang.auth.application.convert.AuthRoleDTOConverter;
import com.liang.auth.application.dto.AuthRoleDTO;
import com.liang.auth.application.validator.AuthRoleValidator;
import com.liang.auth.entity.AuthRoleBO;
import com.liang.auth.entity.Result;
import com.liang.auth.service.AuthRoleDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色Controller
 *
 * @author yzy
 * @date 2023/11/04
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    /**
     * 角色领域服务
     */
    @Resource
    private AuthRoleDomainService authRoleDomainService;

    private final AuthRoleValidator authRoleValidator = new AuthRoleValidator();

    @RequestMapping("/add")
    public Result<Boolean> add(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.add.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            authRoleValidator.validateRoleAdd(authRoleDTO);

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);

            return Result.ok(authRoleDomainService.add(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.add.error:{}", e.getMessage(),e);
            return Result.fail("新增角色失败");
        }

    }

    @RequestMapping("/update")
    public Result<Boolean> update(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.update.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            authRoleValidator.validateRoleUpdate(authRoleDTO);

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);

            return Result.ok(authRoleDomainService.update(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.update.error:{}", e.getMessage(),e);
            return Result.fail("修改角色失败");
        }

    }

    @RequestMapping("/delete")
    public Result<Boolean> delete(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.delete.dto:{}", JSON.toJSONString(authRoleDTO));
            }
            authRoleValidator.validateRoleUpdate(authRoleDTO);

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);

            return Result.ok(authRoleDomainService.delete(authRoleBO));
        } catch (Exception e) {
            log.error("RoleController.delete.error:{}", e.getMessage(),e);
            return Result.fail("修改角色失败");
        }

    }
}
