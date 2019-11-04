package com.huayu.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.ssm.bean.Dept;

import java.util.List;

public interface DeptMapper extends BaseMapper<Dept> {
    public void deletedape(Integer did);
    public void insertdept(Dept dept);
    public Dept deptbyid(Integer did);
    public void updatedept(Dept dept);
    List<Dept> listDept();
}
