package com.android.app.electricvehicle.entity;

import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：当前活动实体对象
 * 修订历史：
 * ================================================
 */
public class DetailVO {


    /**
     * code : 00000
     * message : 成功
     * result : {"pageSize":10,"currentPage":1,"currentPageSql":0,"totalPage":1,"totalCount":2,"result":[{"currentPage":0,"pageSize":0,"param":null,"id":"101121242012242052052bg14224","name":"test2","phone":null,"identify":"42000000000000000000","sex":"0","palteNum":null,"bodyNum":null,"modelNum":null,"gpsDeviceId":null,"siteNo":null,"step":null,"siteName":null,"partPic":"http://10.26.193.161null","overallPic":"http://10.26.193.161null"},{"currentPage":0,"pageSize":0,"param":null,"id":"298b00a4e4334acbb48ef0fd319427dc","name":"test1","phone":null,"identify":"4200000000000000000","sex":"1","palteNum":"123258鄂","bodyNum":null,"modelNum":"小型","gpsDeviceId":"","siteNo":"123","step":1,"siteName":null,"partPic":"http://10.26.193.161","overallPic":"http://10.26.193.161"}]}
     * total : null
     */

    private String code;
    private String message;
    private ResultBeanX result;
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

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class ResultBeanX {
        /**
         * pageSize : 10
         * currentPage : 1
         * currentPageSql : 0
         * totalPage : 1
         * totalCount : 2
         * result : [{"currentPage":0,"pageSize":0,"param":null,"id":"101121242012242052052bg14224","name":"test2","phone":null,"identify":"42000000000000000000","sex":"0","palteNum":null,"bodyNum":null,"modelNum":null,"gpsDeviceId":null,"siteNo":null,"step":null,"siteName":null,"partPic":"http://10.26.193.161null","overallPic":"http://10.26.193.161null"},{"currentPage":0,"pageSize":0,"param":null,"id":"298b00a4e4334acbb48ef0fd319427dc","name":"test1","phone":null,"identify":"4200000000000000000","sex":"1","palteNum":"123258鄂","bodyNum":null,"modelNum":"小型","gpsDeviceId":"","siteNo":"123","step":1,"siteName":null,"partPic":"http://10.26.193.161","overallPic":"http://10.26.193.161"}]
         */

        private String pageSize;
        private String currentPage;
        private String currentPageSql;
        private String totalPage;
        private String totalCount;
        private List<ResultBean> result;

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getCurrentPageSql() {
            return currentPageSql;
        }

        public void setCurrentPageSql(String currentPageSql) {
            this.currentPageSql = currentPageSql;
        }

        public String getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(String totalPage) {
            this.totalPage = totalPage;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * currentPage : 0
             * pageSize : 0
             * param : null
             * id : 101121242012242052052bg14224
             * name : test2
             * phone : null
             * identify : 42000000000000000000
             * sex : 0
             * palteNum : null
             * bodyNum : null
             * modelNum : null
             * gpsDeviceId : null
             * siteNo : null
             * step : null
             * siteName : null
             * partPic : http://10.26.193.161null
             * overallPic : http://10.26.193.161null
             */

            private String currentPage;
            private String pageSize;
            private String param;
            private String id;
            private String name;
            private String phone;
            private String identify;
            private String sex;
            private String palteNum;
            private String bodyNum;
            private String modelNum;
            private String gpsDeviceId;
            private String siteNo;
            private String step;
            private String siteName;
            private String partPic;
            private String overallPic;
            private String motorcycleId;//用来修改车辆图片的id


            public String getMotorcycleId() {
                return motorcycleId;
            }

            public void setMotorcycleId(String motorcycleId) {
                this.motorcycleId = motorcycleId;
            }

            public String getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(String currentPage) {
                this.currentPage = currentPage;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }

            public String getParam() {
                return param;
            }

            public void setParam(String param) {
                this.param = param;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getIdentify() {
                return identify;
            }

            public void setIdentify(String identify) {
                this.identify = identify;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getPalteNum() {
                return palteNum;
            }

            public void setPalteNum(String palteNum) {
                this.palteNum = palteNum;
            }

            public String getBodyNum() {
                return bodyNum;
            }

            public void setBodyNum(String bodyNum) {
                this.bodyNum = bodyNum;
            }

            public String getModelNum() {
                return modelNum;
            }

            public void setModelNum(String modelNum) {
                this.modelNum = modelNum;
            }

            public String getGpsDeviceId() {
                return gpsDeviceId;
            }

            public void setGpsDeviceId(String gpsDeviceId) {
                this.gpsDeviceId = gpsDeviceId;
            }

            public String getSiteNo() {
                return siteNo;
            }

            public void setSiteNo(String siteNo) {
                this.siteNo = siteNo;
            }

            public String getStep() {
                return step;
            }

            public void setStep(String step) {
                this.step = step;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public String getPartPic() {
                return partPic;
            }

            public void setPartPic(String partPic) {
                this.partPic = partPic;
            }

            public String getOverallPic() {
                return overallPic;
            }

            public void setOverallPic(String overallPic) {
                this.overallPic = overallPic;
            }
        }
    }
}
