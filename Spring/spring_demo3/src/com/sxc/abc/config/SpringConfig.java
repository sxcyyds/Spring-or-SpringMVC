package com.sxc.abc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   //组为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.sxc.abc"})
public class SpringConfig {
}
