package test;

import com.atguigu.com.Book;
import com.atguigu.com.User;
import com.atguigu.com.zzz;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdemo1 {
    @Test
    public void testadd(){
//        1、加载spring配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");

//        2、获取配置创建的对象jiazai
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();

    }
    @Test
    public void testBook(){
        ApplicationContext book=new ClassPathXmlApplicationContext("bean1.xml");
        Book book1 = book.getBean("books",Book.class);
        System.out.println(book1);
    }
    @Test
    public void testOrders(){
        ApplicationContext order=new ClassPathXmlApplicationContext("bean1.xml");
        Object order1 = order.getBean("order");
        System.out.println(order1);
    }

    @Test
    public void testBook1(){
        ApplicationContext order=new ClassPathXmlApplicationContext("bean1.xml");
        Object order1 = order.getBean("book2");
        System.out.println(order1);
    }

}
