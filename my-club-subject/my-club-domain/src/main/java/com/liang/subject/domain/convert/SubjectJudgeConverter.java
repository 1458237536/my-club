package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectOptionBO;
import com.liang.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectJudgeConverter {

    SubjectJudgeConverter INSTANCE = Mappers.getMapper(SubjectJudgeConverter.class);

    SubjectJudge convertBOToEntity(SubjectAnswerBO SubjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBO(List<SubjectJudge> subjectJudgeList);

}
