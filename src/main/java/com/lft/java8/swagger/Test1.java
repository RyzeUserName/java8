package com.lft.java8.swagger;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-08 9:57
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fr = new FileReader("E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\swagger\\swaggerApi.json");
        BufferedReader bf = new BufferedReader(fr);
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            stringBuilder.append(str);
        }
        bf.close();
        fr.close();
        SwaggerJson swaggerJson = JSON.parseObject(stringBuilder.toString(), SwaggerJson.class);
        List<TagsBean> tags = swaggerJson.getTags();
        swaggerJson.setTags(tags.stream().filter(tagsBean -> tagsBean.getName().contains("【9】")).collect(Collectors.toList()));
        Map<String, Map<String, InnerBean>> paths = swaggerJson.getPaths();
        List<String> remove = Lists.newArrayList();
        paths.entrySet().stream().forEach(stringMapEntry -> {
            Map<String, InnerBean> value = stringMapEntry.getValue();
            InnerBean get = value.get("get");
            InnerBean post = value.get("post");
            if (get != null) {
                if (!get.getSummary().contains("【9】")) {
                    value = null;
                } else {
                    get.setConsumes(null);
                }
            }
            if (post != null) {
                if (!post.getSummary().contains("【9】")) {
                    value = null;
                }
            }
            if (value == null) {
                remove.add(stringMapEntry.getKey());
            }
            stringMapEntry.setValue(value);
        });
        if (remove.size() > 0) {
            for (String p : remove) {
                paths.remove(p);
            }
        }
        String jsonString = JSON.toJSONString(swaggerJson);
//        File file = new File("E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\swagger\\swaggerApi1.json");
//        file.createNewFile();
//        FileWriter fileWriter = new FileWriter("E:\\study\\java8\\src\\main\\java\\com\\lft\\java8\\swagger\\swaggerApi1.json");
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.write(jsonString);
//        bufferedWriter.close();
//        fileWriter.close();
        System.out.println(jsonString);

    }
}
