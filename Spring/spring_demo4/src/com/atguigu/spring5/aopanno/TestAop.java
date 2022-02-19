package com.atguigu.spring5.aopanno;

import com.atguigu.spring5.aop.Config;
import com.atguigu.spring5.aop.Stu;
import com.atguigu.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();

    }
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Stu stu = context.getBean("stu", Stu.class);
        stu.stu();
    }
}
