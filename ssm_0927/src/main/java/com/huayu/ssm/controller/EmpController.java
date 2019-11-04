package com.huayu.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.bean.Emp;
import com.huayu.ssm.bean.PageList;
import com.huayu.ssm.service.DeptService;
import com.huayu.ssm.service.EmpService;
import com.huayu.ssm.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmpController{
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

     //查询emp
    @RequestMapping("/list.do")
    public ModelAndView select(Emp emp,Integer nowpage) {
        if(nowpage==null){
            nowpage=1;
        }
        PageList pageList=empService.queryAll(emp,nowpage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",pageList.getList());
        modelAndView.addObject("page",nowpage);
        modelAndView.addObject("totalpage",empService.countemp(pageList.getCount()));
        modelAndView.addObject("deptlist",empService.selectdept());
        //modelAndView.setViewName("emp.jsp");
        modelAndView.setViewName("emp");
        return modelAndView;

    }

    //去修改的
    @RequestMapping("/selectid.do")
    public ModelAndView selectid(Integer eid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deptlist",empService.selectdept());
        modelAndView.addObject("emp",empService.selectbyid(eid));
        modelAndView.addObject("roleList",empService.queryrole());
        //modelAndView.setViewName("update.jsp");
        modelAndView.setViewName("update");
        return modelAndView;
    }

     //修改emp
    @RequestMapping(value = "/update.do")
    public String update(Emp emp){
        empService.updateemp(emp);
        return "redirect:/list.do";
    }

    //去添加的
    @RequestMapping("/toadd.do")
    public ModelAndView toadd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deptlist",empService.selectdept());
        modelAndView.addObject("roleList",empService.queryrole());
        //modelAndView.setViewName("insert.jsp");
        modelAndView.setViewName("insert");
        return modelAndView;
    }

    //添加
    @RequestMapping("/insert.do")
    public String insert(Emp emp) {
        empService.insertemp(emp);
        return "redirect:/list.do";
    }

    //删除emp的数据
    @RequestMapping("/delete.do")
    public String delete(Integer eid){
        empService.deleteemp(eid);
        return "redirect:/list.do";

    }

    //删除emp的数据
    @RequestMapping("/delete1.do")
    @ResponseBody
    public String delete1(Integer eid){
        String st1 ="1";
        try {
            empService.deleteemp(eid);

        } catch (Exception e) {
            st1="2";
            e.printStackTrace();
        }
        return st1;
    }

    @RequestMapping("/all.do")
    @ResponseBody
    public Layui all(Emp emp,Integer page,Integer limit){
        Layui layui = new Layui();
        PageList pageList = empService.queryAll(emp,page);
        layui.setCode(0);
        layui.setMag("");
        layui.setCount(pageList.getCount());
        layui.setData(pageList.getList());
        return layui;
    }

    //删除emp的数据
    @RequestMapping("/deleteall.do")
    @ResponseBody
    public String deleteall(String eid){
        String st ="1";
        try {
            //empService.removeByIds(Arrays.asList(eid.split(",")));
            for(String id : eid.split(",")){
                delete1(Integer.parseInt(id));
            }
        } catch (Exception e) {
            st="2";
            e.printStackTrace();
        }
        return st;
    }

    //去添加的
    @RequestMapping("/toadd1.do")
    public String toadd1(Model model){
        model.addAttribute("dept",empService.selectdept());
        return "add";
    }

    //添加
    @RequestMapping("/add.do")
    @ResponseBody
    public String add(Emp emp) {
         String st1 ="1";
        try {
            empService.insertemp(emp);
        } catch (Exception e) {
            st1="2";
            e.printStackTrace();
        }
        return st1;
    }


    //去修改的
    @RequestMapping("/toupdate1.do")
    public String update1(Model model,Integer eid){
        model.addAttribute("dept",empService.selectdept());
        model.addAttribute("emp",empService.selectbyid(eid));
        return "update1";
    }

    //修改的
    @RequestMapping("/update1.do")
    @ResponseBody
    public String update1(Emp emp) {
        String st1 ="1";
        try {
            empService.updateemp(emp);
        } catch (Exception e) {
            st1="2";
            e.printStackTrace();
        }
        return st1;
    }


    //查询部门
    @RequestMapping("/deptall.do")
    @ResponseBody
    public List<Dept> deptall(){
        return deptService.listDept();
    }







}