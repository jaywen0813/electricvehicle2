package com.android.app.electricvehicle.entity;

import java.io.Serializable;
import java.util.List;

public class MyInVO implements Serializable {


    /**
     * ticket : 681c95b50d3b3ad3a8638fce828b75d9
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570606185970
     * data : {"pageNo":1,"pageSize":2,"pageCount":3,"totalCount":6,"beginPageIndex":1,"endPageIndex":3,"dataList":[{"id":"ff97a8e7ea4511e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570592197315,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570592197315,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"500","instoreState":1,"remark":"","enable":true},{"id":"8072dc55e9a811e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570524553018,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570524553018,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"500","instoreState":1,"remark":"","enable":true}],"countResultMap":null,"draw":1,"recordsTotal":6,"recordsFiltered":6,"nextPageNo":2}
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
         * pageNo : 1
         * pageSize : 2
         * pageCount : 3
         * totalCount : 6
         * beginPageIndex : 1
         * endPageIndex : 3
         * dataList : [{"id":"ff97a8e7ea4511e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570592197315,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570592197315,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"500","instoreState":1,"remark":"","enable":true},{"id":"8072dc55e9a811e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570524553018,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570524553018,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"500","instoreState":1,"remark":"","enable":true}]
         * countResultMap : null
         * draw : 1
         * recordsTotal : 6
         * recordsFiltered : 6
         * nextPageNo : 2
         */

        private int pageNo;
        private int pageSize;
        private int pageCount;
        private int totalCount;
        private int beginPageIndex;
        private int endPageIndex;
        private String countResultMap;
        private int draw;
        private int recordsTotal;
        private int recordsFiltered;
        private int nextPageNo;
        private List<DataListBean> dataList;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getBeginPageIndex() {
            return beginPageIndex;
        }

        public void setBeginPageIndex(int beginPageIndex) {
            this.beginPageIndex = beginPageIndex;
        }

        public int getEndPageIndex() {
            return endPageIndex;
        }

        public void setEndPageIndex(int endPageIndex) {
            this.endPageIndex = endPageIndex;
        }

        public String getCountResultMap() {
            return countResultMap;
        }

        public void setCountResultMap(String countResultMap) {
            this.countResultMap = countResultMap;
        }

        public int getDraw() {
            return draw;
        }

        public void setDraw(int draw) {
            this.draw = draw;
        }

        public int getRecordsTotal() {
            return recordsTotal;
        }

        public void setRecordsTotal(int recordsTotal) {
            this.recordsTotal = recordsTotal;
        }

        public int getRecordsFiltered() {
            return recordsFiltered;
        }

        public void setRecordsFiltered(int recordsFiltered) {
            this.recordsFiltered = recordsFiltered;
        }

        public int getNextPageNo() {
            return nextPageNo;
        }

        public void setNextPageNo(int nextPageNo) {
            this.nextPageNo = nextPageNo;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * id : ff97a8e7ea4511e992930242ac110012
             * tokenId : null
             * version : 0
             * locked : false
             * lastAccess : 1570592197315
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1570592197315
             * updaterId : 
             * updatedBy : 
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * instoreCode : 20191001001
             * storehouseId : 55838525
             * storehouseName : 500
             * freeLoc : AAA-02-002
             * packingListId : 500
             * instoreState : 1
             * remark : 
             * enable : true
             */

            private String id;
            private String tokenId;
            private int version;
            private boolean locked;
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
            private String instoreCode;
            private String storehouseId;
            private String storehouseName;
            private String freeLoc;
            private String packingListId;
            private String instoreState;
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

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public boolean isLocked() {
                return locked;
            }

            public void setLocked(boolean locked) {
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

            public String getInstoreCode() {
                return instoreCode;
            }

            public void setInstoreCode(String instoreCode) {
                this.instoreCode = instoreCode;
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

            public String getPackingListId() {
                return packingListId;
            }

            public void setPackingListId(String packingListId) {
                this.packingListId = packingListId;
            }

            public String getInstoreState() {
                return instoreState;
            }

            public void setInstoreState(String instoreState) {
                this.instoreState = instoreState;
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
}
