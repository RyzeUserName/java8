package com.lft.java8.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * 描述
 * @author Ryze
 * @date 2019-10-25 11:16
 */
public class Test1 {
    public static void main(String[] args) {
//        String s = "sss";
//        String substring = s.substring(0, s.length());
////        System.out.println(substring);
//        System.out.println(get(1));
//        System.out.println(get1(1));
        ArrayList<Object> objects = new ArrayList<>();
        objects.addAll(null);
    }

    public static long get(int i) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(23, 59, 59);
        LocalDateTime now = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime = now.plusDays(i - 1);
        long l = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return l;
    }

    public static long get1(int i) {
        return LocalDateTime.of(
            LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(),
            23, 59, 59, 0
        ).plusDays(i-1).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
}
