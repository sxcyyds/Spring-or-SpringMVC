package com.atguigu.spring5.proxy;

import java.lang.reflect.*;

public class Aproxy {
    public static void main(String[] args) {
        Class[] interfaces={A.class};
        A a = (A) Proxy.newProxyInstance(Aproxy.class.getClassLoader(), interfaces, new AAAProxy(new AA()));
        a.add(23,43);
    }
}
class AAAProxy implements InvocationHandler{
    private Object object;

    public AAAProxy(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        方法执行之前
        System.out.println("方法执行之前");

//        执行方法
        Object o = method.invoke(object, args);

        //方法执行之后
        System.out.println("方法执行之后");
        return o;
    }
}