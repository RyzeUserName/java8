package com.lft.java8.create;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * 描述
 * @author Ryze
 * @date 2019-09-18 17:30
 */
public class Test111 {
    public static void main(String[] args) {
        LocalDate localDate = Instant.ofEpochMilli(1568822400000L).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        LocalDate localDate1 = Instant.ofEpochMilli(1568908799999L).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate1);
    }
}
