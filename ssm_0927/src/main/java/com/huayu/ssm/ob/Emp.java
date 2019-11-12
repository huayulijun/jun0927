package com.huayu.ssm.ob;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("emp")
public class Emp {
    @TableId(value = "eid",type = IdType.AUTO)
    public Integer eid;
    public String name;
    public String age;
    public String sex;
    public String mail;
    public String ah;
    public String rztime;
    public String did;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getRztime() {
        return rztime;
    }

    public void setRztime(String rztime) {
        this.rztime = rztime;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }
}
