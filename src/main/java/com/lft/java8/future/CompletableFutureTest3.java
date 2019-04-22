package com.lft.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-19 14:38
 */
@SuppressWarnings("all")
public class CompletableFutureTest3 {
    private static List<DiscountShop> shops = Arrays.asList(
        new DiscountShop("banana"),
        new DiscountShop("apple"),
        new DiscountShop("blueberry"),
        new DiscountShop("orange"),
        new DiscountShop("pear"));

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        List<String> strawberry = findPrices("strawberry");
        long l1 = System.currentTimeMillis();
        List<String> strawberry1 = findPrices1("strawberry");
        long l2 = System.currentTimeMillis();
        List<String> strawberry2 = findPrices2("strawberry");
        long l3 = System.currentTimeMillis();
        //List<String> strawberry3 = findPrices3("strawberry");
        long l4 = System.currentTimeMillis();
        System.out.println("------ time :" + (l1 - l));
        System.out.println("------ time :" + (l2 - l1));
        System.out.println("------ time :" + (l3 - l2));
        System.out.println("------ time :" + (l4 - l3));
    }

    public static List<String> findPrices(String product) {
        return shops.stream()
            .map(shop -> shop.getPrices(product))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(Collectors.toList());
    }

    public static List<String> findPrices1(String product) {
        return shops.parallelStream()
            .map(shop -> shop.getPrices(product))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(Collectors.toList());
    }

    private static final Executor excutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public static List<String> findPrices2(String product) {
        List<CompletableFuture<String>> collect = shops.stream()
            //异步查价格
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrices(product), excutor))
            //同步解析价格　顺序传递
            .map(future -> future.thenApply(Quote::parse))
            //异步计算价格　顺序传递　　thenComposeAsync 不同线程 CompletableFuture 执行
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), excutor)))
            .collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

}
