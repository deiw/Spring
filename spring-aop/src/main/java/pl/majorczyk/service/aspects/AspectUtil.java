package pl.majorczyk.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectUtil {
    @Pointcut("execution(* pl.majorczyk.service.BookRepository.*(..))")
    public void allBookRepositoryMethods(){}
}
