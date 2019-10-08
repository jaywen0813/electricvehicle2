package com.android.app.electricvehicle.entity;

import java.io.Serializable;

/**
 * @Auther: WindyHu
 * @Date: 2018/5/11 09:43
 * @Description:
 */
public class CheckUpdateAppBean implements Serializable {


    /**
     * code : 00000
     * message : 成功
     * result : {"id":"19d48bfd3a9f46cb8df6bc6128f272be","ids":null,"appVersionNo":null,"versCode":"8","osType":"01","versDes":"1","url":"http://openbox.mobilem.360.cn/url/r/k/std_1530503677","sharedAddress":null,"forceFlag":false,"miniOsVersion":null,"fileName":"kuaisou.apk","publishTime":"2018-06-29","authCode":null,"versType":null,"checkFlag":null,"appid":"9","createBy":null,"createDate":null,"updateBy":null,"updateDate":null,"delFlag":null,"beginTime":null,"endTime":null,"brandCode":null}
     * total : null
     */

    private String code;
    private String message;
    private ResultBean result;
    private String total;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class ResultBean {
        /**
         * id : 19d48bfd3a9f46cb8df6bc6128f272be
         * ids : null
         * appVersionNo : null
         * versCode : 8
         * osType : 01
         * versDes : 1
         * url : http://openbox.mobilem.360.cn/url/r/k/std_1530503677
         * sharedAddress : null
         * forceFlag : false
         * miniOsVersion : null
         * fileName : kuaisou.apk
         * publishTime : 2018-06-29
         * authCode : null
         * versType : null
         * checkFlag : null
         * appid : 9
         * createBy : null
         * createDate : null
         * updateBy : null
         * updateDate : null
         * delFlag : null
         * beginTime : null
         * endTime : null
         * brandCode : null
         */

        private String id;
        private String ids;
        private String appVersionNo;
        private String versCode;
        private String osType;
        private String versDes;
        private String url;
        private String sharedAddress;
        private boolean forceFlag;
        private String miniOsVersion;
        private String fileName;
        private String publishTime;
        private String authCode;
        private String versType;
        private String checkFlag;
        private String appid;
        private String createBy;
        private String createDate;
        private String updateBy;
        private String updateDate;
        private String delFlag;
        private String beginTime;
        private String endTime;
        private String brandCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public String getAppVersionNo() {
            return appVersionNo;
        }

        public void setAppVersionNo(String appVersionNo) {
            this.appVersionNo = appVersionNo;
        }

        public String getVersCode() {
            return versCode;
        }

        public void setVersCode(String versCode) {
            this.versCode = versCode;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getVersDes() {
            return versDes;
        }

        public void setVersDes(String versDes) {
            this.versDes = versDes;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSharedAddress() {
            return sharedAddress;
        }

        public void setSharedAddress(String sharedAddress) {
            this.sharedAddress = sharedAddress;
        }

        public boolean isForceFlag() {
            return forceFlag;
        }

        public void setForceFlag(boolean forceFlag) {
            this.forceFlag = forceFlag;
        }

        public String getMiniOsVersion() {
            return miniOsVersion;
        }

        public void setMiniOsVersion(String miniOsVersion) {
            this.miniOsVersion = miniOsVersion;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        public String getVersType() {
            return versType;
        }

        public void setVersType(String versType) {
            this.versType = versType;
        }

        public String getCheckFlag() {
            return checkFlag;
        }

        public void setCheckFlag(String checkFlag) {
            this.checkFlag = checkFlag;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getBrandCode() {
            return brandCode;
        }

        public void setBrandCode(String brandCode) {
            this.brandCode = brandCode;
        }
    }
}
