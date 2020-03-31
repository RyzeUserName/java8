package com.lft.java8.leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-31 11:26
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(isFlipedString1("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString1("aa", "aba"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        int length2 = s2.length();
        int length1 = s1.length();
        if (length2 != length1) {
            return false;
        }
        Map<String, Long> collect2 = s2.chars().mapToObj(value -> String.valueOf((char) value)).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        Map<String, Long> collect1 = s1.chars().mapToObj(value -> String.valueOf((char) value)).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        for (Map.Entry<String, Long> entry : collect1.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            Long aLong = collect2.get(key);
            if (aLong == null || !value.equals(aLong)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFlipedString1(String s1, String s2) {
        int length2 = s2.length();
        int length1 = s1.length();
        if (length2 != length1) {
            return false;
        }
        s1 += s1;
        return s1.contains(s2);
    }
}
