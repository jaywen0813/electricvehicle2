package com.android.app.electricvehicle.entity;

import java.io.Serializable;
import java.util.List;

public class MyOutVO implements Serializable {


    /**
     * ticket : eeb9e7202243330385728435cd06ebf1
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570797645339
     * data : {"pageNo":1,"pageSize":2,"pageCount":2,"totalCount":4,"beginPageIndex":1,"endPageIndex":2,"dataList":[{"id":"6df0e3ccea9411e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625883104,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625883104,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"1181916734454632448","storehouseId":"45933d9fe07511e992930242ac110012","storehouseName":"T00012B00001","freeLoc":"AAA-02-014","packingListId":"7eb0e96bea9211e992930242ac110012","packingCode":"1181913249818480640","remark":"","packingList":{"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrintText":"未打印"},"enable":true},{"id":"6c737657ea6011e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570603546715,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570603546715,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"20191001001","packingCode":"","remark":"","packingList":null,"enable":true}],"countResultMap":null,"draw":1,"recordsTotal":4,"recordsFiltered":4,"nextPageNo":2}
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
         * pageCount : 2
         * totalCount : 4
         * beginPageIndex : 1
         * endPageIndex : 2
         * dataList : [{"id":"6df0e3ccea9411e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625883104,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625883104,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"1181916734454632448","storehouseId":"45933d9fe07511e992930242ac110012","storehouseName":"T00012B00001","freeLoc":"AAA-02-014","packingListId":"7eb0e96bea9211e992930242ac110012","packingCode":"1181913249818480640","remark":"","packingList":{"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrintText":"未打印"},"enable":true},{"id":"6c737657ea6011e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570603546715,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570603546715,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"20191001001","storehouseId":"55838525","storehouseName":"500","freeLoc":"AAA-02-002","packingListId":"20191001001","packingCode":"","remark":"","packingList":null,"enable":true}]
         * countResultMap : null
         * draw : 1
         * recordsTotal : 4
         * recordsFiltered : 4
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
             * id : 6df0e3ccea9411e992930242ac110012
             * tokenId : null
             * version : 0
             * locked : false
             * lastAccess : 1570625883104
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1570625883104
             * updaterId : 
             * updatedBy : 
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * outstoreCode : 1181916734454632448
             * storehouseId : 45933d9fe07511e992930242ac110012
             * storehouseName : T00012B00001
             * freeLoc : AAA-02-014
             * packingListId : 7eb0e96bea9211e992930242ac110012
             * packingCode : 1181913249818480640
             * remark : 
             * packingList : {"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrintText":"未打印"}
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
            private String outstoreCode;
            private String storehouseId;
            private String storehouseName;
            private String freeLoc;
            private String packingListId;
            private String packingCode;
            private String remark;
            private PackingListBean packingList;
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

            public String getPackingListId() {
                return packingListId;
            }

            public void setPackingListId(String packingListId) {
                this.packingListId = packingListId;
            }

            public String getPackingCode() {
                return packingCode;
            }

            public void setPackingCode(String packingCode) {
                this.packingCode = packingCode;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public PackingListBean getPackingList() {
                return packingList;
            }

            public void setPackingList(PackingListBean packingList) {
                this.packingList = packingList;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public static class PackingListBean {
                /**
                 * id : 7eb0e96bea9211e992930242ac110012
                 * tokenId : null
                 * version : 0
                 * locked : false
                 * lastAccess : 1570625052301
                 * disabled : false
                 * creatorId : a475d2268eb511e992930242ac110012
                 * createdBy : 英特诺
                 * createdTime : 1570625052301
                 * updaterId : 
                 * updatedBy : 
                 * dataId : null
                 * isNew : null
                 * logTime : null
                 * tenantId : 304548c2ec8033f4917b18bfe144c569
                 * packingCode : 1181913249818480640
                 * workCode : 55896849
                 * madeTime : 1569501298656
                 * packingMaterial : 1
                 * rankNum : 1
                 * totalNum : 1
                 * packLength : 500
                 * packwidth : 500
                 * packHeight : 500
                 * netWeight : 5000
                 * roughWeight : 5200
                 * storeState : 0
                 * billArchived : 0
                 * billPrint : 0
                 * printTimes : 0
                 * remark : 
                 * packingListItems : [{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}]
                 * enable : true
                 * storeStateText : 暂存
                 * billArchivedText : 未归档
                 * billPrintText : 未打印
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
                private String packingCode;
                private String workCode;
                private long madeTime;
                private int packingMaterial;
                private int rankNum;
                private int totalNum;
                private int packLength;
                private int packwidth;
                private int packHeight;
                private int netWeight;
                private int roughWeight;
                private int storeState;
                private int billArchived;
                private int billPrint;
                private int printTimes;
                private String remark;
                private boolean enable;
                private String storeStateText;
                private String billArchivedText;
                private String billPrintText;
                private List<PackingListItemsBean> packingListItems;

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

                public String getPackingCode() {
                    return packingCode;
                }

                public void setPackingCode(String packingCode) {
                    this.packingCode = packingCode;
                }

                public String getWorkCode() {
                    return workCode;
                }

                public void setWorkCode(String workCode) {
                    this.workCode = workCode;
                }

                public long getMadeTime() {
                    return madeTime;
                }

                public void setMadeTime(long madeTime) {
                    this.madeTime = madeTime;
                }

                public int getPackingMaterial() {
                    return packingMaterial;
                }

                public void setPackingMaterial(int packingMaterial) {
                    this.packingMaterial = packingMaterial;
                }

                public int getRankNum() {
                    return rankNum;
                }

                public void setRankNum(int rankNum) {
                    this.rankNum = rankNum;
                }

                public int getTotalNum() {
                    return totalNum;
                }

                public void setTotalNum(int totalNum) {
                    this.totalNum = totalNum;
                }

                public int getPackLength() {
                    return packLength;
                }

                public void setPackLength(int packLength) {
                    this.packLength = packLength;
                }

                public int getPackwidth() {
                    return packwidth;
                }

                public void setPackwidth(int packwidth) {
                    this.packwidth = packwidth;
                }

                public int getPackHeight() {
                    return packHeight;
                }

                public void setPackHeight(int packHeight) {
                    this.packHeight = packHeight;
                }

                public int getNetWeight() {
                    return netWeight;
                }

                public void setNetWeight(int netWeight) {
                    this.netWeight = netWeight;
                }

                public int getRoughWeight() {
                    return roughWeight;
                }

                public void setRoughWeight(int roughWeight) {
                    this.roughWeight = roughWeight;
                }

                public int getStoreState() {
                    return storeState;
                }

                public void setStoreState(int storeState) {
                    this.storeState = storeState;
                }

                public int getBillArchived() {
                    return billArchived;
                }

                public void setBillArchived(int billArchived) {
                    this.billArchived = billArchived;
                }

                public int getBillPrint() {
                    return billPrint;
                }

                public void setBillPrint(int billPrint) {
                    this.billPrint = billPrint;
                }

                public int getPrintTimes() {
                    return printTimes;
                }

                public void setPrintTimes(int printTimes) {
                    this.printTimes = printTimes;
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

                public String getStoreStateText() {
                    return storeStateText;
                }

                public void setStoreStateText(String storeStateText) {
                    this.storeStateText = storeStateText;
                }

                public String getBillArchivedText() {
                    return billArchivedText;
                }

                public void setBillArchivedText(String billArchivedText) {
                    this.billArchivedText = billArchivedText;
                }

                public String getBillPrintText() {
                    return billPrintText;
                }

                public void setBillPrintText(String billPrintText) {
                    this.billPrintText = billPrintText;
                }

                public List<PackingListItemsBean> getPackingListItems() {
                    return packingListItems;
                }

                public void setPackingListItems(List<PackingListItemsBean> packingListItems) {
                    this.packingListItems = packingListItems;
                }

                public static class PackingListItemsBean {
                    /**
                     * id : 7eb760afea9211e992930242ac110012
                     * tokenId : null
                     * version : 0
                     * locked : false
                     * lastAccess : 1570625052353
                     * disabled : false
                     * creatorId : a475d2268eb511e992930242ac110012
                     * createdBy : 英特诺
                     * createdTime : 1570625052353
                     * updaterId : 
                     * updatedBy : 
                     * dataId : null
                     * isNew : null
                     * logTime : null
                     * packingId : 7eb0e96bea9211e992930242ac110012
                     * soItem : 100
                     * material : RD-89VHJ4A5PF
                     * rl : 100
                     * agl : 200
                     * qty : 300
                     * wtpc : 0
                     * totalWeight : 0
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
                    private String packingId;
                    private String soItem;
                    private String material;
                    private int rl;
                    private int agl;
                    private int qty;
                    private int wtpc;
                    private int totalWeight;
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

                    public String getPackingId() {
                        return packingId;
                    }

                    public void setPackingId(String packingId) {
                        this.packingId = packingId;
                    }

                    public String getSoItem() {
                        return soItem;
                    }

                    public void setSoItem(String soItem) {
                        this.soItem = soItem;
                    }

                    public String getMaterial() {
                        return material;
                    }

                    public void setMaterial(String material) {
                        this.material = material;
                    }

                    public int getRl() {
                        return rl;
                    }

                    public void setRl(int rl) {
                        this.rl = rl;
                    }

                    public int getAgl() {
                        return agl;
                    }

                    public void setAgl(int agl) {
                        this.agl = agl;
                    }

                    public int getQty() {
                        return qty;
                    }

                    public void setQty(int qty) {
                        this.qty = qty;
                    }

                    public int getWtpc() {
                        return wtpc;
                    }

                    public void setWtpc(int wtpc) {
                        this.wtpc = wtpc;
                    }

                    public int getTotalWeight() {
                        return totalWeight;
                    }

                    public void setTotalWeight(int totalWeight) {
                        this.totalWeight = totalWeight;
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
    }
}
