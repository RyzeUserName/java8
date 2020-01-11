package com.ccbuluo.pay.service;

import com.ccbuluo.exception.RpcServiceException;
import com.ccbuluo.pay.dto.AccountOpenDTO;
import com.ccbuluo.pay.dto.AccountOpenResultDTO;
import com.ccbuluo.pay.dto.OutAccountEditDTO;
import com.ccbuluo.pay.entity.FinanceAccount;

import java.util.List;


/**
 * 账户 Service
 * @author Ryze
 * @date 2019-05-13 17:47:22
 * @version V 2.0.0
 */

public interface AccountOpenService {

    /**
     * 开户
     * @param entity 账户实体
     * @return int 影响条数
     * @author Ryze
     * @date 2019-05-13 17:47:22
     */
    
    AccountOpenResultDTO openAccount(AccountOpenDTO entity) throws RpcServiceException;


    /**
     * 编辑外部账户
     * @param entity 账户实体
     * @return int 影响条数
     * @author Ryze
     * @date 2019-05-13 17:47:22
     */

    void editOutAccount(OutAccountEditDTO entity) throws RpcServiceException;



    /**
     * 编辑运营账户
     * @param accountCode 账户编码
     * @param appId 系统appId
     * @param overdraftAmount 透支额度
     * @return int 影响条数
     * @author Ryze
     * @date 2019-05-13 17:47:22
     */

    void editOperatingAccount(String accountCode, String appId, Long overdraftAmount) throws RpcServiceException;


    /**
     * 查询平台该渠道的收单账户
     * @param appId appid
     * @param channelCode 渠道编码
     * @return com.ccbuluo.pay.entity.FinanceAccount
     * @exception
     * @author wuyibo
     * @date 2019-09-09 16:53:15
     */
    FinanceAccount findReceivingAccount(String appId, String channelCode);

    /**
     * 查询账户
     * @param accountTypes 账户类型
     * @param organizationCodes 组织或个人的编码
     * @return java.util.List<com.ccbuluo.pay.entity.FinanceAccount>
     * @exception
     * @author wuyibo
     * @date 2019-09-10 15:10:31
     */
    List<FinanceAccount> queryAccountsList(List<String> accountTypes, List<String> organizationCodes);

    /**
     * 更新账号名称
     * @param organizationCode 组织或个人的编码
     * @param organizationName 组织或个人的名称
     * @return void
     * @exception
     * @author wuyibo
     * @date 2019-09-20 18:48:18
     */
    void updateMemberAccount(String organizationCode, String organizationName) throws RpcServiceException;

}
