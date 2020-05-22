package com.lft.java8.thread;

import java.util.concurrent.*;

/**
 * 线程池测试
 * @author Ryze
 * @date 2020-05-20 11:33
 */
public class Test1 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        Runnable runnable = () -> {
            System.out.println("线程执行开始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行结束");
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(runnable);
    }
    public static void test2(){
        Runnable runnable = () -> {
            System.out.println("线程执行开始");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行结束");
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(runnable);
        try {
             submit.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            boolean cancel = submit.cancel(true);
            System.out.println(cancel);
            e.printStackTrace();
        }
    }
}
