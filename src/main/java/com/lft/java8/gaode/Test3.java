package com.lft.java8.gaode;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 转高德 坐标
 * @author Ryze
 * @date 2019-12-27 10:19
 */
public class Test3 {
    static final String key = "key=dbedc0a3d2201c6d704b3b6391ddcc4e";
    static final String url = "https://restapi.amap.com/v3/assistant/coordinate/convert?";
    static final String location = "locations=116.299191,40.047855&coordsys=gps";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url+location+"&"+key).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String string = response.body().string();
            LocationResultDTO districtResultDTO = JSONObject.parseObject(string, LocationResultDTO.class);
            System.out.println(districtResultDTO.getStatus().equals("1"));
            System.out.println(districtResultDTO.getLocations());


        } else {
            System.out.println("失败");
        }
    }
}
