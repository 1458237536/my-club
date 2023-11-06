package com.liang.subject.domain.handler.subject;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.common.enums.SubjectInfoTypeEnum;
import com.liang.subject.domain.convert.SubjectMultipleConverter;
import com.liang.subject.domain.convert.SubjectRadioConverter;
import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.entity.SubjectOptionBO;
import com.liang.subject.infra.basic.entity.SubjectMultiple;
import com.liang.subject.infra.basic.entity.SubjectRadio;
import com.liang.subject.infra.basic.service.SubjectRadioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题日的策略类
 *
 * @author 梁海彪
 * @date 2023/10/25
 */
@Component
@Slf4j
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("RadioTypeHandler.add.bo：{}", JSON.toJSON(subjectInfoBO));
        }

        // 单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();

        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = SubjectRadioConverter.INSTANCE.convertBOToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {

        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(subjectId);
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = SubjectRadioConverter.INSTANCE.convertEntityToBO(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
