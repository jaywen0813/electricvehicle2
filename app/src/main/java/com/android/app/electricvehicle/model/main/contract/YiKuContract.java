package com.android.app.electricvehicle.model.main.contract;

import android.content.Context;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
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
public interface YiKuContract {

    interface View extends BaseViewInf {



        //通过装箱单号查询到详情以后返回的数据
        void  showDetail(ItemDetailOutVO detailOutVO);


        void loadingtext();

        void loadWanCheng();
    }

    interface Presenter {


        //通过装箱单号查询详情信息
        void getZXD(String zxd, Context context);


    }
}
