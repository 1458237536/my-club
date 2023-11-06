package com.liang.subject.common.enums;

/**
 * 题目类型枚举
 * 1单选 2多选 3判断 4简答
 *
 * @author 梁海彪
 * @date 2023/10/25
 */
public enum SubjectInfoTypeEnum {

    RADIO(1, "单选"),

    MULTIPLE(2, "多选"),

    JUDGE(3, "判断"),

    BRIEF(4, "简答");

    public Integer code;
    public String desc;

    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal) {
        for (SubjectInfoTypeEnum subjectInfoTypeEnum : SubjectInfoTypeEnum.values())
            if (subjectInfoTypeEnum.code == codeVal) {
                return subjectInfoTypeEnum;
            }
        return null;
    }
}
