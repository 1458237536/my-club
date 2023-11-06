package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectLabelBO;
import com.liang.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBOToLabel(SubjectLabelBO subjectLabelBO);

    // List<SubjectLabelBO> convertBoToLabel(List<SubjectLabel> subjectLabelList);
}
