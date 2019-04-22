package com.lft.java8.list;

/**
 * 节点数据
 * @author Ryze
 * @date 2019-04-22 11:30
 */
public class ListNode<T> {
    private T t;
    private ListNode<T> next;

    public ListNode() {
        this.t = null;
        this.next = null;
    }

    public ListNode(T t) {
        this.t = t;
        this.next = null;
    }

    public ListNode(T t, ListNode<T> next) {
        this.t = t;
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "t=" + t +
            ", next=" + next +
            '}';
    }
}
