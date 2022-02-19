package com.atguigu.spring5.test;

import com.atguigu.spring5.service.UserService;
import jdk.Exported;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)  //注解引用
//@ContextConfiguration("classpath:bean1.xml")   //读取配置文件
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class JTest5 {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        System.out.println("sb111");
        userService.accountMoney();
    }
}
