package com.atguigu.spring5.service;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;
    //添加
    public void add(Book user){
        bookDao.add(user);

    }
    //删除
    public void delById(Integer id){
        bookDao.delById(id);

    }
    //更新
    public void update(Book book){
        bookDao.update(book);

    }
    //查询表中的记录数
    public int findCount(){
        int count = bookDao.selectCount();
        return count;

    }
    //返回一个对象
    public Book findBookById(Integer i){
        Book book = bookDao.findById(i);
        return book;

    }
    //返回所有的数据
    public List<Book> fianAll(){
        return bookDao.findAllBook();

    }

    //批量参加
    public void  bathAdd(List<Object[]> bathAdd){
        bookDao.bathAddBook(bathAdd);

    }
    //批量修改
    public void bathupdate(List<Object[]> list){
        bookDao.bathUpdate(list);

    }
    //批量删除
    public void bathDel(List<Object[]> list){
        bookDao.bathDelBook(list);

    }



}
