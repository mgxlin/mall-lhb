package com.lhb.mall.common.api;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lhb
 * @date 2022/1/16 17:05
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageTotal;
    private Long total;
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> page = new PageInfo<>(list);
        commonPage.setPageNum(page.getPageNum());
        commonPage.setPageSize(page.getPageSize());
        commonPage.setPageTotal(page.getPages());
        commonPage.setTotal(page.getTotal());
        commonPage.setList(page.getList());
        return commonPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
