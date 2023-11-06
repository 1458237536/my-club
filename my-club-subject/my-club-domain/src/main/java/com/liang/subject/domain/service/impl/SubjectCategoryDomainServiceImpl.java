package com.liang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.domain.convert.SubjectCategoryConverter;
import com.liang.subject.domain.entity.SubjectCategoryBO;
import com.liang.subject.domain.service.SubjectCategoryDomainService;
import com.liang.subject.infra.basic.entity.SubjectCategory;
import com.liang.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.add.bo：{}", JSON.toJSON(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        subjectCategoryService.insert(subjectCategory);

    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.convertBOToCategoryList(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.queryPrimaryCategory.boList：{}", JSON.toJSON(boList));
        }
        return boList;
    }


    /**
     * 更新分类
     *
     * @param subjectCategoryBO
     * @return {@link Boolean}
     */
    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    /**
     * 删除分类
     *
     * @param subjectCategoryBO
     * @return {@link Boolean}
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBOToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETE.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
