package com.lft.java8.create;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import sun.misc.Cleaner;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-12 16:07
 */
public class Room implements AutoCloseable {
    private final State state;
    private final Cleaner CLEANER;
    public Room(int thing) {
        this.state = new State(thing);
        this.CLEANER = Cleaner.create(this, state);
    }
    private static class State implements Runnable {
        int thing;
        public State(int thing) {
            this.thing = thing;
        }
        @Override
        public void run() {
            System.out.println("清理房间");
            thing = 0;
        }
    }
    @Override
    public void close() throws Exception {
        CLEANER.clean();
    }
    public static void main(String[] args) {
        try (Room room = new Room(9)) {
            System.out.println("清理");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
