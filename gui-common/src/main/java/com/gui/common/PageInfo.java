package com.gui.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * 分页通用对象
 * @param <T>
 */
@Data
public class PageInfo<T> {

    /**
     * 接收前端传递过来的分页参数
     */

    //页大小
    // @JsonIgnore
    private int pageSize;
    //当前页
   //  @JsonIgnore
    private int currentPage;
    //查询条件
   // @JsonIgnore
    private T query;
    //排序类型
    // @JsonIgnore
    private String sortType = "asc"; // asc desc
    //排序字段
    // @JsonIgnore
    private String sortField;

    // 设置传递给前端的参数
    // 总记录数
    private int total;
    // 当前页数据集合
    private List<T> list;
}
