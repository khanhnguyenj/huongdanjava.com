package com.huongdanjava.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloWorldAspect {

    @Before("execution (* com.huongdanjava.aspectj.HelloWorld.hello(..))")
    public void allMethods(JoinPoint joinPoint) {
        System.out.println("Hello, method name: " + joinPoint.getSignature().getName());
    }

}