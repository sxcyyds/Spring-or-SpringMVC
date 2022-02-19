package com.atguigu.spring5.proxy;

public class AA implements A{
    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }
}
