package com.lft.java8.thread;

import org.junit.Test;

/**
 * 测试线程
 * @author Ryze
 * @date 2020-05-11 15:38
 */
public class Test1 {
    /**
     * 线程停止
     */
    @Test
    public void test1() {
        MyRun myRun = new MyRun();
        new Thread(myRun).start();
        myRun.tellStop();
    }

    /**
     * 线程暂停
     */
    @Test
    public void test2() throws InterruptedException {
        MyRun1 myRun = new MyRun1();
        Thread thread = new Thread(myRun);
        thread.start();
        myRun.tellPause();
        Thread.sleep(8000);
        myRun.tellResume();
    }
    /**
     * 线程切换
     */
    @Test
    public void test3() throws InterruptedException {
        MyRun2 myRun = new MyRun2();
        Thread thread = new Thread(myRun);
        thread.start();
        Thread.sleep(1000);
        thread.join();
        System.out.println("执行完毕");
    }

    class MyRun implements Runnable {
        volatile boolean stop;

        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println("线程执行 " + id);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("检测到 stop " + this.stop);
            if (this.stop) {
                System.out.println("停止");
                return;
            }
            System.out.println("进入不可停止区域");
            System.out.println("退出不可停止区域 ");
        }

        public void tellStop() {
            this.stop = true;
        }
    }

    public void sleep(long l) throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("进入睡眠 线程" + id);
        Thread.sleep(l);
        System.out.println("睡眠 完成 线程" + id);
    }

    class MyRun1 implements Runnable {
        volatile boolean pause;

        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println("线程执行 " + id);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("检测到 pause " + this.pause);
            if (this.pause) {
                System.out.println("暂停");
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("恢复执行");
            System.out.println("进入不可停止区域");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("退出不可停止区域 ");
        }

        public void tellPause() {
            this.pause = true;
        }

        public void tellResume() {
            synchronized (this) {
                this.notify();
            }
        }
    }

    class MyRun2 implements Runnable {

        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println("线程执行 " + id);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕 " + id);
        }

    }
}
