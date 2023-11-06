package com.liang.subject.application.convert;

import com.liang.subject.application.dto.SubjectInfoDTO;
import com.liang.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO);
    SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoDTO> convertBoListToDTOList(List<SubjectInfoBO> subjectInfoBOList);
}
