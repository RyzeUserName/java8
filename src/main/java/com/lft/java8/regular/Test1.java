package com.lft.java8.regular;

import java.util.regex.Pattern;

/**
 * 描述
 * @author Ryze
 * @date 2020-02-10 14:05
 */
public class Test1 {
    //字母数字
    static String regex1 = "^[a-z0-9A-Z]+$";
    //数字
    static String regex2 = "^-?\\d+(\\.\\d+)?$";
    //字母数字
    static Pattern p1 = Pattern.compile("^[a-z0-9A-Z]+$");

    public static void main(String[] args) {
        String s1="1234";
        String s2="1234xdfdsd";
        String s3="xdfdsd";
        String s4="xdfd-!ssd";
        String s5="^-xdfd-!ssd";
        System.out.println(p1.matcher(s1).matches());
        System.out.println(p1.matcher(s2).matches());
        System.out.println(p1.matcher(s3).matches());
        System.out.println(p1.matcher(s4).matches());
        System.out.println(p1.matcher(s5).matches());
    }
}
