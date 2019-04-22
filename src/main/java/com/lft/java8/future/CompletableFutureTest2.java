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
public class CompletableFutureTest2 {
    private static List<Shop> shops = Arrays.asList(
        new Shop("banana"),
        new Shop("apple"),
        new Shop("orange"),
        new Shop("orange3"),
        new Shop("orange4"),
        new Shop("orange5"),
        new Shop("orange6"),
        new Shop("orange7"),
        new Shop("orange8"),
        new Shop("orange1"),
        new Shop("orange2"),
        new Shop("pear"));

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        List<String> strawberry = findPrices("strawberry");
        long l1 = System.currentTimeMillis();
        List<String> strawberry1 = findPrices1("strawberry");
        long l2 = System.currentTimeMillis();
        List<String> strawberry2 = findPrices2("strawberry");
        long l3 = System.currentTimeMillis();
        List<String> strawberry3 = findPrices3("strawberry");
        long l4 = System.currentTimeMillis();
        System.out.println("------ time :" + (l1 - l));
        System.out.println("------ time :" + (l2 - l1));
        System.out.println("------ time :" + (l3 - l2));
        System.out.println("------ time :" + (l4 - l3));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static List<String> findPrices(String product) {
        return shops.stream().map(shop -> shop.getName() + "-----price is ----" + shop.getPrices(product)).collect(Collectors.toList());
    }

    public static List<String> findPrices1(String product) {
        return shops.parallelStream().map(shop -> shop.getName() + "-----price is ----" + shop.getPrices(product)).collect(Collectors.toList());
    }

    /**
     * CompletableFuture 改造
     * 建议：有i/o 操作（网络链接等）---> CompletableFuture
     *      计算密集型 无I/O操作     ---> parallelStream
     * @param product
     * @return
     */
    public static List<String> findPrices2(String product) {
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() ->
            shop.getName() + "" + shop.getPrices(product))).collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    /**
     * thread = cpu * cpu利用率*（1+w/c）
     *  cpu =Runtime.getRuntime().availableProcessors()  我的是 8
     *  w/c 等待时间/计算时间  99% 的时间等待响应   1/100
     *  8* 1* 1.01
     * @param product
     * @return
     */
    private static final Executor excutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public static List<String> findPrices3(String product) {
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() ->
            shop.getName() + "" + shop.getPrices(product), excutor)).collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
}
