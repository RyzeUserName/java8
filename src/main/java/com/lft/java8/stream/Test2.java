package com.lft.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-13 17:59
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<A> as = Lists.newArrayList(
            new A(1, 1, 1, 1, 1),
            new A(1, 1, 1, 1, 1),
            new A(1, 1, 1, 1, 1),
            new A(2, 1, 1, 1, 1),
            new A(2, 1, 1, 1, 1),
            new A(3, 1, 1, 1, 1)

        );
        Map<Integer, A> collect = as.stream().collect(Collectors.groupingBy(o -> o.getId(), Collectors.collectingAndThen(Collectors.toList(), as1 -> {
            A a = as1.get(0);
            int sum1 = as1.stream().mapToInt(A::getCount1).sum();
            int sum2 = as1.stream().mapToInt(A::getCount2).sum();
            int sum3 = as1.stream().mapToInt(A::getCount3).sum();
            int sum4 = as1.stream().mapToInt(A::getCount4).sum();
            a.setCount1(sum1);
            a.setCount2(sum2);
            a.setCount3(sum3);
            a.setCount4(sum4);
            return a;
        })));
        System.out.println();

    }

    static class A {
        private int id;
        private int count1;
        private int count2;
        private int count3;
        private int count4;

        public A() {
        }

        public A(int id, int count1, int count2, int count3, int count4) {
            this.id = id;
            this.count1 = count1;
            this.count2 = count2;
            this.count3 = count3;
            this.count4 = count4;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCount1() {
            return count1;
        }

        public void setCount1(int count1) {
            this.count1 = count1;
        }

        public int getCount2() {
            return count2;
        }

        public void setCount2(int count2) {
            this.count2 = count2;
        }

        public int getCount3() {
            return count3;
        }

        public void setCount3(int count3) {
            this.count3 = count3;
        }

        public int getCount4() {
            return count4;
        }

        public void setCount4(int count4) {
            this.count4 = count4;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", A.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("count1=" + count1)
                .add("count2=" + count2)
                .add("count3=" + count3)
                .add("count4=" + count4)
                .toString();
        }
    }
}
