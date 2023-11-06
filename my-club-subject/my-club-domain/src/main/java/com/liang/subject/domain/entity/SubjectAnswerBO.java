package com.liang.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 题目答案DTO
 *
 * @author makejava
 * @since 2023-10-24 11:37:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectAnswerBO implements Serializable {
    private static final long serialVersionUID = -71258391934740978L;
    /**
     * 答案选项
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;


}

