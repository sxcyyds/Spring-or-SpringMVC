package com.atguigu.mvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class HController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/target")
    public String ta(){
        return "target";
    }


    @RequestMapping("/param")
    public String  testParams(){
        return "test_params";
    }

}
