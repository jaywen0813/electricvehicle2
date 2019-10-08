package com.android.app.electricvehicle.mvp.model;

import com.google.gson.annotations.SerializedName;

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
public class BaseEntity<T> implements Serializable {

    @SerializedName("code")
    public String code;

    @SerializedName("message")
    public String message;

    @SerializedName("success")
    private String success;

    @SerializedName("result")
    public T result;

    @SerializedName("total")
    public String total;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("moreinfo")
    private String moreinfo;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
