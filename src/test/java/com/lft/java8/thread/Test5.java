package com.lft.java8.thread;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.function.Consumer;

/**
 * 相比 CyclicBarrier 可以动态处理
 *  有12个工人
 *   三个阶段工作
 *   每阶段工作人员不一定
 *   按需
 * @author Ryze
 * @date 2020-05-11 17:37
 */
public class Test5 extends Phaser {
    private static Random random = new Random();
    static Consumer<Phaser> WORK = Phaser::arriveAndAwaitAdvance;
    static Consumer<Phaser> NOT_WORK = Phaser::arriveAndDeregister;

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Test5();
        Task[] tasks = new Task[12];
        int length = tasks.length;
        for (int i = 0; i < length; i++) {
            int k = random.nextInt(12);
            if (k < 5) {
                tasks[i] = new Task(phaser, WORK, WORK, WORK);
            } else if (k > 8) {
                tasks[i] = new Task(phaser, WORK, WORK, NOT_WORK);
            } else {
                tasks[i] = new Task(phaser, WORK, NOT_WORK, WORK);
            }
            phaser.register();
        }
        Thread[] threads = new Thread[length];
        for (int i = 0; i < length; i++) {
            threads[i] = new Thread(tasks[i], "线程" + i);
            threads[i].start();
        }
        //等待所有线程执行结束
        for (int i = 0; i < length; i++) {
            threads[i].join();
        }
        System.out.println("Phaser has finished:" + phaser.isTerminated());
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                checkNum(registeredParties);
                return false;
            case 1:
                return first();
            case 2:
                return second();
            case 3:
                return last();
            default:
                return true;
        }
    }

    private void checkNum(int registeredParties) {
        System.out.println("线程 开始工作 线程数" + registeredParties);
    }

    private boolean first() {
        System.out.println("第一阶段结束");
        return false;
    }

    private boolean second() {
        System.out.println("第二阶段结束");
        return false;
    }

    private boolean last() {
        System.out.println("第三阶段结束");
        return true;
    }

    static class Task implements Runnable {
        private Phaser phaser;
        private Consumer f1;
        private Consumer f2;
        private Consumer f3;


        public Task(Phaser phaser, Consumer<Phaser> f1, Consumer<Phaser> f2, Consumer<Phaser> f3) {
            this.phaser = phaser;
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始");
            f1.accept(phaser);
            if (f1.equals(WORK)) {
                System.out.println(Thread.currentThread().getName() + "第1阶段开始");
                doSomeThing();
                System.out.println(Thread.currentThread().getName() + "第1阶段结束");
                f2.accept(phaser);
                if (f2.equals(WORK)) {
                    System.out.println(Thread.currentThread().getName() + "第2阶段开始");
                    doSomeThing();
                    System.out.println(Thread.currentThread().getName() + "第2阶段结束");
                    f3.accept(phaser);
                    if (f3.equals(WORK)) {
                        System.out.println(Thread.currentThread().getName() + "第3阶段开始");
                        doSomeThing();
                        System.out.println(Thread.currentThread().getName() + "第3阶段结束");
                        phaser.arriveAndAwaitAdvance();
                    } else {
                        System.out.println(Thread.currentThread().getName() + "结束");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "结束");
            }
        }

        private void doSomeThing() {

        }
    }
}
