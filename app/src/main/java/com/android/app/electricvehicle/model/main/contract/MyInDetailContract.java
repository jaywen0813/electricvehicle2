package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.DeleteInDetailVO;
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



        //查询详情成功
        void showSuccess(ItemDetailInVO result );

        //失败
        void showwsj();

        //删除成功以后返回的方法
        void showdelete(DeleteInDetailVO result);


    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String id,String packingCode);

        //作废删除
        void deleteThis(String id,String packingCode);

    }
}
