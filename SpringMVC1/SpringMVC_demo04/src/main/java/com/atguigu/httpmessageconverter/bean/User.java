package com.atguigu.httpmessageconverter.bean;

import org.springframework.stereotype.Component;


public class User {
    private  String name;
    private  Integer age;
    private  String sex;

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
