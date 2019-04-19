package com.lft.java8.future;

import java.util.Random;

public class Shop {
    private Random random = new Random();

    public Double getPrices(String product) {
        return calculatePrice(product);
    }

    public Double calculatePrice(String product) {
        deplay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private void deplay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
