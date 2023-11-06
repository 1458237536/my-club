package com.liang.subject.domain.handler.subject;

import com.liang.subject.common.enums.SubjectInfoTypeEnum;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 故举身份的识别
     *
     * @return {@link SubjectInfoTypeEnum}
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 笑际的题目的插入
     *
     * @param subjectInfoBO 题目信息
     */
    void add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO query(Long subjectId);
}
