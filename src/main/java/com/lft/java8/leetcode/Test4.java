package com.lft.java8.leetcode;

import java.util.HashSet;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 * @author Ryze
 * @date 2020-03-23 17:04
 */
public class Test4 {
    public static void main(String[] args) {
        boolean b = canPermutePalindrome("AAbBBCCA");
        System.out.println(b);
    }

    public static boolean canPermutePalindrome(String s) {
        if (s == null || s == "") {
            return false;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int countOdd = length % 2;
        Character odd = null;
        for (int i = 0; i < length; i++) {
            int countChar = 1;
            char aChar = chars[i];
            for (int j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }
                if (aChar == chars[j]) {
                    countChar++;
                }
            }
            if (countChar % 2 == 1 && (odd == null || !odd.equals(aChar))) {
                odd = aChar;
                countOdd--;
            }
            if (countOdd < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canPermutePalindrome1(String s) {
        HashSet<Character> characters = new HashSet<>();
        for (char a : s.toCharArray()) {
            if (!characters.add(a)) {
                characters.remove(a);
            }
        }
        return characters.size() <= 1;
    }
}
