package com.sxc.a.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String name="687";

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
