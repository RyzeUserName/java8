package com.lft.java8.create;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 11:05
 */
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C();
        c.setName("name");

        C clone = (C)c.clone();

        System.out.println(c.equals(clone));
        System.out.println(c==clone);
        System.out.println(c.getName().equals(clone.getName()));
        System.out.println(c.getName()==clone.getName());


    }
}
