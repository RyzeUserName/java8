package com.lft.java8.compiler;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Javassist 编译测试
 * @author Ryze
 * @date 2020/5/24 21:51
 */
public class JavassistTest {
    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass helloWorld = pool.makeClass("HelloWorld");
        CtMethod make = CtNewMethod.make(" public static void hello(){\n" +
            "        System.out.println(\"hello world\");\n" +
            "    }", helloWorld);
        helloWorld.addMethod(make);
        Class aClass = helloWorld.toClass();
        Object instance = aClass.newInstance();
        Method hello = aClass.getDeclaredMethod("hello", null);
        hello.invoke(instance,null);
    }
    public static void hello(){
        System.out.println("hello world");
    }
}
