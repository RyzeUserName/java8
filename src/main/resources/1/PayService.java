package com.ccbuluo.trade.service.pay;

import com.ccbuluo.http.StatusDtoThriftBean;
import com.ccbuluo.http.StatusDtoThriftList;
import com.ccbuluo.trade.dto.*;
import com.ccbuluo.trade.entity.BasicPaymentOrder;

import java.util.Map;

/**
 * 分账
 * @author Ryze
 * @date 2019-12-03 10:36:28
 * @version V1.0.0
 */

public interface PayService {

	/**
	 * 查询预下单详情
	 *
	 * @param paySerialNumber
	 * @return
	 */

	StatusDtoThriftList<BasicPaymentOrder> getOrderInfo(String paySerialNumber);

	/**
	 * 退款
	 *
	 * @param refundRequestDto
	 * @return
	 */

	StatusDtoThriftBean<RefundOrderResponse> refund(
        RefundOrderRequest refundRequestDto);

	/**
	 * 分帐操作
	 *
	 * @param orderNo
	 * @return
	 */

	StatusDtoThriftBean<ResponseMessage> subAccount(String appId, String orderNo);

	/**
	 * 支付
	 *
	 * @param payDto
	 * @return
	 */
	@Deprecated
	StatusDtoThriftBean<PayInfoDto> pay(PayDto payDto);

	/**
	 * 内部支付成功回调
	 *
	 * @param paySerialNumber
	 * @return
	 */

	StatusDtoThriftList<BasicPaymentOrder> innerSuccess(String paySerialNumber);

	/**
	 * 微信通知
	 *
	 * @param wechatResponse
	 * @return
	 */

	StatusDtoThriftList<BasicPaymentOrder> wechatNotifySuccess(
        String xml, Map<String, String> map);

	/**
	 * 确认退款
	 *
	 * @param paySerialNumber
	 * @param refundNo
	 * @return
	 */

	StatusDtoThriftBean<RefundOrderResponse> confirmRefund(
        String paySerialNumber, String refundNo);

	/**
	 * 关闭订单
	 * @param orderNo
	 * @return
	 */
	StatusDtoThriftBean<CloseWechatPayOrderResponse> closeOrder(String orderNo);

}
