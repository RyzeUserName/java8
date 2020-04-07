package com.lft.java8.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *  
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-01 15:51
 */
public class Test15 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println(isPalindrome1(listNode1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode next = head;
        List<Integer> ints = new ArrayList<>();
        while (next != null) {
            ints.add(next.val);
            next = next.next;
        }
        int size = ints.size();
        int sizeFix = size - 1;
        int i = size / 2;
        for (int j = 0; j <= i; j++) {
            int i1 = sizeFix - j;
            if (i1 != j && !ints.get(j).equals(ints.get(i1))) {
                return false;
            }

        }
        return true;
    }

    /**
     * 链表反转 链表截断  牛逼
     * @param head
     * @return
     */

    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = head;
        ListNode slow = pre.next;
        ListNode fast = slow.next;
        //fast 每次走两步  slow 每次走一步  fast 为末尾那个(有可能是null) slow是中间那个
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //将链表截成两个 0到pre  slow 到结束
        if (pre != null) {
            pre.next = null;
        }
        //反转后面链表
        pre = null;
        while (slow != null) {
            ListNode listNode = slow.next;
            //指向第一个
            slow.next = pre;
            pre = slow;
            slow = listNode;
        }
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }



}
