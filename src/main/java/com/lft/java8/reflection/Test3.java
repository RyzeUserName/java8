package com.lft.java8.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-14 17:57
 */
public class Test3 {
    static class A {
        private String say1() {
            return "say1";
        }

        public String say2(String name) {
            return name + " say2";
        }

        protected String say3() {
            return "say3";
        }

        public static String say4(String ... grs) {
            return "say4";
        }

        public synchronized String say5() {
            return "say5";
        }

        @Deprecated
        public String say6() throws RuntimeException {
            return "say6";
        }

        public static void main(String[] args) {
            Class<A> aClass = A.class;
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                //名称
                String name = method.getName();
                System.out.print("方法名: " + name);
                System.out.println();
                //修饰符
                String m = Modifier.toString(method.getModifiers());
                System.out.print(" 修饰符: " + m);
                System.out.println();
                //获得完整的方法信息（包括修饰符、返回值、路径、名称、参数、抛出值）
                String s = method.toGenericString();
                System.out.print(" 方法信息: " + s);
                System.out.println();
                //返回值信息
                Class<?> returnType = method.getReturnType();
                Type genericReturnType = method.getGenericReturnType();
                System.out.print(" 返回值类型: " + returnType);
                System.out.println();
                System.out.print(" 返回值签名类型: " + genericReturnType);
                System.out.println();
                //参数信息
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < genericParameterTypes.length; i++) {
                    Type genericParameterType = genericParameterTypes[i];
                    Class<?> parameterType = parameterTypes[i];
                    System.out.print(" 参数签名: " + genericParameterType);
                    System.out.println();
                    System.out.print(" 参数: " + parameterType);
                    System.out.println();
                }
                //异常
                Type[] genericExceptionTypes = method.getGenericExceptionTypes();
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                for (int i = 0; i < genericExceptionTypes.length; i++) {
                    Type genericParameterType = genericExceptionTypes[i];
                    Class<?> parameterType = exceptionTypes[i];
                    System.out.print(" 异常签名: " + genericParameterType);
                    System.out.println();
                    System.out.print(" 异常: " + parameterType);
                    System.out.println();
                }
                //注解
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                for (int i = 0; i < declaredAnnotations.length; i++) {
                    Annotation genericParameterType = declaredAnnotations[i];
                    System.out.print(" 注解: " + genericParameterType);
                    System.out.println();
                }
                boolean varArgs = method.isVarArgs();
                boolean bridge = method.isBridge();
                boolean synthetic = method.isSynthetic();
                boolean aDefault = method.isDefault();
                System.out.println("varArgs: " + varArgs + " bridge:" + bridge + " synthetic: " + synthetic + " isDefault:" + aDefault);
            }
            //方法名: main
            // 修饰符: public static
            // 方法信息: public static void com.lft.java8.reflection.Test3$A.main(java.lang.String[])
            // 返回值类型: void
            // 返回值签名类型: void
            // 参数签名: class [Ljava.lang.String;
            // 参数: class [Ljava.lang.String;
            //varArgs: false bridge:false synthetic: false isDefault:false
            //方法名: say1
            // 修饰符: private
            // 方法信息: private java.lang.String com.lft.java8.reflection.Test3$A.say1()
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            //varArgs: false bridge:false synthetic: false isDefault:false
            //方法名: say2
            // 修饰符: public
            // 方法信息: public java.lang.String com.lft.java8.reflection.Test3$A.say2(java.lang.String)
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            // 参数签名: class java.lang.String
            // 参数: class java.lang.String
            //varArgs: false bridge:false synthetic: false isDefault:false
            //方法名: say3
            // 修饰符: protected
            // 方法信息: protected java.lang.String com.lft.java8.reflection.Test3$A.say3()
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            //varArgs: false bridge:false synthetic: false isDefault:false
            //方法名: say4
            // 修饰符: public static transient
            // 方法信息: public static java.lang.String com.lft.java8.reflection.Test3$A.say4(java.lang.String...)
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            // 参数签名: class [Ljava.lang.String;
            // 参数: class [Ljava.lang.String;
            //varArgs: true bridge:false synthetic: false isDefault:false
            //方法名: say5
            // 修饰符: public synchronized
            // 方法信息: public synchronized java.lang.String com.lft.java8.reflection.Test3$A.say5()
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            //varArgs: false bridge:false synthetic: false isDefault:false
            //方法名: say6
            // 修饰符: public
            // 方法信息: public java.lang.String com.lft.java8.reflection.Test3$A.say6() throws java.lang.RuntimeException
            // 返回值类型: class java.lang.String
            // 返回值签名类型: class java.lang.String
            // 异常签名: class java.lang.RuntimeException
            // 异常: class java.lang.RuntimeException
            // 注解: @java.lang.Deprecated()
            //varArgs: false bridge:false synthetic: false isDefault:false
        }

    }

}
