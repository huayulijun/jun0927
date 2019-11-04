package com.huayu.ssm.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Set;
@TableName("dept")
public class Dept {
    @TableId("did")
    private String did;
    @TableField("deptbh")
    private  String deptbh;
    private Set<Emp> listemp;

    public Set<Emp> getListemp() {
        return listemp;
    }

    public void setListemp(Set<Emp> listemp) {
        this.listemp = listemp;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDeptbh() {
        return deptbh;
    }

    public void setDeptbh(String deptbh) {
        this.deptbh = deptbh;
    }

    @Override
    public String toString() {
        return "Dept{" +
                ", deptbh='" + deptbh + '\'' +
                '}';
    }
}
 