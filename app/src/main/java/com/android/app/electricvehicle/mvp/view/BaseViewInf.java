package com.android.app.electricvehicle.mvp.view;

import android.content.Context;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface BaseViewInf {

    /**
     * 显示加载错误
     *
     * @param err 错误内容
     */
    void showErr(String err);

    Context getViewContext();
}
