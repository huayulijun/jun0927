package com.huayu.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.bean.Emp;
import com.huayu.ssm.bean.Role;
import java.util.List;

public interface EmpMapper extends BaseMapper<Emp> {
    //模糊查询
    public List<Emp> queryAll(Emp emp);
    //删除
    public void deleteemp(Integer eid);
    //添加
    public void insertemp(Emp emp);
    //查询一条
    public Emp selectbyid(Integer eid);
    //修改
    public void updateemp(Emp emp);
    //查询部门
    public List<Dept> selectdept();
    //查询角色表
    public List<Role> queryrole();
    //查询角色id
    public Role rolebyid(int roleid);
    //查询总条数
    public int countemp();

}
