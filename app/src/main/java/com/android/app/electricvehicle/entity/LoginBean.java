package com.android.app.electricvehicle.entity;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：booob
 * 版    本：1.0
 * 创建日期：2018-06-19-0019 13:51
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LoginBean implements Serializable {

    /**
     * code : 00000
     * message : 成功
     * result : {"userName":"D011316","token":"86c87e722beec52674fe71d773476df4","userId":"28008","authorityCode":"Manager","userType":"1"}
     * total : 1
     */


    private String code;
    private String message;
    private ResultBean result;
    private int total;


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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class ResultBean {
        /**
         * userName : D011316
         * token : 86c87e722beec52674fe71d773476df4
         * userId : 28008
         * authorityCode : Manager
         * userType : 1
         */

        private String userName;
        private String token;
        private String userId;
        private String authorityCode;
        private String userType;
        private String positionName;

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAuthorityCode() {
            return authorityCode;
        }

        public void setAuthorityCode(String authorityCode) {
            this.authorityCode = authorityCode;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}
