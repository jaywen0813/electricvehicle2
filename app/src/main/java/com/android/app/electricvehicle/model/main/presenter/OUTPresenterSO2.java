package com.android.app.electricvehicle.model.main.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutDetailVO2;
import com.android.app.electricvehicle.model.main.contract.OUTContract2;
import com.android.app.electricvehicle.model.main.contract.OUTContractSO2;
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
public class OUTPresenterSO2 extends BasePresenter<OUTContractSO2.View> implements OUTContractSO2.Presenter {




    //提交数据  出库
    @Override
    public void getUP(String outstoreCode,String freeLoc) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("packingCode", outstoreCode);

        paramsMap.put("freeLoc", freeLoc);//这里出库的库位号都传的1到后台，因为详情拿不到库位号






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



    //SO查询详细信息
    @Override
    public void getSO(String salesOrder, String soItem) {
        SortedMap<String, String> paramsMap = new TreeMap<>();

        paramsMap.put("salesOrder", salesOrder);

        paramsMap.put("soItem", soItem);



        //GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl("https://api.zrcloud.me/interroll/")
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
//        Observable<ItemDetailOutVO> observable = services.getoutPage(ParameterUtils.getHeaser(paramsMap),"packings/list/code/"+"1181913249818480640");
        Observable<OutDetailVO2> observable = services.getoutPage3(ParameterUtils.getHeaser(paramsMap),"packings/instore?instoreState=0&salesOrder="+salesOrder+"&soItem="+soItem);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OutDetailVO2>() {

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
                    public void onNext(OutDetailVO2 vDate) {


                        Log.d("qqqqqq", "onNext: " + vDate);
//                        if (vDate.getSuccess().equals("T")) {
                            mView.showDetail(vDate);
//                        }else {
                            Log.e("false",vDate.getMessage()+"");
//                            Toast.makeText(context,"查询失败",Toast.LENGTH_LONG).show();
//                        }
                    }
                });

    }




}
