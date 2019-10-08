package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface MianContract3 {

    interface View extends BaseViewInf {



        //点击退出以后的方法
        void getOutActivity();



    }

    interface Presenter {



        //退出
        void getOutActivity();


//        //网络请求  搜索
//        void getSousuo(String ss, String currentPage);
    }
}
