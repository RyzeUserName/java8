package com.lft.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * 描述
 * @author Ryze
 * @date 2019-11-12 18:40
 */
public class Test1 {
    public static void main(String[] args) {
        List<A> as = Lists.newArrayList(new A("1", "2"), new A("3", "4"), new A("5", "6"));
        Set<String> collect = as.stream().collect((Supplier<Set<String>>) HashSet::new, (list, arg) -> {
            list.add(arg.getA());
            list.add(arg.getB());
        }, Set::addAll);
        collect.forEach(System.out::println);

    }

    static class A {
        private String a;
        private String b;

        public A(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
