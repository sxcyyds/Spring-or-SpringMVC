package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{


    @Autowired
    private JdbcTemplate jdbcTemplate;


    //多钱方法      lucy转账给mary100
    public void addMoney(){
        String sql="update t_account set  money=money-? where username=?";
        int lucy = jdbcTemplate.update(sql, 100, "lucy");


    }
    //少钱的方法
    @Override
    public void reduceMoney() {
        String sql="update t_account set  money=money+? where username=?";
        int lucy = jdbcTemplate.update(sql, 100, "mary");

    }
}
