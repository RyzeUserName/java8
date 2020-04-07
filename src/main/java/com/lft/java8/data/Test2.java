package com.lft.java8.data;

/**
 * 链表反转
 * @author Ryze
 * @date 2019-12-31 18:37
 */
public class Test2 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        print(reverse(listNode1));

    }
    //链表反转
    public static ListNode reverse(ListNode head) {
        ListNode returnNode = null;
        //1->2->3->4->5
        ListNode next = head;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = returnNode;
            returnNode = next;
            next = nextNext;
        }
        return returnNode;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
