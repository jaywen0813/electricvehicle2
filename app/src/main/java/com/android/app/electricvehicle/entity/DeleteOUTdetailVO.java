package com.android.app.electricvehicle.entity;

import java.util.List;

//出库作废以后返回的
public class DeleteOUTdetailVO {

    /**
     * ticket : 7eab65f86a6231b383f6b970f02c0472
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1571192659539
     * data : {"id":"d824717eef0711e994c60242ac110018","tokenId":null,"version":0,"locked":false,"lastAccess":1571115258158,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1571115258158,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","outstoreCode":"1183969322209513472","storehouseId":"ca912ef7e2cf11e992930242ac110012","storehouseName":"T00029A00004","freeLoc":"APP-02-009","PackingId":"7686dcc3eddf11e992930242ac110012","packingCode":"1183435409103917056","remark":"","Packing":{"id":"7686dcc3eddf11e992930242ac110012","tokenId":null,"version":6,"locked":false,"lastAccess":1571192659569,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987963354,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1183435409103917056","workCode":"56150073","madeTime":1570987963354,"packingMaterial":0,"rankNum":1,"totalNum":1,"packLength":1,"packwidth":1,"packHeight":1,"netWeight":1,"roughWeight":1,"storeState":2,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","PackingItems":[{"id":"76879ad7eddf11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987963359,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987963359,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7686dcc3eddf11e992930242ac110012","soItem":"10","material":"RD-89VVJ725PF","rl":319,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}],"packingMaterialText":"Carton(纸箱)","storeStateText":"已入库","billArchivedText":"未归档","billPrintText":"未打印","enable":true},"enable":true}
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
         * id : d824717eef0711e994c60242ac110018
         * tokenId : null
         * version : 0
         * locked : false
         * lastAccess : 1571115258158
         * disabled : false
         * creatorId : a475d2268eb511e992930242ac110012
         * createdBy : 英特诺
         * createdTime : 1571115258158
         * updaterId : 
         * updatedBy : 
         * dataId : null
         * isNew : null
         * logTime : null
         * tenantId : 304548c2ec8033f4917b18bfe144c569
         * outstoreCode : 1183969322209513472
         * storehouseId : ca912ef7e2cf11e992930242ac110012
         * storehouseName : T00029A00004
         * freeLoc : APP-02-009
         * PackingId : 7686dcc3eddf11e992930242ac110012
         * packingCode : 1183435409103917056
         * remark : 
         * Packing : {"id":"7686dcc3eddf11e992930242ac110012","tokenId":null,"version":6,"locked":false,"lastAccess":1571192659569,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987963354,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1183435409103917056","workCode":"56150073","madeTime":1570987963354,"packingMaterial":0,"rankNum":1,"totalNum":1,"packLength":1,"packwidth":1,"packHeight":1,"netWeight":1,"roughWeight":1,"storeState":2,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","PackingItems":[{"id":"76879ad7eddf11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987963359,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987963359,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7686dcc3eddf11e992930242ac110012","soItem":"10","material":"RD-89VVJ725PF","rl":319,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}],"packingMaterialText":"Carton(纸箱)","storeStateText":"已入库","billArchivedText":"未归档","billPrintText":"未打印","enable":true}
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
        private String PackingId;
        private String packingCode;
        private String remark;
        private PackingBean Packing;
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

        public String getPackingId() {
            return PackingId;
        }

        public void setPackingId(String PackingId) {
            this.PackingId = PackingId;
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

        public PackingBean getPacking() {
            return Packing;
        }

        public void setPacking(PackingBean Packing) {
            this.Packing = Packing;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public static class PackingBean {
            /**
             * id : 7686dcc3eddf11e992930242ac110012
             * tokenId : null
             * version : 6
             * locked : false
             * lastAccess : 1571192659569
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1570987963354
             * updaterId : a475d2268eb511e992930242ac110012
             * updatedBy : 英特诺
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * packingCode : 1183435409103917056
             * workCode : 56150073
             * madeTime : 1570987963354
             * packingMaterial : 0
             * rankNum : 1
             * totalNum : 1
             * packLength : 1
             * packwidth : 1
             * packHeight : 1
             * netWeight : 1
             * roughWeight : 1
             * storeState : 2
             * billArchived : 0
             * billPrint : 0
             * printTimes : 0
             * remark : 
             * PackingItems : [{"id":"76879ad7eddf11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987963359,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987963359,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"7686dcc3eddf11e992930242ac110012","soItem":"10","material":"RD-89VVJ725PF","rl":319,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}]
             * packingMaterialText : Carton(纸箱)
             * storeStateText : 已入库
             * billArchivedText : 未归档
             * billPrintText : 未打印
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
            private String packingMaterialText;
            private String storeStateText;
            private String billArchivedText;
            private String billPrintText;
            private boolean enable;
            private List<PackingItemsBean> PackingItems;

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

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public List<PackingItemsBean> getPackingItems() {
                return PackingItems;
            }

            public void setPackingItems(List<PackingItemsBean> PackingItems) {
                this.PackingItems = PackingItems;
            }

            public static class PackingItemsBean {
                /**
                 * id : 76879ad7eddf11e992930242ac110012
                 * tokenId : null
                 * version : 0
                 * locked : false
                 * lastAccess : 1570987963359
                 * disabled : false
                 * creatorId : a475d2268eb511e992930242ac110012
                 * createdBy : 英特诺
                 * createdTime : 1570987963359
                 * updaterId : 
                 * updatedBy : 
                 * dataId : null
                 * isNew : null
                 * logTime : null
                 * packingId : 7686dcc3eddf11e992930242ac110012
                 * soItem : 10
                 * material : RD-89VVJ725PF
                 * rl : 319
                 * agl : 0
                 * qty : 0
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
                private int rl;
                private int agl;
                private int qty;
                private int wtpc;
                private int totalWeight;
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
}
