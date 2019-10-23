package com.android.app.electricvehicle.model.setting;

import com.android.app.electricvehicle.mvp.view.BaseViewInf;


public interface LoginAddress {



    interface View extends BaseViewInf {

        void OFFWindow();

    }
    interface Presenter {
        //网络请求。提交数据
        void loginchoose(String net);

    }



}
