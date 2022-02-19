package second.fuxi.proxy.annototal;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestA {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student = context.getBean("student", Student.class);
        student.eat();
    }
}
