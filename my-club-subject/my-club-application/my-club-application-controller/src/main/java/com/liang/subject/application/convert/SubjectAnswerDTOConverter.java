package com.liang.subject.application.convert;

import com.liang.subject.application.dto.SubjectAnswerDTO;
import com.liang.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerDTOConverter {

    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerBO convertDTOToBO(SubjectAnswerDTO subjectAnswerDTO);
    List<SubjectAnswerBO> convertDTOListToBOList(List<SubjectAnswerDTO> subjectAnswerDTOList);
    List<SubjectAnswerDTO> convertBOListToDTOList(List<SubjectAnswerBO> subjectAnswerBOList);
}
