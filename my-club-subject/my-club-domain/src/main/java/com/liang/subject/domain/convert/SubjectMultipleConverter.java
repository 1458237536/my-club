package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.infra.basic.entity.SubjectJudge;
import com.liang.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectMultipleConverter {

    SubjectMultipleConverter INSTANCE = Mappers.getMapper(SubjectMultipleConverter.class);

    SubjectMultiple convertBOToEntity(SubjectAnswerBO SubjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBO(List<SubjectMultiple> subjectMultipleList);

}
