package com.lft.java8.io;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * aa
 * @author Ryze
 * @date 2019-08-23 18:55
 */
public class WhiteListImportDTO {
    /**
     * 分类
     */
    @ExcelProperty("分类")
    private String phone;
    /**
     * 接口
     */
    @ExcelProperty("接口")
    private String activityCode;
    /**
     * 路径
     */
    @ExcelProperty("路径")
    private String activityName;
    /**
     * 路径
     */
    @ExcelProperty("qq")
    private String qq;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
