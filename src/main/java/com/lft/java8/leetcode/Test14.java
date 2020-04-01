package com.lft.java8.leetcode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-01 14:08
 */
public class Test14 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        print(addTwoNumbers(listNode1, listNode4));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode returnNode = null;
        ListNode returnNodeNext = null;
        int add = 0;
        while (add != 0 || next1 != null || next2 != null) {
            boolean b1 = next1 == null;
            boolean b2 = next2 == null;
            int val1 = b1 ? 0 : next1.val;
            int val2 = b2 ? 0 : next2.val;
            int i = val1 + val2 + add;
            if (i > 9) {
                i = i - 10;
                add = 1;
            } else {
                add = 0;
            }
            ListNode listNode = new ListNode(i);
            if (returnNode == null) {
                returnNode = listNode;
                returnNodeNext = listNode;
            } else {
                returnNodeNext.next = listNode;
                returnNodeNext = listNode;
            }
            next1 = b1 ? null : next1.next;
            next2 = b2 ? null : next2.next;
        }
        return returnNode;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
