package second.fuxi.proxy.annototal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentProxy {
    @Pointcut(value ="execution(* second.fuxi.proxy.annototal.Student.eat(..))" )
    public void a(){

    }
    @Before(value = "execution(* second.fuxi.proxy.annototal.Student.eat(..))")
    public void be(){

        System.out.println("吃饭之前要洗手---------befor");
    }
    @Around(value = "a()")
    public void round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();  //调用被增强的方法
        System.out.println("环绕之后");
    }

    @After(value = "execution(* second.fuxi.proxy.annototal.Student.eat(..))")
    public void af(){

        System.out.println("吃饭之后也要洗手-------after");
    }

}
