package com.atguigu.mvc.Interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class FirstIntecerptor  implements HandlerInterceptor {
//    perHandle在控制器方法执行前执行,返回false表示拦截，返回true表示放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstIntecerptor------>perHandle");
        return true;
    }
//postHandle在控制器方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstIntecerptor------>postHandle");
    }
//afterCompletion渲染万视图执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("FirstIntecerptor------>afterCompletion");
    }
}
