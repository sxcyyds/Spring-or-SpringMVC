package com.atguigu.spring5.entity;

import org.springframework.stereotype.Component;


public class Book {
    private Integer id;
    private String username;
    private String ustatus;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }
}
