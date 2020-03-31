package com.lft.java8.leetcode;

/**
 * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-24 15:55
 */
public class Test7 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        rotate(matrix1);
        rotate(matrix2);
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        //沿主对角线 兑换
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int a = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = a ^ matrix[j][i];
                matrix[i][j] = a ^ matrix[i][j];
            }
        }
        int maxIndex = length - 1;
        //每组自己替换
        for (int i = 0; i < length; i++) {
            int[] matrixY = matrix[i];
            for (int j = 0; j < length / 2; j++) {
                int jj = maxIndex - j;
                int a = matrixY[j] ^ matrixY[jj];
                matrixY[j] = a ^ matrixY[j];
                matrixY[jj] = a ^ matrixY[jj];
            }
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
