package com.yzy.auth.enums;

import lombok.Getter;

/**
 * 用户状态枚举
 * 
 * @author: ChickenWing
 * @date: 2023/10/3
 */
@Getter
public enum AuthUserStatusEnum {

    /**
     * 启用
     */
    OPEN(0,"启用"),
    /**
     * 禁用
     */
    CLOSE(1,"禁用");

    public int code;


    public String desc;

    AuthUserStatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static AuthUserStatusEnum getByCode(int codeVal){
        for(AuthUserStatusEnum resultCodeEnum : AuthUserStatusEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
