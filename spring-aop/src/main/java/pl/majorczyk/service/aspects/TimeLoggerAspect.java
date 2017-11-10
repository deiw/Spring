package pl.majorczyk.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
public class TimeLoggerAspect {

    @Around("pl.majorczyk.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public Object measureExecTime(ProceedingJoinPoint pjp) throws Throwable{
        Instant start=Instant.now();
        try{
           Object result=pjp.proceed();
           return result;
        }finally {
            Instant end=Instant.now();
            Duration execTime=Duration.between(start,end);
            System.out.printf("%s execution took %d ms \n",pjp.toShortString(),execTime.toMillis());
        }
    }
}
