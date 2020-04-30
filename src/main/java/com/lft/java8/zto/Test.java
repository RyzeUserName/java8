package com.lft.java8.zto;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-27 8:34
 */
public class Test {
    static String companyId = "0efbbeab046746c5a8bd8d136b431c2d";
    static String key = "78297bd02c0a";
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("data", "['75339866757936']");
        parameters.put("company_id", companyId);
        parameters.put("msg_type", "NEW_TRACES");
        String strToDigest = paramsToQueryString(parameters) + key;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(strToDigest.getBytes(Charset.forName("UTF-8")));
        String dataDigest = Base64.getEncoder().encodeToString(md.digest());
        URL url = new URL("https://japi.zto.com/traceInterfaceNewTraces");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        con.setDoOutput(true);
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("x-datadigest", dataDigest);
        con.setRequestProperty("x-companyid", companyId);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.write(paramsToQueryStringUrlencoded(parameters).getBytes(Charset.forName("UTF-8")));
        out.flush();
        out.close();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        String string = content.toString();
        ResultTraceInfo parse = JSONObject.parseObject(string, ResultTraceInfo.class);
        System.out.println(parse.isStatus());
        System.out.println(parse.getMsg());
        List<ResultTraceInfo.DataBean> data = parse.getData();
        ResultTraceInfo.DataBean dataBean = data.get(0);
        System.out.println(dataBean.getBillCode());
        List<ResultTraceInfo.DataBean.TracesBean> traces = dataBean.getTraces();
        for (ResultTraceInfo.DataBean.TracesBean tracesBean:traces) {
            System.out.println(tracesBean);
        }

    }

    public static String paramsToQueryString(Map<String, String> params) {
        return params.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
    }


    public static String paramsToQueryStringUrlencoded(Map<String, String> params) {
        return params.entrySet().stream().map(e -> {
            try {
                return e.getKey() + "=" + URLEncoder.encode(e.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e1) {
                return e.getValue();
            }
        }).collect(Collectors.joining("&"));
    }
}
