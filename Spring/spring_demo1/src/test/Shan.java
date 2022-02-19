package test;

import com.atguigu.com.Book;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Shan {
    /**
     * BeanFactory是Spring内部接口，不提供开发人员使用
     * BeanFactory在加载配置文件的时候，只会加载配置文件，不闯将配置文件中的对象，只有在
     * 获取配置文件创建的对象时才会创建对象（context.getBean时才会创建对象）
     */

    @Test
    public void testBeanFactory(){
        //BeanFactory时Spring内部的接口，不提供开发人员使用
        //BeanFactory在加载配置文件时，只会加载配置文件，不会创建对象。只有在获取配置创建的对象时，才会创建文件
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        Book books = context.getBean("books", Book.class);
        System.out.println(books);
    }

    /**
     * ApplicationContext在加载配置文件时就会创建配置文件中的对象
     */
    @Test
    public void testApplicationContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book books = context.getBean("books", Book.class);
        System.out.println(books);
    }

}
