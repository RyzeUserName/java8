package com.lft.java8.reflection;

import com.google.common.reflect.Reflection;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-15 18:31
 */
public class Test6 {
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    @interface t {
        String value();
    }

    interface A {
        String say(String name);

        String sayYou(String name);
    }

    static class AImpl implements A {
        @Override
        @t("测试")
        public String say(String name) {
            return name;
        }

        @Override
        public String sayYou(String name) {
            return "you  is " + name;
        }
    }

    static class MyInvocationHandler implements InvocationHandler {
        private Object source;
        private Class sourceClass;

        public MyInvocationHandler(Object source) {
            this.source = source;
            this.sourceClass = source.getClass();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Method declaredMethod = sourceClass.getDeclaredMethod(name, parameterTypes);
            t annotation = declaredMethod.getAnnotation(t.class);
            if (annotation != null) {
                String value = annotation.value();
                System.out.println("注解是 " + value);
                return method.invoke(source, args) + "添加的东西哦";
            } else {
                return method.invoke(source, args);
            }
        }
    }

    public static void main(String[] args) {
        InvocationHandler myInvocationHandler = new MyInvocationHandler(new AImpl());
        A a = Reflection.newProxy(A.class, myInvocationHandler);
        System.out.println(a.say("sss"));
        System.out.println(a.sayYou("sss"));
        //注解是 测试
        //sss添加的东西哦
        //you  is sss
    }


}
