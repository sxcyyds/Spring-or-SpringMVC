package com.atguigu.spring5.service;


import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.PlatformLoggingMXBean;

@Service
@Transactional
public class UserService {
    //将UserDaoImp注入进来
    @Autowired
    private UserDao dao;


    //转账操作
    public void accountMoney(){
//        try {

            //第一步：开启事务

            //第二部：进行业务操作

            //lucy少100
            dao.reduceMoney();

            //模拟异常




            //mary多100
            dao.addMoney();

            //第三步：没有发生异常，提交事务

//        }catch(Exception e){
//            //第四步、发生异常，事务回滚
//
//        }

    }

}
