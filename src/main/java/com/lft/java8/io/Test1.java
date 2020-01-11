package com.lft.java8.io;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019-11-28 11:12
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fis = new FileInputStream("E:\\study\\java8\\src\\main\\resources\\api.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
        }
        fis.close();
        List<SuiBian> suiBians = JSON.parseArray(stringBuilder.toString(), SuiBian.class);
        List<WhiteListImportDTO> whiteListImportDTOS =
            suiBians.stream().filter(a -> a.getName().contains("v1.2")).map(suiBian -> {
                String name = suiBian.getName();
                List<WhiteListImportDTO> whiteListImportDTOS1 = new ArrayList<>();
                List<SuiBian.ListBean> list = suiBian.getList();
                for (SuiBian.ListBean listBean : list) {
                    WhiteListImportDTO whiteListImportDTO = new WhiteListImportDTO();
                    whiteListImportDTO.setPhone(name);
                    whiteListImportDTO.setActivityCode(listBean.getTitle());
                    whiteListImportDTO.setActivityName(listBean.getPath());
                    whiteListImportDTOS1.add(whiteListImportDTO);
                }
                return whiteListImportDTOS1;
            }).flatMap(Collection::stream).collect(Collectors.toList());
        EasyExcel.write("1.xlsx", WhiteListImportDTO.class).sheet("Sheet1").doWrite(whiteListImportDTOS);
    }

}
