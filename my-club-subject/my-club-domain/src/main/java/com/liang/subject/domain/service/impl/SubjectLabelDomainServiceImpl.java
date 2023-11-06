package com.liang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.domain.convert.SubjectLabelConverter;
import com.liang.subject.domain.entity.SubjectLabelBO;
import com.liang.subject.domain.service.SubjectLabelDomainService;
import com.liang.subject.infra.basic.entity.SubjectLabel;
import com.liang.subject.infra.basic.entity.SubjectMapping;
import com.liang.subject.infra.basic.service.SubjectLabelService;
import com.liang.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;


    /**
     * 新增标签
     *
     * @param subjectLabelBO
     * @return {@link Boolean}
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.bo：{}", JSON.toJSON(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        int count = subjectLabelService.insert(subjectLabel);

        return count > 0;
    }

    /**
     * 更新标签
     *
     * @param subjectLabelBO
     * @return {@link Boolean}
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.bo：{}", JSON.toJSON(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 删除标签
     *
     * @param subjectLabelBO
     * @return {@link Boolean}
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.bo：{}", JSON.toJSON(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBOToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETE.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 按类别 ID 查询标签
     *
     * @param subjectLabelBO 主题标签博
     * @return {@link List}<{@link SubjectLabelBO}>
     */
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.queryLabelByCategoryId.bo：{}", JSON.toJSON(subjectLabelBO));
        }
        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        // System.out.println("查询结果 = " + subjectMappingList);  9
        if (CollectionUtils.isEmpty(subjectMappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        // System.out.println("查询结果 = " + labelIdList);   9
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryById(labelIdList);

        List<SubjectLabelBO> boList = new LinkedList<>();
        subjectLabelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;
    }
}
