package com.lft.java8.data;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-31 18:37
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> longList=new ArrayList<>();
        longList.add(1);
        longList.add(2);
        longList.add(6);
        longList.add(3);
        List<Integer> collect = longList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(collect.get(0));
    }
}
