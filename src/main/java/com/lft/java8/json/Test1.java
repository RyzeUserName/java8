package com.lft.java8.json;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * 描述
 * @author Ryze
 * @date 2020-02-26 10:25
 */
public class Test1 {
    public static void main(String[] args) {
        List<TrackLocationDetail> trackLocationDetails = JSONObject.parseArray("[{\"x\": 116.26957666666, \"y\": 40.06614, \"ag\": \"64\", \"lx\": \"116.26957\", \"ly\": \"40.06614\", \"sp\": \"10.2\", \"tm\": \"1582692986\"}, {\"ag\": \"270\", \"lx\": \"116.26958\", \"ly\": \"40.066143\", \"sp\": \"19.2\", \"tm\": \"1582692991\"}, {\"ag\": \"346\", \"lx\": \"116.26958\", \"ly\": \"40.06615\", \"sp\": \"11.5\", \"tm\": \"1582692996\"}, {\"ag\": \"15\", \"lx\": \"116.269585\", \"ly\": \"40.066154\", \"sp\": \"0.4\", \"tm\": \"1582693001\"}, {\"ag\": \"215\", \"lx\": \"116.26959\", \"ly\": \"40.06616\", \"sp\": \"14.6\", \"tm\": \"1582693006\"}, {\"ag\": \"241\", \"lx\": \"116.26959\", \"ly\": \"40.066162\", \"sp\": \"7.2\", \"tm\": \"1582693011\"}, {\"ag\": \"141\", \"lx\": \"116.2696\", \"ly\": \"40.06617\", \"sp\": \"10.6\", \"tm\": \"1582693016\"}]", TrackLocationDetail.class);
        System.out.println(trackLocationDetails);
    }
}
