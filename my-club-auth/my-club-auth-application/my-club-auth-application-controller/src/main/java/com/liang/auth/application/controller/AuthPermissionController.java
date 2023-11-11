package com.liang.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.liang.auth.application.convert.AuthPermissionDTOConverter;
import com.liang.auth.application.dto.AuthPermissionDTO;
import com.liang.auth.application.validator.AuthPermissionValidator;
import com.liang.auth.entity.AuthPermissionBO;
import com.liang.auth.entity.Result;
import com.liang.auth.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限Controller
 *
 * @author yzy
 * @date 2023/11/04
 */
@RestController
@RequestMapping("/permission")
@Slf4j
public class AuthPermissionController {

    private final AuthPermissionValidator authPermissionValidator = new AuthPermissionValidator();

    /**
     * 权限领域服务
     */
    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    @RequestMapping("/add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.add.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            authPermissionValidator.validateAuthPermissionAdd(authPermissionDTO);

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            return Result.ok(authPermissionDomainService.add(authPermissionBO));
        } catch (Exception e) {
            log.error("AuthPermissionController.add.error:{}", e.getMessage(),e);
            return Result.fail("新增角色失败");
        }
    }

    @RequestMapping("/update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.update.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            authPermissionValidator.validateAuthPermissionUpdate(authPermissionDTO);

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            return Result.ok(authPermissionDomainService.update(authPermissionBO));
        } catch (Exception e) {
            log.error("AuthPermissionController.update.error:{}", e.getMessage(),e);
            return Result.fail("新增角色失败");
        }
    }

    @RequestMapping("/delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("AuthPermissionController.delete.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            authPermissionValidator.validateAuthPermissionDelete(authPermissionDTO);

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);

            return Result.ok(authPermissionDomainService.delete(authPermissionBO));
        } catch (Exception e) {
            log.error("AuthPermissionController.delete.error:{}", e.getMessage(),e);
            return Result.fail("新增角色失败");
        }
    }

}
