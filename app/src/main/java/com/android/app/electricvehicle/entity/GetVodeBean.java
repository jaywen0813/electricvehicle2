package com.android.app.electricvehicle.entity;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：booob
 * 版    本：1.0
 * 创建日期：2018-06-15-0015 13:25
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GetVodeBean implements Serializable {

    /**
     * code : 00000
     * message : 成功,验证码：636173
     * result : 636173
     * total : null
     */

    private String code;
    private String message;
    private String result;
    private Object total;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }
}
