package com.sxc.a.test;

import com.sxc.a.config.Config;
import com.sxc.a.entity.Person;
import com.sxc.a.entity.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test1 {
    @Test
    public void testUser(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("user", User.class);
        user.setName("史旭超");
        System.out.println(user);
    }
    @Test
    public void testPerson(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person person = context.getBean("person", Person.class);

        System.out.println(person);
    }
}
