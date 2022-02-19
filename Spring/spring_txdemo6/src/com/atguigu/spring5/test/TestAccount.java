package com.atguigu.spring5.test;

import com.atguigu.spring5.config.Config;
import com.atguigu.spring5.entity.User;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestAccount {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }


    //全注解
    @Test
    public void tesAop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }


    //函数式编程
    @Test
    public void testA(){
        //创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2、调用context的方法对象注册
        context.refresh();
        context.registerBean(User.class,() ->new User());
//        context.registerBean("user",User.class,() ->new User());
//        //获取在spring注册的对象
//        User user = (User) context.getBean("user");
        //获取在spring注册的对象
        User user = (User) context.getBean("com.atguigu.spring5.entity.User");
        System.out.println(user);
    }

}
