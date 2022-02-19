package com.atguigu.spring5.TestDemo5;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestJdbc  {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        book.setId(3);
        book.setUsername("Jack");
        book.setUstatus("on");
        bookService.add(book);
    }
    @Test
    public void testdel(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delById(2);

    }
    @Test
    public void testupdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = context.getBean("book", Book.class);
        book.setId(1);
        book.setUsername("hlm");
        book.setUstatus("on");
        bookService.update(book);

    }
    //查找记录数
    @Test
    public void testcount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        int count = bookService.findCount();
        System.out.println(count);

    }
    //返回一个对象
    @Test
    public void testBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.findBookById(1);
        System.out.println(book);

    }

    //返回所有元素
    @Test
    public void testAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> books = bookService.fianAll();
        for (Book b:books) {
            System.out.println(b);
        }

    }

    //批量添加数据
    @Test
    public void  addPi(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]>  list=new ArrayList<>();
        Object[] o1={4,"聊斋志异","in"};
        Object[] o2={5,"聊斋志异2","in"};
        Object[] o3={6,"鬼畜等","on"};
        list.add(o1);
        list.add(o2);
        list.add(o3);

        bookService.bathAdd(list);
    }
    //
    //批量修改数据
    @Test
    public void  bathUpdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]>  list=new ArrayList<>();
        Object[] o1={"sb123","in",3};
        Object[] o2={"abc","in",4};
        Object[] o3={"kb23gdfas","on",6};
        list.add(o1);
        list.add(o2);
        list.add(o3);

        bookService.bathupdate(list);
    }
    //批量删除
    @Test
    public void bathDel(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]>  list=new ArrayList<>();
        Object[] o1={3};
        Object[] o2={4};

        list.add(o1);
        list.add(o2);


        bookService.bathDel(list);
    }

}
