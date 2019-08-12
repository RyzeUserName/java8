package com.lft.java8.list;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019/6/26 20:22
 */
public class Test1 {
    static class User {
        public String type;
        public String name;

        public User(String type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
        }
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("1", "11"));
        users.add(new User("1", "12"));
        users.add(new User("2", "22"));
        users.add(new User("3", "33"));


        users.stream().collect(Collectors.groupingBy(a -> a.type,Collectors.mapping(o -> o.name,Collectors.toList())));
    }
}
