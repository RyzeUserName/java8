package com.lft.java8.create;

/**
 * 描述
 * @author Ryze
 * @date 2019-08-13 20:17
 */
public enum AEnum {
    A1("sa1"),  A2("sa2"),
    ;
    String label;

    AEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
