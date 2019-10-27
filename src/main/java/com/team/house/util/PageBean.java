package com.team.house.util;

public class PageBean {
    private Integer page;
    private Integer rows;

    public PageBean() {
    }

    public PageBean(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
