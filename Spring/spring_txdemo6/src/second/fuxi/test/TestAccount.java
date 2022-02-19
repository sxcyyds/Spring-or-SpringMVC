package second.fuxi.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import second.fuxi.dao.AccountDao;
import second.fuxi.service.AccountService;

public class TestAccount {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("fuxi1.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.money();
    }
}
