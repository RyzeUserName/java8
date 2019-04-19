package com.lft.java8.list;

import java.util.*;

/**
 * @author ryze
 */
public class MyArrayList<T> implements List<T> {
    private T[] array;
    private int size;

    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
//        for (int j = 0; j < size; j++) {
//            if (array[j] == null && o == null) {
//                return true;
//            } else if (array[j].equals(o)) {
//                return true;
//            }
//        }
//        return false;
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        T[] ts = Arrays.copyOf(array, size);
        return Arrays.asList(ts).iterator();
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        //过长
        if (size >= array.length) {
            T[] ts = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, ts, 0, array.length);
            array = ts;
        }
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            while (contains(o)) {
                for (int j = indexOf(o); j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
            }
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = true;
        for (T t : c) {
            flag &= add(t);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        // array = (T[]) new Object[10];
        size = 0;
    }

    /**
     * O(1) 时间
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * 常数时间 O(1)
     * @param index
     * @param element
     * @return
     */
    @Override
    public T set(int index, T element) {
        T old = get(index);
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        //增加
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);
        for (int j = index; j < size - 1; j++) {
            array[j + 1] = array[j];
        }
        array[index] = element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T t = array[index];
        for (int j = index; j < size - 1; j++) {
            array[j] = array[j + 1];
        }
        array[size - 1] = null;
        size--;
        return t;
    }

    /**
     * 线性时间 O(n) 一次for循环
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            boolean b = (o == null && array[i] == null) || (o != null && o.equals(array[i]));
            if (b) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            boolean b = (o == null && array[i] == null) || (o != null && o.equals(array[i]));
            if (b) {
                return i;
            }
        }
        return -1;
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
        if (fromIndex < 0 || fromIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (toIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        T[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
        return Arrays.asList(copy);
    }
}
