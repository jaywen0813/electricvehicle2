package com.android.app.electricvehicle.model.main.contract;

import android.content.Context;


import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutDetailVO2;
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
public interface OUTContractSO2 {

    interface View extends BaseViewInf {

        //提交成功
        void showSuccess(OutDetailVO vDate);


        //通过SO查询到详情以后返回的数据
        void  showDetail(OutDetailVO2 detailOutVO);



        void loadingtext();

        void loadWanCheng();
    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String outstoreCode, String freeLoc);
        //通过SO查询详情信息
        void getSO(String salesOrder, String soItem);



    }
}
