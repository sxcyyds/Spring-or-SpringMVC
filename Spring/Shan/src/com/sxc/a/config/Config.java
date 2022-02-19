package com.sxc.a.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration     //代替xml
@ComponentScan(basePackages = "com.sxc.a")   //开启组件扫描
public class Config {
}
