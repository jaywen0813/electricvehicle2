package com.android.app.electricvehicle.entity;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：booob
 * 版    本：1.0
 * 创建日期：2018-06-27-0027 17:03
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ContentBean implements Serializable {

    /**
     * contenType : 0
     * content : 您有一条新的预约消息
     * createDate : 2018/06/27 16:49:21
     * id : cdf43c30c4b1489aaa7547186711db53
     * link :
     * picId :
     * pushTime : 2018/06/27 16:49:21
     * title : 预约
     * type : 0
     */

    private String contenType;
    private String content;
    private String createDate;
    private String id;
    private String link;
    private String picId;
    private String pushTime;
    private String title;
    private String type;

    public String getContenType() {
        return contenType;
    }

    public void setContenType(String contenType) {
        this.contenType = contenType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
