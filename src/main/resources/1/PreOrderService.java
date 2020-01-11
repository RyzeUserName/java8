package com.ccbuluo.trade.service.pay;


import com.ccbuluo.http.StatusDto;
import com.ccbuluo.http.StatusDtoThriftBean;
import com.ccbuluo.http.StatusDtoThriftList;
import com.ccbuluo.trade.dto.OrderDto;
import com.ccbuluo.trade.dto.PreOrderRequest;
import com.ccbuluo.trade.dto.PreOrderResponse;

/**
 * 预下单
 * @author Ryze
 * @date 2019-12-03 10:36:46
 * @version V1.0.0
 */
public interface PreOrderService {

	/**
	 * 预下单--创建
	 * @param preOrderRequest
	 * @return
	 */
	
	StatusDtoThriftBean<PreOrderResponse> precreateOrder(PreOrderRequest preOrderRequest);

	/**
	 * 根据条件查询订单列表
	 *
	 * @param
	 * @exception @return
	 * @author weijb
	 * @date 2018-11-15 10:44:48
	 */
	
	StatusDtoThriftList<OrderDto> queryOrderList(String businessCode);


	/**
	 * 外部暂时未用到
	 * @param orderDto
	 * @return
	 */
	@Deprecated
	StatusDto<String> preOrder(OrderDto orderDto);


}
