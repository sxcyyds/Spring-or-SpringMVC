package com.atguigu.jspcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @RequestMapping("/success")
    public String test1(){
        return "success";
    }
}
