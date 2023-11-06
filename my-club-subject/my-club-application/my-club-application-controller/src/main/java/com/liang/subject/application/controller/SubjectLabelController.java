package com.liang.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liang.subject.application.convert.SubjectLabelDTOConverter;
import com.liang.subject.application.dto.SubjectLabelDTO;
import com.liang.subject.common.entity.Result;
import com.liang.subject.domain.entity.SubjectLabelBO;
import com.liang.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签controller
 *
 * @author 梁海彪
 * @date 2023/10/21
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {


    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     *
     * @param subjectLabelDTO 主题标签 DTO
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            /**
             * 如果要在高并发的情况下，它其实是会先把后面的json序列化执行一遍
             * 如果先执行json序列化意味着高并发请求即使日志不打印都要做一次json的转换，这是佷耗性能的
             * 如果前面加判断可避免这种情况，这也是做日志优化，
             */
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto：{}", JSON.toJSON(subjectLabelDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()), "标签名称不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDTOToBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error：{}", e.getMessage(), e);
            return Result.fail("新增标签失败");
        }
    }


    /**
     * 根据分类查询标签
     *
     * @return {@link Result}<{@link List}<{@link SubjectLabelDTO}>>
     */
    @PostMapping("/queryByCategoryId")
    public Result<List<SubjectLabelDTO>> queryByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryByCategoryId.dto：{}", JSON.toJSON(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDTOToBO(subjectLabelDTO);

            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOList = SubjectLabelDTOConverter.INSTANCE.convertBOListToDTOList(subjectLabelBOList);
            return Result.ok(subjectLabelDTOList);
        } catch (Exception e) {
            log.error("SubjectLabelController.queryByCategoryId.error：{}", e.getMessage(), e);
            return Result.fail("查询分类标签失败");
        }
    }

    // /**
    //  * 查询大类下分类
    //  *
    //  * @return {@link Result}<{@link List}<{@link SubjectCategoryDTO}>>
    //  */
    // @PostMapping("/queryCategoryByPrimary")
    // public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
    //     try {
    //         if (log.isInfoEnabled()) {
    //             log.info("SubjectCategoryController.queryCategoryByPrimary.dto：{}", JSON.toJSON(subjectCategoryDTO));
    //         }
    //
    //         Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类ID不能为空！");
    //
    //         SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDToToCategoryDTOList(subjectCategoryDTO);
    //         List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
    //         List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategoryDTOList(subjectCategoryBOList);
    //         return Result.ok(subjectCategoryDTOList);
    //     } catch (Exception e) {
    //         log.error("SubjectCategoryController.queryCategoryByPrimary.error：{}", e.getMessage(), e);
    //         return Result.fail("查询失败");
    //     }
    // }
    //

    /**
     * 更新标签
     *
     * @return {@link Result}
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {

            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.dto：{}", JSON.toJSON(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()), "标签名称不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDTOToBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.update.error：{}", e.getMessage(), e);
            return Result.fail("更新标签失败");
        }
    }


    /**
     * 删除标签
     *
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {

            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto：{}", JSON.toJSON(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDTOToBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error：{}", e.getMessage(), e);
            return Result.fail("删除标签失败");
        }
    }
}
