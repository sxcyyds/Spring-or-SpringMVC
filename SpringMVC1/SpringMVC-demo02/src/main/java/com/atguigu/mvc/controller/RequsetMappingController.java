package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class RequsetMappingController {

    @RequestMapping(
            value = {"/map","/Map","/a","test"},
            method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String index(){
        return "Map";
    }


    @GetMapping(value ={"getMapping"} )
    public String testGetMapping(){
        return "testgetmapping";
    }

    @RequestMapping(value = "/test",method = RequestMethod.PUT)
    public String testPut(){
        return "put";
    }

    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username","password=123123"},
            headers ={"Host=localhost:8080"}

            )
    public String testParamsAndHeaders(){
        return "testParamsAndHeaders";
    }


    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "put";
    }

    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id")Integer id){
        System.out.println("id");
        return "put";

    }
}
