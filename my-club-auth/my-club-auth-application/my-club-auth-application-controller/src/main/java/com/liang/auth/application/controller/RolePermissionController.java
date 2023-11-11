package com.liang.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.liang.auth.application.convert.AuthPermissionDTOConverter;
import com.liang.auth.application.dto.AuthPermissionDTO;
import com.liang.auth.application.dto.AuthRolePermissionDTO;
import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.entity.AuthRolePermissionBO;
import com.liang.auth.entity.Result;
import com.liang.auth.service.AuthRolePermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色权限Controller
 *
 * @author yzy
 * @date 2023/11/04
 */
@RequestMapping("/rolePermission")
@RestController
@Slf4j
public class RolePermissionController {

    /**
     * 角色权限领域服务
     */
    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;

    /**
     * 新增角色权限关联关系
     */
    @RequestMapping("/add")
    public Result<Boolean> add(@RequestBody AuthRolePermissionDTO authRolePermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RolePermissionController.add.dto:{}", JSON.toJSONString(authRolePermissionDTO));
            }

            AuthRolePermissionBO authRolePermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authRolePermissionDTO);

            return Result.ok(authRolePermissionDomainService.add(authRolePermissionBO));
        } catch (Exception e) {
            log.error("RolePermissionController.add.error:{}", e.getMessage(),e);
            return Result.fail("新增角色失败");
        }
    }


}
