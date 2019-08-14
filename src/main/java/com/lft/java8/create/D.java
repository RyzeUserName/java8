package com.lft.java8.create;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 16:24
 */
public class D implements Comparable<D> {
    private int age;
    private String name;
    private LocalDateTime localDateTime;

    public D() {
    }

    public D(D d) {
        this.age = d.getAge();
        this.name = d.getName();
        this.localDateTime = d.getLocalDateTime();
    }


    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public int compareTo(D o) {
        int result = Integer.compare(this.getAge(), o.getAge());
        if (result == 0) {
            result = this.getName().compareTo(o.getName());
        }
        if (result == 0) {
            result = this.getLocalDateTime().compareTo(o.getLocalDateTime());
        }
        return result;
    }

    public static class DBuilder {
        private D d;

        public DBuilder() {
            this.d = new D();
        }

        public DBuilder age(int age) {
            this.d.setAge(age);
            return this;
        }

        public DBuilder name(String name) {
            this.d.setName(name);
            return this;
        }

        public DBuilder localDateTime(LocalDateTime localDateTime) {
            this.d.setLocalDateTime(localDateTime);
            return this;
        }

        public D build() {
            return new D(this.d);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", D.class.getSimpleName() + "[", "]")
            .add("age=" + age)
            .add("name='" + name + "'")
            .add("localDateTime=" + localDateTime)
            .toString();
    }
}
