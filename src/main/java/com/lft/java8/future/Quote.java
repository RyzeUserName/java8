package com.lft.java8.future;

/**
 * 描述
 * @author Ryze
 * @date 2019-04-19 15:56
 */
public class Quote {
    private String name;
    private Double price;
    private Discount.code disCode;

    public Quote(String name, Double price, Discount.code disCode) {
        this.name = name;
        this.price = price;
        this.disCode = disCode;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        return new Quote(split[0], Double.valueOf(split[1]), Discount.code.valueOf(split[2]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Discount.code getDisCode() {
        return disCode;
    }

    public void setDisCode(Discount.code disCode) {
        this.disCode = disCode;
    }
}
