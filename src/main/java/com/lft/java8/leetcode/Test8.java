package com.lft.java8.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-24 15:55
 */
public class Test8 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}};

        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5},
        };
        rotate1(matrix1);
        rotate1(matrix2);
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        Set<Integer> integerX = new HashSet<>();
        Set<Integer> integerY = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    integerX.add(i);
                    integerY.add(j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (integerX.contains(i) || integerY.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        print(matrix);
    }

    public static void rotate1(int[][] matrix) {
        int length = matrix.length;
        int length1 = matrix[0].length;
        //第一行是否需要清零
        boolean firstFlg = false;
        //其他行是否需要清零
        boolean flg = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstFlg = true;
                    } else {
                        flg = true;
                    }
                    matrix[0][j] = 0;
                }
                // 遍历完此行之后判断是否清零
                if (flg && length1 == j + 1 && i != 0) {
                    matrix[i] = new int[length1];
                    // 清零标记重置
                    flg = false;
                }
            }
        }
        //进行列清零
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //第一横清零
        if (firstFlg) {
            matrix[0]=new int[length1];
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
}
