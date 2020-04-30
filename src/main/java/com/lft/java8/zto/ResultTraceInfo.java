package com.lft.java8.zto;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 * @author Ryze
 * @date 2020-04-27 9:06
 */
public class ResultTraceInfo {

    /**
     * data : [{"billCode":"680000000000","traces":[{"desc":"【萧山钱江世纪城】 的 杨晓慧 已进行【异常件】上报，异常原因：客户要求改地址","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"","scanDate":"2020-03-05 23:41:39","scanProv":"浙江省","scanSite":"萧山钱江世纪城","scanSiteCode":"59778","scanSitePhone":"0571-56178080","scanType":"问题件","signMan":""}]}]
     * msg :
     * status : true
     */

    private String msg;
    private boolean status;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * billCode : 680000000000
         * traces : [{"desc":"【萧山钱江世纪城】 的 杨晓慧 已进行【异常件】上报，异常原因：客户要求改地址","dispOrRecMan":"","dispOrRecManCode":"","dispOrRecManPhone":"","isCenter":"F","preOrNextCity":"","preOrNextProv":"","preOrNextSite":"","preOrNextSiteCode":"","preOrNextSitePhone":"","remark":"","scanCity":"","scanDate":"2020-03-05 23:41:39","scanProv":"浙江省","scanSite":"萧山钱江世纪城","scanSiteCode":"59778","scanSitePhone":"0571-56178080","scanType":"问题件","signMan":""}]
         */

        private String billCode;
        private List<TracesBean> traces;

        public String getBillCode() {
            return billCode;
        }

        public void setBillCode(String billCode) {
            this.billCode = billCode;
        }

        public List<TracesBean> getTraces() {
            return traces;
        }

        public void setTraces(List<TracesBean> traces) {
            this.traces = traces;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", DataBean.class.getSimpleName() + "[", "]")
                .add("billCode='" + billCode + "'")
                .add("traces=" + traces)
                .toString();
        }

        public static class TracesBean {
            @Override
            public String toString() {
                return new StringJoiner(", ", TracesBean.class.getSimpleName() + "[", "]")
                    .add("desc='" + desc + "'")
                    .add("dispOrRecMan='" + dispOrRecMan + "'")
                    .add("dispOrRecManCode='" + dispOrRecManCode + "'")
                    .add("dispOrRecManPhone='" + dispOrRecManPhone + "'")
                    .add("isCenter='" + isCenter + "'")
                    .add("preOrNextCity='" + preOrNextCity + "'")
                    .add("preOrNextProv='" + preOrNextProv + "'")
                    .add("preOrNextSite='" + preOrNextSite + "'")
                    .add("preOrNextSiteCode='" + preOrNextSiteCode + "'")
                    .add("preOrNextSitePhone='" + preOrNextSitePhone + "'")
                    .add("remark='" + remark + "'")
                    .add("scanCity='" + scanCity + "'")
                    .add("scanDate='" + scanDate + "'")
                    .add("scanProv='" + scanProv + "'")
                    .add("scanSite='" + scanSite + "'")
                    .add("scanSiteCode='" + scanSiteCode + "'")
                    .add("scanSitePhone='" + scanSitePhone + "'")
                    .add("scanType='" + scanType + "'")
                    .add("signMan='" + signMan + "'")
                    .toString();
            }

            /**
             * desc : 【萧山钱江世纪城】 的 杨晓慧 已进行【异常件】上报，异常原因：客户要求改地址
             * dispOrRecMan :
             * dispOrRecManCode :
             * dispOrRecManPhone :
             * isCenter : F
             * preOrNextCity :
             * preOrNextProv :
             * preOrNextSite :
             * preOrNextSiteCode :
             * preOrNextSitePhone :
             * remark :
             * scanCity :
             * scanDate : 2020-03-05 23:41:39
             * scanProv : 浙江省
             * scanSite : 萧山钱江世纪城
             * scanSiteCode : 59778
             * scanSitePhone : 0571-56178080
             * scanType : 问题件
             * signMan :
             */

            private String desc;
            private String dispOrRecMan;
            private String dispOrRecManCode;
            private String dispOrRecManPhone;
            private String isCenter;
            private String preOrNextCity;
            private String preOrNextProv;
            private String preOrNextSite;
            private String preOrNextSiteCode;
            private String preOrNextSitePhone;
            private String remark;
            private String scanCity;
            private String scanDate;
            private String scanProv;
            private String scanSite;
            private String scanSiteCode;
            private String scanSitePhone;
            private String scanType;
            private String signMan;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDispOrRecMan() {
                return dispOrRecMan;
            }

            public void setDispOrRecMan(String dispOrRecMan) {
                this.dispOrRecMan = dispOrRecMan;
            }

            public String getDispOrRecManCode() {
                return dispOrRecManCode;
            }

            public void setDispOrRecManCode(String dispOrRecManCode) {
                this.dispOrRecManCode = dispOrRecManCode;
            }

            public String getDispOrRecManPhone() {
                return dispOrRecManPhone;
            }

            public void setDispOrRecManPhone(String dispOrRecManPhone) {
                this.dispOrRecManPhone = dispOrRecManPhone;
            }

            public String getIsCenter() {
                return isCenter;
            }

            public void setIsCenter(String isCenter) {
                this.isCenter = isCenter;
            }

            public String getPreOrNextCity() {
                return preOrNextCity;
            }

            public void setPreOrNextCity(String preOrNextCity) {
                this.preOrNextCity = preOrNextCity;
            }

            public String getPreOrNextProv() {
                return preOrNextProv;
            }

            public void setPreOrNextProv(String preOrNextProv) {
                this.preOrNextProv = preOrNextProv;
            }

            public String getPreOrNextSite() {
                return preOrNextSite;
            }

            public void setPreOrNextSite(String preOrNextSite) {
                this.preOrNextSite = preOrNextSite;
            }

            public String getPreOrNextSiteCode() {
                return preOrNextSiteCode;
            }

            public void setPreOrNextSiteCode(String preOrNextSiteCode) {
                this.preOrNextSiteCode = preOrNextSiteCode;
            }

            public String getPreOrNextSitePhone() {
                return preOrNextSitePhone;
            }

            public void setPreOrNextSitePhone(String preOrNextSitePhone) {
                this.preOrNextSitePhone = preOrNextSitePhone;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getScanCity() {
                return scanCity;
            }

            public void setScanCity(String scanCity) {
                this.scanCity = scanCity;
            }

            public String getScanDate() {
                return scanDate;
            }

            public void setScanDate(String scanDate) {
                this.scanDate = scanDate;
            }

            public String getScanProv() {
                return scanProv;
            }

            public void setScanProv(String scanProv) {
                this.scanProv = scanProv;
            }

            public String getScanSite() {
                return scanSite;
            }

            public void setScanSite(String scanSite) {
                this.scanSite = scanSite;
            }

            public String getScanSiteCode() {
                return scanSiteCode;
            }

            public void setScanSiteCode(String scanSiteCode) {
                this.scanSiteCode = scanSiteCode;
            }

            public String getScanSitePhone() {
                return scanSitePhone;
            }

            public void setScanSitePhone(String scanSitePhone) {
                this.scanSitePhone = scanSitePhone;
            }

            public String getScanType() {
                return scanType;
            }

            public void setScanType(String scanType) {
                this.scanType = scanType;
            }

            public String getSignMan() {
                return signMan;
            }

            public void setSignMan(String signMan) {
                this.signMan = signMan;
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResultTraceInfo.class.getSimpleName() + "[", "]")
            .add("msg='" + msg + "'")
            .add("status=" + status)
            .add("data=" + data)
            .toString();
    }
}
