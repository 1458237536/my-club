package com.liang.subject.common.entity;

/**
 * 分页请求实体
 *
 * @author 梁海彪
 * @date 2023/10/26
 */
public class PageInfo {

    private Integer pageNo = 1;
    private Integer pageSize = 20;

    public Integer getPageNo() {
        return pageNo == null || pageNo < 1 ? 1 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE ? 20 : pageSize;
    }
}
