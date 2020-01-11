package com.lft.java8.observable;

/**
 * 测试观察者
 * @author Ryze
 * @date 2019-12-03 14:54
 */
public class Test1 {
    public static void main(String[] args) {
        //宠物店里 一只猫
        Cat cat = new Cat();
        //陆续来了6个人
        for (int i = 0; i < 6; i++) {
            Breeder breeder = new Breeder("路人" + i);
            cat.addObserver(breeder);
        }

        for (int i = 0; i < 6; i++) {
            cat.play();
        }
        System.out.println("猫睡着了");
    }
}
