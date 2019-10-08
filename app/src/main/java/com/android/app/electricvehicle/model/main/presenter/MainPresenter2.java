package com.android.app.electricvehicle.model.main.presenter;

import android.content.Intent;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.entity.SouSuo;

import com.android.app.electricvehicle.model.main.contract.MianContract2;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

import com.android.app.electricvehicle.utils.T;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class MainPresenter2 extends BasePresenter<MianContract2.View> implements MianContract2.Presenter {

    /**
     * 获取首页数据
     */
    @Override
    public void getActivityList(String currentPage) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

        paramsMap.put("currentPage", currentPage);
        paramsMap.put("pageSize", "10");
        MainDataRepository.getInstance().MainService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<ActivityVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ActivityVO vDate) {
                        if (vDate.getCode().equals("00000")) {
                            if (vDate.getResult() != null) {
                                mView.wancheng();//先隐藏加载的转圈
                                mView.showActivityList((List<ActivityVO.ResultBeanX.ResultBean>)  vDate.getResult().getResult());

                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.wancheng();
                    }

                    @Override
                    public void onComplete() {
                        //请求完成
                        mView.wancheng();
                    }
                });
    }



    //退出按钮
    @Override
    public void getOutActivity() {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

//        paramsMap.put("currentPage", currentPage);
//        paramsMap.put("pageSize", "10");
        MainDataRepository.getInstance().OutService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<OutVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(OutVO vDate) {
                        if (vDate.getCode().equals("200")) {//如果是200，则代表退出成功了
                            mView.getOutActivity();
                        }else {//token失效等,需要手动退出
                            mView.getOutActivity();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        //请求完成
                    }
                });
    }



    /**
     * 搜索
     */
    @Override
    public void getSousuo(String ss,String currentPage) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("param", ss);
        paramsMap.put("currentPage", currentPage);
        paramsMap.put("pageSize", "10");

        MainDataRepository.getInstance().sousuo(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<ActivityVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ActivityVO vDate) {
                        if (vDate.getCode().equals("00000")) {
//                            if (vDate.getResult().getActivict() != null) {
//                                mView.showActivityList();
//                            }
                            if (vDate.getResult()!=null &&vDate.getResult().getResult()!=null){
                                mView.showActivityList((List<ActivityVO.ResultBeanX.ResultBean>) vDate.getResult().getResult());
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        //请求完成
                    }
                });
    }

}
