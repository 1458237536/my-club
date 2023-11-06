package com.liang.subject.domain.handler.subject;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.common.enums.SubjectInfoTypeEnum;
import com.liang.subject.domain.convert.SubjectJudgeConverter;
import com.liang.subject.domain.convert.SubjectMultipleConverter;
import com.liang.subject.domain.convert.SubjectRadioConverter;
import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.entity.SubjectOptionBO;
import com.liang.subject.infra.basic.entity.SubjectJudge;
import com.liang.subject.infra.basic.entity.SubjectMultiple;
import com.liang.subject.infra.basic.entity.SubjectRadio;
import com.liang.subject.infra.basic.service.SubjectMultipleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题日的策略类
 *
 * @author 梁海彪
 * @date 2023/10/25
 */
@Component
@Slf4j
public class MultipleTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 多选题目的插入
        if (log.isInfoEnabled()) {
            log.info("MultipleTypeHandler.add.bo：{}", JSON.toJSON(subjectInfoBO));
        }


        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();

        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = SubjectMultipleConverter.INSTANCE.convertBOToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId);
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = SubjectMultipleConverter.INSTANCE.convertEntityToBO(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
