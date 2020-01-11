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
public class Test1 {
    public static void main(String[] args) throws IOException {
        List<Object> objects = EasyExcel.read(new FileInputStream("C:\\Users\\Ryze\\Desktop\\can.xlsx")).head(CAN.class).sheet(1).doReadSync();
        Map<String, List<CAN>> collect = objects.stream().map(o -> (CAN) o).collect(Collectors.groupingBy(can -> StringUtils.split(can.getA(), "_")[0]));
        Converter<String, String> stringStringConverter2 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);
        List<String> objects1 = Lists.newArrayList();
        String s = "{\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"vin\": {\n" +
            "      \"type\": \"string\",\n" +
            "      \"description\": \"vin\"\n" +
            "    },\n" +
            "    \"collectionTime\": {\n" +
            "      \"type\": \"integer\",\n" +
            "      \"description\": \"采集时间\",\n" +
            "      \"format\": \"int64\"\n" +
            "    },";

        collect.entrySet().forEach(stringListEntry -> {
            String key = stringListEntry.getKey();
            List<CAN> value = stringListEntry.getValue();
            List<CAN> collect1 = value.stream().filter(c -> c.getC() != null || c.getD() != null).collect(Collectors.toList());
            CAN can = value.stream().filter(c -> c.getC() == null).findFirst().get();
            StringBuilder stringBuilder = new StringBuilder();
            int size = collect1.size();
            AtomicReference<Integer> i = new AtomicReference<>(0);
            collect1.forEach(canc -> {
                i.getAndSet(i.get() + 1);
                String b = canc.getB().toLowerCase();
                String q = b.contains("_") ? stringStringConverter2.convert(b) : b;
                q = toLowerCaseFirstOne(q);
                String d = canc.getD();
                String sss = d == null ? null : d.replaceAll("\n", " ");
                sss = sss == null ? null : sss.replaceAll("\"", " ");
                String c = canc.getC();
                c = c == null ? null : c.replaceAll("\n", " ");
                c = c == null ? "" : c.replaceAll("\"", " ");
                if (d != null && d.contains(".")) {
                    stringBuilder.append("" +
                        "    \"" + q + "\": {\n" +
                        "      \"type\": \"number\",\n" +
                        "      \"description\": \"" + c + sss + "\n\"" +
                        "    }");
                } else {
                    stringBuilder.append("" +
                        "    \"" + q + "\": {\n" +
                        "      \"type\": \"integer\",\n" +
                        "      \"description\": \"" + c + sss + "\",\n" +
                        "      \"format\": \"int32\"\n" +
                        "    }");
                }
                if (i.get() != size) {
                    stringBuilder.append(",");
                }

            });
            String s2 = "},\n" +
                "  \"$$ref\": \"#/definitions/" + key + "StatusDTO\",\n" +
                "  \"required\": []\n" +
                "}";
            objects1.add(can.getB() + "-----" + s + stringBuilder.toString() + s2);
        });
        objects1.forEach(ss -> {
            System.out.println(ss);
            System.out.println("------------------------------------------------------");
        });
    }

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
