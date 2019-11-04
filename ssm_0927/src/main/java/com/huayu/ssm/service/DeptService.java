package com.huayu.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.mapper.DeptMapper;
import com.huayu.ssm.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptService extends ServiceImpl<DeptMapper,Dept>{
    @Autowired
    private DeptMapper deptMapper;

    public void deletedape(Integer did){
        deptMapper.deletedape(did);
    }

    public void insertdept(Dept dept){
        deptMapper.insertdept(dept);
    }

    public Dept deptbyid(Integer did){
        return deptMapper.deptbyid(did);
    }

    public void updatedept(Dept dept){
        deptMapper.updatedept(dept);
    }

    public List<Dept> listDept(){
        return deptMapper.listDept();
    }

}
