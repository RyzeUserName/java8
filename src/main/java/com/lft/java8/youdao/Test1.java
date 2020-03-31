package com.lft.java8.youdao;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 翻译
 * @author Ryze
 * @date 2020-02-24 13:58
 */
public class Test1 {
    private static final String S1 = "{\n" +
        "  \"type\": \"object\",\n" +
        "  \"properties\":{";
    private static final String S2_1 = "\": {\n" +
        "      \"type\": \"string\",\n" +
        "      \"description\":\"";
    private static final String S2_3 = " \"\n" +
        "    },";
    private static final String S3 = "},\n" +
        "  \"required\": [],\n" +
        "  \"$$ref\": \"#/definitions/";
    private static final String S5 = "\"\n" +
        "}";
    private static final String TABLE_S1 = "CREATE TABLE `";
    private static final String TABLE_S3 = "` (\n" +
        "  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',\n" +
        "  `remark` varchar(500) DEFAULT NULL COMMENT '备注',\n" +
        "  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',\n" +
        "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
        "  `operator` varchar(32) DEFAULT NULL COMMENT '更新人',\n" +
        "  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
        "  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '删除标识',\n";

    private static final String TABLE_S5 = "  PRIMARY KEY (`id`)\n" +
        ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='";

    private static final String TABLE_S7 = "';";
    private static final String TABLE_DEFAULT = " DEFAULT NULL COMMENT '";

    public static void main(String[] args) throws IOException {
        translationYapi("待保养车辆列表", Boolean.TRUE,
            Pair.of("当前里程数", "char(17)"),
            Pair.of("到期保养里程数", "varchar(100)"),
            Pair.of("到期保养日期", "varchar(100)")
        );
    }

    public static Converter<String, String> stringStringConverter2 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);
    public static Converter<String, String> stringStringConverter3 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);

    public static void translationYapi(String content, Boolean needTable, Pair<String, String>... colAll) throws IOException {
        List<String> cols = Arrays.stream(colAll).map(Pair::getKey).collect(Collectors.toList());
        List<String> strings = Lists.newArrayList(cols);
        strings.add(content);
        String collect = strings.stream().collect(Collectors.joining(","));
        String translate = TranslationTools.translate(collect);
        String[] split = translate.split(",");
        int size = strings.size();
        if (size != split.length) {
            split = translate.split("\\.");
        }
        StringBuilder s2 = new StringBuilder();
        StringBuilder tableS2 = new StringBuilder();
        String name = split[split.length - 1];
        tableS2.append(TABLE_S1);
        tableS2.append(getColStringHaveUnderscore(name, 2));
        tableS2.append(TABLE_S3);
        s2.append(S1);
        for (int i = 0; i < split.length - 1; i++) {
            StringBuilder ss = new StringBuilder();
            String col = split[i];
            String colStringHaveUnderscore = getColStringHaveUnderscore(col, 2);
            tableS2.append("`");
            tableS2.append(colStringHaveUnderscore);
            tableS2.append("` ");
            tableS2.append(colAll[i].getValue());
            tableS2.append(TABLE_DEFAULT);
            tableS2.append(strings.get(i));
            tableS2.append("' ,\n");
            String q = covert2(colStringHaveUnderscore);
            String result = toLowerCaseFirstOne(q);
            ss.append("\"" + result)
                .append(S2_1)
                .append(strings.get(i))
                .append(S2_3);
            s2.append(ss);
        }
        tableS2.append(TABLE_S5);
        tableS2.append(content);
        tableS2.append(TABLE_S7);
        s2.append("    \"id\": {\n" +
            "      \"type\": \"integer\",\n" +
            "      \"description\": \"id\"\n" +
            "    }")
            .append(S3)
            .append(getUpperString(name) + "DTO")
            .append(S5);

        System.out.println(s2.toString());
        System.out.println("---------");
        if (needTable) {
            System.out.println(tableS2.toString());
            System.out.println("---------");
        }
    }

    private static String getUpperString(String col) {
        String b = getUnderscoreString(col);
        return b.contains("_") ? stringStringConverter3.convert(b) : b;
    }

    @NotNull
    private static String getUnderscoreString(String col) {
        if (col.contains("'s")) {
            col.replaceAll("'s", "");
        }
        String all = col.replaceAll(" ", "_");
        col.replaceAll("", "");
        return all.toLowerCase();
    }

    private static String getColStringHaveUnderscore(String col) {
        String b = getUnderscoreString(col);
        return b.contains("_") ? stringStringConverter2.convert(b) : b;
    }

    private static String covert2(String b) {
        return b.contains("_") ? stringStringConverter2.convert(b) : b;
    }

    private static String getColStringHaveUnderscore(String col, int i) {
        if (col.contains("'s")) {
            col.replaceAll("'s", " ");
        }
        col = col.trim();
        for (int j = 0; j < i; j++) {
            col = col.replaceFirst(" ", "_");
        }
        col = col.replaceAll(" ", "");
        //col.replaceAll("", "");
        return col.toLowerCase();
    }

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
