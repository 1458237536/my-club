package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectBriefConverter {

    SubjectBriefConverter INSTANCE = Mappers.getMapper(SubjectBriefConverter.class);

    SubjectBrief convertBOToEntity(SubjectInfoBO subjectInfoBO);

}
