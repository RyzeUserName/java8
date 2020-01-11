package com.ccbuluo.pay.service;

import com.ccbuluo.http.StatusDtoThriftBoolean;
import com.ccbuluo.http.StatusDtoThriftList;
import com.ccbuluo.pay.dto.KeyCheckDTO;

import java.util.List;

/**
 * 密钥校验 Service
 * @author Ryze
 * @date 2019-05-13 17:47:22
 * @version V 2.0.0
 */

public interface KeyCheckService {
    /**
     * 批量校验密钥有效性
     * @param keyCheckDTOS
     * @return StatusDtoThriftList<Boolean>
     * @exception  (方法有异常的话加)
     * @author Ryze
     * @date 2019-12-03 10:29:45
     */
    StatusDtoThriftList<Boolean> checkKeys(List<KeyCheckDTO> keyCheckDTOS);

    /**
     * 校验密钥有效性
     * @param keyCheckDTOS
     * @return StatusDtoThriftList<Boolean>
     * @exception  (方法有异常的话加)
     * @author Ryze
     * @date 2019-12-03 10:29:45
     */
    StatusDtoThriftBoolean<Boolean> checkKey(String apikey, String appid, String mch_id);
}
