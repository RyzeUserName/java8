package com.lft.java8.web;

import java.util.ArrayList;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-18 14:11
 */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.contains(Integer.valueOf(1)));
        System.out.println(integers.contains(1));
    }
}
