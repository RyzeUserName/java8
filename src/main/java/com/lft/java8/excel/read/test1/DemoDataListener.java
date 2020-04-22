package com.lft.java8.excel.read.test1;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.lft.java8.youdao.TranslationTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    private String name;

    public DemoDataListener(String name) throws IOException {
        String translate = TranslationTools.translate(name);
        translate = dealStr(translate);
        Converter<String, String> stringStringConverter2 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);
        translate = stringStringConverter2.convert(translate);
        this.name = "public class " + translate + "DTO {";
    }

    @Override
    public void invoke(DemoData data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        StringBuilder builder = new StringBuilder();
        headMap.entrySet().forEach(integerStringEntry -> {
            //System.out.printf("解析到一条头数据 %s", integerStringEntry.getValue());
            String value = integerStringEntry.getValue();
            try {
                String translate = TranslationTools.translate(value);
                translate = dealStr(translate);
                Converter<String, String> stringStringConverter2 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);
                Converter<String, String> stringStringConverter3 = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);
                String convert1 = stringStringConverter2.convert(translate);
                String convert2 = stringStringConverter3.convert(translate);
                builder.append( "\n  @ExcelProperty(\"" + value + "\")");
                builder.append( "\n private String " + convert1 + ";");
                builder.append( "\n \n public String get" + convert2 + "() {\n");
                builder.append( " return "+convert1+";\n");
                builder.append( "         } \n \n ");
                builder.append( "public void set"+ convert2 + "(String "+convert1+") {\n");
                builder.append( "  this."+convert1+" = "+convert1+";\n");
                builder.append( "         } \n \n ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(name+builder.toString()+"\n   }");
    }

    private String dealStr(String translate) {
        String translate1 = translate.replaceAll("\\(", " ");
         translate1 = translate1.replaceAll("/", " ");
        translate1 = translate1.replaceAll("\\)", "");
        translate1 = translate1.replaceAll("\\.", "_");
        translate1 = translate1.replaceAll(" ", "_");
        return translate1;
    }
}