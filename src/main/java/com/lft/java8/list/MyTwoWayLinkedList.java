package com.lft.java8.list;

import com.google.common.base.Function;

import java.util.*;

/**
 * 双端链表
 * @author Ryze
 * @date 2019-04-22 11:35
 */
public class MyTwoWayLinkedList<T> implements List<T> {
    private ListNode<T> head = null;
    private ListNode<T> foot = null;
    private int size = 0;

    public MyTwoWayLinkedList() {
    }

    ListNode<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int i = (size + 1) / 2;
        //前遍历
        if (index < i) {
            return functionNode(head, ListNode::getNext, index);
        } else {
            //后遍历
            return functionNode(foot, ListNode::getPrevious, size - index - 1);
        }
    }

    ListNode<T> functionNode(ListNode<T> next, Function<ListNode<T>, ListNode<T>> function, int index) {
        int i = 0;
        while (next != null && i < index) {
            next = function.apply(next);
            i++;
        }
        return next;
    }

    public MyTwoWayLinkedList(ListNode<T> head) {
        this.head = head;
        if (head != null) {
            size++;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        ListNode<T> tListNode = new ListNode<>(t);
        if (size == 0) {
            this.foot = tListNode;
            this.head = tListNode;
        } else {
            ListNode<T> foot = this.foot;
            foot.setNext(tListNode);
            tListNode.setPrevious(foot);
            this.foot = tListNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        ListNode<T> node = getNode(index);
        ListNode<T> tListNode = new ListNode<>(element);
        if (node == null) {
            this.foot = tListNode;
            this.head = tListNode;
        } else {
            tListNode.setPrevious(node.getPrevious());
            tListNode.setNext(node);
            node.setPrevious(tListNode);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public class ListNode<T> {
        private T t;
        private ListNode<T> next;
        private ListNode<T> previous;

        public ListNode() {
            this.t = null;
            this.next = null;
            this.previous = null;
        }

        public ListNode(T t) {
            this.t = t;
            this.next = null;
            this.previous = null;
        }

        public ListNode(T t, ListNode<T> next, ListNode<T> previous) {
            this.t = t;
            this.next = next;
            this.previous = previous;
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

        public ListNode<T> getPrevious() {
            return previous;
        }

        public void setPrevious(ListNode<T> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "t=" + t +
                ", next=" + next +
                '}';
        }
    }
}
