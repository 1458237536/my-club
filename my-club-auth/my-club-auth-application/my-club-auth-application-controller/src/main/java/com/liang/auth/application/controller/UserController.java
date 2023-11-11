package com.liang.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liang.auth.application.convert.AuthUserDTOConverter;
import com.liang.auth.application.dto.AuthUserDTO;
import com.liang.auth.application.validator.AuthUserValidator;
import com.liang.auth.entity.AuthUserBO;
import com.liang.auth.entity.Result;
import com.liang.auth.service.AuthUserDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author yzy
 * @date 2023/10/29
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * 身份验证用户验证器
     */
    private final AuthUserValidator authUserValidator = new AuthUserValidator();

    /**
     * 用户领域服务
     */
    @Resource
    private AuthUserDomainService authUserDomainService;


    /**
     * 注册用户
     */
    @RequestMapping("/register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto：{}", JSON.toJSONString(authUserDTO));
            }

            // 数据校验
            authUserValidator.checkUserInfo(authUserDTO);

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("UserController.register.error:{}",e.getMessage(),e);
            return Result.fail("注册用户失败");
        }
    }

    /**
     * 更新用户
     */
    @RequestMapping("/update")
    public Result<Boolean> update(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto：{}", JSON.toJSONString(authUserDTO));
            }
            // 数据校验
            authUserValidator.checkUserInfo(authUserDTO);

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.update.error:{}",e.getMessage(),e);
            return Result.fail("用户信息更新失败");
        }
    }

    /**
     * 逻辑删除用户
     */
    @RequestMapping("/delete")
    public Result<Boolean> delete(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.delete.dto：{}", JSON.toJSONString(authUserDTO));
            }

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);

            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.delete.error:{}",e.getMessage(),e);
            return Result.fail("删除用户信息失败");
        }
    }

    /**
     * 用户启用/禁用
     */
    @RequestMapping("changeStatus")
    public Result<Boolean> changeStatus(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.changeStatus.dto:{}", JSON.toJSONString(authUserDTO));
            }
            Preconditions.checkNotNull(authUserDTO.getStatus(), "用户状态不能为空");
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.changeStatus.error:{}", e.getMessage(), e);
            return Result.fail("启用/禁用用户信息失败");
        }
    }

    @RequestMapping("/doLogin")
    public SaResult login(String username, String password) {
        // 模拟登录
        if ("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login("鸡翅");
            // 获取toKen
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        return SaResult.error();
    }

    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }
}
