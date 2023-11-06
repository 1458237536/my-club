package com.liang.subject.domain.handler.subject;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.common.enums.SubjectInfoTypeEnum;
import com.liang.subject.domain.convert.SubjectBriefConverter;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.entity.SubjectOptionBO;
import com.liang.subject.infra.basic.entity.SubjectBrief;
import com.liang.subject.infra.basic.service.SubjectBriefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 简答题日的策略类
 *
 * @author 梁海彪
 * @date 2023/10/25
 */
@Component
@Slf4j
public class BriefTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 简答题目的插入
        if (log.isInfoEnabled()) {
            log.info("BriefTypeHandler.add.bo：{}", JSON.toJSON(subjectInfoBO));
        }

        SubjectBrief subjectBrief = SubjectBriefConverter.INSTANCE.convertBOToEntity(subjectInfoBO);

        subjectBrief.setSubjectId(subjectBrief.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}


