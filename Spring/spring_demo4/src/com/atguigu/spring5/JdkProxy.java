package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces={UserDao.class};
        UserDao o = (UserDao)Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new UserDaoProxy(new UserDaoImp()));
        int add = o.add(1, 5);
//        System.out.println(add);

    }
}

class UserDaoProxy implements InvocationHandler{
    //1、创建的是谁的代理对象，就把谁传进来
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //创建代理对象代码
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法执行之前。。。。。"+method.getName());
        //被增强的方法执行
        Object o = method.invoke(obj, args);
        System.out.println(o);
        //方法执行之后
        System.out.println("方法执行之后。。。。。"+obj);

        return o;
    }
}
