package com.legend.dao.domain.condition;

import java.io.Serializable;

/**
 * Created by dell-pc on 2017/9/7.
 */
public class AmmeterCondition implements Serializable{

    private Integer pageIndex;

    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
