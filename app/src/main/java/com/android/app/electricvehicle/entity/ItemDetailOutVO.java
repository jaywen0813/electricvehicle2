package com.android.app.electricvehicle.entity;

import java.util.List;

public class ItemDetailOutVO {


    /**
     * ticket : 9624ac769cdc36b1bef9f55f4c5d73e1
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1572246359615
     * data : {"id":"8b88edb0f56611e9a72d0242ac110004","tokenId":null,"version":0,"locked":false,"lastAccess":1571815638798,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1571815638798,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1186906931529388032","workCode":"4444","madeTime":1571815638532,"packingMaterial":0,"rankNum":77555,"totalNum":55554,"packLength":7885,"packwidth":885,"packHeight":844,"netWeight":855,"roughWeight":57,"storeState":1,"billArchived":0,"billPrint":0,"printTimes":0,"salesOrder":"885","comments":"885","installTime":1571815620000,"deliveryDate":1571815622000,"remark":"","packingListItems":[{"id":"8b89b984f56611e9a72d0242ac110004","tokenId":null,"version":0,"locked":false,"lastAccess":1571815638803,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1571815638803,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"8b88edb0f56611e9a72d0242ac110004","soItem":"路","material":"888","rl":888,"agl":888,"qty":888,"wtpc":0,"totalWeight":0,"remark":"","enable":true}],"packingMaterialText":"Carton(纸箱)","storeStateText":"待入库","billPrintText":"未打印","installTimeText":"2019-10-23","deliveryDateText":"2019-10-23","enable":true,"billArchivedText":"未归档"}
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
         * id : 8b88edb0f56611e9a72d0242ac110004
         * tokenId : null
         * version : 0
         * locked : false
         * lastAccess : 1571815638798
         * disabled : false
         * creatorId : a475d2268eb511e992930242ac110012
         * createdBy : 英特诺
         * createdTime : 1571815638798
         * updaterId :
         * updatedBy :
         * dataId : null
         * isNew : null
         * logTime : null
         * tenantId : 304548c2ec8033f4917b18bfe144c569
         * packingCode : 1186906931529388032
         * workCode : 4444
         * madeTime : 1571815638532
         * packingMaterial : 0
         * rankNum : 77555
         * totalNum : 55554
         * packLength : 7885
         * packwidth : 885
         * packHeight : 844
         * netWeight : 855
         * roughWeight : 57
         * storeState : 1
         * billArchived : 0
         * billPrint : 0
         * printTimes : 0
         * salesOrder : 885
         * comments : 885
         * installTime : 1571815620000
         * deliveryDate : 1571815622000
         * remark :
         * packingListItems : [{"id":"8b89b984f56611e9a72d0242ac110004","tokenId":null,"version":0,"locked":false,"lastAccess":1571815638803,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1571815638803,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"8b88edb0f56611e9a72d0242ac110004","soItem":"路","material":"888","rl":888,"agl":888,"qty":888,"wtpc":0,"totalWeight":0,"remark":"","enable":true}]
         * packingMaterialText : Carton(纸箱)
         * storeStateText : 待入库
         * billPrintText : 未打印
         * installTimeText : 2019-10-23
         * deliveryDateText : 2019-10-23
         * enable : true
         * billArchivedText : 未归档
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
        private String madeTime;
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
        private String salesOrder;
        private String comments;
        private String installTime;
        private String deliveryDate;
        private String remark;
        private String packingMaterialText;
        private String storeStateText;
        private String billPrintText;
        private String installTimeText;
        private String deliveryDateText;
        private boolean enable;
        private String billArchivedText;
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



        public String getSalesOrder() {
            return salesOrder;
        }

        public void setSalesOrder(String salesOrder) {
            this.salesOrder = salesOrder;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getMadeTime() {
            return madeTime;
        }

        public void setMadeTime(String madeTime) {
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

        public String getInstallTime() {
            return installTime;
        }

        public void setInstallTime(String installTime) {
            this.installTime = installTime;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPackingMaterialText() {
            return packingMaterialText;
        }

        public void setPackingMaterialText(String packingMaterialText) {
            this.packingMaterialText = packingMaterialText;
        }

        public String getStoreStateText() {
            return storeStateText;
        }

        public void setStoreStateText(String storeStateText) {
            this.storeStateText = storeStateText;
        }

        public String getBillPrintText() {
            return billPrintText;
        }

        public void setBillPrintText(String billPrintText) {
            this.billPrintText = billPrintText;
        }

        public String getInstallTimeText() {
            return installTimeText;
        }

        public void setInstallTimeText(String installTimeText) {
            this.installTimeText = installTimeText;
        }

        public String getDeliveryDateText() {
            return deliveryDateText;
        }

        public void setDeliveryDateText(String deliveryDateText) {
            this.deliveryDateText = deliveryDateText;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
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
             * id : 8b89b984f56611e9a72d0242ac110004
             * tokenId : null
             * version : 0
             * locked : false
             * lastAccess : 1571815638803
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1571815638803
             * updaterId :
             * updatedBy :
             * dataId : null
             * isNew : null
             * logTime : null
             * packingId : 8b88edb0f56611e9a72d0242ac110004
             * soItem : 路
             * material : 888
             * rl : 888
             * agl : 888
             * qty : 888
             * wtpc : 0
             * totalWeight : 0
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
            private String packingId;
            private String soItem;
            private String material;
            private String rl;
            private String agl;
            private String qty;
            private String wtpc;
            private String totalWeight;
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
