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
public class LoginBean2 implements Serializable {

    private String code;
    private String message;
    private ResultBean result;
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class ResultBean {
        /**
         * ldcSysUser : {"id":"1","loginName":null,"password":null,"phone":null,"email":null,"description":null,"pwdUpdateTime":null,"createUser":null,"createTime":null,"updateUser":null,"updateTime":null,"token":null,"unicomNumber":null,"userMac":null,"userStatus":null}
         * token : 3a1b15a63440134500f30a09e93acdf1
         * roles : null
         * treeMenus : null
         */

        private LdcSysUserBean ldcSysUser;
        private String token;
        private String roles;
        private String treeMenus;

        public LdcSysUserBean getLdcSysUser() {
            return ldcSysUser;
        }

        public void setLdcSysUser(LdcSysUserBean ldcSysUser) {
            this.ldcSysUser = ldcSysUser;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public String getTreeMenus() {
            return treeMenus;
        }

        public void setTreeMenus(String treeMenus) {
            this.treeMenus = treeMenus;
        }

        public static class LdcSysUserBean {
            /**
             * id : 1
             * loginName : null
             * password : null
             * phone : null
             * email : null
             * description : null
             * pwdUpdateTime : null
             * createUser : null
             * createTime : null
             * updateUser : null
             * updateTime : null
             * token : null
             * unicomNumber : null
             * userMac : null
             * userStatus : null
             */

            private String id;
            private String loginName;
            private String password;
            private String phone;
            private String email;
            private String description;
            private String pwdUpdateTime;
            private String createUser;
            private String createTime;
            private String updateUser;
            private String updateTime;
            private String token;
            private String unicomNumber;
            private String userMac;
            private String userStatus;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPwdUpdateTime() {
                return pwdUpdateTime;
            }

            public void setPwdUpdateTime(String pwdUpdateTime) {
                this.pwdUpdateTime = pwdUpdateTime;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getUnicomNumber() {
                return unicomNumber;
            }

            public void setUnicomNumber(String unicomNumber) {
                this.unicomNumber = unicomNumber;
            }

            public String getUserMac() {
                return userMac;
            }

            public void setUserMac(String userMac) {
                this.userMac = userMac;
            }

            public String getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(String userStatus) {
                this.userStatus = userStatus;
            }
        }
    }
}
