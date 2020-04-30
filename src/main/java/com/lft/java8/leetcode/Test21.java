package com.lft.java8.leetcode;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 通过次数2,908提交次数3,956
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-21 17:16
 */
public class Test21 {
    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        System.out.println(queue.peek());
//        System.out.println(queue.pop());
//        System.out.println(queue.peek());
//        System.out.println(queue.empty());
        System.out.println(" 是就是 就是sssss ".trim().toUpperCase());
    }

    static class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
            stack2.clear();
            int size = stack1.size();
            for (int i = size - 1; i >= 0; i--) {
                stack2.push(stack1.get(i));
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            stack1.remove(0);
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack2.isEmpty();
        }
    }
}
