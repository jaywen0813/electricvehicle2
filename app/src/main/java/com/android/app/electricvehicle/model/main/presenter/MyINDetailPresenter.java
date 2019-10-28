package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.entity.DeleteInDetailVO;
import com.android.app.electricvehicle.entity.INDetailVO;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.MyInVO;
import com.android.app.electricvehicle.model.main.contract.INContract;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
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
public class MyINDetailPresenter extends BasePresenter<MyInDetailContract.View> implements MyInDetailContract.Presenter {




    //提交到后台
    @Override
    public void getUP(String id,String packingCode) {
        SortedMap<String, String> paramsMap = new TreeMap<>();

        paramsMap.put("id",id);


        paramsMap.put("pageNo","1");
        paramsMap.put("pageSize","10");
//        paramsMap.put("packingCode","1181913249818480640");
        paramsMap.put("packingCode",packingCode);





//正常的post请求
//        NetInstance.getEventsService().getMyIndetail(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
//                subscribeOn(Schedulers.io()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(new Observer<ItemDetailInVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(ItemDetailInVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {
//                            mView.showSuccess(vDate);
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
//        Observable<ItemDetailInVO> observable = services.getPage(ParameterUtils.getHeaser(paramsMap),"packings/instore/get/"+"ba8fc8a8ea9311e992930242ac110012");
        Observable<ItemDetailInVO> observable = services.getPage(ParameterUtils.getHeaser(paramsMap),"packings/instore/get/"+id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemDetailInVO>() {

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
                    public void onNext(ItemDetailInVO vDate) {



                        Log.d("heihie", "onNext: " + vDate.getSuccess());
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess(vDate);
                        }else {
                            Log.e("false",vDate.getMessage()+"");
                            mView.showwsj();
                        }
                    }
                });

//和列表调用同一个接口，多传一个packingCode 就是这个装箱单的详情
//        NetInstance.getEventsService().myin(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
//                subscribeOn(Schedulers.io()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(new Observer<MyInVO>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onNext(MyInVO vDate) {
//                        if (vDate.getSuccess().equals("T")) {
//                            if ((vDate.getData().getDataList() != null) && vDate.getData().getDataList().size()>0) {
//
//                                mView.showSuccess(vDate.getData().getDataList());
//
//
//                            }
//
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


    }

    //作废按钮  删除请求
    @Override
    public void deleteThis(String id,String packingCode) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl("https://api.zrcloud.me/interroll/").build();
        MainService services = retrofit.create(MainService.class);


        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("id",id);
        //parames1:url传空字符串就可以，但是不能不写
        Observable<DeleteInDetailVO> postPage = services.deleteInDetail(ParameterUtils.getHeaser(paramsMap),ParameterUtils.getJsonBody(paramsMap),"packings/instore/disable/"+id+"/1");
        postPage.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteInDetailVO>() {


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
                    public void onNext(DeleteInDetailVO pageBean) {
                        Log.d("heihie", "onNext: " + pageBean.getMessage());
                        mView.showdelete(pageBean);

                        if (pageBean.getSuccess().equals("T")){//操作成功以后，刷新数据
                            getUP(id,packingCode);//再查询一次
                        }
                    }
                });
    }


}
