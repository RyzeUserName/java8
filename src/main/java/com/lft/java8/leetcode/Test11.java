package com.lft.java8.leetcode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-31 14:54
 */
public class Test11 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(kthToLast1(listNode1, 2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode next = head;
        int index = 0;
        while (next != null) {
            index++;
            next = next.next;
        }
        int i = index - k;
        index = 0;
        next = head;
        while (next != null) {
            if (index == i) {
                return next.val;
            }
            index++;
            next = next.next;
        }
        return 0;
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast1(ListNode head, int k) {
        ListNode to = head;
        while (k-->0){
            to=to.next;
        }
        ListNode next = head;
        while (to!=null){
            to=to.next;
            next=next.next;
        }
        return next.val;
    }
}
