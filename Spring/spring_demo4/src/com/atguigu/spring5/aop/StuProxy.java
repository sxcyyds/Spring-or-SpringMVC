package com.atguigu.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StuProxy {
    @Before("execution(* com.atguigu.spring5.aop.Stu.stu(..))")
    public void stubf(){
        System.out.println("学生吃完饭了");
    }
}
