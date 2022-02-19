package com.atguigu.spring.collecttype.testDemo2;

import com.atguigu.spring.collecttype.Book;
import com.atguigu.spring.collecttype.Course;
import com.atguigu.spring.collecttype.Stu;
import com.atguigu.spring.collecttype.autowire.Emp;
import com.atguigu.spring.collecttype.bean.Orders;
import com.atguigu.spring.collecttype.factortbean.MyBean;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo2 {
    @Test
    public void demo2(){
        //读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        Stu stu1 = context.getBean("stu", Stu.class);
        System.out.println(stu);
        System.out.println(stu1);
    }

    @Test
    public void booktest(){
        //读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book1", Book.class);
        System.out.println(book);
    }

    @Test
    public void testMybean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course1 = context.getBean("mybean", Course.class);

        System.out.println(course1);

    }
    @Test
    public void testSimple(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course1 = context.getBean("c", Course.class);
        Course course2 = context.getBean("c", Course.class);
        System.out.println(course1);
        System.out.println(course2);
    }

//    bean的生命周期
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取到创建的对象");
        System.out.println(orders);
        //手动让bean销毁，调用close()方法，会自动调用Orders中的destory()方法
        context.close();
    }
    @Test
    public void test4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);;

    }

}

