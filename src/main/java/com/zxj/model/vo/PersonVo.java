package com.zxj.model.vo;

import com.zxj.model.po.TbPerson;

public class PersonVo extends TbPerson {
    private Integer count;
    private Integer page;
    private Integer limit;

    @Override
    public String toString() {
        return "PersonVo{" +
                "count=" + count +
                ", page=" + page +
                ", limit=" + limit +
                "} " + super.toString();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
