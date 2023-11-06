package com.liang.subject.infra.basic.service;

import com.liang.subject.infra.basic.entity.SubjectInfo;
import com.liang.subject.infra.basic.entity.SubjectMapping;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.config.plugins.PluginValue;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2023-10-24 11:37:20
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId")Long categoryId,
                         @Param("labelId")Long labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo")SubjectInfo subjectInfo,
                                @Param("categoryId")Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") int start,
                                @Param("pageSize")  Integer pageSize);
}
