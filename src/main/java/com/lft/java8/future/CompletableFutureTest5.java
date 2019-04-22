package com.lft.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * 查出 就显示
 * @author Ryze
 * @date 2019-04-19 14:38
 */
@SuppressWarnings("all")
public class CompletableFutureTest5 {
    private static List<DiscountShop> shops = Arrays.asList(
        new DiscountShop("banana"),
        new DiscountShop("apple"),
        new DiscountShop("blueberry"),
        new DiscountShop("orange"),
        new DiscountShop("pear"));


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
       // CompletableFuture[] list = findPrices("耳机").map(f -> f.thenAccept(System.out::println)).toArray(value -> new CompletableFuture[value]);
        long l1 = System.currentTimeMillis();
        CompletableFuture.allOf(findPrices("耳机").map(f -> f.thenAccept(s -> System.out.println(s + "---time----: " + (System.currentTimeMillis() - l)))).toArray(value -> new CompletableFuture[value])).join();
        long l2 = System.currentTimeMillis();
        long l3 = System.currentTimeMillis();
        long l4 = System.currentTimeMillis();
        System.out.println("------ time :" + (l1 - l));
        System.out.println("------ time :" + (l2 - l1));
        System.out.println("------ time :" + (l3 - l2));
        System.out.println("------ time :" + (l4 - l3));
    }


    private static final Executor excutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public static Stream<CompletableFuture<String>> findPrices(String product) {
        return shops.stream()
            //异步查价格
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrices(product), excutor))
            //同步解析价格　顺序传递
            .map(future -> future.thenApply(Quote::parse))
            //异步计算价格　顺序传递　　thenComposeAsync 不同线程 CompletableFuture 执行
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), excutor)));
    }

}
