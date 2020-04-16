package com.lft.java8.leetcode;

/**
 * 三合一。描述如何只用一个数组来实现***三个栈****。
 *
 *  三个栈
 *
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-14 18:06
 */
public class Test18 {

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        boolean empty = tripleInOne.isEmpty(0);
    }

    /**
     * 先进后出
     *
     *
     */

    static class TripleInOne {
        private int[] ints;
        private int size;

        public TripleInOne(int stackSize) {
            size = stackSize;
            ints = new int[3 * size + 3];

        }

        public void push(int stackNum, int value) {
            if (ints[stackNum] == size) return;
            ints[stackNum * size + 3 + ints[stackNum]++] = value;

        }

        public int pop(int stackNum) {
            if (ints[stackNum] == 0) return -1;
            return ints[stackNum * size + 3 + --ints[stackNum]];
        }

        public int peek(int stackNum) {
            if (ints[stackNum] == 0) return -1;
            return ints[stackNum * size + 3 + ints[stackNum] - 1];

        }

        public boolean isEmpty(int stackNum) {
            return ints[stackNum] == 0;
        }
    }
}
