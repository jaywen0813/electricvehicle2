package com.android.app.electricvehicle.model.main.presenter;

import android.content.Context;
import android.util.Log;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.PanDianListVO;
import com.android.app.electricvehicle.entity.PanDianZxdVO;
import com.android.app.electricvehicle.entity.YiKuVO;
import com.android.app.electricvehicle.entity.ZXDListVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
import com.android.app.electricvehicle.model.main.contract.PanDianContract;
import com.android.app.electricvehicle.model.main.contract.YiKuContract;
import com.android.app.electricvehicle.model.main.http.MainService;
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
public class PanDianPresenter extends BasePresenter<PanDianContract.View> implements PanDianContract.Presenter {


    //通过库位号查询装箱单详情
    @Override
    public void getFreeLoc(String kuwei) {

        SortedMap<String, String> paramsMap = new TreeMap<>();

        paramsMap.put("freeLoc", kuwei);

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
        Observable<PanDianListVO> observable = services.getfreelocZXD(ParameterUtils.getHeaser(paramsMap),"packings/instore?freeLoc="+kuwei+"&instoreState=1");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PanDianListVO>() {

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
                    public void onNext(PanDianListVO panDianListVO) {

                        mView.showDetail(panDianListVO);
                    }
                });

    }

    //扫描装箱单进行盘点
    @Override
    public void getPandian(String zxd) {

        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

        paramsMap.put("packingCode", zxd);


        NetInstance.getEventsService().getpandian(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<PanDianZxdVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(PanDianZxdVO vDate) {
                        if (vDate.getSuccess().equals("T")) {
                            mView.pandianSuccess();
                        }else {
                            mView.pandianMiss();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        Log.e("why",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
