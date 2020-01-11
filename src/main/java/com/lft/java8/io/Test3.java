package com.lft.java8.io;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * 描述
 * @author Ryze
 * @date 2019-11-28 11:12
 */
public class Test3 {

    public static void main(String[] args) throws IOException {
        ArrayList<WhiteListImportDTO> objects = Lists.newArrayList();
        WhiteListImportDTO whiteListImportDTO1 = new WhiteListImportDTO();
        whiteListImportDTO1.setPhone("1");
        whiteListImportDTO1.setActivityCode("1");
        whiteListImportDTO1.setActivityName("1");
        WhiteListImportDTO whiteListImportDTO2 = new WhiteListImportDTO();
        whiteListImportDTO2.setPhone("2");
        whiteListImportDTO2.setActivityCode("2");
        whiteListImportDTO2.setActivityName("2");
        WhiteListImportDTO whiteListImportDTO3 = new WhiteListImportDTO();
        whiteListImportDTO3.setPhone("3");
        whiteListImportDTO3.setActivityCode("3");
        whiteListImportDTO3.setActivityName("3");
        objects.add(whiteListImportDTO1);
        objects.add(whiteListImportDTO2);
        objects.add(whiteListImportDTO3);
      //  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        EasyExcel.write("1.xlsx", WhiteListImportDTO.class).sheet("Sheet1").registerWriteHandler(new ColorCell()).doWrite(objects);
       // EasyExcel.write(outputStream,WhiteListImportDTO.class).sheet("Sheet1").registerWriteHandler(new ColorCell()).doWrite(objects);
//        outputStream.flush();
//        byte[] bytes = outputStream.toByteArray();
//        outputStream.close();
    }

}
