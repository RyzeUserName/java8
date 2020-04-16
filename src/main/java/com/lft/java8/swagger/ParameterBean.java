package com.lft.java8.swagger;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-08 14:20
 */
public class ParameterBean {
    private String name;
    private String in;
    private String description;
    private boolean required;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}