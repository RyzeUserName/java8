package com.lft.java8.excel.read;

import com.alibaba.excel.EasyExcel;

import java.io.IOException;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-31 15:36
 */
public class ReadHeader {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Ryze\\Desktop\\车辆导入模板.xlsx";
        String[] split = fileName.split("\\\\");
        String[] split1 = split[split.length - 1].split("\\.");
        String name = split1[0];
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener(name)).sheet().doRead();
    }
}
