package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class ParamController {


    @RequestMapping("/testServletAPI")
    public String testServlet(HttpServletRequest  req){
        //该方法的调用者是DispatcherServlet，
        // DispatcherServlet的底层会根据控制器方法的形参给。其注入不同的值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(username+"\t"+password);
        System.out.println(hobbies);


        return "put";

    }


    @RequestMapping("/testServletAPI1")
    public String getServlet(
            @RequestParam(value = "user_name",required =true,defaultValue = "zhangsan") String username ,
            String  password,
            String[] hobby,
            @RequestHeader("Host") String host){
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobby));
        System.out.println(host);
        return "put";
    }

    @RequestMapping("/testBean")
    public String  testBean(User user){
        System.out.println(user);
        return "put";
    }


}
