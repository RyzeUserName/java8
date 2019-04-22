package com.lft.java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;


    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    private Random random = new Random();

    public Double getPrices(String product) {
        return calculatePrice(product);
    }

    /**
     * 同步版本
     * 缺点： 同步
     * @param product 名字
     * @return
     */
    public Double calculatePrice(String product) {
        deplay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 异步版本1 future 返回
     *  缺点： 异常无法处理，发生异常get 一直阻塞
     * @param product 名字
     * @return
     */

    public Future<Double> getPricesAsync(String product) {
        CompletableFuture<Double> doubleCompletableFuture = new CompletableFuture<>();
        new Thread(() -> {
            Double aDouble = calculatePrice(product);
            doubleCompletableFuture.complete(aDouble);
        }).start();
        return doubleCompletableFuture;
    }

    /**
     * 异步版本2 异常处理
     *
     * @param product 名字
     * @return
     */

    public Future<Double> getPricesAsync2(String product) {
        CompletableFuture<Double> doubleCompletableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Double aDouble = calculatePrice(product);
                doubleCompletableFuture.complete(aDouble);
            } catch (Exception ex) {
                doubleCompletableFuture.completeExceptionally(ex);
            }
        }).start();
        return doubleCompletableFuture;
    }

    /**
     * 异步版本3 CompletableFuture 工厂方法使用
     *
     * @param product 名字
     * @return
     */

    public Future<Double> getPricesAsync3(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    private void deplay() {
        try {
            Thread.sleep(1000);
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
