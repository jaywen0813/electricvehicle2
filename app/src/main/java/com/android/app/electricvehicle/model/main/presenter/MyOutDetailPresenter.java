package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.entity.DeleteOUTdetailVO;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.MyOutDetailVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.contract.MyOutDetailContract;
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
public class MyOutDetailPresenter extends BasePresenter<MyOutDetailContract.View> implements MyOutDetailContract.Presenter {




    //提交到后台
    @Override
    public void getUP(String id) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("id", id);
//        paramsMap.put("instoreCode", instoreCode);//装箱单号  入库单号
//        paramsMap.put("storehouseId", storehouseId);//仓库id
//        paramsMap.put("storehouseName", storehouseName);//仓库名称
//        paramsMap.put("freeLoc", freeLoc);//库位编号
//        paramsMap.put("packingListId", packingListId);//装箱单ID
//        paramsMap.put("instoreState", "1");//状态（1，未出库，2已出库）
//        paramsMap.put("remark",remark);//备注，非必传


//        paramsMap.put("instoreCode", "11118525");//装箱单号  入库单号
//        paramsMap.put("storehouseId", "55838525");//仓库id
//        paramsMap.put("storehouseName", "500");//仓库名称
//        paramsMap.put("freeLoc", "AAA-02-002");//库位编号
//        paramsMap.put("packingListId", "500");//装箱单ID
//        paramsMap.put("instoreState", "1");//状态（1，未出库，2已出库）







        //GET请求
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl("https://api.zrcloud.me/interroll/")
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
//        Observable<MyOutDetailVO> observable = services.getmyoutdetailpage(ParameterUtils.getHeaser(paramsMap),"packings/outstore/get/"+"6df0e3ccea9411e992930242ac110012");
        Observable<MyOutDetailVO> observable = services.getmyoutdetailpage(ParameterUtils.getHeaser(paramsMap),"packings/outstore/get/"+id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyOutDetailVO>() {

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
                    public void onNext(MyOutDetailVO vDate) {



                        Log.d("qqqqqq", "onNext: " + vDate);
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess(vDate);
                        }else {
                            Log.e("false",vDate.getMessage()+"");
                            mView.showwsj();//失败的方法
                        }
                    }
                });


    }




    //作废
    @Override
    public void deleteThis(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl("https://api.zrcloud.me/interroll/").build();
        MainService services = retrofit.create(MainService.class);


        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("id",id);
        //parames1:url传空字符串就可以，但是不能不写
        Observable<DeleteOUTdetailVO> postPage = services.deleteOutDetail(ParameterUtils.getHeaser(paramsMap),ParameterUtils.getJsonBody(paramsMap),"packings/outstore/disable/"+id+"/1");
        postPage.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteOUTdetailVO>() {


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
                    public void onNext(DeleteOUTdetailVO pageBean) {
                        Log.d("heihie", "onNext: " + pageBean.getMessage());
                        mView.showdelete(pageBean);

                        if (pageBean.getSuccess().equals("T")){//操作成功以后，刷新数据
                            getUP(id);//再查询一次
                        }
                    }
                });
    }








}
