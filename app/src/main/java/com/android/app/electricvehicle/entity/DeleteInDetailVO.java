package com.android.app.electricvehicle.entity;

import java.util.List;

//入库单作废以后返回的
public class DeleteInDetailVO {

    /**
     * ticket : e813ca654e583b7388be960b10f15925
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1571189829024
     * data : {"id":"0732c902ef0811e994c60242ac110018","tokenId":null,"version":0,"locked":false,"lastAccess":1571115337105,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1571115337105,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"1183969653337231360","storehouseId":"2b94e116ee3d11e994c60242ac110018","storehouseName":"成品仓A区","freeLoc":"FGB-02-004","packingListId":"d182e21eedde11e992930242ac110012","packingCode":"1183434247910854656","instoreState":0,"remark":"","packingList":{"id":"d182e21eedde11e992930242ac110012","tokenId":null,"version":4,"locked":false,"lastAccess":1571189829051,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987686504,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1183434247910854656","workCode":"55868400","madeTime":1570987686504,"packingMaterial":2,"rankNum":1,"totalNum":2,"packLength":10,"packwidth":11,"packHeight":12,"netWeight":13,"roughWeight":14,"storeState":1,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","packingListItems":[{"id":"d184015bedde11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987686511,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987686511,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"d182e21eedde11e992930242ac110012","soItem":"10","material":"RD-35VDJ72WAB","rl":414,"agl":0,"qty":0,"wtpc":10,"totalWeight":15,"remark":"","enable":true}],"packingMaterialText":"Wooden Carton(木托盘纸箱)","storeStateText":"待入库","billArchivedText":"未归档","billPrintText":"未打印","enable":true},"instoreStateText":"未出库","enable":true}
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
         * id : 0732c902ef0811e994c60242ac110018
         * tokenId : null
         * version : 0
         * locked : false
         * lastAccess : 1571115337105
         * disabled : false
         * creatorId : a475d2268eb511e992930242ac110012
         * createdBy : 英特诺
         * createdTime : 1571115337105
         * updaterId : 
         * updatedBy : 
         * dataId : null
         * isNew : null
         * logTime : null
         * tenantId : 304548c2ec8033f4917b18bfe144c569
         * instoreCode : 1183969653337231360
         * storehouseId : 2b94e116ee3d11e994c60242ac110018
         * storehouseName : 成品仓A区
         * freeLoc : FGB-02-004
         * packingListId : d182e21eedde11e992930242ac110012
         * packingCode : 1183434247910854656
         * instoreState : 0
         * remark : 
         * packingList : {"id":"d182e21eedde11e992930242ac110012","tokenId":null,"version":4,"locked":false,"lastAccess":1571189829051,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987686504,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1183434247910854656","workCode":"55868400","madeTime":1570987686504,"packingMaterial":2,"rankNum":1,"totalNum":2,"packLength":10,"packwidth":11,"packHeight":12,"netWeight":13,"roughWeight":14,"storeState":1,"billArchived":0,"billPrint":0,"printTimes":0,"remark":"","packingListItems":[{"id":"d184015bedde11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987686511,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987686511,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"d182e21eedde11e992930242ac110012","soItem":"10","material":"RD-35VDJ72WAB","rl":414,"agl":0,"qty":0,"wtpc":10,"totalWeight":15,"remark":"","enable":true}],"packingMaterialText":"Wooden Carton(木托盘纸箱)","storeStateText":"待入库","billArchivedText":"未归档","billPrintText":"未打印","enable":true}
         * instoreStateText : 未出库
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
        private String packingCode;
        private int instoreState;
        private String remark;
        private PackingListBean packingList;
        private String instoreStateText;
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

        public String getPackingCode() {
            return packingCode;
        }

        public void setPackingCode(String packingCode) {
            this.packingCode = packingCode;
        }

        public int getInstoreState() {
            return instoreState;
        }

        public void setInstoreState(int instoreState) {
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

        public String getInstoreStateText() {
            return instoreStateText;
        }

        public void setInstoreStateText(String instoreStateText) {
            this.instoreStateText = instoreStateText;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public static class PackingListBean {
            /**
             * id : d182e21eedde11e992930242ac110012
             * tokenId : null
             * version : 4
             * locked : false
             * lastAccess : 1571189829051
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1570987686504
             * updaterId : a475d2268eb511e992930242ac110012
             * updatedBy : 英特诺
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * packingCode : 1183434247910854656
             * workCode : 55868400
             * madeTime : 1570987686504
             * packingMaterial : 2
             * rankNum : 1
             * totalNum : 2
             * packLength : 10
             * packwidth : 11
             * packHeight : 12
             * netWeight : 13
             * roughWeight : 14
             * storeState : 1
             * billArchived : 0
             * billPrint : 0
             * printTimes : 0
             * remark : 
             * packingListItems : [{"id":"d184015bedde11e992930242ac110012","tokenId":null,"version":0,"locked":false,"lastAccess":1570987686511,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1570987686511,"updaterId":"","updatedBy":"","dataId":null,"isNew":null,"logTime":null,"packingId":"d182e21eedde11e992930242ac110012","soItem":"10","material":"RD-35VDJ72WAB","rl":414,"agl":0,"qty":0,"wtpc":10,"totalWeight":15,"remark":"","enable":true}]
             * packingMaterialText : Wooden Carton(木托盘纸箱)
             * storeStateText : 待入库
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

            public List<PackingListItemsBean> getPackingListItems() {
                return packingListItems;
            }

            public void setPackingListItems(List<PackingListItemsBean> packingListItems) {
                this.packingListItems = packingListItems;
            }

            public static class PackingListItemsBean {
                /**
                 * id : d184015bedde11e992930242ac110012
                 * tokenId : null
                 * version : 0
                 * locked : false
                 * lastAccess : 1570987686511
                 * disabled : false
                 * creatorId : a475d2268eb511e992930242ac110012
                 * createdBy : 英特诺
                 * createdTime : 1570987686511
                 * updaterId : 
                 * updatedBy : 
                 * dataId : null
                 * isNew : null
                 * logTime : null
                 * packingId : d182e21eedde11e992930242ac110012
                 * soItem : 10
                 * material : RD-35VDJ72WAB
                 * rl : 414
                 * agl : 0
                 * qty : 0
                 * wtpc : 10
                 * totalWeight : 15
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
