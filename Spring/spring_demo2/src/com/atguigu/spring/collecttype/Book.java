package com.atguigu.spring.collecttype;

import javax.swing.*;
import java.util.List;

public class   Book {
    private List<String> list;
    private Stu stu;




    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                ", stu=" + stu +
                '}';
    }
}
