package com.lft.java8.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @author Ryze
 * @date 2020-03-23 14:15
 */
public class Test2 {
    public static void main(String[] args) {

    }

    public static boolean deal(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        String s1Str = s1.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining());
        String s2Str = s2.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining());
        return s1Str.equals(s2Str);
    }
}
