package com.example.springboottutorial.aspects;

import com.example.springboottutorial.entities.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnnotationAOP {

    @Around("@annotation(com.example.springboottutorial.annotations.MyAnnotation)")
    public void myAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before advice executed");
        try {
           User user = (User) proceedingJoinPoint.proceed();
            System.out.println(user);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("After advice executed");
    }

}
