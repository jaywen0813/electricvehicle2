package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.contract.OUTContract;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.ParameterUtils;
import com.orhanobut.logger.Logger;

import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
public class OUTPresenter extends BasePresenter<OUTContract.View> implements OUTContract.Presenter {




    //提交数据
    @Override
    public void getUP(String outstoreCode,String freeLoc) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("packingCode", outstoreCode);
//        paramsMap.put("storehouseId", storehouseId);
//        paramsMap.put("storehouseName", storehouseName);
//        paramsMap.put("freeLoc", freeLoc);
//        paramsMap.put("packingListId", packingListId);
//        paramsMap.put("remark", remark);

        paramsMap.put("packingCode", "20191001001");
//        paramsMap.put("storehouseId", "55838525");
//        paramsMap.put("storehouseName", "500");
        paramsMap.put("freeLoc", "AAA-02-014");
//        paramsMap.put("packingListId", "20191001001");


//        MainDataRepository.getInstance().OutdetailService(paramsMap)
//                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
//                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
//                .subscribe(new Observer<OutDetailVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(OutDetailVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {//如果是200，则代表退出成功了
//                            mView.showSuccess();
//                        }else {//token失效等,需要手动退出
//                            mView.showSuccess();
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



        NetInstance.getEventsService().outdetail(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<OutDetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(OutDetailVO vDate) {
                            mView.showSuccess(vDate);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    //出库单号查询信息
    @Override
    public void getZXD(String zxd) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

//        paramsMap.put("currentPage", currentPage);
        paramsMap.put("outstoreCode", zxd);



//post
//        NetInstance.getEventsService().getoutdetail(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
//                subscribeOn(Schedulers.io()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(new Observer<ItemDetailOutVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(ItemDetailOutVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {//如果是200，则代表退出成功了
//                            mView.showDetail(vDate);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Logger.e(e.toString());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


        //GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl("https://api.zrcloud.me/interroll/")
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
        Observable<ItemDetailOutVO> observable = services.getoutPage(ParameterUtils.getHeaser(paramsMap),"packings/list/code/"+"1181913249818480640");
//        Observable<ItemDetailOutVO> observable = services.getoutPage(ParameterUtils.getHeaser(paramsMap),"packings/list/code/"+zxd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemDetailOutVO>() {

                    @Override
                    public void onError(Throwable e) {
                        Log.d("heihei", "onError: 失败");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ItemDetailOutVO vDate) {



                        Log.d("qqqqqq", "onNext: " + vDate);
                        if (vDate.getSuccess().equals("T")) {
                            mView.showDetail(vDate);
                        }else {
                            Log.e("false",vDate.getMessage()+"");
                        }
                    }
                });

    }

}
