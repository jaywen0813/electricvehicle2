package com.android.app.electricvehicle.entity;

import java.util.List;

public class OutDetailVO2 {


    /**
     * ticket : a4b008b620853204b1f01c85cbb163bc
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1572242463922
     * data : [{"id":"50c16f32f92e11e9a72d0242ac110004","tokenId":null,"version":1,"locked":false,"lastAccess":1572231327793,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572231293017,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","instoreCode":"1188650311678562304","storehouseId":"9aa021d5f3a511e9a72d0242ac110004","storehouseName":"成品仓","freeLoc":"FGA-01-089","packingListId":"75a24e0ef92c11e9a72d0242ac110004","packingCode":"1188646968293986304","instoreState":1,"remark":"","packingList":{"id":"75a24e0ef92c11e9a72d0242ac110004","tokenId":null,"version":3,"locked":false,"lastAccess":1572231327803,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572230495892,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1188646968293986304","workCode":"58771379","madeTime":1572230495891,"packingMaterial":2,"rankNum":1,"totalNum":1,"packLength":1,"packwidth":1,"packHeight":1,"netWeight":1,"roughWeight":1,"storeState":3,"billArchived":0,"billPrint":0,"printTimes":0,"salesOrder":"1981469","comments":"","installTime":1699200000,"deliveryDate":1573401600000,"remark":"","packingListItems":[{"id":"75a6cbbff92c11e9a72d0242ac110004","tokenId":null,"version":1,"locked":false,"lastAccess":1572231293011,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572230495924,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"packingId":"75a24e0ef92c11e9a72d0242ac110004","soItem":"220","material":"RD-35VDJAAWAB","rl":455,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}],"packingMaterialText":"Wooden Carton(木托盘纸箱)","storeStateText":"已出库","billPrintText":"未打印","installTimeText":"1970-01-21","deliveryDateText":"2019-11-11","enable":true,"billArchivedText":"未归档"},"instoreStateText":"已出库","enable":true}]
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
    private String args;
    private String moreinfo;
    private String detail;
    private String subCode;
    private String subMessage;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 50c16f32f92e11e9a72d0242ac110004
         * tokenId : null
         * version : 1
         * locked : false
         * lastAccess : 1572231327793
         * disabled : false
         * creatorId : a475d2268eb511e992930242ac110012
         * createdBy : 英特诺
         * createdTime : 1572231293017
         * updaterId : a475d2268eb511e992930242ac110012
         * updatedBy : 英特诺
         * dataId : null
         * isNew : null
         * logTime : null
         * tenantId : 304548c2ec8033f4917b18bfe144c569
         * instoreCode : 1188650311678562304
         * storehouseId : 9aa021d5f3a511e9a72d0242ac110004
         * storehouseName : 成品仓
         * freeLoc : FGA-01-089
         * packingListId : 75a24e0ef92c11e9a72d0242ac110004
         * packingCode : 1188646968293986304
         * instoreState : 1
         * remark :
         * packingList : {"id":"75a24e0ef92c11e9a72d0242ac110004","tokenId":null,"version":3,"locked":false,"lastAccess":1572231327803,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572230495892,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"tenantId":"304548c2ec8033f4917b18bfe144c569","packingCode":"1188646968293986304","workCode":"58771379","madeTime":1572230495891,"packingMaterial":2,"rankNum":1,"totalNum":1,"packLength":1,"packwidth":1,"packHeight":1,"netWeight":1,"roughWeight":1,"storeState":3,"billArchived":0,"billPrint":0,"printTimes":0,"salesOrder":"1981469","comments":"","installTime":1699200000,"deliveryDate":1573401600000,"remark":"","packingListItems":[{"id":"75a6cbbff92c11e9a72d0242ac110004","tokenId":null,"version":1,"locked":false,"lastAccess":1572231293011,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572230495924,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"packingId":"75a24e0ef92c11e9a72d0242ac110004","soItem":"220","material":"RD-35VDJAAWAB","rl":455,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}],"packingMaterialText":"Wooden Carton(木托盘纸箱)","storeStateText":"已出库","billPrintText":"未打印","installTimeText":"1970-01-21","deliveryDateText":"2019-11-11","enable":true,"billArchivedText":"未归档"}
         * instoreStateText : 已出库
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
        private String createdTime;
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

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
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
             * id : 75a24e0ef92c11e9a72d0242ac110004
             * tokenId : null
             * version : 3
             * locked : false
             * lastAccess : 1572231327803
             * disabled : false
             * creatorId : a475d2268eb511e992930242ac110012
             * createdBy : 英特诺
             * createdTime : 1572230495892
             * updaterId : a475d2268eb511e992930242ac110012
             * updatedBy : 英特诺
             * dataId : null
             * isNew : null
             * logTime : null
             * tenantId : 304548c2ec8033f4917b18bfe144c569
             * packingCode : 1188646968293986304
             * workCode : 58771379
             * madeTime : 1572230495891
             * packingMaterial : 2
             * rankNum : 1
             * totalNum : 1
             * packLength : 1
             * packwidth : 1
             * packHeight : 1
             * netWeight : 1
             * roughWeight : 1
             * storeState : 3
             * billArchived : 0
             * billPrint : 0
             * printTimes : 0
             * salesOrder : 1981469
             * comments :
             * installTime : 1699200000
             * deliveryDate : 1573401600000
             * remark :
             * packingListItems : [{"id":"75a6cbbff92c11e9a72d0242ac110004","tokenId":null,"version":1,"locked":false,"lastAccess":1572231293011,"disabled":false,"creatorId":"a475d2268eb511e992930242ac110012","createdBy":"英特诺","createdTime":1572230495924,"updaterId":"a475d2268eb511e992930242ac110012","updatedBy":"英特诺","dataId":null,"isNew":null,"logTime":null,"packingId":"75a24e0ef92c11e9a72d0242ac110004","soItem":"220","material":"RD-35VDJAAWAB","rl":455,"agl":0,"qty":0,"wtpc":0,"totalWeight":0,"remark":"","enable":true}]
             * packingMaterialText : Wooden Carton(木托盘纸箱)
             * storeStateText : 已出库
             * billPrintText : 未打印
             * installTimeText : 1970-01-21
             * deliveryDateText : 2019-11-11
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
            private int totalNum;
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



            public int getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(int totalNum) {
                this.totalNum = totalNum;
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
                 * id : 75a6cbbff92c11e9a72d0242ac110004
                 * tokenId : null
                 * version : 1
                 * locked : false
                 * lastAccess : 1572231293011
                 * disabled : false
                 * creatorId : a475d2268eb511e992930242ac110012
                 * createdBy : 英特诺
                 * createdTime : 1572230495924
                 * updaterId : a475d2268eb511e992930242ac110012
                 * updatedBy : 英特诺
                 * dataId : null
                 * isNew : null
                 * logTime : null
                 * packingId : 75a24e0ef92c11e9a72d0242ac110004
                 * soItem : 220
                 * material : RD-35VDJAAWAB
                 * rl : 455
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
                private String rl;
                private String agl;
                private String qty;
                private String wtpc;
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
