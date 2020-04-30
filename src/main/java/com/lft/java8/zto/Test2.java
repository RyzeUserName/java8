package com.lft.java8.zto;

import com.alibaba.fastjson.JSONObject;
import com.zto.zop.ZopClient;
import com.zto.zop.ZopPublicRequest;

import java.io.IOException;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-30 9:05
 */
public class Test2 {
    static String companyId = "0efbbeab046746c5a8bd8d136b431c2d";
    static String key = "78297bd02c0a";
    private ResultTraceInfo getResultTraceInfo(String expressNo) throws IOException {
        ZopClient client = new ZopClient(companyId,key);
        ZopPublicRequest request = new ZopPublicRequest();
        // 请使用request.addParam方法将"业务参数"添加进来，每个接口的"业务参数"请参考文档描述
        request.addParam("data", "['" + expressNo + "']");
        request.addParam("msg_type", "NEW_TRACES");
        request.setUrl("https://japi.zto.com/traceInterfaceNewTraces");
        String execute = client.execute(request);
        return JSONObject.parseObject(execute,ResultTraceInfo.class);
    }
}
