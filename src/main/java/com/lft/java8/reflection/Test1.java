package com.lft.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-14 15:03
 */
public class Test1 {

    static class A {
        private String name;
        public int age;

        public A() {
        }

        private A(String name) {
            this.name = name;
        }

        private String getSomethingForPri(String name) {
            return name + " age is " + age;
        }

        public String getSomethingForPub(String name) {
            return name + " age is " + age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<A> aClass = A.class;
        // 可以获取的构造
        Constructor<A> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Constructor<A> declaredConstructor1 = aClass.getDeclaredConstructor();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        // 只能获取公有的构造
        Constructor<A> constructor = aClass.getConstructor();
        Constructor<?>[] constructors = aClass.getConstructors();

        // 获取全部成员变量
        Field declaredField1 = aClass.getDeclaredField("name");
        Field declaredField2 = aClass.getDeclaredField("age");
        Field[] declaredFields = aClass.getDeclaredFields();

        //只能获取公有的成员变量
        Field age = aClass.getField("age");
        Field[] fields = aClass.getFields();


        //获取方法 可以获取私有的
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Method declaredMethod1 = aClass.getDeclaredMethod("getSomethingForPri",String.class);
        Method declaredMethod2 = aClass.getDeclaredMethod("getSomethingForPub",String.class);


        //获取方法 不可获取私有的 但是获取全部方法 继承成的
        Method declaredMethod3 = aClass.getMethod("getSomethingForPub",String.class);
        Method[] methods = aClass.getMethods();
    }
}

