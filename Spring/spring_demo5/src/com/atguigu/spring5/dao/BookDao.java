package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.*;


@Repository
public class BookDao {
    //注入JdbcTemplate
    //默认按照类型进行注入，如果IOC容器中存在两个及以上的相同类型的bean时，
    //  根据bean的名称进行注入，如果没有指定名称的bean，则会报错。
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加方法
    public void add(Book user){
        String sql="insert into t_user(id,username,ustatus) values(?,?,?) ";
        int i = jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getUstatus());
        System.out.println(i);
    }

    public void delById(Integer id) {
        String sql="delete from t_user where id=?";
        int i = jdbcTemplate.update(sql, id);
        System.out.println("删除成功");
    }

    public void update(Book book) {
        String sql="update t_user set username=? ,ustatus=? where id=?";
        int i = jdbcTemplate.update(sql, book.getUsername(), book.getUstatus(), book.getId());
        System.out.println(i +"修改成功");



    }

    public int selectCount() {
        String sql="select count(*) from t_user";
        Integer integer = jdbcTemplate.queryForObject(sql, int.class);
        return integer;
    }

    public Book findById(Integer i) {
        String sql="select * from t_user where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), i);
        return book;

    }


    public List<Book> findAllBook() {
        String sql="select * from t_user";
        List<Book> book =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));

        return book;


    }

    public void bathAddBook(List<Object[]> bathAdd) {
        String sql="insert into t_user(id,username,ustatus) values(?,?,?) ";
        int[] ints = jdbcTemplate.batchUpdate(sql, bathAdd);
        System.out.println(Arrays.toString(ints));
    }

    public void bathUpdate(List<Object[]> list) {
        String sql="update t_user set username=?,ustatus=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }

    public void bathDelBook(List<Object[]> list) {
        String sql="delete from t_user where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(ints));
    }
}
