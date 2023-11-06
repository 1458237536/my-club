package com.liang.subject.application.convert;

import com.liang.subject.application.dto.SubjectCategoryDTO;
import com.liang.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDTOToBO(SubjectCategoryDTO subjectCategoryDTO);
    List<SubjectCategoryDTO> convertBOListToDTOList(List<SubjectCategoryBO> subjectCategoryBOList);
}
