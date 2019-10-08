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
public class LoginResultVO3 implements Serializable {


    /**
     * ticket : 0c4beb5584073496bcbbe4a5efbad654
     * success : T
     * code : null
     * message : null
     * method : null
     * uri : null
     * timestamp : 1570425220788
     * data : {"access_token":"pIFDcDC0muOTACNBw3KbRruiSKOHCc6WLNkOy5tTnc3bx7yeyS4KDRGUbnwquaiQ","refresh_token":"72Si4nY9NhYMIl2tGEiB7Knlyjnfz6FaxyYJs70K6jB0IOQylMgTuw4vgkuBSPsK","refresh_expires_in":604800,"expires_in":86400}
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
         * access_token : pIFDcDC0muOTACNBw3KbRruiSKOHCc6WLNkOy5tTnc3bx7yeyS4KDRGUbnwquaiQ
         * refresh_token : 72Si4nY9NhYMIl2tGEiB7Knlyjnfz6FaxyYJs70K6jB0IOQylMgTuw4vgkuBSPsK
         * refresh_expires_in : 604800
         * expires_in : 86400
         */

        private String access_token;
        private String refresh_token;
        private int refresh_expires_in;
        private int expires_in;



        public String getAccess_token() {


            if (Kits.Empty.check(access_token)) {
                access_token = PreferenceUtils.getInstance(MainApplication.getContext()).getString("TOKEN");
            }

            return access_token;

        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
            PreferenceUtils.getInstance(MainApplication.getContext()).setString("TOKEN", access_token);
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public int getRefresh_expires_in() {
            return refresh_expires_in;
        }

        public void setRefresh_expires_in(int refresh_expires_in) {
            this.refresh_expires_in = refresh_expires_in;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }
    }
}
