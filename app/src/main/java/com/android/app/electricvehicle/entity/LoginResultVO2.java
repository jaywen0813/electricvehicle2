package com.android.app.electricvehicle.entity;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;

import java.io.Serializable;
import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class LoginResultVO2 implements Serializable {


  
        /**
         * ldcSysUser : {"id":"1","loginName":null,"password":null,"phone":null,"email":null,"description":null,"pwdUpdateTime":null,"createUser":null,"createTime":null,"updateUser":null,"updateTime":null,"token":null,"unicomNumber":null,"userMac":null,"userStatus":null}
         * token : 3a1b15a63440134500f30a09e93acdf1
         * roles : [{"id":"1","name":"测试","roleDesc":"测试","organization":"测试","flag":null,"createBy":null,"createDate":"2018-11-20 11:11:41","updateBy":null,"updateDate":"2018-11-20 10:10:21"}]
         * treeMenus : null
         */

        private LdcSysUserBean ldcSysUser;
        private String token;
        private String treeMenus;
        private List<RolesBean> roles;
        private String id;
        private String unicomNumber;

    public String getId() {
        if (Kits.Empty.check(id)) {
            id = PreferenceUtils.getInstance(MainApplication.getContext()).getString("userId");
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
        PreferenceUtils.getInstance(MainApplication.getContext()).setString("userId", id);
    }

    public String getUnicomNumber() {
        if (Kits.Empty.check(unicomNumber)) {
            unicomNumber = PreferenceUtils.getInstance(MainApplication.getContext()).getString("siteNo");
        }
        return unicomNumber;
    }

    public void setUnicomNumber(String unicomNumber) {
        this.unicomNumber = unicomNumber;
        PreferenceUtils.getInstance(MainApplication.getContext()).setString("siteNo", unicomNumber);
    }

    public LdcSysUserBean getLdcSysUser() {
            return ldcSysUser;
        }

        public void setLdcSysUser(LdcSysUserBean ldcSysUser) {
            this.ldcSysUser = ldcSysUser;
        }

        public String getToken() {
            if (Kits.Empty.check(token)) {
                token = PreferenceUtils.getInstance(MainApplication.getContext()).getString("TOKEN");
            }

            return token;
        }

        public void setToken(String token) {
            this.token = token;

            PreferenceUtils.getInstance(MainApplication.getContext()).setString("TOKEN", token);
        }

        public String getTreeMenus() {
            return treeMenus;
        }

        public void setTreeMenus(String treeMenus) {
            this.treeMenus = treeMenus;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
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

            private String id;//userId
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
            private String unicomNumber;//siteNo
            private String userMac;
            private String userStatus;

            public String getId() {

                if (Kits.Empty.check(id)) {
                    id = PreferenceUtils.getInstance(MainApplication.getContext()).getString("userId");
                }

                return id;
            }

            public void setId(String id) {
                this.id = id;
                PreferenceUtils.getInstance(MainApplication.getContext()).setString("userId", id);
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
                if (Kits.Empty.check(unicomNumber)) {
                    unicomNumber = PreferenceUtils.getInstance(MainApplication.getContext()).getString("siteNo");
                }

                return unicomNumber;
            }

            public void setUnicomNumber(String unicomNumber) {
                this.unicomNumber = unicomNumber;
                PreferenceUtils.getInstance(MainApplication.getContext()).setString("siteNo", unicomNumber);
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

        public static class RolesBean {
            /**
             * id : 1
             * name : 测试
             * roleDesc : 测试
             * organization : 测试
             * flag : null
             * createBy : null
             * createDate : 2018-11-20 11:11:41
             * updateBy : null
             * updateDate : 2018-11-20 10:10:21
             */

            private String id;
            private String name;
            private String roleDesc;
            private String organization;
            private String flag;
            private String createBy;
            private String createDate;
            private String updateBy;
            private String updateDate;

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

            public String getRoleDesc() {
                return roleDesc;
            }

            public void setRoleDesc(String roleDesc) {
                this.roleDesc = roleDesc;
            }

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }
        }
    
}
