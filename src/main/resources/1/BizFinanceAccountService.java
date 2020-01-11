package com.ccbuluo.account;

import com.ccbuluo.http.StatusDto;
import com.ccbuluo.http.StatusDtoThriftList;

import java.util.List;


/**
 * 内部账户 Service
 * @author Ryze
 * @date 2018-09-06 18:01:27
 * @version V 2.0.0
 */

public interface BizFinanceAccountService {

    /**
     * 保存 账号实体
     * @param accountName 账户名称 我自己后缀 -零钱账户
     * @param businessType 业务类型 (售后 AFTER_SALE/营销 MARKETING/ 租赁 LEASE）
     * @param businessItemType 账号业务具体类型(客户经理 ACCOUNT_MANAGER/服务中心SERVICE_CENTER/)
     * @param organizationCode 组织或个人的编码
     * @param organizationName 组织或个人的名称
     * @param organizationType 个人PERSONAL/组织 ORGANIZATION/平台 PLATFORM
     * @param creator 创建人uuid
     * @return
     * @author Ryze
     * @date 2018-09-06 18:01:27
     */
    
    StatusDto<String> saveBizFinanceAccount(String accountName,
                                            BusinessTypeEnumThrift businessType,
                                            BusinessItemTypeEnumThrift businessItemType,
                                            String organizationCode,
                                            String organizationName,
                                            OrganizationTypeEnumThrift organizationType,
                                            String creator);

    /**
     *  根据条件查询账户列表
     * @param
     * @exception
     * @return
     * @author weijb
     * @date 2018-11-14 10:44:48
     */
    
    StatusDtoThriftList<BizFinanceAccount> queryAccountList(BizFinanceAccount account);

    /**
     * 根据多个机构号获取帐户信息
     * @param organizationCodes
     * @return
     */
    
    StatusDtoThriftList<BizFinanceAccount> queryAccountListForOrganizationCodes(List<String> organizationCodes);
}
