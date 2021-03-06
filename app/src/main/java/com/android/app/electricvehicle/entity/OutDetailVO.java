package com.android.app.electricvehicle.entity;

import java.io.Serializable;

public class OutDetailVO implements Serializable {


    /**
     * ticket : 4d1323635d9f393da8d1f58cd5c5d969
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570603546923
     * data : {"id":"6c737657ea6011e992930242ac110012","tokenId":"MSag69rfZLhGipIcPC81jtccjhroIsVsW9AlcudW766j8T8QQTAfGWGERrecNxNs","version":null,"locked":null,"lastAccess":1570603546715,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570603546715,"updaterId":null,"updatedBy":null,"dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","PackingId":"20191001001","remark":null,"enable":true}
     * args : null
     * moreinfo : null
     * detail : null
     * subCode : null
     * subMessage : null
     */

    private String ticket;
    private String success;
    private String code;
    private String message;
    private String method;
    private String uri;
    private long timestamp;
    private DataBean data;
    private String args;
    private String moreinfo;
    private String detail;
    private String subCode;
    private String subMessage;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public static class DataBean {
        /**
         * id : 6c737657ea6011e992930242ac110012
         * tokenId : MSag69rfZLhGipIcPC81jtccjhroIsVsW9AlcudW766j8T8QQTAfGWGERrecNxNs
         * version : null
         * locked : null
         * lastAccess : 1570603546715
         * disabled : false
         * creatorId : a475d2268eb511e992930242ac110012
         * createdBy : 英特诺
         * createdTime : 1570603546715
         * updaterId : null
         * updatedBy : null
         * dataId : null
         * isNew : null
         * logTime : null
         * tenantId : 304548c2ec8033f4917b18bfe144c569
         * outstoreCode : 20191001001
         * storehouseId : 55838525
         * storehouseName : 500
         * freeLoc : AAA-02-002
         * PackingId : 20191001001
         * remark : null
         * enable : true
         */

        private String id;
        private String tokenId;
        private String version;
        private String locked;
        private long lastAccess;
        private boolean disabled;
        private String creatorId;
        private String createdBy;
        private long createdTime;
        private String updaterId;
        private String updatedBy;
        private String dataId;
        private String isNew;
        private String logTime;
        private String tenantId;
        private String outstoreCode;
        private String storehouseId;
        private String storehouseName;
        private String freeLoc;
        private String PackingId;
        private String remark;
        private boolean enable;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getLocked() {
            return locked;
        }

        public void setLocked(String locked) {
            this.locked = locked;
        }

        public long getLastAccess() {
            return lastAccess;
        }

        public void setLastAccess(long lastAccess) {
            this.lastAccess = lastAccess;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public String getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(String creatorId) {
            this.creatorId = creatorId;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdaterId() {
            return updaterId;
        }

        public void setUpdaterId(String updaterId) {
            this.updaterId = updaterId;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public String getLogTime() {
            return logTime;
        }

        public void setLogTime(String logTime) {
            this.logTime = logTime;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getOutstoreCode() {
            return outstoreCode;
        }

        public void setOutstoreCode(String outstoreCode) {
            this.outstoreCode = outstoreCode;
        }

        public String getStorehouseId() {
            return storehouseId;
        }

        public void setStorehouseId(String storehouseId) {
            this.storehouseId = storehouseId;
        }

        public String getStorehouseName() {
            return storehouseName;
        }

        public void setStorehouseName(String storehouseName) {
            this.storehouseName = storehouseName;
        }

        public String getFreeLoc() {
            return freeLoc;
        }

        public void setFreeLoc(String freeLoc) {
            this.freeLoc = freeLoc;
        }

        public String getPackingId() {
            return PackingId;
        }

        public void setPackingId(String PackingId) {
            this.PackingId = PackingId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }
    }
}
