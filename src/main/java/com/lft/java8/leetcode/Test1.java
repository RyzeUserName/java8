package com.lft.java8.leetcode;

import java.util.stream.Collectors;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 *
 * @author Ryze
 * @date 2020-03-23 10:21
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(deal1("leetcode"));
        System.out.println(deal1("abc"));
        System.out.println(deal1(""));

    }

    public static boolean deal(String args) {
        int length = args.length();
        if (length < 0 || length > 100) {
            return false;
        }
        if (length == 0) {
            return true;
        }
        int distinctSum = args.chars().distinct().sum();
        int sum = args.chars().sum();
        return distinctSum == sum;
    }

    /**
     * 其实就是 26 个字母 不可重复出现
     * 那么一个26 大小的
     * @param astr
     * @return
     */
    public static boolean deal1(String astr) {
        char[] chars = astr.toCharArray();
        char a = 'a';
        int mark = 0;
        for (int i = 0; i < chars.length; i++) {
            int moveBit = chars[i] - a;
            if ((mark & (1 << moveBit)) != 0) {
                return false;
            } else {
                mark |= (1 << moveBit);
            }
        }
        return true;
    }
}
