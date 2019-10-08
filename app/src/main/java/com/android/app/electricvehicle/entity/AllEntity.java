package com.android.app.electricvehicle.entity;

import java.io.Serializable;

public class AllEntity implements Serializable {


    /**
     * success : F
     * code : 10005
     * message : 错误的授权令牌
     * timestamp : 1570332482704
     * moreinfo : 10005
     */

    private String success;
    private int code;
    private String message;
    private long timestamp;
    private String moreinfo;

    public AllEntity(String success, int code, String message, long timestamp, String moreinfo) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.moreinfo = moreinfo;
    }
    public AllEntity(){

    }


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }
}
