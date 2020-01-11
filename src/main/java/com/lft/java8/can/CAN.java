package com.lft.java8.can;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-25 17:11
 */
public class CAN {
    @ExcelProperty("报文名称")
    private String a;
    @ExcelProperty("信号名称")
    private String b;
    @ExcelProperty("信号描述")
    private String c;
    @ExcelProperty("信号值描述")
    private String d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
