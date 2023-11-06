package com.liang.subject.domain.service;

import com.liang.subject.common.entity.PageResult;
import com.liang.subject.domain.entity.SubjectInfoBO;

public interface SubjectInfoDomainService {
    void add(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
