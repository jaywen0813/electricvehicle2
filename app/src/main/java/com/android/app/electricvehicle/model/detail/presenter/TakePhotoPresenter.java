package com.android.app.electricvehicle.model.detail.presenter;

import android.util.Log;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.DetailVO;
import com.android.app.electricvehicle.entity.Shangchuan;
import com.android.app.electricvehicle.model.detail.contract.TakePhotoContract;
import com.android.app.electricvehicle.model.main.contract.MianContract2;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.ParameterUtils;
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
public class TakePhotoPresenter extends BasePresenter<TakePhotoContract.View> implements TakePhotoContract.Presenter {

    /**
     * 上传安装和车辆全景两张照片
     */
    @Override
    public void getPhoto(String id,String motorcycleId,String gps,String img1,String img2) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());
//        paramsMap.put("id", id);
        paramsMap.put("id", motorcycleId);//传入车辆id
        paramsMap.put("gpsDeviceId", gps);
        paramsMap.put("partPic", img1);
        paramsMap.put("overallPic", img2);

        MainDataRepository.getInstance().shangchuan(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<BaseEntity<Shangchuan>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseEntity<Shangchuan> BaseEntity) {
                        if (BaseEntity.getCode().equals("00000")){
                            mView.showActivity();
                        }else {
                            mView.showErr("错误的请求");
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("---------", "onError: " + e);
                        mView.showErr(""+e);
//                        mView.loadingComplete();

                    }

                    @Override
                    public void onComplete() {
                        //请求完成
//                        mView.loadingComplete();
                    }
                });

    }

    //获取详情数据
    @Override
    public void getDetail(String id) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());
        paramsMap.put("id", id);
        paramsMap.put("currentPage", "1");
        paramsMap.put("pageSize", "10");

        MainDataRepository.getInstance().detail(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<DetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(DetailVO baseEntity) {
                        if (baseEntity.getCode().equals("00000")){
                            mView.detail((List<DetailVO.ResultBeanX.ResultBean>) baseEntity.getResult().getResult());
                        }else {
                            mView.showErr("错误的请求");
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("---------", "onError: " + e);
                        mView.showErr(""+e);
//                        mView.loadingComplete();

                    }

                    @Override
                    public void onComplete() {
                        //请求完成
//                        mView.loadingComplete();
                    }
                });
    }


}
