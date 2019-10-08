package com.android.app.electricvehicle.model.detail.contract;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.DetailVO;
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
public interface TakePhotoContract {

    interface View extends BaseViewInf {

        //上传成功
        void showActivity();

        //请求详情的数据
        void detail(List<DetailVO.ResultBeanX.ResultBean> list);

    }

    interface Presenter {
        //网络请求。上传照片
        void getPhoto(String id, String motorcycleId, String gps, String img1, String img2);

        //获取详情
        void getDetail(String id);


    }
}
