package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controll {

    @RequestMapping("/abc")
    public String test1(){
        return "a";
    }
}
