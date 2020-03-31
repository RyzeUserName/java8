package com.lft.java8.leetcode;

import java.util.stream.Collectors;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 * 示例2:
 *
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 * 提示：
 *
 * 字符串长度在[0, 500000]范围内。
 * @author Ryze
 * @date 2020-03-23 15:40
 */
public class Test3 {
    public static void main(String[] args) {
        String s = replaceSpaces("Mr John Smith    ", 13);
        System.out.println(s);
    }

    public static String replaceSpaces(String S, int length) {
        if (length == 0) {
            return S;
        }
        return S.chars().mapToObj(value -> {
            if (value == 32) {
                return "%20";
            } else {
                return String.valueOf((char)value);
            }
        }).limit(length).collect(Collectors.joining());
    }
}
