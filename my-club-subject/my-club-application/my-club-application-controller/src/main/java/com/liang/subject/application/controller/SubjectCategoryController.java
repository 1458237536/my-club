package com.liang.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.liang.subject.application.convert.SubjectCategoryDTOConverter;
import com.liang.subject.application.dto.SubjectCategoryDTO;
import com.liang.subject.common.entity.Result;
import com.liang.subject.domain.entity.SubjectCategoryBO;
import com.liang.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类controller
 *
 * @author 梁海彪
 * @date 2023/10/20
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     *
     * @param subjectCategoryDTO 主题类别 DTO
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            /**
             * 如果要在高并发的情况下，它其实是会先把后面的json序列化执行一遍
             * 如果先执行json序列化意味着高并发请求即使日志不打印都要做一次json的转换，这是佷耗性能的
             * 如果前面加判断可避免这种情况，这也是做日志优化，
             */
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto：{}", JSON.toJSON(subjectCategoryDTO));
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");

            // System.out.println("subjectCategoryDTO = " + subjectCategoryDTO);
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOToBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error：{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }


    /**
     * 查询岗位大类
     *
     * @return {@link Result}<{@link List}<{@link SubjectCategoryDTO}>>
     */
    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOToBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertBOListToDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error：{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 查询大类下分类
     *
     * @return {@link Result}<{@link List}<{@link SubjectCategoryDTO}>>
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto：{}", JSON.toJSON(subjectCategoryDTO));
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类ID不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOToBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convertBOListToDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error：{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }


    /**
     * 更新分类
     *
     * @return {@link Result}
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {

            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto：{}", JSON.toJSON(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOToBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error：{}", e.getMessage(), e);
            return Result.fail("更新失败");
        }
    }


    /**
     * 删除分类
     *
     * @return {@link Result}<{@link Boolean}>
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {

            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto：{}", JSON.toJSON(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDTOToBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error：{}", e.getMessage(), e);
            return Result.fail("删除失败");
        }
    }

}
