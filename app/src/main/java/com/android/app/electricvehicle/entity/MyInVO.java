package com.android.app.electricvehicle.entity;

import java.io.Serializable;
import java.util.List;

public class MyInVO implements Serializable {


    /**
     * ticket : 370998a8064230cdba57dfb87855dd26
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570797600348
     * data : {"pageNo":1,"pageSize":10,"pageCount":1,"totalCount":1,"beginPageIndex":1,"endPageIndex":1,"dataList":[{"id":"ba8fc8a8ea9311e992930242ac110012","tokenId":null,"version":1,"locked":false,"lastAccess":1570625883301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625582254,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"1181915472606662656","storehouseId":"45933d9fe07511e992930242ac110012","storehouseName":"T00012B00001","freeLoc":"AAA-02-014","packingListId":"7eb0e96bea9211e992930242ac110012","packingCode":"1181913249818480640","instoreState":1,"remark":"","packingList":{"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrString":0,"prStringTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrStringText":"未打印"},"enable":true,"instoreStateText":"已出库"}],"countResultMap":null,"draw":1,"recordsTotal":1,"recordsFiltered":1,"nextPageNo":1}
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
         * pageSize : 10
         * pageCount : 1
         * totalCount : 1
         * beginPageIndex : 1
         * endPageIndex : 1
         * dataList : [{"id":"ba8fc8a8ea9311e992930242ac110012","tokenId":null,"version":1,"locked":false,"lastAccess":1570625883301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625582254,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"1181915472606662656","storehouseId":"45933d9fe07511e992930242ac110012","storehouseName":"T00012B00001","freeLoc":"AAA-02-014","packingListId":"7eb0e96bea9211e992930242ac110012","packingCode":"1181913249818480640","instoreState":1,"remark":"","packingList":{"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrString":0,"prStringTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrStringText":"未打印"},"enable":true,"instoreStateText":"已出库"}]
         * countResultMap : null
         * draw : 1
         * recordsTotal : 1
         * recordsFiltered : 1
         * nextPageNo : 1
         */

        private String pageNo;
        private String pageSize;
        private String pageCount;
        private String totalCount;
        private String beginPageIndex;
        private String endPageIndex;
        private String countResultMap;
        private String draw;
        private String recordsTotal;
        private String recordsFiltered;
        private String nextPageNo;
        private List<DataListBean> dataList;

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getPageCount() {
            return pageCount;
        }

