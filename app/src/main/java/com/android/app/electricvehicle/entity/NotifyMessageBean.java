package com.android.app.electricvehicle.entity;

/**
 * ================================================
 * 作    者：booob
 * 版    本：1.0
 * 创建日期：2018-05-31-0031 11:11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NotifyMessageBean {


    /**
     * content : 本消息 用于推送到app端，如有人收到请及时联系ntsp相关开发人员
     * data : {}
     * title : ntsp推送消息测试
     */

    private String content;
    private String data;
    private String title;
    private int notifyId;

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
