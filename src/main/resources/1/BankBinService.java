package com.ccbuluo.pay.service;

import com.ccbuluo.http.StatusDto;


/**
 * 卡bin
 * @author Ryze
 * @date 2019-05-13 17:47:22
 * @version V 2.0.0
 */

public interface BankBinService {


    /**
     * 根据银行卡 前6位返回银行名称
     * @param bankNumber 前6位
     * @return String 银行名称
     * @author Ryze
     * @date 2019-05-13 17:47:22
     */
    
    StatusDto<String> getBankName(String bankNumber);
}
