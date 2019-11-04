package com.huayu.ssm.bean;


import java.util.Date;

public class Gzjl {
    private Integer gzjlid;
    private String gzjl;
    private Date rztime;
    private Date lztime;
    private String zw;

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    private Integer eid;
    @Override
    public String toString() {
        return "Gzjl{" +
                "gzjlid=" + gzjlid +
                ", gzjl=" + gzjl +
                ", rztime=" + rztime +
                ", lztime=" + lztime +
                ", eid=" + eid +
                '}';
    }

    public String getGzjl() {
        return gzjl;
    }

    public void setGzjl(String gzjl) {
        this.gzjl = gzjl;
    }

    public Date getRztime() {
        return rztime;
    }

    public void setRztime(Date rztime) {
        this.rztime = rztime;
    }

    public Date getLztime() {
        return lztime;
    }

    public void setLztime(Date lztime) {
        this.lztime = lztime;
    }

    public Integer getGzjlid() {
        return gzjlid;
    }

    public void setGzjlid(Integer gzjlid) {
        this.gzjlid = gzjlid;
    }


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}
