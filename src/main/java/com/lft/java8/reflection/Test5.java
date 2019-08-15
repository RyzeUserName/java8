package com.lft.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-15 17:19
 */
public class Test5 {
    static class A {
        private String say1(String... strings) {
            return "参数长度" + strings.length;
        }

        public String say2(String name, int a) {
            return "name:" + name + " a:" + a;
        }

        private String id;
        private int aa;

        private A() {
            this.id = "id";
            this.aa = 22;
        }

        public A(String id, int aa) {
            this.id = id;
            this.aa = aa;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", A.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("aa=" + aa)
                .toString();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        A id = new A("id", 1);
        Class<A> aClass = A.class;
        //反射 可变长参数 xxx[].class
        Method say1 = aClass.getDeclaredMethod("say1", String[].class);
        String [] ss={"sss", "ss1s"};
        //私有的 需要
        say1.setAccessible(true);
        //必须写(Object) ss  否则报错
        Object invoke = say1.invoke(id,(Object) ss);
        System.out.println(invoke);

        Method say2 = aClass.getDeclaredMethod("say2", String.class,int.class);
        Object sss = say2.invoke(id, "sss", 11);
        System.out.println(sss);

        //无参的 null
        Constructor<A> declaredConstructor = aClass.getDeclaredConstructor(null);
        //私有的 需要
        declaredConstructor.setAccessible(true);
        //无参的 null
        A a = declaredConstructor.newInstance(null);
        System.out.println(a);

        Constructor<A> declaredConstructor1 = aClass.getDeclaredConstructor(String.class, int.class);
        A qq = declaredConstructor1.newInstance("qq", 111);
        System.out.println(qq);

        //参数长度2
        //name:sss a:11
        //A[id='id', aa=22]
        //A[id='qq', aa=111]
    }
}
