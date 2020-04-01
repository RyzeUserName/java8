package com.lft.java8.leetcode;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，
 * x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-03-31 16:39
 */
public class Test13 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(10);
        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        print(partition(listNode1, 5));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode next = head;
        ListNode first = null;
        ListNode firstEnd = null;
        ListNode lastFirst = null;
        ListNode lastEnd = null;
        while (next != null) {
            int val = next.val;
            ListNode nextNext = next.next;
            if (val < x) {
                next.next = null;
                if (first == null) {
                    first = next;
                    firstEnd = next;
                } else {
                    firstEnd.next = next;
                    firstEnd = next;
                }
            } else {
                next.next = null;
                if (lastFirst == null) {
                    lastFirst = next;
                    lastEnd = next;
                } else {
                    lastEnd.next = next;
                    lastEnd = next;
                }
            }
            next = nextNext;
        }
        if (first != null) {
            firstEnd.next = lastFirst;
        } else {
            first = lastFirst;
        }
        return first;

    }


    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
