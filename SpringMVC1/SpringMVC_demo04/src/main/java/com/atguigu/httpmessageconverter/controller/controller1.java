package com.atguigu.httpmessageconverter.controller;

import com.atguigu.httpmessageconverter.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class controller1 {


    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String s){
        System.out.println(s);
        return "success";

    }
    @RequestMapping(value = "/testRequestEntity",method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> a){
//        获取请求体
        System.out.println("请求体"+a.getBody());
//        获取请求头信息
        System.out.println("请求头"+a.getHeaders());
//        获取更加详细的信息
        System.out.println("请求头内部信息"+a.getHeaders().getAccept());
        return "success";

    }
    @RequestMapping("/testRsponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello ,Response");
    }
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() throws IOException {
// 没有@ResponseBody注解返回的时视图的名称，有该注解返回的是响应体
        return  "Hello ,Response";
    }
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User("综述",12,"男");

    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAjax(String name,String sex){
        System.out.println(name+"\t"+sex);
        return "Hello ,Ajax";
    }

}
