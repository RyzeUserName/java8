package com.lft.java8.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 线程
 * @author Ryze
 * @date 2020-05-11 16:00
 */
public class Test2 {
    static final int COUNT = 20;
    static CountDownLatch countDownLatch = new CountDownLatch(COUNT);
    @Test
    public void test1() throws InterruptedException {
        new Thread(new Teacher(countDownLatch)).start();
        for (int i = 0; i < 20; i++) {
            new Thread(new Student(countDownLatch,i)).start();
        }
        synchronized (Test2.class) {
            Test2.class.wait();
        }
    }
    class Teacher implements Runnable {
        CountDownLatch countDownLatch;

        public Teacher(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("老师开始发卷子");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("收卷完成");
        }
    }

    class Student implements Runnable {
        CountDownLatch countDownLatch;
        int num;

        public Student(CountDownLatch countDownLatch, int num) {
            this.countDownLatch = countDownLatch;
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("学生" + num + "开始做卷子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("学生" + num + "交卷");
            countDownLatch.countDown();
        }
    }
}
