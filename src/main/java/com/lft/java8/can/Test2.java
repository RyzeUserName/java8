package com.lft.java8.can;

import com.alibaba.excel.EasyExcel;
import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-25 17:15
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        List<Object> objects = EasyExcel.read(new FileInputStream("C:\\Users\\Ryze\\Desktop\\can.xlsx")).head(CAN.class).sheet(1).doReadSync();
        Map<String, List<CAN>> collect = objects.stream().map(o -> (CAN) o).collect(Collectors.groupingBy(can -> StringUtils.split(can.getA(), "_")[0]));
        List<String> objects1 = Lists.newArrayList();
        String s = "CREATE TABLE `iov_can_";
        String s1 = "` (\n" +
            "  `vin` char(17) NOT NULL,\n" +
            "`data_key` char(18) DEFAULT NULL COMMENT '数据标识号，对应kafka的消息key',\n" +
            "`collection_time` timestamp NULL DEFAULT NULL COMMENT '数据采集时间',\n";
        String s2 = "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
            "  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间，可作为数据接收时间用',\n" +
            "  `delete_flag` tinyint(4) DEFAULT 0 COMMENT '删除标记',\n" +
            "  PRIMARY KEY (`vin`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='";
        collect.entrySet().forEach(stringListEntry -> {
            String key = stringListEntry.getKey();
            List<CAN> value = stringListEntry.getValue();
            List<CAN> collect1 = value.stream().filter(c -> c.getC() != null || c.getD() != null).collect(Collectors.toList());
            CAN can = value.stream().filter(c -> c.getC() == null && c.getD() == null).findFirst().get();
            StringBuilder stringBuilder = new StringBuilder();
            collect1.forEach(canc -> {
                String b = canc.getB();
                String q = b.toLowerCase();
                String d = canc.getD();
                String sss = d == null ? null : d.replaceAll("\n", " ");
                sss = sss == null ? null : sss.replaceAll("\"", " ");
                String c = canc.getC();
                c = c == null ? "" : c.replaceAll("\n", " ");
                c = c == null ? "" : c.replaceAll("\"", " ");
                if (d != null && d.contains(".")) {
                    stringBuilder.append("`" + q + "` double(9,3) DEFAULT NULL COMMENT '" + c + sss + "'");
                } else {
                    stringBuilder.append("`" + q + "` int(11) DEFAULT NULL COMMENT '" + c + sss + "'");
                }
                stringBuilder.append(",");
                stringBuilder.append("\n");
            });
            String b = can.getB();
            b = b == null ? StringUtils.split(can.getA(), "_")[0] : b;
            objects1.add(s + key.toLowerCase() + s1 + stringBuilder.toString() + s2 + b + "';");
        });
        objects1.forEach(ss -> {
            System.out.println(ss);
        });
    }
}
