package pl.majorczyk.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.majorczyk.model.Book;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("pl.majorczyk.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logBefore(JoinPoint jp){
        Object[] args=jp.getArgs();
        System.out.printf("Log before %s with args %s \n",jp.getSignature(), Arrays.toString(args));
    }

    @After("pl.majorczyk.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logAfter(JoinPoint jp){
        System.out.printf("Method %s executed \n",jp.getSignature());
    }

    @AfterThrowing(pointcut = "pl.majorczyk.service.aspects.AspectUtil.allBookRepositoryMethods()",
    throwing = "error")
    public void logError(JoinPoint jp,Throwable error){
        System.out.printf("Method %s finished with error %s \n",jp.getSignature(),error.getMessage());
    }

    @AfterReturning(pointcut = "execution(* pl.majorczyk.service.BookRepository.get(..))&&args(isbn)",
    returning = "result")
    public void logSuccess(JoinPoint jp, Book result, String isbn){
        if (result!=null)
        System.out.printf("Method get() successfully returned %s for isbn %s \n",result,isbn);
    }
}
