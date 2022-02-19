package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopController {

    //使用ServletAPI向request域对象添加数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest req){
        req.setAttribute("testRequestScope","Hello,ServlstAPI");

        return "success";
    }

    //使用ModelAndView向request域添加数据
    @RequestMapping("/testModelandView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //处理模型数据，即向请求域request添加共享数据
        modelAndView.addObject("a","Hello");
        //设置视图，实现页面跳转
        modelAndView.setViewName("success");
        return modelAndView;

    }
    //通过model向request域添加数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("a","hello,SpringMVC");
        System.out.println(model);
        return "success";
    }

    //通过map向request域中添加共享数据
    @RequestMapping("/testMap")
    public String  testMap(Map<String,Object> map){
        map.put("a",12);
        System.out.println(map);
        System.out.println(map.getClass().getName());
        return "success";
    }

    //通过ModelMap向request域中添加数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("a11","通过ModelMap向request域中添加数据");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //使用原生的session向session中添加数据 ，推荐使用
    @RequestMapping("/testSession")
    public String testSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("test",5345);
        return "success";
    }

    //向application中添加数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("application","123");



        return "success";
    }







}
