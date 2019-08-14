package com.lft.java8.create;

import com.google.common.base.Objects;

import java.util.StringJoiner;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 10:53
 */
public class C implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", C.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
//        C clone1 = (C) clone;
//        clone1.name = new String(this.name);
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return Objects.equal(name, c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
