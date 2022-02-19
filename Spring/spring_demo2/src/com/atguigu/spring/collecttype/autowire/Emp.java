package com.atguigu.spring.collecttype.autowire;

public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public void test(){
        System.out.println(dept);
    }
    @Override
    public String toString() {
        return  "dept=" + dept
                ;
    }
}
