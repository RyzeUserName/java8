package com.lft.java8.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-14 16:33
 */
public class Test2 {

    static class A<T> {
        public String name;
        public int age;
        public double[][] doubles;
        public T t;
        public final float aFloat=1F;

        @Override
        public String toString() {
            return new StringJoiner(", ", A.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("doubles=" + Arrays.toString(doubles))
                .add("t=" + t)
                .toString();
        }
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        A<String> stringA = new A<>();
        Class<? extends A> aClass = stringA.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            Class<?> type = field.getType();
            Type genericType = field.getGenericType();
            System.out.print(name+" field : type is " + type + ", genericType is " + genericType);
            System.out.println();
            //name field : type is class java.lang.String, genericType is class java.lang.String
            //age field : type is int, genericType is int
            //doubles field : type is class [[D, genericType is class [[D
            //t field : type is class java.lang.Object, genericType is T
        }
        Field aFloat = aClass.getField("aFloat");
        aFloat.setAccessible(true);
        aFloat.setFloat(stringA,2L);
        System.out.println(stringA.aFloat);
    }
}
