package com.lft.java8.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *  核心数是否满了
 *  等待队列是否满了
 *  线程池是否满了
 *  按照策略执行
 * @author Ryze
 * @date 2020-05-12 10:36
 */
public class Test7 {
    @Test
    public void test1() {
        /**
         * 核心线程数
         * 最大线程数
         * 执行完任务 无任务分配 可存活时间
         * 可存活时间单位
         * 线程池已满 队列也满了 对新任务的 拒绝策略
         *
         *                  AbortPolicy 拒绝 抛异常 默认
         *                  CallerRunsPolicy  扩容队列
         *                  DiscardPolicy   不处理新任务，直接丢弃掉。
         *                  DiscardOldestPolicy  将丢弃最早的未处理的任务请求。
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
            10,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(5), new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getId() + "   start   " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "  end   " + System.currentTimeMillis());
        };
        for (int i = 0; i < 30; i++) {
            executor.execute(runnable);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("结束");
    }
}
