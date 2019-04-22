package com.lft.java8.list;

import org.junit.Before;

import java.util.ArrayList;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-22 11:35
 */
public class MyLinkedListTest extends MyArrayListTest {
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyLinkedList<Integer>();
        mylist.addAll(list);
    }
}
