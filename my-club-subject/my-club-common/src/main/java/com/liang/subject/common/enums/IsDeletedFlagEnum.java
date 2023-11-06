package com.liang.subject.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 *
 * @author 梁海彪
 * @date 2023/10/21
 */
@Getter
public enum IsDeletedFlagEnum {

    DELETE(1, "已删除"),
    UN_DELETE(0, "未删除");


    public int code;
    public String desc;

    IsDeletedFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal) {
        for (IsDeletedFlagEnum isDeletedFlagEnum : IsDeletedFlagEnum.values())
            if (isDeletedFlagEnum.code == codeVal) {

                return isDeletedFlagEnum;
            }
        return null;
    }
}
