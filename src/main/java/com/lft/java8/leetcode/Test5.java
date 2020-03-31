package com.lft.java8.leetcode;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-24 10:33
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("park", "spake"));
    }

    public static boolean oneEditAway(String first, String second) {
        int fLength = first.length();
        int sLength = second.length();
        int difference = fLength - sLength;
        if (difference != 0 && difference != 1 && difference != -1) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }
        char[] fChars = first.toCharArray();
        char[] sChars = second.toCharArray();
        if (difference == 1) {
            boolean flg = false;
            for (int i = 0; i < sLength; i++) {
                if (!flg) {
                    if (fChars[i] != sChars[i]) {
                        if (fChars[i + 1] != sChars[i]) {
                            return false;
                        }
                        flg = true;
                    }
                } else {
                    if (fChars[i + 1] != sChars[i]) {
                        return false;
                    }
                }
            }
            return true;
        } else if (difference == -1) {
            boolean flg = false;
            for (int i = 0; i < fLength; i++) {
                if (!flg) {
                    if (fChars[i] != sChars[i]) {
                        if (fChars[i] != sChars[i + 1]) {
                            return false;
                        }
                        flg = true;
                    }
                } else {
                    if (fChars[i] != sChars[i + 1]) {
                        return false;
                    }
                }
            }
            return true;
        } else if (difference == 0) {
            int count = 1;
            for (int i = 0; i < fLength; i++) {
                if (fChars[i] != sChars[i]) {
                    count--;
                }
                if(count<0){
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    public static boolean oneEditAway1(String first, String second) {
        int f = first.length();
        int s = second.length();
        // 长度差大于1必然无法完成
        if (Math.abs(f - s) > 1) {
            return false;
        }
        int count = 1;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (f > s) {
                    // f长点儿，尝试给短的s添一个
                    j--;
                } else if (f < s) {
                    // s长点儿，尝试给短的f添一个
                    i--;
                }
                // 长度相同当前字符不同尝试替换一下
                // 替换完以后可编辑次数减1
                count--;
            }
            if (count < 0) return false;
        }
        return true;
    }
}
