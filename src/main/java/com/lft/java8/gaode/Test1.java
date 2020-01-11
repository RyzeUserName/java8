package com.lft.java8.gaode;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 描述
 * @author Ryze
 * @date 2019-12-27 10:19
 */
public class Test1 {
    static final String key = "key=dbedc0a3d2201c6d704b3b6391ddcc4e";
    static final String url = "https://restapi.amap.com/v3/geocode/regeo?";
    static final String location = "location=116.275650,40.067387&batch=true";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url+location+"&"+key).build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String string = response.body().string();
            DistrictResultDTO districtResultDTO = JSONObject.parseObject(string, DistrictResultDTO.class);
            System.out.println(districtResultDTO.getStatus().equals("1"));
            System.out.println(districtResultDTO.getRegeocodes().get(0).getAddressComponent().getAdcode());
            System.out.println(districtResultDTO.getRegeocodes().get(0).getAddressComponent().getProvince());
            System.out.println(districtResultDTO.getRegeocodes().get(0).getAddressComponent().getDistrict());
//            System.out.println(administrativeDistrictDTO.getRegeocodes().get(1).getAddressComponent().getAdcode());
//            System.out.println(administrativeDistrictDTO.getRegeocodes().get(1).getAddressComponent().getProvince());
//            System.out.println(administrativeDistrictDTO.getRegeocodes().get(1).getAddressComponent().getDistrict());
        } else {
            System.out.println("失败");
        }
    }
}
