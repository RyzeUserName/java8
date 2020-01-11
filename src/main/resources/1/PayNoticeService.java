package com.ccbuluo.trade.service.pay;

import com.ccbuluo.exception.RpcServiceException;
import com.ccbuluo.trade.entity.BasicPaymentNotice;

/**
 * 支付通知回调处理
 * @author Ryze
 * @date 2019-11-13 11:08:27
 * @version V1.0.0
 */
public interface PayNoticeService {
    /**
     * 保存实体
     * @param notice
     * @throws RpcServiceException
     */
    void saveNotice(BasicPaymentNotice notice) throws RpcServiceException;
}
