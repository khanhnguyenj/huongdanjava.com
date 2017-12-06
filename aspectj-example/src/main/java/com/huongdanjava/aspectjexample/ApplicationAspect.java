package com.huongdanjava.aspectjexample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ApplicationAspect {

    @Before("execution (* com.huongdanjava.aspectjexample.Application.*(..))")
    public void allMethods(JoinPoint joinPoint) {
        System.out.println("Method name: " + joinPoint.getSignature().getName());
    }

}
