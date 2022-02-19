package com.atguigu.spring5.test;

import com.atguigu.spring5.service.UserService;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //指明使用的是那个unit的版本,指明单元测试的版本
@ContextConfiguration("classpath:bean2.xml")  //加载配置文件
public class JTest4 {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        System.out.println("sb");
    }
}
