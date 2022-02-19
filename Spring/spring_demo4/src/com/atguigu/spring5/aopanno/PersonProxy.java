package com.atguigu.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component
@Aspect
public class PersonProxy {

    @Before(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void sProxy(){
        System.out.println("第二次增强。。。。。。。");
    }
}
