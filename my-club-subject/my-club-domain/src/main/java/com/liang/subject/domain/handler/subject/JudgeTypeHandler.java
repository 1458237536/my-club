package com.liang.subject.domain.handler.subject;

import com.alibaba.fastjson.JSON;
import com.liang.subject.common.enums.IsDeletedFlagEnum;
import com.liang.subject.common.enums.SubjectInfoTypeEnum;
import com.liang.subject.domain.convert.SubjectJudgeConverter;
import com.liang.subject.domain.convert.SubjectRadioConverter;
import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.entity.SubjectOptionBO;
import com.liang.subject.infra.basic.entity.SubjectJudge;
import com.liang.subject.infra.basic.entity.SubjectRadio;
import com.liang.subject.infra.basic.service.SubjectJudgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断题日的策略类
 *
 * @author 梁海彪
 * @date 2023/10/25
 */
@Component
@Slf4j
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断题目的插入
        if (log.isInfoEnabled()) {
            log.info("JudgeTypeHandler.add.bo：{}", JSON.toJSON(subjectInfoBO));
        }


        SubjectJudge subjectJudge = new SubjectJudge();

        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETE.getCode());
        subjectJudgeService.insert(subjectJudge);

    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(subjectId);
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = SubjectJudgeConverter.INSTANCE.convertEntityToBO(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);

        return subjectOptionBO;
    }

}
