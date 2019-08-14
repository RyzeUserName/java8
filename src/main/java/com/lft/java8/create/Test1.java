package com.lft.java8.create;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-12 11:32
 */
public class Test1 {
    public void test1() {
        // 创建对象

        //1 构造

        A a1 = new A("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        //2 java Bean
        A a2 = new A();
        a2.setA1("1");
        a2.setA2("2");
        a2.setA3("3");
        a2.setA4("4");
        a2.setA5("5");
        a2.setA6("6");
        a2.setA7("7");
        a2.setA8("8");
        a2.setA9("9");
        a2.setA10("10");
        //3. builder

        B build1 = new B.BBuilder()
            .b1("1")
            .b2("2")
            .b3("3")
            .b4("4")
            .b5("5")
            .b6("6")
            .b7("7")
            .b8("8")
            .b9("9")
            .b10("10").build();

        B build2 = new B.BBuilder()
            .b1("1")
            .b2("2")
            .b3("3")
            .b4("4")
            .b5("5")
            .b6("6")
            .b7("7")
            .b8("8")
            .b9("9")
            .b10("10").build();
    }
}
