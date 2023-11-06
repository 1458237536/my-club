package com.liang.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2023-10-21 18:09:55
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = 939550073002058721L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 类别编号
     */
    private Long categoryId;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

}

