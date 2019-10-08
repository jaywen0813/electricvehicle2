package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.mvp.view.BaseViewInf;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface OUTContract {

    interface View extends BaseViewInf {

        //提交成功
        void showSuccess();



    }

    interface Presenter {
        //网络请求。提交数据
        void getUP();
        //通过库位查询信息
        void getKuWei();

    }
}
