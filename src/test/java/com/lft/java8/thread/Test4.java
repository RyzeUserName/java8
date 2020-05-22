package com.lft.java8.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;


/**
 * 线程 交换器
 * @author Ryze
 * @date 2020-05-11 16:00
 */
public class Test4 {
    static Exchanger<Tool> toolExchanger = new Exchanger();

    static class Tool {
        String name;
        String work;

        public Tool(String name, String work) {
            this.name = name;
            this.work = work;
        }
    }

    @Test
    public void test1() throws InterruptedException {
        new Thread(new Staff("小明",new Tool("笤帚","扫地"),toolExchanger,1000)).start();
        new Thread(new Staff("小红",new Tool("抹布","拖地"),toolExchanger,1500)).start();
        synchronized (Test4.class) {
            Test4.class.wait();
        }
    }

    static class Staff implements Runnable {
        String name;
        Tool tool;
        Exchanger<Tool> toolExchanger;
        long sleep;

        public Staff(String name, Tool tool, Exchanger<Tool> toolExchanger,long sleep) {
            this.name = name;
            this.tool = tool;
            this.toolExchanger = toolExchanger;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            System.out.printf("%s拿的工具是[%s]，他开始[%s]。。。", name, tool.name, tool.work);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s开始交换工具。。。", name);
            try {
                tool = toolExchanger.exchange(tool);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.printf("%s的工具变为[%s]，他开始[%s]。。。", name, tool.name, tool.work);
        }

    }

}
