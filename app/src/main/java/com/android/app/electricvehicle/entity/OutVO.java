package com.android.app.electricvehicle.entity;

import java.io.Serializable;
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
public class OutVO implements Serializable{


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




    }
}
