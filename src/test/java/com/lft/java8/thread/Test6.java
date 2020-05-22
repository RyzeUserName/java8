package com.lft.java8.thread;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述
 * @author Ryze
 * @date 2020-05-11 18:28
 */
public class Test6 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static Random random = new Random();

    static class Queue {
        Lock lock = new ReentrantLock();
        Condition proCondition = lock.newCondition();
        Condition conCondition = lock.newCondition();
        final int CAPACITY = 10;
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void put(Object o) throws InterruptedException {
            try {
                lock.lock();
                while (count == CAPACITY) {
                    System.out.println("生产过剩，生产者开始睡觉");
                    proCondition.await();
                }
                container[putIndex++] = o;
                System.out.println("生产者 生产中----");
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                System.out.println("通知消费者消费");
                conCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            try {
                lock.lock();
                while (count == 0) {
                    System.out.println("没有可消费的产品，消费者开始睡觉");
                    conCondition.await();
                }
                Object o = container[takeIndex++];
                System.out.println("消费者 消费----");
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                System.out.println("通知生产者生产----");
                proCondition.signalAll();
                return o;
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * 生产
     */
    static class Producer implements Runnable {
        Queue queue;

        public Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                doingLongTime();
                try {
                    queue.put(random.nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费
     */
    static class Consumer implements Runnable {
        Queue queue;

        public Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                doingLongTime();
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void doingLongTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
