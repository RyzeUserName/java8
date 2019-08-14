package com.lft.java8.create;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 16:30
 */
public class TestD {
    public static void main(String[] args) {
        D d1 = new D.DBuilder().age(1).name("a").localDateTime(LocalDateTime.now()).build();
        D d11 = new D.DBuilder().age(1).name("b").localDateTime(LocalDateTime.now()).build();
        D d2 = new D.DBuilder().age(2).name("b").localDateTime(LocalDateTime.now()).build();
        D d22 = new D.DBuilder().age(2).name("c").localDateTime(LocalDateTime.now()).build();
        D[] ds = {d11, d22, d1, d2};
        Arrays.sort(ds);
        Arrays.stream(ds).forEach(System.out::println);
    }
}
