package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.AllEntity;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.model.main.contract.INContract;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.T;

import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class INPresenter extends BasePresenter<INContract.View> implements INContract.Presenter {




    //提交到后台
    @Override
    public void getUP() {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

//        paramsMap.put("currentPage", currentPage);
//        paramsMap.put("pageSize", "10");

        paramsMap.put("instoreCode", "11118525");
        paramsMap.put("storehouseId", "55838525");
        paramsMap.put("storehouseName", "500");
        paramsMap.put("freeLoc", "AAA-02-002");
        paramsMap.put("packingListId", "500");
        paramsMap.put("instoreState", "1");


        MainDataRepository.getInstance().INdetailService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<AllEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(AllEntity vDate) {
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess("T");
                        }else {
                            mView.showSuccess("F");
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
