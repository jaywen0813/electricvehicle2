package com.android.app.electricvehicle.model.sousuo.presenter;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.Shangchuan;
import com.android.app.electricvehicle.entity.SouSuo;
import com.android.app.electricvehicle.model.detail.contract.TakePhotoContract;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.sousuo.contract.SouSuoContract;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
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
public class SouSuoPresenter extends BasePresenter<SouSuoContract.View> implements SouSuoContract.Presenter {

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
