package pl.majorczyk.service.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* pl.majorczyk.service.BookRepository.*(..))")
    public void logBefore(){
        System.out.println("Log before ");
    }
    @After("execution(* pl.majorczyk.service.BookRepository.*(..))")
    public void logAfter(){
        System.out.println("Method executed");
    }
    @AfterThrowing("execution(* pl.majorczyk.service.BookRepository.*(..))")
    public void logError(){
       System.out.println("Method finished with error");
    }
    @AfterReturning("execution(* pl.majorczyk.service.BookRepository.*(..))")
    public void logSuccess(){
        System.out.println("Metod successfully returned");
    }
}
