package com.android.app.electricvehicle.model.main.presenter;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.entity.OutVO2;
import com.android.app.electricvehicle.model.main.contract.MianContract2;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

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
public class MainPresenter3 extends BasePresenter<MianContract3.View> implements MianContract3.Presenter {




    //退出按钮
    @Override
    public void getOutActivity() {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

//        paramsMap.put("currentPage", currentPage);
//        paramsMap.put("pageSize", "10");
        MainDataRepository.getInstance().Outservice2(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<OutVO2>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(OutVO2 vDate) {
                        if (vDate.getSuccess().equals("T")) {//如果是200，则代表退出成功了
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
//    @Override
//    public void getSousuo(String ss,String currentPage) {
//        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("param", ss);
//        paramsMap.put("currentPage", currentPage);
//        paramsMap.put("pageSize", "10");
//
//        MainDataRepository.getInstance().sousuo(paramsMap)
//                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
//                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
//                .subscribe(new Observer<ActivityVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(ActivityVO vDate) {
//                        if (vDate.getCode().equals("00000")) {
////                            if (vDate.getResult().getActivict() != null) {
////                                mView.showActivityList();
////                            }
//                            if (vDate.getResult()!=null &&vDate.getResult().getResult()!=null){
//                                mView.showActivityList((List<ActivityVO.ResultBeanX.ResultBean>) vDate.getResult().getResult());
//                            }
//
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
//    }

}
