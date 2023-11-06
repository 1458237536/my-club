package com.liang.subject.domain.entity;

import com.liang.subject.common.entity.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息DTO
 *
 * @author makejava
 * @since 2023-10-24 11:37:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOptionBO extends PageInfo implements Serializable {
    /**
     * 题目答案
     */
    private String subjectAnswer;


    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;

}

