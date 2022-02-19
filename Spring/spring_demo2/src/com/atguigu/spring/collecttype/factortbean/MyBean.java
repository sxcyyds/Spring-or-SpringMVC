package com.atguigu.spring.collecttype.factortbean;

import com.atguigu.spring.collecttype.Course;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

public class MyBean implements FactoryBean<Course> {

    //定义返回的bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
