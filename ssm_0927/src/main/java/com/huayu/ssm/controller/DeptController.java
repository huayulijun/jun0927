package com.huayu.ssm.controller;


import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.service.DeptService;
import com.huayu.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeptController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    //查询
    @RequestMapping("/deptselect.do")
    public ModelAndView deptselect(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listdept",empService.selectdept());
        //modelAndView.setViewName("dept.jsp");
        modelAndView.setViewName("dept");
        return modelAndView;
    }

    @RequestMapping("/deletedepe.do")
    public String deletedape(Integer did){
        deptService.deletedape(did);
        return "redirect:/deptselect.do";
    }

    @RequestMapping("/insertdept.do")
    public String insertdept(Dept dept){
        deptService.insertdept(dept);
        return "redirect:/deptselect.do";
    }

    @RequestMapping("/deptbyid.do")
    public ModelAndView deptbyid(Integer did){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dept",deptService.deptbyid(did));
        modelAndView.setViewName("deptupdate.jsp");
        return modelAndView;
    }

    @RequestMapping("/updatedept.do")
    public String updatedept(Dept dept){
        deptService.updatedept(dept);
        return "redirect:/deptselect.do";
    }
}
