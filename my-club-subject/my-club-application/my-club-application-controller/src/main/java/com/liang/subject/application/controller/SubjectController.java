package com.liang.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liang.subject.application.convert.SubjectAnswerDTOConverter;
import com.liang.subject.application.convert.SubjectInfoDTOConverter;
import com.liang.subject.application.dto.SubjectInfoDTO;
import com.liang.subject.common.entity.PageResult;
import com.liang.subject.common.entity.Result;
import com.liang.subject.domain.entity.SubjectAnswerBO;
import com.liang.subject.domain.entity.SubjectInfoBO;
import com.liang.subject.domain.service.SubjectInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 刷题controller
 *
 * @author 梁海彪
 * @date 2023/10/19
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * 新增题目
     *
     * @param subjectInfoDTO 题目类别 DTO
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto：{}", JSON.toJSON(subjectInfoDTO));
            }


            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()), "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "标签id不能为空");


            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOList = SubjectAnswerDTOConverter.INSTANCE.convertDTOListToBOList(subjectInfoDTO.getOptionList());

            // Preconditions.checkArgument(!subjectAnswerBOList.isEmpty(), "List cannot be empty");
            // Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectAnswerBOList), "SubjectAnswer cannot be empty");

            subjectInfoBO.setOptionList(subjectAnswerBOList);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.error：{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 查询题目列表
     *
     * @param subjectInfoDTO 题目信息 DTO
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto：{}", JSON.toJSON(subjectInfoDTO));
            }


            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类ID不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签ID不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectController.getSubjectPage.error：{}", e.getMessage(), e);
            return Result.fail("查询题目列表失败");
        }
    }

    /**
     * 查询题目详情
     *
     * @param subjectInfoDTO 题目信息 DTO
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto：{}", JSON.toJSON(subjectInfoDTO));
            }

            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目ID不能为空");
            // Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类ID不能为空");
            // Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签ID不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            SubjectInfoBO boPageResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boPageResult);
            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectController.querySubjectInfo.error：{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }


}
