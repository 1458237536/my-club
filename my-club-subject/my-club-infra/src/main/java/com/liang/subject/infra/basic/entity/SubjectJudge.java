package com.liang.subject.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 判断题(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2023-10-24 11:38:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = 841346798162428997L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 是否正确
     */
    private Integer isCorrect;
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

