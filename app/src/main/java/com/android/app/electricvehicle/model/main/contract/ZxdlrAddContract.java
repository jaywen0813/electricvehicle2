package com.android.app.electricvehicle.model.main.contract;


import com.android.app.electricvehicle.entity.PackingItems;

import com.android.app.electricvehicle.entity.ZxdDetailAddVO;
import com.android.app.electricvehicle.entity.ZxdDetailDeleteVO;
import com.android.app.electricvehicle.entity.ZxdDetailUpdateVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
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
public interface ZxdlrAddContract {

    interface View extends BaseViewInf {


        //添加成功
        void showToast(ZxdDetailAddVO zxdDetailUpdateVO);



    }

    interface Presenter {

        //添加
        void add(String id, String madeTime, String packingMaterial, String rankNum, String totalNum, String packLength, String packwidth,
                 String packHeight, String netWeight, String roughWeight, List<PackingItems> packingItem, String salesOrder, String comments, String installTime, String deliveryDate);


    }
}
