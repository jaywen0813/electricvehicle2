package com.android.app.electricvehicle.model.main.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.model.main.contract.OUTContract;
import com.android.app.electricvehicle.model.main.contract.OUTContract2;
import com.android.app.electricvehicle.model.main.http.MainService;
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
public class OUTPresenter2 extends BasePresenter<OUTContract2.View> implements OUTContract2.Presenter {




    //提交数据
    @Override
    public void getUP(String outstoreCode,String freeLoc) {

        mView.loadingtext();

        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("packingCode", outstoreCode);
//        paramsMap.put("storehouseId", storehouseId);
//        paramsMap.put("storehouseName", storehouseName);
        paramsMap.put("freeLoc", freeLoc);
//        paramsMap.put("packingListId", packingListId);
//        paramsMap.put("remark", remark);

//        paramsMap.put("packingCode", "20191001001");
//        paramsMap.put("storehouseId", "55838525");
//        paramsMap.put("storehouseName", "500");
//        paramsMap.put("freeLoc", "AAA-02-014");
//        paramsMap.put("packingListId", "20191001001");





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
                        mView.loadWanCheng();
                    }

                    @Override
                    public void onComplete() {
                        mView.loadWanCheng();
                    }
                });
    }



    //出库单号查询详细信息
    @Override
    public void getZXD(String zxd, Context context) {

        mView.loadingtext();

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
                .baseUrl(Api.BASE_URL)
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
//        Observable<ItemDetailOutVO> observable = services.getoutPage(ParameterUtils.getHeaser(paramsMap),"packings/list/by/code?packingCode="+"1181913249818480640");
        Observable<ItemDetailOutVO> observable = services.getoutPage(ParameterUtils.getHeaser(paramsMap),"packings/instore?instoreState=0&packingCode="+zxd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemDetailOutVO>() {

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
                    public void onNext(ItemDetailOutVO vDate) {


                        Log.d("qqqqqq", "onNext: " + vDate);
//                        if (vDate.getSuccess().equals("T")) {
                            mView.showDetail(vDate);
//                        }else {
//                            Log.e("false",vDate.getMessage()+"");
//                            Toast.makeText(context,"查询失败",Toast.LENGTH_LONG).show();
//
//                        }
                    }
                });

    }




}
