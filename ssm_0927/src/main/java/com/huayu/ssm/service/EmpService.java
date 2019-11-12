package com.huayu.ssm.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.bean.Emp;
import com.huayu.ssm.bean.PageList;
import com.huayu.ssm.bean.Role;
import com.huayu.ssm.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EmpService extends ServiceImpl<EmpMapper,Emp>{
    @Autowired
    private EmpMapper empMapper;

    //查询所有
    public PageList queryAll(Emp emp, Integer nowpage,Integer limit){
        Page page = PageHelper.startPage(nowpage,limit);
        List<Emp> list=empMapper.queryAll(emp);
        Long i=page.getTotal();
        PageList pageList=new PageList(list,i.intValue());
        return pageList;
    }


    //查询所有
    public List<Emp> queryAll(com.huayu.ssm.ob.Emp emp){
        List<Emp> list = empMapper.queryAll(emp);
        return list;
    }


    //删除
    public void deleteemp(Integer eid){
       empMapper.deleteemp(eid);
    }

    //添加
    public void insertemp(com.huayu.ssm.ob.Emp emp){
        empMapper.insertemp(emp);
    }

    //添加
    public void insertemp(Emp emp){
        empMapper.insertemp(emp);
    }

    //查询一条
    public Emp selectbyid(Integer eid){
       return empMapper.selectbyid(eid);
    }

    //修改
    public void updateemp(Emp emp){
        empMapper.updateemp(emp);
    }

    //查询部门
    public List<Dept> selectdept(){
        return empMapper.selectdept();
    }

    //查询角色
    public List<Role> queryrole(){
        return empMapper.queryrole();
    }

    //查询页数
    public int countemp(Integer count){
       if(count%3 != 0){
           count = count/3+1;
       }else{
           count=count/3;
       }
        return count;
    }


    //批量删除
    


}
