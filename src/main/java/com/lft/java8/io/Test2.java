package com.lft.java8.io;

import com.alibaba.excel.EasyExcel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * @author Ryze
 * @date 2019-11-28 11:12
 */
public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File file = new File("E:\\study\\java8\\src\\main\\resources\\1");
        File[] list = file.listFiles();
        List<WhiteListImportDTO> whiteListImportDTOS = new ArrayList<>();
        for (File clasz : list) {
            StringBuilder stringBuilder = new StringBuilder();
            FileInputStream fileInputStream = new FileInputStream(clasz);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            br.close();
            fileInputStream.close();
            String clazz = stringBuilder.toString();
            String[] split = clazz.split("interface");
            String s1 = split[0];
            String aPublic = s1.substring(s1.indexOf("/**") + 4, s1.indexOf(" * @a"));
            String s = split[1];
            String className = s.substring(0, s.indexOf("{"));
            String substring = s.substring(s.indexOf("{"), s.length() - 1);
            String[] split1 = substring.split(";");
            for (String s2 : split1) {
                String p = s2.substring(s2.indexOf("/**") + 4, s2.indexOf(" * @p"));
                WhiteListImportDTO whiteListImportDTO = new WhiteListImportDTO();
                whiteListImportDTO.setPhone(aPublic + className);
                whiteListImportDTO.setActivityCode(p);
                int index = s2.lastIndexOf("(");
                String p1 = s2.substring(s2.lastIndexOf(" ", index) + 1, index);
                whiteListImportDTO.setActivityName(p1);
                whiteListImportDTOS.add(whiteListImportDTO);
            }
        }
        EasyExcel.write("2.xlsx", WhiteListImportDTO.class).sheet("Sheet1").doWrite(whiteListImportDTOS);
    }

}
