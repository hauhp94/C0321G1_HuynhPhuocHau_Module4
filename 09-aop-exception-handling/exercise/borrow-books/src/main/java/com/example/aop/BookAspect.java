package com.example.aop;

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

    @Pointcut("execution(* com.example.controller.BookController.borrowBook(..))")
    public void borrow() {
    }
    @Pointcut("execution(* com.example.controller.BookController.giveBackBook(..))")
    public void pay() {
    }

    @Pointcut("within(com.example.controller.BookController*)")
    public void numberOfVisit(){}


    @After("numberOfVisit()")
    public void afterVisit(JoinPoint joinPoint){
        numberOfVisit+=1;
        System.err.println("number of visits: "+numberOfVisit+ " name method: "+joinPoint.getSignature().getDeclaringTypeName()+
                "- method name: "+ joinPoint.getSignature().getName()+
                "- Time: "+ LocalDate.now());

    }

    @After("borrow()")
    public void resultBorrow(JoinPoint joinPoint) {
        System.err.println("book plus 1 " + joinPoint.getSignature().getName());
        System.err.println("time :" + LocalDate.now());
    }
    @After("pay()")
    public void resultPay(JoinPoint joinPoint) {
        System.err.println("book minus 1 : " + joinPoint.getSignature().getName());
        System.err.println("time :" + LocalDate.now());
    }
}
