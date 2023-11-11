package com.yzy.auth.enums;

import lombok.Getter;


/**
 * 删除状态枚举
 *
 * @author yzy
 * @date 2023/10/07
 */
@Getter
public enum IsDeletedFlagEnum {

    /**
     * 已删除
     */
    DELETED(1,"已删除"),

    /**
     * 未删除
     */
    UN_DELETED(0,"未删除");

    public int code;

    public String desc;


    IsDeletedFlagEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
