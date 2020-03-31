package com.lft.java8.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-31 11:39
 */
public class Test10 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        print(removeDuplicateNodes1(listNode1));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> strings = new HashSet<>();
        strings.add(head.val);
        ListNode first = head;
        ListNode next = first.next;
        while (next != null) {
            int val = next.val;
            if (strings.contains(val)) {
                //包含删除
                first.next = next.next;
                next = next.next;
            } else {
                strings.add(val);
                first = next;
                next = next.next;
            }
        }
        return head;
    }
    static Set<Integer> ints = new HashSet<>();
    public static ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        if(!ints.contains(head.val)){
            ints.add(head.val);
            head.next=removeDuplicateNodes1(head.next);
            return head;
        }else {
            return removeDuplicateNodes1(head.next);
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

}
