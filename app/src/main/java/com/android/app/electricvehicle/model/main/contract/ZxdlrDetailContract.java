package com.android.app.electricvehicle.model.main.contract;


import com.android.app.electricvehicle.entity.PackingItem;

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
public interface ZxdlrDetailContract {

    interface View extends BaseViewInf {



        //获取详情成功
        void showSuccess(ZxdlrDetailVO result);

        //失败
        void showwsj();

        //修改成功
        void showToast(ZxdDetailUpdateVO zxdDetailUpdateVO);

        //装箱单作废以后返回的方法
        void showdelete(ZxdDetailDeleteVO zxdDetailDeleteVO);

    }

    interface Presenter {
        //网络请求。获取详情
        void getUP(String id);
        //修改
        void update(String id, String madeTime, String packingMaterial, String rankNum, String totalNum, String packLength, String packwidth,
                    String packHeight, String netWeight, String roughWeight, List<PackingItem> packingItem, String salesOrder, String comments, String installTime, String deliveryDate);


        //删除
        void deleteThis(String id);
    }
}
