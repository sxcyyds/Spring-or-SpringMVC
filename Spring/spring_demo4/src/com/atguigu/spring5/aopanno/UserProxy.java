package com.atguigu.spring5.aopanno;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.stream.events.ProcessingInstruction;

//增强类
@Order(2)
@Component
@Aspect   //生成代理对象
public class UserProxy {
    @Pointcut(value="execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void a(){

    }
    //前置通知  @Befo注解表示作为前置通知
    @Before(value = "a()")
    public void befo(){
        System.out.println("Befor.....");
    }


    //在返回值之后执行（返回通知）
    @AfterReturning("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning.......");
    }


    //后置通知(最终通知)
    //value可以省略不写
    @After("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void after(){
        System.out.println("After......");
    }


    //异常通知，出现异常才会执行
    @AfterThrowing("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void thro(){
        System.out.println("异常通知。。。。。。。");
    }
    //环绕通知
    @Around("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知之前.......");
        proceedingJoinPoint.proceed();  //调用被增强的方法add（）
        System.out.println("环绕通知之后。。。。。。");


    }



}
