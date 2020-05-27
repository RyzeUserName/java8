package com.lft.java8.aop;

import org.springframework.stereotype.Component;

/**
 * 描述
 * @author Ryze
 * @date 2020-05-22 19:14
 */
@Component
public class A {
    @MyAnno
    public int a(int a, int b) {
        return a + b;
    }
}
