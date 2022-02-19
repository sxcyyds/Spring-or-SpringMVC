package test;

import com.atguigu.com.User;
import com.atguigu.com.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Testbean {
    @Test
    public void testbean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        userservice.add();
    }
      @Test
    public void testEmp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp e= context.getBean("emp", Emp.class);
        System.out.println(e);
    }
    @Test
    public void testEmp1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Emp e= context.getBean("emp", Emp.class);
        System.out.println(e);
    }

}
