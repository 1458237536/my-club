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
public class SubjectInfoBO extends PageInfo implements Serializable {
    private static final long serialVersionUID = -71258391934740978L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 分类id
     */
    private List<Integer> categoryIds;

    /**
     * 标签id
     */
    private List<Integer> labelIds;
    /**
     * 标签名称
     */
    private List<String> labelName;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;

    private Long categoryId;

    private Long labelId;

}

