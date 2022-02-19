package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "view";      //没有任何前缀，通过Thymeleaf视图解析器解析为Thymeleafciew实现页面的转发
    }


    @RequestMapping("/testForward")
    public String testForwward(){
        return "forward:/testThymeleafView";   //有两次视图解析，第一次解析自己的路径，第二次解析为去除forward:之后的路径
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

    @RequestMapping("/testrest")
    public String test12(){
        return "test_rest";
    }
}
