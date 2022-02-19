package com.sxc.abc.service;


import org.springframework.stereotype.Component;
//创建普通对象的组件,value的值和<bean id="userService" class="">中的id的值是等价的。
//value默认是可以省略的，默认值是类的名称，首字母小写
@Component
public class UserService {

    public void add(){
        System.out.println("Service add.....");
    }
}
