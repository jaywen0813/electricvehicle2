package com.android.app.electricvehicle.entity;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;

import java.io.Serializable;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class LoginResultVO implements Serializable {

//    {
//        "userName": "18518235206",
//            "token": "53f08ce8a1876186c6c305d781e4221e",
//            "userId": "28849",
//            "authorityCode": "4000593",
//            "positionName": "服务顾问3",
//            "userType": "1"
//    }


    private static final long serialVersionUID = -7925014676906585664L;

    /**
     * 用户名
     */
    private String loginName = "";
    String password="";

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

    /**
     * token
     */
    private String token = "";

    /**
     * 用户权限编码
     */
    private String authorityCode = "";

    /**
     * 用户ID
     */
    private String userId = "";

    /**
     * 用户类型 0：T用户；1：非T用户；2：非车用户
     */
    private String userType;

    /**
     * 职位名称
     */
    private String positionName = "";

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUserName() {
        if (Kits.Empty.check(loginName)) {
            loginName = PreferenceUtils.getInstance(MainApplication.getContext()).getString("USERNAME");
        }
        return loginName;
    }

    public void setUserName(String userName) {
        this.loginName = userName;
        PreferenceUtils.getInstance(MainApplication.getContext()).setString("USERNAME", userName);
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

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
