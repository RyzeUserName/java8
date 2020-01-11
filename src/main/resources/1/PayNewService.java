package com.ccbuluo.trade.service.pay

import com.ccbuluo.exception.RpcServiceException
import com.ccbuluo.trade.dto.*
import com.ccbuluo.trade.entity.BasicPaymentOrder

import java.util.List
import java.util.Map

/**
 * 支付
 * @author Ryze
 * @date 2019-12-03 10:36:05
 * @version V1.0.0
 */
public interface PayNewService {

	/**
	 * 预下单
	 * @param preOrderRequest
	 * 			appId  目标系统api
	 * 			businessType 业务类型
	 * 			subject 订单描述
	 * 			backUrl 回调业务服务url
	 * 			notifyUrl  c端跳转回到服务页面url
	 * 			attach 附加参数
	 * 			productDetail 订单商品详情 json
	 * 			payModeEnum INNER("内部支付", 0), THIRD("第三方", 1), NATIVE("微信Native支付", 2), JSAPI("微信小程序", 3)
	 * 			lastPayTime 支付单最后支付时间 yyyyMMddHHmmss格式
	 * 			wechatAppid 微信appId
	 * 			payPicture 支付充值凭证
	 * 			payRemark 备注
	 * 			preOrderItemList 支付项明细List<PreOrderItem>
	 * 				orderNo 订单编号
	 * 				payee 收款人
	 * 				payer 付款人
	 * 				amount 付款金额
	 * 				organizationCode 组织或个人的编码(第三方付款时，付款人为空时，需要该参数)
	 * 				discountDTOList 订单优惠列表List<PreOrderDiscountDTO>
	 * 					activityNumber 活动编号
	 * 					activityName 活动名称
	 * 					discountNumber 优惠编号
	 * 					discountAmount 优惠金额
	 *
	 * @return PreOrderResponse
	 *  		appId 系统appid
	 *  		paySerialNumber 支付流水号
	 *  		orderSecret 加密单信息
	 *  		totalFee 支付金额
	 *  		subject 订单描述
	 *  		attach 附加参数
	 *  		submitPayTime 提交支付时间
	 *  		businessType 业务类型
	 *  		businessDesc 业务场景描述
	 *  		payModeEnum INNER("内部支付", 0), THIRD("第三方", 1), NATIVE("微信Native支付", 2), JSAPI("微信小程序", 3)
	 *  		productDetail 商品详情json
	 *  		backUrl 回调url 特殊的附加参数
	 *  		notifyUrl 消息推送url
	 *  		traderUrl 收银台url
	 *  		preOrderItem 支付项明细List<PreOrderItem>
	 *  		payControlEnum AUTO_PAY自动付，不去收银台，CONFIRM_PAY确认付
	 * @throws  RpcServiceException 校验异常
	 * @throws  Exception 异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	PreOrderResponse precreateOrder(PreOrderRequest preOrderRequest) throws RpcServiceException, Exception;

	/**
	 * 支付
	 * @param payDto
	 * 			payModeEnum 交易方式（内部支付、第三方支付）
	 * 			orderSecret 支付流水号
	 * 			openId
	 *
	 * @return PayInfoDto
	 *  		payType 支付类型，第三方支付/内部支付
	 *  		totalFee 支付金额，考虑小数还是整数
	 *  		orderNumber 订单号
	 *  		qrCode 二维码，base64。只有第三方支付有值
	 *  		prepayId 小程序预下单id
	 *  		expirationTime 二维码到期时间，目前没有用
	 *  		accountName 支付账户名称，只有内部支付有值
	 *  		accountCode 支付账户
	 *  		accountBalance 账户余额
	 *  		pwdExist 密码是否存在
	 *  		openId
	 *  		requestPayment 小程序支付
	 * @throws  RpcServiceException 校验异常
	 * @throws  Exception 异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	PayInfoDto pay(PayDto payDto) throws RpcServiceException, Exception;

	/**
	 * 退款
	 * @param refundOrderRequest
	 *  		orderNo 订单号
	 * 			paySerialNumber 支付流水号
	 * 			refundDesc 退款描述
	 * 			refundFee 退款金额
	 * 			appId appId
	 * 			discountDTOList 退优惠金额 List<RefundOrderDiscountDTO>
	 * 				refundDiscountNumber 优惠退单编号
	 * 				refundDiscountAmount 优惠退单金额
	 *
	 * @return RefundOrderResponse
	 *  		orderNo 订单号
	 * 			result SUCCESS 成功, FAIL 失败
	 * 			resultDesc 退款描述
	 * 			refundFee 退款金额
	 * 			refundNo 退款单号
	 * 			refundModelEnum 退款模式 自动,手动
	 * 			refundItem 退款明细 次 项
	 * 			refundTime 发起退款的时间
	 * 			totalRefundFee 退款总金额
	 * @throws  RpcServiceException 校验异常
	 * @throws  Exception 异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	RefundOrderResponse refund(RefundOrderRequest refundOrderRequest) throws RpcServiceException, Exception;

	/**
	 * 分账
	 * @param appId appid
	 * @param paySerialNumber 支付流水号
	 * @return ResponseMessage
	 *   		preOrderResponse
	 *  			appId 系统appid
	 *  			paySerialNumber 支付流水号
	 *  			orderSecret 加密单信息
	 *  			totalFee 支付金额
	 *  			subject 订单描述
	 *  			attach 附加参数
	 *  			submitPayTime 提交支付时间
	 *  			businessType 业务类型
	 *  			businessDesc 业务场景描述
	 *  			payModeEnum INNER("内部支付", 0), THIRD("第三方", 1), NATIVE("微信Native支付", 2), JSAPI("微信小程序", 3)
	 *  			productDetail 商品详情json
	 *  			backUrl 回调url 特殊的附加参数
	 *  			notifyUrl 消息推送url
	 *  			traderUrl 收银台url
	 *  			preOrderItem 支付项明细List<PreOrderItem>
	 *  			payControlEnum AUTO_PAY自动付，不去收银台，CONFIRM_PAY确认付
	 * 	 		refundResponse null
	 * 	 		messageResultEnum SUCCESS("0", "成功"), FAIL("1", "失败")
	 * 	 		payResponse
	 * 	 			payMode 支付类型，INNER("内部支付", 0), THIRD("第三方", 1), NATIVE("微信Native支付", 2), JSAPI("微信小程序", 3)
	 * 	 			payDesc 支付描述 分帐
	 * 	 		messageType PAY_MESSAGE("0", "支付消息"), REFUND_MESSAGE("1", "退款消息")
	 * @throws  RpcServiceException 校验异常
	 * @throws  Exception 异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	ResponseMessage subAccount(String appId, String paySerialNumber) throws RpcServiceException, Exception;

	/**
	 * 内部支付
	 * @param paySerialNumber 支付流水号
	 * @return List<BasicPaymentOrder>
	 *  		id
	 *  		appId 系统appid
	 *  		orderNo 唯一订单编号
	 *  		paySerialNumber 支付流水号
	 *  		totalFee 支付金额
	 *  		subject 订单描述
	 *  		attach 附加参数
	 *  		submitPayTime 提交支付时间
	 *  		businessType 业务类型
	 *  		tradeType 交易类型
	 *  		payType 交易方式
	 *  		payer 付款人
	 *  		payerAccount 付款账户
	 *  		payee 收款人
	 *  		payeeAccount 收款账户
	 *  		productDetail  商品详情json
	 *  		backUrl 回调url 特殊的附加参数
	 *  		notifyUrl 消息推送url
	 *  		orderStatus 支付单状态待支付，支付成功，支付失败，已过期, 枚举
	 *  		lastPayTime 支付单最后支付时间 yyyyMMddHHmmss格式
	 *  		businessDesc 业务场景描述
	 *  		payControl AUTO_PAY自动付，不去收银台，CONFIRM_PAY确认付
	 *  		batchPay 是否是批量0单个，１批量
	 *  		traderUrl 收银台url
	 *
	 * @throws  RpcServiceException 校验异常
	 * @throws  Exception 异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	List<BasicPaymentOrder> innerSuccess(String paySerialNumber) throws RpcServiceException, Exception;
	/**
	 * 微信回调
	 * @param wechatResponse
	 *  		transactionId
	 * 			codeUrl 二维码链接
	 * 			tradeType 交易类型(微信、小程序、h5)
	 * 			prepayId 预支付交易会话标识
	 * 			sign 签名
	 * 			nonceStr 随机字符串
	 * 			mchId 商户号
	 * 			resultCode 返回状态码
	 * 			returnMsg 返回信息
	 * 			returnCode 业务结果
	 * 			appid 小程序ID
	 * 			id
	 * 			paySerialNumber 支付流水号
	 * 			status 预下单支付状态1已过期，0初始
	 *
	 * @return List<BasicPaymentOrder>
	 *  		id
	 *  		appId 系统appid
	 *  		orderNo 唯一订单编号
	 *  		paySerialNumber 支付流水号
	 *  		totalFee 支付金额
	 *  		subject 订单描述
	 *  		attach 附加参数
	 *  		submitPayTime 提交支付时间
	 *  		businessType 业务类型
	 *  		tradeType 交易类型
	 *  		payType 交易方式
	 *  		payer 付款人
	 *  		payerAccount 付款账户
	 *  		payee 收款人
	 *  		payeeAccount 收款账户
	 *  		productDetail  商品详情json
	 *  		backUrl 回调url 特殊的附加参数
	 *  		notifyUrl 消息推送url
	 *  		orderStatus 支付单状态待支付，支付成功，支付失败，已过期, 枚举
	 *  		lastPayTime 支付单最后支付时间 yyyyMMddHHmmss格式
	 *  		businessDesc 业务场景描述
	 *  		payControl AUTO_PAY自动付，不去收银台，CONFIRM_PAY确认付
	 *  		batchPay 是否是批量0单个，１批量
	 *  		traderUrl 收银台url
	 * @throws  RpcServiceException 校验异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	List<BasicPaymentOrder> wechatNotifySuccess(String xml, Map<String, String> map) throws RpcServiceException;

	/**
	 * 根据业务类型查询预下单订单
	 * @param businessCode 业务类型
	 * @return List<OrderDto>
	 *  		appId 系统appid
	 * 			subject 订单描述
	 * 			backUrl 回调业务服务url
	 * 			notifyUrl c端跳转回到服务页面url
	 * 			attach 附加参数
	 * 			productDetail 订单商品详情
	 * 			payModeEnum INNER("内部支付", 0), THIRD("第三方", 1), NATIVE("微信Native支付", 2), JSAPI("微信小程序", 3)
	 * 			lastPayTime 支付单最后支付时间 yyyyMMddHHmmss格式
	 * @throws RpcServiceException 校验异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	List<OrderDto> queryOrderList(String businessCode) throws RpcServiceException;

	/**
	 * 查询预下单
	 * @param paySerialNumber 支付流水号
	 * @return List<BasicPaymentOrder>
	 *  		id
	 *  		appId 系统appid
	 *  		orderNo 唯一订单编号
	 *  		paySerialNumber 支付流水号
	 *  		totalFee 支付金额
	 *  		subject 订单描述
	 *  		attach 附加参数
	 *  		submitPayTime 提交支付时间
	 *  		businessType 业务类型
	 *  		tradeType 交易类型
	 *  		payType 交易方式
	 *  		payer 付款人
	 *  		payerAccount 付款账户
	 *  		payee 收款人
	 *  		payeeAccount 收款账户
	 *  		productDetail  商品详情json
	 *  		backUrl 回调url 特殊的附加参数
	 *  		notifyUrl 消息推送url
	 *  		orderStatus 支付单状态待支付，支付成功，支付失败，已过期, 枚举
	 *  		lastPayTime 支付单最后支付时间 yyyyMMddHHmmss格式
	 *  		businessDesc 业务场景描述
	 *  		payControl AUTO_PAY自动付，不去收银台，CONFIRM_PAY确认付
	 *  		batchPay 是否是批量0单个，１批量
	 *  		traderUrl 收银台url
	 * @throws RpcServiceException 校验异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	List<BasicPaymentOrder> getOrderInfo(String paySerialNumber) throws RpcServiceException;

	/**
	 * 关闭订单
	 * @param orderNo 订单号
	 * @return void
	 * @throws RpcServiceException 校验异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	void closeOrder(String orderNo) throws RpcServiceException;

	/**
	 * 检查订单状态
	 * @param id 预下单ID
	 * @return void
	 * @throws RpcServiceException 校验异常
	 * @author wuyibo
	 * @date 2019-08-23 16:12:56
	 */
	List<BasicPaymentOrder> checkOrderStatus(Long id) throws RpcServiceException;

}
