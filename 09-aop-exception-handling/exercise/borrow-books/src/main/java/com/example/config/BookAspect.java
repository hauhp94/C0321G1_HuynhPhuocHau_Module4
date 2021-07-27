package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class BookAspect {

    public int numberOfVisit=0;

    @Pointcut("within(com.example.controller.BookController*)")
    public void addMethodPointCut(){};

    @Pointcut("within(com.example.controller.BookController*)")
    public void numberOfVisit(){}


    @After("numberOfVisit()")
    public void afterVisit(JoinPoint joinPoint){
        numberOfVisit+=1;
        System.err.println("number of visits: "+numberOfVisit+ " name method: "+joinPoint.getSignature().getDeclaringTypeName()+
                "- method name: "+ joinPoint.getSignature().getName()+
                "- Time: "+ LocalDate.now());

    }

    @After("addMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("After method in bookController Class name: "+ joinPoint.getSignature().getDeclaringTypeName()+
                "- method name: "+ joinPoint.getSignature().getName()+
                "- Time: "+ LocalDate.now());

    }
}
