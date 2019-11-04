package com.huayu.ssm.bean;

import java.util.List;

public class PageList {
    private List<Emp> list;
    private Integer count;

    public PageList(List<Emp> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
