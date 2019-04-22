package com.lft.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-19 14:38
 */
@SuppressWarnings("all")
public class CompletableFutureTest4 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        b1();
        long l1 = System.currentTimeMillis();
        b2();
        long l2 = System.currentTimeMillis();
        long l3 = System.currentTimeMillis();
        long l4 = System.currentTimeMillis();
        System.out.println("------ time :" + (l1 - l));
        System.out.println("------ time :" + (l2 - l1));
        System.out.println("------ time :" + (l3 - l2));
        System.out.println("------ time :" + (l4 - l3));
    }

    static Integer b1() {
        Integer integer = do1();
        Integer integer1 = do2();
        return integer + integer1;
    }

    static Future<Integer> b2() {
        // 相对于 thenCombine() 而言 thenCompose() 有先后顺序
        // thenCombine() 没有先后顺序
        return CompletableFuture.supplyAsync(() -> do1())
            .thenCombine(
                CompletableFuture.supplyAsync(() -> do2()), (integer, integer2) -> integer + integer2);
    }

    static CompletableFuture<Integer> b3() {
        return CompletableFuture.supplyAsync(() -> do1())
            .thenCombine(
                CompletableFuture.supplyAsync(() -> do2()), (integer, integer2) -> integer + integer2);
    }

    static Integer do1() {
        deplay();
        return 1;
    }

    static Integer do2() {
        deplay();
        return 2;
    }

    private static void deplay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
