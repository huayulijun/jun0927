package com.huayu.ssm.controller;

import com.huayu.ssm.bean.Login;
import com.huayu.ssm.service.DengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DengController {
    @Autowired
    private DengService dengService;

    //登录
    @RequestMapping("/login.do")
    public  String login(Login login,HttpSession session){
        Login login1 = dengService.denglu(login);
        //判断
        if(login1 != null){
            //存域对象
            session.setAttribute("s",login1);
            return "redirect:/list.do";
        }else{
            return "redirect:/jsp/login.jsp";
        }

    }

    //登出
    @RequestMapping("/logout.do")
    public  String logout(HttpSession session){
            session.removeAttribute("s");
            return "redirect:/jsp/login.jsp";
        }

}
