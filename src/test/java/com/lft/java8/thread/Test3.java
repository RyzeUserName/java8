package com.lft.java8.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程 同步屏障
 * @author Ryze
 * @date 2020-05-11 16:00
 */
public class Test3 {
    static final int COUNT = 5;
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, new Singer());

    static class Singer implements Runnable {
        @Override
        public void run() {
            System.out.println("唱歌了-------");
        }
    }

    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Staff(cyclicBarrier,i)).start();
        }
        synchronized (Test3.class) {
            Test3.class.wait();
        }
    }

    static class Staff implements Runnable {
        CyclicBarrier cb;
        int num;

        @Override
        public void run() {
            System.out.println("员工" + num + "出发");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "到达第1集结点");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "再出发");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "到达第2集结点");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "再出发");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "到达第3集结点");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("员工" + num + "结束");

        }

        public Staff(CyclicBarrier cb, int num) {
            this.cb = cb;
            this.num = num;
        }
    }

}
