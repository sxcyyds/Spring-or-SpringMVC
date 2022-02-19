package com.atguigu.spring.collecttype.bean;

public class Orders {
    private String oname;

    public Orders() {
        System.out.println("第一步，我是Order的无参构造器");
    }

    public void setOname(String oname) {
        System.out.println("第二部，调用了set的方法设置属性的值");
        this.oname = oname;
    }



    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步，执行初始化方法");
    }

//    测试方法中对象的获取

    //创建执行销毁的方法
    public void destory(){
        System.out.println("第五步，执行销毁方法");
    }
}
