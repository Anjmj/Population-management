package com.zxj.model.vo;

public class DataVo {
    private Integer offset;
    private Integer pageSize;
    private String pname;

    @Override
    public String toString() {
        return "DataVo{" +
                "offset=" + offset +
                ", pageSize=" + pageSize +
                ", pname=" + pname +
                "} " ;
    }

    public DataVo() {
    }

    public Integer getOffset() {

        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
