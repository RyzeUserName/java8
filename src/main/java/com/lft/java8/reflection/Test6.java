package com.lft.java8.reflection;

import com.google.common.reflect.Reflection;
import org.junit.jupiter.api.Test;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-15 18:31
 */
public class Test6 {
    interface A {
        String say(String name);
    }

    class AImpl implements A {

        @Override
        public String say(String name) {
            return name;
        }
    }

    @Test
    public void test1() {
        A a = Reflection.newProxy(A.class, (proxy, method, args1) -> {
            String invoke = (String) method.invoke(proxy, args1);
            return invoke + " hello";
        });
        String xiao_ming = a.say("xiao ming");
        System.out.println(xiao_ming);
    }

}
