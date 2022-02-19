package com.sxc.abc.testdemo;

import com.sxc.abc.config.SpringConfig;
import com.sxc.abc.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

    }
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = context.getBean("userService", UserService.class);
        service.add();  
    }

}
