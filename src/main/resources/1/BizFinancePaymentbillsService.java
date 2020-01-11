package com.ccbuluo.supplier.service;

import com.ccbuluo.http.StatusDtoThriftBean;
import com.ccbuluo.http.StatusDtoThriftList;
import com.ccbuluo.http.StatusDtoThriftPage;
import com.ccbuluo.supplier.dto.BizFinanceDetail;
import com.ccbuluo.supplier.dto.BizFinancePaymentbills;
import com.ccbuluo.supplier.dto.BizFinanceReceipt;
import com.ccbuluo.supplier.model.BizFinancePaymentbillsModel;

import java.util.List;

/**
 * 财务项目付款单、退款单管理服务
 * @author 王晓亮
 * @date 2018-09-06 18:01:27
 * @version V 2.0.0
 */

public interface BizFinancePaymentbillsService {

    /**
     * 向db写入多个营销付款单
     * @param list db映射实体列表
     * @return RPC包装后的写入db的对象列表
     * @throws Exception 向调用方反馈错误的具体内容
     */
    
    StatusDtoThriftList<BizFinancePaymentbills> saveMarketPaymentbillsList(List<BizFinancePaymentbills> list) throws Exception;

    /**
     * 更改付/退款单状态
     * @param entity db映射实体
     * @return RPC包装后的写入db的对象
     */
    
    StatusDtoThriftBean<BizFinancePaymentbills> updatePaymentbillsStatus(String creator, BizFinancePaymentbills entity) throws Exception;

    /**
     * 获取改付/退款单列表
     * @param entity 检索条件封装实体
     * @param offset 列表偏移量
     * @param limit 列表容量
     * @return RPC包装后的检索结果
     */
    
    StatusDtoThriftPage<BizFinancePaymentbillsModel> queryBizFinancePaymentbillsPage(BizFinancePaymentbills entity, int offset, int limit);

    /**
     * 根据付/退款单号获取收据列表
     * @param entity 检索条件实体
     * @return RPC包装后的检索结果
     */
    
    StatusDtoThriftList<BizFinanceReceipt> queryBizFinanceReceiptList(BizFinanceReceipt entity);

    /**
     * 获取付/退款的支付明细列表
     * @param entity 检索条件实体
     * @return RPC包装后的检索结果
     */
    
    StatusDtoThriftList<BizFinanceDetail> queryBizFinanceDetailList(BizFinanceDetail entity);

    /**
     * 根据付/退款单号查询付/退款单的详细信息
     * @param entity 检索条件实体
     * @return RPC包装后的检索结果
     */
    
    StatusDtoThriftBean<BizFinancePaymentbills> findBizFinancePaymentbills(BizFinancePaymentbills entity);

}
