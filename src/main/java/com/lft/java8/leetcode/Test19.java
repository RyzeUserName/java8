package com.lft.java8.leetcode;

import java.util.*;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-15 17:15
 */
public class Test19 {

    /**
     * ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
     * [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
     * @param args
     */
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.push(2147483647);
        obj.push(-2147483648);
        obj.pop();

    }

    static class MinStack {
        private Stack<Integer> objects;

        public MinStack() {
            this.objects = new Stack<>();
        }

        public void push(int x) {
            int i = objects.size() > 0 ? (objects.lastElement()< x ? objects.lastElement() : x) : x;
            objects.push(x);
            objects.push(i);
        }

        public void pop() {
            objects.pop();
            objects.pop();
        }

        public int top() {
            return objects.get(objects.size()-2);
        }

        public int getMin() {
            return objects.size() > 0 ? objects.lastElement() : -1;
        }
    }
}
