package com.lft.java8.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-03 16:29
 */
public class Test1 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = new Date(1588694400000L).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        now=now.withHour(0).withMinute(0).withSecond(0).withNano(0);
        long l = Duration.between(now,localDateTime).toDays();
        System.out.println(l);
    }
}
