package com.liang.subject.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 简答题(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2023-10-24 11:38:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = -22682086190850975L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;

}