        public void setPageCount(String pageCount) {
            this.pageCount = pageCount;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getBeginPageIndex() {
            return beginPageIndex;
        }

        public void setBeginPageIndex(String beginPageIndex) {
            this.beginPageIndex = beginPageIndex;
        }

        public String getEndPageIndex() {
            return endPageIndex;
        }

        public void setEndPageIndex(String endPageIndex) {
            this.endPageIndex = endPageIndex;
        }

        public String getCountResultMap() {
            return countResultMap;
        }

        public void setCountResultMap(String countResultMap) {
            this.countResultMap = countResultMap;
        }

        public String getDraw() {
            return draw;
        }

        public void setDraw(String draw) {
            this.draw = draw;
        }

        public String getRecordsTotal() {
            return recordsTotal;
        }

        public void setRecordsTotal(String recordsTotal) {
            this.recordsTotal = recordsTotal;
        }

        public String getRecordsFiltered() {
            return recordsFiltered;
        }

        public void setRecordsFiltered(String recordsFiltered) {
            this.recordsFiltered = recordsFiltered;
        }

        public String getNextPageNo() {
            return nextPageNo;
        }

        public void setNextPageNo(String nextPageNo) {
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
             * id : ba8fc8a8ea9311e992930242ac110012
             * tokenId : null
             * version : 1
             * locked : false
             * lastAccess : 1570625883301
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1570625582254
             * updaterId : a475d2268eb511e992930242ac110012
             * updatedBy : 英特诺
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * instoreCode : 1181915472606662656
             * storehouseId : 45933d9fe07511e992930242ac110012
             * storehouseName : T00012B00001
             * freeLoc : AAA-02-014
             * packingListId : 7eb0e96bea9211e992930242ac110012
             * packingCode : 1181913249818480640
             * instoreState : 1
             * remark : 
             * packingList : {"id":"7eb0e96bea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052301,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052301,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1181913249818480640","workCode":"55896849","madeTime":1569501298656,"packingMaterial":1,"rankNum":1,"totalNum":1,"packLength":500,"packwidth":500,"packHeight":500,"netWeight":5000,"roughWeight":5200,"storeState":0,"billArchived":0,"billPrString":0,"prStringTimes":0,"remark":"","packingListItems":[{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}],"enable":true,"storeStateText":"暂存","billArchivedText":"未归档","billPrStringText":"未打印"}
             * enable : true
             * instoreStateText : 已出库
             */

            private String id;
            private String tokenId;
            private String version;
            private boolean locked;
            private long lastAccess;
            private String disabled;
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
            private String packingCode;
            private String instoreState;
            private String remark;
            private PackingListBean packingList;
            private boolean enable;
            private String instoreStateText;


            public String getDisabled() {
                return disabled;
            }

            public void setDisabled(String disabled) {
                this.disabled = disabled;
            }

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

            public String getPackingCode() {
                return packingCode;
            }

            public void setPackingCode(String packingCode) {
                this.packingCode = packingCode;
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

            public String getInstoreStateText() {
                return instoreStateText;
            }

            public void setInstoreStateText(String instoreStateText) {
                this.instoreStateText = instoreStateText;
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
                 * billPrString : 0
                 * prStringTimes : 0
                 * remark : 
                 * packingListItems : [{"id":"7eb760afea9211e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570625052353,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570625052353,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7eb0e96bea9211e992930242ac110012","soItem":"100","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300,"wtpc":0,"totalWeight":0,"enable":true}]
                 * enable : true
                 * storeStateText : 暂存
                 * billArchivedText : 未归档
                 * billPrStringText : 未打印
                 */

                private String id;
                private String tokenId;
                private String version;
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
                private String packingMaterial;
                private String rankNum;
                private String totalNum;
                private String packLength;
                private String packwidth;
                private String packHeight;
                private String netWeight;
                private String roughWeight;
                private String storeState;
                private String billArchived;
                private String billPrint;
                private String printTimes;
                private String remark;
                private boolean enable;
                private String storeStateText;
                private String billArchivedText;
                private String billPrintText;
                private List<PackingListItemsBean> packingListItems;


                public String getBillPrint() {
                    return billPrint;
                }

                public void setBillPrint(String billPrint) {
                    this.billPrint = billPrint;
                }

                public String getPrintTimes() {
                    return printTimes;
                }

                public void setPrintTimes(String printTimes) {
                    this.printTimes = printTimes;
                }

                public String getBillPrintText() {
                    return billPrintText;
                }

                public void setBillPrintText(String billPrintText) {
                    this.billPrintText = billPrintText;
                }

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

                public String getPackingMaterial() {
                    return packingMaterial;
                }

                public void setPackingMaterial(String packingMaterial) {
                    this.packingMaterial = packingMaterial;
                }

                public String getRankNum() {
                    return rankNum;
                }

                public void setRankNum(String rankNum) {
                    this.rankNum = rankNum;
                }

                public String getTotalNum() {
                    return totalNum;
                }

                public void setTotalNum(String totalNum) {
                    this.totalNum = totalNum;
                }

                public String getPackLength() {
                    return packLength;
                }

                public void setPackLength(String packLength) {
                    this.packLength = packLength;
                }

                public String getPackwidth() {
                    return packwidth;
                }

                public void setPackwidth(String packwidth) {
                    this.packwidth = packwidth;
                }

                public String getPackHeight() {
                    return packHeight;
                }

                public void setPackHeight(String packHeight) {
                    this.packHeight = packHeight;
                }

                public String getNetWeight() {
                    return netWeight;
                }

                public void setNetWeight(String netWeight) {
                    this.netWeight = netWeight;
                }

                public String getRoughWeight() {
                    return roughWeight;
                }

                public void setRoughWeight(String roughWeight) {
                    this.roughWeight = roughWeight;
                }

                public String getStoreState() {
                    return storeState;
                }

                public void setStoreState(String storeState) {
                    this.storeState = storeState;
                }

                public String getBillArchived() {
                    return billArchived;
                }

                public void setBillArchived(String billArchived) {
                    this.billArchived = billArchived;
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
                    private String version;
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
                    private String rl;
                    private String agl;
                    private String qty;
                    private String wtpc;
                    private String totalWeight;
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

                    public String getRl() {
                        return rl;
                    }

                    public void setRl(String rl) {
                        this.rl = rl;
                    }

                    public String getAgl() {
                        return agl;
                    }

                    public void setAgl(String agl) {
                        this.agl = agl;
                    }

                    public String getQty() {
                        return qty;
                    }

                    public void setQty(String qty) {
                        this.qty = qty;
                    }

                    public String getWtpc() {
                        return wtpc;
                    }

                    public void setWtpc(String wtpc) {
                        this.wtpc = wtpc;
                    }

                    public String getTotalWeight() {
                        return totalWeight;
                    }

                    public void setTotalWeight(String totalWeight) {
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
