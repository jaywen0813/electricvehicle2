package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.MyInVO;
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
public interface MyInDetailContract {

    interface View extends BaseViewInf {

        //查询成功
//        void showSuccess(ItemDetailInVO vDate);

        //成功
        void showSuccess(ItemDetailInVO result );

        //失败
        void showwsj();
    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String id,String packingCode);



    }
}
