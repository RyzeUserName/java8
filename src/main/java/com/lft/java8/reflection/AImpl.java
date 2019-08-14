package com.lft.java8.reflection;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-14 20:14
 */
public class AImpl implements A<String> {
    @Override
    public String say(String string) {
        return string;
    }
}
