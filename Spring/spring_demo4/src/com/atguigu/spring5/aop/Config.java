package com.atguigu.spring5.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration    //代替xml文件
@ComponentScan(basePackages = {"com.atguigu.spring5.aop"})   //开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)   // 替换   <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class Config {

}


