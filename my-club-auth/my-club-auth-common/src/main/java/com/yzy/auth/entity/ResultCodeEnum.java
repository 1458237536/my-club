package com.yzy.auth.entity;

import lombok.Getter;

/**
 * code枚举
 * 
 * @author: ChickenWing
 * @date: 2023/10/28
 */
@Getter
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 失败
     */
    FAIL(500,"失败");

    /**
     * 编码
     */
    public int code;

    /**
     * DESC
     */
    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
