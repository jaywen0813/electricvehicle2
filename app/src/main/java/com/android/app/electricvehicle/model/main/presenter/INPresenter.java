package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.INDetailVO;
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
    public void getUP(String instoreCode,String freeLoc,String remark) {
        SortedMap<String, String> paramsMap = new TreeMap<>();

//        paramsMap.put("instoreCode", instoreCode);//装箱单号  入库单号
//        paramsMap.put("storehouseId", storehouseId);//仓库id
//        paramsMap.put("storehouseName", storehouseName);//仓库名称
//        paramsMap.put("freeLoc", freeLoc);//库位编号
//        paramsMap.put("packingListId", packingListId);//装箱单ID
//        paramsMap.put("instoreState", "1");//状态（1，未出库，2已出库）
//        paramsMap.put("remark",remark);//备注，非必传


        paramsMap.put("instoreCode", "11118525");//装箱单号  入库单号
        paramsMap.put("storehouseId", "55838525");//仓库id
        paramsMap.put("storehouseName", "500");//仓库名称
        paramsMap.put("freeLoc", "AAA-02-002");//库位编号
        paramsMap.put("packingListId", "500");//装箱单ID
        paramsMap.put("instoreState", "1");//状态（1，未出库，2已出库）



        MainDataRepository.getInstance().INdetailService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<INDetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(INDetailVO vDate) {
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
