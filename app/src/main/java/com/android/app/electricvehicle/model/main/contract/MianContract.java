package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

import java.util.List;

/**
 * ================================================
 * 作   者：邓浩
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface MianContract {

    interface View extends BaseViewInf {

        void showActivityList(List<ActivityVO.ResultBeanX.ResultBean> activityVOList);

        void showName(String name);

        void showTX(String imgUrl, String sex);

        void showCSCount(String count);

        void showTodo(String todoCount);

        void showJYCount(String jyCount);

        void showTodayBookCount(String count);
    }

    interface Presenter {
        //网络请求。获取活动列表
        void getActivityList();



        //跳转至救援单页面
        void jumpToJyd();



    }
}
