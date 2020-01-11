package com.lft.java8.web;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-17 20:19
 */
public class Test2 {
    public static void main(String[] args) {
        LinkedList<A> as = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            int group = 1;
            if (i > 19) {
                group=2;
            }
            as.add(new A(0, String.valueOf(i), group));
        }
        Random random = new Random();
        for (int i = 0; i < as.size(); i++) {
            int i1 = random.nextInt(100);
            A a = as.get(i);
            switch (a.group) {
                case 0:
                    i1 *= 1.8;
                    break;
                case 1:
                    i1 *= 1.2;
                    break;
                case 2:
//                    i1*=1.3;
//                    break;
//                case 3:
//                    i1*=1.2;
//                    break;
//                case 4:
//                    i1*=1;
//                    break;
            }
            a.sorce = i1;
            System.out.println(a);
        }
        List<A> collect = as.stream().sorted(Comparator.comparing(o -> (long) o.sorce)).limit(10).collect(Collectors.toList());
        System.out.println("中奖" + collect.stream().map(a -> a.name).collect(Collectors.joining(",")));

    }

    static class A {
        int sorce;
        String name;
        int group;

        public A(int sorce, String name, int group) {
            this.sorce = sorce;
            this.name = name;
            this.group = group;
        }

        public A(int sorce, String name) {
            this.sorce = sorce;
            this.name = name;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", A.class.getSimpleName() + "[", "]")
                .add("sorce=" + sorce)
                .add("name='" + name + "'")
                .add("group=" + group)
                .toString();
        }
    }
}
