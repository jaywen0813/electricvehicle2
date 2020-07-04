package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.entity.PackingItems;
import com.android.app.electricvehicle.entity.ZxdDetailAddVO;
import com.android.app.electricvehicle.entity.ZxdDetailDeleteVO;
import com.android.app.electricvehicle.entity.ZxdDetailUpdateVO;
import com.android.app.electricvehicle.model.main.contract.ZxdlrAddContract;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.ParameterUtils;
import com.orhanobut.logger.Logger;

import java.util.List;
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
public class ZxdlrAddlPresenter extends BasePresenter<ZxdlrAddContract.View> implements ZxdlrAddContract.Presenter {




    //提交到后台

    @Override    //添加
    public void add(String workCode, String madeTime, String packingMaterial, String rankNum, String totalNum, String packLength, String packwidth,
                    String packHeight, String netWeight, String roughWeight, List<PackingItems> packingItem, String salesOrder, String comments, String installTime, String deliveryDate){
        SortedMap<String, Object> paramsMap = new TreeMap<>();

        paramsMap.put("workCode",workCode);
        paramsMap.put("madeTime",madeTime);
        paramsMap.put("packingMaterial",packingMaterial);
        paramsMap.put("rankNum",rankNum);
        paramsMap.put("totalNum",totalNum);
        paramsMap.put("packLength",packLength);
        paramsMap.put("packwidth",packwidth);
        paramsMap.put("packHeight",packHeight);
        paramsMap.put("netWeight",netWeight);
        paramsMap.put("roughWeight",roughWeight);
        paramsMap.put("packingListItems",packingItem);
        paramsMap.put("salesOrder",salesOrder);
        paramsMap.put("comments",comments);
        paramsMap.put("installTime",installTime);
        paramsMap.put("deliveryDate",deliveryDate);


                //这里请求修改了头布为SortedMap<String, Object> 入参，添加的时候相同
                NetInstance.getEventsService().addzxdlr(ParameterUtils.getHead(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<ZxdDetailAddVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ZxdDetailAddVO vDate) {

                        if(vDate.getSuccess().equals("T")){

                        }
                            mView.showToast(vDate);

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




}
