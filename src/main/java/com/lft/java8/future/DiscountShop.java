package com.lft.java8.future;

import java.util.Random;

public class DiscountShop {
    private String name;


    public DiscountShop() {
    }

    public DiscountShop(String name) {
        this.name = name;
    }

    private Random random = new Random();

    public String getPrices(String product) {
        Double aDouble = calculatePrice(product);
        Discount.code value = Discount.code.values()[random.nextInt(Discount.code.values().length)];
        return getName() + ":" + aDouble + ":" + value;
    }

    public Double calculatePrice(String product) {
        deplay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    private static final Random RANDOM = new Random();

    private static void deplay() {
        try {
            //Thread.sleep(1000);
            //模拟延迟 0.5 -2.5
            Thread.sleep(RANDOM.nextInt(2000) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
