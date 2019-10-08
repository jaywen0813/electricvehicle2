package com.android.app.electricvehicle.model.sousuo.contract;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.SouSuo;
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
public interface SouSuoContract {

    interface View extends BaseViewInf {

        void showActivityList(List<ActivityVO.ResultBeanX.ResultBean> list);


    }

    interface Presenter {
        //网络请求
        void getSousuo(String ss, String currentPage);




    }
}
