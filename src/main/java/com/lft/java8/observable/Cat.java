package com.lft.java8.observable;

import java.util.Observable;
import java.util.Random;

/**
 * 被观察对象  猫
 * @author Ryze
 * @date 2019-12-03 15:44
 */
public class Cat extends Observable {
    /**
     * 活动
     */
    public void play() {
        System.out.println("猫开始活动了");
        int i = new Random().nextInt(3);
        PlayType playType = PlayType.getPlayType(i);
        System.out.println(playType.getMsg());
        setChanged();
        notifyObservers(playType);
    }

    enum PlayType {
        EAT(0, "猫吃东西~~~~~"), DRINK(1, "猫喝水~~~~~"), BEND(2, "猫遛弯~~~~~");
        private int v;
        private String msg;

        PlayType(int i, String msg) {
            this.v = i;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public static PlayType getPlayType(int i) {
            switch (i) {
                case 0:
                    return EAT;
                case 1:
                    return DRINK;
                case 2:
                    return BEND;
                default:
                    return null;
            }
        }
    }
}
