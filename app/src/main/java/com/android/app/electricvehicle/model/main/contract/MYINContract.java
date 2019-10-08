package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2019年9月30日 13:08:20
 * 描   述：
 * 修订历史：我的扫码入库订单
 * ================================================
 */
public interface MYINContract {

    interface View extends BaseViewInf {

        //提交成功
        void showSuccess(List<ActivityVO.ResultBeanX.ResultBean>  result);



    }

    interface Presenter {
        //网络请求。提交数据
        void getActivityList(String currentPage);

    }
}
