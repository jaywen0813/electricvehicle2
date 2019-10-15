package com.android.app.electricvehicle.model.main.contract;


import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
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
public interface ZxdlrDetailContract {

    interface View extends BaseViewInf {

        //查询成功
//        void showSuccess(ItemDetailInVO vDate);

        //成功
        void showSuccess(ZxdlrDetailVO result);

        //失败
        void showwsj();
    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String id);



    }
}
