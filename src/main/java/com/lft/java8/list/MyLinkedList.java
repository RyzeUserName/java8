package com.lft.java8.list;

import java.util.*;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-22 11:35
 */
public class MyLinkedList<T> implements List<T> {
    private int size = 0;
    private ListNode<T> first = null;

    public MyLinkedList() {
    }

    public MyLinkedList(ListNode<T> first) {
        this.first = first;
        ListNode<T> nextNode = first;
        if (first != null) {
            int i = 0;
            while ((nextNode) != null) {
                i++;
                nextNode = nextNode.getNext();
            }
            this.size = i;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) Arrays.asList(toArray()).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        if (this.first != null) {
            int i = 0;
            ListNode<T> nextNode = first;
            do {
                objects[i] = nextNode.getT();
                i++;
                nextNode = nextNode.getNext();
            } while (nextNode != null);
        }
        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        ListNode<T> node = new ListNode<>(t);
        if (first == null) {
            first = node;
        } else {
            ListNode<T> nextNode = first;
            int i = 0;
            while (i < size - 1) {
                nextNode = nextNode.getNext();
                i++;
            }
            nextNode.setNext(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
//        if (first != null) {
//            boolean b = (o == null && first.getT() == null) || (o != null && o.equals(first.getT()));
//            if (b) {
//                first = first.getNext();
//                size--;
//                return true;
//            }
//            ListNode<T> nextNode = first;
//            do {
//                ListNode<T> next = nextNode.getNext();
//                T t = next != null ? nextNode.getNext().getT() : null;
//                boolean b1 = (o == null && t == null) || (o != null && o.equals(t));
//                if (b1) {
//                    nextNode.setNext(next != null ? next.getNext() : null);
//                    size--;
//                    return true;
//                }
//            } while ((nextNode = nextNode.getNext()) != null);
//        }
//        return false;
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        this.remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean back = true;
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return back;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean back = true;
        for (T o : c) {
            back &= add(o);
        }
        return back;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int i = index;
        for (T o : c) {
            add(i, o);
            i++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean back = false;
        for (Object o : c) {
            back &= remove(o);
        }
        return back;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        ListNode<T> next = this.first;
        while (next != null && i != index) {
            next = next.getNext();
            i++;
        }
        return next == null ? null : next.getT();
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> tListNode = new ListNode<>(element);
        if (index == 0) {
            tListNode.setNext(first == null ? null : first.getNext());
            T t = first == null ? null : first.getT();
            this.first = tListNode;
            return t;
        }
        int i = 0;
        ListNode<T> next = first;
        while (i < index - 1) {
            i++;
            next = next.getNext();
        }
        // 本身
        ListNode<T> next1 = next.getNext();
        T t = next1 == null ? null : next1.getT();
        //本身后一个
        tListNode.setNext(next1 == null ? null : next1.getNext());
        next.setNext(tListNode);
        return t;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> node = new ListNode<>(element);
        if (index == 0) {
            ListNode<T> temp = this.first;
            node.setNext(temp);
            this.first = node;
        } else {
            int i = 0;
            ListNode<T> next = first;
            while (i < index - 1) {
                i++;
                next = next.getNext();
            }
            ListNode<T> next1 = next.getNext();
            node.setNext(next1);
            next.setNext(node);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> next = this.first;
        int i = 1;
        while (i < index) {
            next = next.getNext();
            i++;
        }
        T t = next.getNext() == null ? null : next.getNext().getT();
        next.setNext(next.getNext() == null ? null : next.getNext().getNext());
        size--;
        return t;
    }

    @Override
    public int indexOf(Object o) {
        ListNode<T> next = this.first;
        int i = 0;
        while (next != null && i < size) {
            boolean b = (o == null && next.getT() == null) || (o != null && o.equals(next.getT()));
            if (b) {
                return i;
            }
            next = next.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        ListNode<T> next = this.first;
        int i = 0;
        int back = -1;
        while (i < size) {
            boolean b = (o == null && next.getT() == null) || (o != null && o.equals(next.getT()));
            if (b) {
                back = i;
            }
            i++;
            next = next.getNext();
        }
        return back;
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
        int i = 0;
        ListNode<T> next = first;
        while (i < fromIndex) {
            next = next.getNext();
            i++;
        }
        ListNode<T> head = new ListNode<>(next != null ? next.getT() : null);
        ListNode<T> next1 = head;
        while (i < toIndex) {
            next = next.getNext();
            next1.setNext(new ListNode<>(next != null ? next.getT() : null));
            next1 = next1.getNext();
            i++;
        }
        return new MyLinkedList<>(head);
    }

    private ListNode<T> nextFor = null;


}
