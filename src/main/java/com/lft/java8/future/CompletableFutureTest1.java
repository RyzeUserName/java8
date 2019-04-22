package com.lft.java8.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Shop shop = new Shop();
        long millis = System.currentTimeMillis();
        Future<Double> coco1 = shop.getPricesAsync("coco1");
        long a = System.currentTimeMillis();
        Double coco = shop.getPrices("coco");
        long b = System.currentTimeMillis();
        System.out.println("time is-----" + (b - a) + "----price is -----" + coco);
        System.out.println(coco1.isDone());
        System.out.println("time is-----" + (a - millis) + "----price is -----" + coco1.get());
        System.out.println("time is-----" + (b - millis) + "----price is -----" + coco1.get());
    }

}
