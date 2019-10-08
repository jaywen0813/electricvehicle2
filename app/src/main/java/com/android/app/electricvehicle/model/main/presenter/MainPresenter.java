package com.android.app.electricvehicle.model.main.presenter;

import android.content.Intent;


import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.model.main.contract.MianContract;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;

import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

import com.android.app.electricvehicle.ui.activity.LoginActivity;

import com.android.app.electricvehicle.utils.T;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


import java.util.SortedMap;
import java.util.TreeMap;

/**
 * ================================================
 * 作   者：邓浩
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class MainPresenter extends BasePresenter<MianContract.View> implements MianContract.Presenter {

    /**
     * 获取首页数据
     */
    @Override
    public void getActivityList() {
//        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());
//        MainDataRepository.getInstance().MainService(paramsMap)
//                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
//                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
//                .subscribe(new Observer<BaseEntity<ActivityVO>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(BaseEntity<ActivityVO> vDate) {
//                        if (vDate.getCode().equals("00000")) {
////                            if (vDate.getResult().getActivict() != null) {
////                                mView.showActivityList(vDate.getResult().getActivict());
////                            }
////                            if (vDate.getResult().getUserInfo() != null) {
////                                mView.showTX(vDate.getResult().getUserInfo().getPicUrl(), vDate.getResult().getUserInfo().getSex());
////                                mView.showName(vDate.getResult().getUserInfo().getName());
////                            } else {
////                                mView.showTX(null, null);
////                                mView.showName("无名");
////                            }
////
////
////                            if (vDate.getResult().getOrderCount() != null) {
////                                mView.showCSCount(vDate.getResult().getOrderCount().getOverTimeOrderCount());
////                                mView.showJYCount(vDate.getResult().getOrderCount().getRescuseOrderWaitHandleCount());
////                                mView.showTodo(vDate.getResult().getOrderCount().getWaitHandleCount());
////                                mView.showTodayBookCount(vDate.getResult().getOrderCount().getTodayAppointmentCount());
////                            } else {
////                                mView.showCSCount("0");
////                                mView.showJYCount("0");
////                                mView.showTodo("0");
////                                mView.showTodayBookCount("0");
////                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        //请求完成
//                    }
//                });
    }







    /**
     * 跳转至救援单页面
     */
    @Override
    public void jumpToJyd() {
        if (MainApplication.sIsLogin) {
            if (MainApplication.LOGINRESULTVO.getAuthorityCode().contains("RescueAuth")) {

            } else {
                T.showToastSafe("没有该权限");
            }

        } else {
            mView.getViewContext().startActivity(new Intent(mView.getViewContext(), LoginActivity.class));
        }

    }




}
