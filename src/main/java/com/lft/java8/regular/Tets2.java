package com.lft.java8.regular;

/**
 * 描述
 * @author Ryze
 * @date 2020-02-11 17:34
 */
public class Tets2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = new StringBuilder().append(stringBuilder.toString());
        System.out.println(append.length());
        System.out.println("1");
    }
}
