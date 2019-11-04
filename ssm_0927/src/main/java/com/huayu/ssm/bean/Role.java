package com.huayu.ssm.bean;

import java.util.Set;

public class Role {
    private  Integer roleid;
    private  String rolename;
    private Set<Emp> listemp1;

    public Set<Emp> getListemp1() {
        return listemp1;
    }

    public void setListemp1(Set<Emp> listemp1) {
        this.listemp1 = listemp1;
    }


    /*角色的实体类*/
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
