package com.lft.java8.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnnoAspect {
    @Pointcut("@annotation(com.lft.java8.aop.MyAnno)")
    public void annotationPointcut() {

    }

    @Around("annotationPointcut()")
    public Object a(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            System.out.println("----额外执行----");
        }
        return joinPoint.proceed();
    }
}
