package com.atguigu.mvc.config;

import com.atguigu.mvc.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * 代替SpringMVC的配置文件
 * 1、扫描组件
 * 2、视图解析器
 * 3、view-controller
 * 4、default-servlet-handle     配置默认的servlet处理，需要实现接口WebMvcConfigurer
 * 5、mvc注解驱动
 * 6、文件上传解析器
 * 7、异常处理
 * 8、拦截器
 */
@Configuration                                                       //将当前类表示为配置类
@EnableWebMvc                                                       //开启mvc的注解驱动
@ComponentScan(basePackages = {"com.atguigu.mvc"})                   //组件扫描
public class WebConfig implements WebMvcConfigurer {
    //4、 default-servlet-handle
    //配置默认的servlet处理，需要实现接口WebMvcConfigurer，重写configureDefaultServletHandling方法
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  //表示当前默认的Servlet可用

    }
    //8、添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器，需要自己创建一个拦截器

        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");

    }
    //3、视图控制器

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");

    }
    //6、文件上传解析器
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }
    //7、配置异常解析器
    @Override
public void  configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    Properties prop = new Properties();
    prop.setProperty("java.lang.ArithmeticException", "error");
    //设置异常映射
    exceptionResolver.setExceptionMappings(prop);
    //设置共享异常信息的键
    exceptionResolver.setExceptionAttribute("ex");
    resolvers.add(exceptionResolver);
}

    //    配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =ContextLoader.getCurrentWebApplicationContext();
    // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过 WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new
                ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
}
    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }


}

