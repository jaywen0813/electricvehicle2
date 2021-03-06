package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.DeleteOUTdetailVO;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.MyOutDetailVO;
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
public interface MyOutDetailContract {

    interface View extends BaseViewInf {

        //查询成功
        void showSuccess(MyOutDetailVO vDate);


        //失败
        void showwsj();

        //删除成功以后返回的方法
        void showdelete(DeleteOUTdetailVO result);


        void loadingtext();

        void loadWanCheng();

    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String id);


        //作废删除
        void deleteThis(String id);
    }
}
