package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectCategoryBO;
import com.liang.subject.infra.basic.entity.SubjectCategory;
import com.liang.subject.infra.basic.entity.SubjectMultiple;
import com.liang.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectRadioConverter {

    SubjectRadioConverter INSTANCE = Mappers.getMapper(SubjectRadioConverter.class);

    SubjectRadio convertBOToEntity(SubjectAnswerBO SubjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBO(List<SubjectRadio> subjectRadioList);

}
