package com.atguigu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration   //配置类
@ComponentScan(basePackages ="com.atguigu")   //开启组件扫描
@EnableTransactionManagement   //开启事务
public class Config {
    //创建数据库连接池

    @Bean
    public DruidDataSource druidDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///user_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    //创建JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource){
        //根据类型到ioc容器中，找到source
        JdbcTemplate jdbctemplate = new JdbcTemplate();
        jdbctemplate.setDataSource(dataSource);
        return jdbctemplate;

    }


    //创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;

    }

}
