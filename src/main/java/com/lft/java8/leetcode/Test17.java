package com.lft.java8.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Ryze
 * @date 2020-04-07 14:28
 */
public class Test17 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;
        ListNode listNode = detectCycle1(node1);
        System.out.println(listNode == null ? null : listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        Set<String> objects = new HashSet<>();
        while (head != null) {
            if (objects.contains(head.toString())) {
                return head;
            } else {
                objects.add(head.toString());
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 环路检测 快慢指针
     * 1.  slow 走1步   fast 走2步
     * 2.  当 slow=fast  slow回到起点  步数 在  交点处 slow*2=fast  交点处即为中点处
     * 3.  slow 走1步   fast 走1步    步数 在  中点处 slow
     * 4.  当 slow=fast  即为交点
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if (slow == fast) {
                slow=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
