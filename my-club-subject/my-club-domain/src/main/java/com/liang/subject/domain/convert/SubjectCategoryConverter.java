package com.liang.subject.domain.convert;

import com.liang.subject.domain.entity.SubjectCategoryBO;
import com.liang.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBOToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertBOToCategoryList(List<SubjectCategory> subjectCategoryList);
}
