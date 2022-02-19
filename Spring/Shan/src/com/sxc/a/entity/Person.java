package com.sxc.a.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    private User user;



    @Override
    public String toString() {
        return "Person{" +
                "user=" + user +
                '}';
    }
}
