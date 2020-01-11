package com.lft.java8.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 饲养员
 * @author Ryze
 * @date 2019-12-03 15:43
 */
public class Breeder implements Observer {
    private String name;

    public Breeder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Cat.PlayType type = (Cat.PlayType) arg;
        switch (type) {
            case EAT:
                do1();
                break;
            case BEND:
                do2();
                break;
            case DRINK:
                do3();
                break;
            default:
        }
    }

    public void do1() {
        System.out.println(name + " 添点 吃的");
    }

    public void do2() {
        System.out.println(name + " 添点 喝的");
    }

    public void do3() {
        System.out.println(name + "看到 好开心");
    }

}
