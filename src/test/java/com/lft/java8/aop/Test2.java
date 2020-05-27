package com.lft.java8.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述
 * @author Ryze
 * @date 2020-05-22 19:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
    @Autowired
    A a;
    @Test
    public void tetst(){
        System.out.println(a.a(1,2));
    }
}
