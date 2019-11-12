package com.huayu.ssm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.ssm.bean.Dept;
import com.huayu.ssm.bean.Emp;
import com.huayu.ssm.bean.PageList;
import com.huayu.ssm.service.DeptService;
import com.huayu.ssm.service.EmpService;
import com.huayu.ssm.service.FileUploadService;
import com.huayu.ssm.util.Layui;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

@Controller
@Api
public class EmpController{

    static Logger logger = Logger.getLogger(EmpController.class);
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private FileUploadService fileUploadService;

     //查询emp
    @RequestMapping(value = "/list.do",method = {RequestMethod.POST,RequestMethod.GET})
    //swagger返回值注解
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统内部错误"),
            @ApiResponse(code = 200, message = "成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response =Layui.class) })
    @ApiOperation(httpMethod = "post", value = "个人信息")//swagger 当前接口注解
    public ModelAndView select(@ApiParam(required = false, name = "Emp", value = "模糊查询数据")Emp emp,
                               @ApiParam(required = true, name = "nowpage", value = "当前页数")@RequestParam Integer nowpage,
                               @ApiParam(required = true, name = "limit", value = "分页条数")@RequestParam Integer limit) {
        if(nowpage==null){
            nowpage=1;
        }
        PageList pageList=empService.queryAll(emp,nowpage,limit);
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
    @RequestMapping(value = "/selectid.do",method = {RequestMethod.POST,RequestMethod.GET} )
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
    @RequestMapping(value = "/update.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String update(Emp emp){
        empService.updateemp(emp);
        return "redirect:/list.do";
    }

    //去添加的
    @RequestMapping(value = "/toadd.do",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView toadd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deptlist",empService.selectdept());
        modelAndView.addObject("roleList",empService.queryrole());
        //modelAndView.setViewName("insert.jsp");
        modelAndView.setViewName("insert");
        return modelAndView;
    }

    //添加
    @RequestMapping(value = "/insert.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String insert(Emp emp) {
        empService.insertemp(emp);
        return "redirect:/list.do";
    }

    //删除emp的数据
    @RequestMapping(value = "/delete.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String delete(Integer eid){
        empService.deleteemp(eid);
        return "redirect:/list.do";

    }

    //删除emp的数据
    @RequestMapping(value = "/delete1.do",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String delete1(Integer eid){
        String st1 ="1";
        try {
            //int i = 1/0;
            empService.deleteemp(eid);
        } catch (Exception e) {
            st1="2";
            logger.error("除零异常",e);
            e.printStackTrace();
        }
        return st1;
    }



    @RequestMapping(value = "/all.do",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    //swagger返回值注解
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统内部错误"),
            @ApiResponse(code = 200, message = "模糊查询分页成功", response =Layui.class) })
    @ApiOperation(httpMethod = "post", value = "emp模糊查询加分页个人信息")//swagger 当前接口注解
    public Layui all(@ApiParam(required = false, name = "Emp", value = "模糊查询数据")Emp emp,
                     @ApiParam(required = true, name = "page", value = "当前页数")@RequestParam Integer page,
                     @ApiParam(required = true, name = "limit", value = "分页条数")@RequestParam Integer limit){
        Layui layui = new Layui();
        PageList pageList = empService.queryAll(emp,page,limit);
        layui.setCode(0);
        layui.setMag("");
        layui.setCount(pageList.getCount());
        layui.setData(pageList.getList());
        return layui;
    }

    //批量删除emp的数据
    @RequestMapping(value = "/deleteall.do",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "批量删除成功",response = Layui.class),
            @ApiResponse(code = 500,message = "系统内部错误")
    })
    @ApiOperation(httpMethod = "post",value = "批量删除员工")
    public String deleteall(@ApiParam(required = true,name="eid",value = "根据ID批量删除员工")@RequestParam String eid){
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
    @RequestMapping(value = "/toadd1.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String toadd1(Model model){
        model.addAttribute("dept",empService.selectdept());
        return "add";
    }

    //添加
    @RequestMapping(value = "/add.do",method = {RequestMethod.POST,RequestMethod.GET})
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
    @RequestMapping(value = "/toupdate1.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String update1(Model model,Integer eid){
        model.addAttribute("dept",empService.selectdept());
        model.addAttribute("emp",empService.selectbyid(eid));
        return "update1";
    }

    //修改的
    @RequestMapping(value = "/update1.do",method = {RequestMethod.POST,RequestMethod.GET})
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
    @RequestMapping(value = "/deptall.do",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Dept> deptall(){
        return deptService.listDept();
    }



    //上传文件
    @RequestMapping(value = "/fileUpload",method ={RequestMethod.POST,RequestMethod.GET} )
    @ResponseBody
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){
        String i = "";
        try {
            InputStream inputStream =multipartFile.getInputStream();
            List<com.huayu.ssm.ob.Emp> list =  fileUploadService.fileUpload(inputStream, com.huayu.ssm.ob.Emp.class);
            for(com.huayu.ssm.ob.Emp emp:list){
                empService.insertemp(emp);
            }
            i="1";
        } catch (IOException e) {
            i="2";
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return i;
    }


    //下载文件
    @RequestMapping("/excleDewnLoad.do")
    public void excleDewnLoad(HttpServletResponse response, com.huayu.ssm.ob.Emp emp) throws InstantiationException, IllegalAccessException {
        String salaryDate="";
        response.setHeader("Content-Disposition", "attachment;filename="+salaryDate+".xls");
        response.setContentType("applicationnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HSSFWorkbook workbook=null;
        //导出Excel对象emp
        String[] tols={"姓名","年龄","性别","邮箱","爱好","入职时间","班级"};
        workbook = fileUploadService.outPutExcel("emp信息",tols,empService.queryAll(emp));
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }















}