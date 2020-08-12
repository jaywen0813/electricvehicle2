package com.android.app.electricvehicle.entity;

import java.util.List;

public class INDetail_RuKu {
    //用来入库的  传递给后台的参数的
    /**
     * packingCode : 1181913249818480640
     * freeLoc :
     * Packing : {"workCode":"55873904","madeTime":"1569501298656","packingMaterial":1,"rankNum":"1","totalNum":"1","packLength":"500","packwidth":"500","packHeight":"500","netWeight":5000,"roughWeight":5200,"salesOrder":"ssssss","comments":"sss","installTime":"1569501298656","deliveryDate":"1569501298656","PackingItems":[{"soItem":"10","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300}]}
     */

    private String packingCode;
    private String freeLoc;
    private PackingBean Packing;

    public String getPackingCode() {
        return packingCode;
    }

    public void setPackingCode(String packingCode) {
        this.packingCode = packingCode;
    }

    public String getFreeLoc() {
        return freeLoc;
    }

    public void setFreeLoc(String freeLoc) {
        this.freeLoc = freeLoc;
    }

    public PackingBean getPacking() {
        return Packing;
    }

    public void setPacking(PackingBean Packing) {
        this.Packing = Packing;
    }

    public static class PackingBean {
        /**
         * workCode : 55873904
         * madeTime : 1569501298656
         * packingMaterial : 1
         * rankNum : 1
         * totalNum : 1
         * packLength : 500
         * packwidth : 500
         * packHeight : 500
         * netWeight : 5000
         * roughWeight : 5200
         * salesOrder : ssssss
         * comments : sss
         * installTime : 1569501298656
         * deliveryDate : 1569501298656
         * PackingItems : [{"soItem":"10","material":"RD-89VHJ4A5PF","rl":100,"agl":200,"qty":300}]
         */

        private String workCode;
        private String madeTime;
        private int packingMaterial;
        private String rankNum;
        private String totalNum;
        private String packLength;
        private String packwidth;
        private String packHeight;
        private String netWeight;
        private String roughWeight;
        private String salesOrder;
        private String comments;
        private String installTime;
        private String deliveryDate;
        private List<PackingItemsBean> packingItems;

        public String getWorkCode() {
            return workCode;
        }

        public void setWorkCode(String workCode) {
            this.workCode = workCode;
        }

        public String getMadeTime() {
            return madeTime;
        }

        public void setMadeTime(String madeTime) {
            this.madeTime = madeTime;
        }

        public int getPackingMaterial() {
            return packingMaterial;
        }

        public void setPackingMaterial(int packingMaterial) {
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

        public List<PackingItemsBean> getPackingItems() {
            return packingItems;
        }

        public void setPackingItems(List<PackingItemsBean> packingItems) {
            this.packingItems = packingItems;
        }

        public static class PackingItemsBean {
            /**
             * soItem : 10
             * material : RD-89VHJ4A5PF
             * rl : 100
             * agl : 200
             * qty : 300
             */

            private String soItem;
            private String material;
            private String rl;
            private String agl;
            private String qty;

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
        }
    }


}
