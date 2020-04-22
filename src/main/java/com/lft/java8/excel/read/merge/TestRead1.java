package com.lft.java8.excel.read.merge;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-16 15:43
 */
public class TestRead1 {
    public static void main(String[] args) {
        ADataListener aDataListener = new ADataListener();
        EasyExcel.read("E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\excel\\read\\merge\\1.xlsx", A.class, aDataListener).extraRead(CellExtraTypeEnum.MERGE).sheet().doRead();
    }
}
