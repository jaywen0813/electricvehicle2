package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;
import android.widget.Toast;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.INDetailVO;
import com.android.app.electricvehicle.entity.INDetail_RuKu;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.entity.ShowInDetailEntity;
import com.android.app.electricvehicle.model.main.contract.INContract;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.ParameterUtils;
import com.android.app.electricvehicle.utils.T;
import com.orhanobut.logger.Logger;

import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
public class INPresenter extends BasePresenter<INContract.View> implements INContract.Presenter {




    //提交到后台  有详情数据的时候，提交
    @Override
    public void getUP(String instoreCode,String freeLoc) {

        mView.loadingtext();

        SortedMap<String, String> paramsMap = new TreeMap<>();

        paramsMap.put("packingCode", instoreCode);//装箱单号  入库单号
//        paramsMap.put("storehouseId", storehouseId);//仓库id
//        paramsMap.put("storehouseName", storehouseName);//仓库名称
        paramsMap.put("freeLoc", freeLoc);//库位编号
//        paramsMap.put("packingListId", packingListId);//装箱单ID
//        paramsMap.put("instoreState", "1");//状态（1，未出库，2已出库）
//        paramsMap.put("remark",remark);//备注，非必传


//        paramsMap.put("packingCode", "122191324981180640");//装箱单号  入库单号
//        paramsMap.put("freeLoc", "AAA-02-088");//库位编号




//        MainDataRepository.getInstance().INdetailService(paramsMap)
//                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
//                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
//                .subscribe(new Observer<INDetailVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(INDetailVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {
//                            mView.showSuccess("T");
//                            Log.e("qqqq", "onNext: 成功" );
//                        }else {
//                            mView.showSuccess("F");
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


        NetInstance.getEventsService().indetail(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<INDetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(INDetailVO vDate) {
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess(vDate);
                            Log.e("qqqq", "onNext: 成功" );
                        }else {
//                            mView.showSuccess(vDate);

                            mView.toast(vDate.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadWanCheng();
                    }

                    @Override
                    public void onComplete() {
                        mView.loadWanCheng();
                    }
                });






    }



    //没有详情数据的时候的提交
    @Override
    public void getUP2(String instoreCode, String freeLoc, INDetail_RuKu.PackingBean inDetail_ruKu) {

        mView.loadingtext();

        SortedMap<String, Object> paramsMap = new TreeMap<>();

        paramsMap.put("packingCode", instoreCode);//装箱单号  入库单号
        paramsMap.put("freeLoc", freeLoc);//库位编号

        paramsMap.put("packingList", inDetail_ruKu);//装箱单号  入库单号
//        paramsMap.put("freeLoc", "AAA-02-088");//库位编号




//        MainDataRepository.getInstance().INdetailService(paramsMap)
//                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
//                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
//                .subscribe(new Observer<INDetailVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(INDetailVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {
//                            mView.showSuccess("T");
//                            Log.e("qqqq", "onNext: 成功" );
//                        }else {
//                            mView.showSuccess("F");
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


        NetInstance.getEventsService().indetail(ParameterUtils.getHead(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<INDetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(INDetailVO vDate) {
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess(vDate);
                            Log.e("qqqq", "onNext: 成功" );
                        }else {
                            mView.showSuccess(vDate);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadWanCheng();
                    }

                    @Override
                    public void onComplete() {
                        mView.loadWanCheng();
                    }
                });






    }


    //获取详情
    @Override
    public void getInDetail(String packingCode) {

        mView.loadingtext();

        SortedMap<String, String> paramsMap = new TreeMap<>();


        //GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl(Api.BASE_URL)
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
//        Observable<ItemDetailInVO> observable = services.getPage(ParameterUtils.getHeaser(paramsMap),"packings/instore/get/"+"ba8fc8a8ea9311e992930242ac110012");
        Observable<ShowInDetailEntity> observable = services.getINDetail(ParameterUtils.getHeaser(paramsMap),"packings/list/by/code?packingCode="+packingCode);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowInDetailEntity>() {

                    @Override
                    public void onError(Throwable e) {
                        Log.d("heihei", "onError: 失败");
                        e.printStackTrace();
                        mView.loadWanCheng();
                    }

                    @Override
                    public void onComplete() {
                        mView.loadWanCheng();
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowInDetailEntity vDate) {



                        Log.d("heihie", "onNext: " + vDate.getSuccess());
//                        if (vDate.getSuccess().equals("T")) {
                            mView.showInDetail(vDate);
//                        }else {
//                            Log.e("false",vDate.getMessage()+"");
//                            mView.showInDetail(vDate);
//                        }
                    }
                });

    }







}
