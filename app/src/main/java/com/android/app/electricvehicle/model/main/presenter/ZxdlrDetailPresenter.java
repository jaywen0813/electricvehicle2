package com.android.app.electricvehicle.model.main.presenter;

import android.util.Log;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.PackingItem;
import com.android.app.electricvehicle.entity.ZxdDetailDeleteVO;
import com.android.app.electricvehicle.entity.ZxdDetailUpdateVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.contract.ZxdlrDetailContract;
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
public class ZxdlrDetailPresenter extends BasePresenter<ZxdlrDetailContract.View> implements ZxdlrDetailContract.Presenter {




    //提交到后台   查询详情
    @Override
    public void getUP(String id) {
        SortedMap<String, String> paramsMap = new TreeMap<>();

        paramsMap.put("id",id);


        paramsMap.put("pageNo","1");
        paramsMap.put("pageSize","10");
//        paramsMap.put("packingCode","1181913249818480640");
//        paramsMap.put("packingCode",packingCode);


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
                .baseUrl(Api.BASE_URL)
                .build();
        MainService services = retrofit.create(MainService.class);
        //params1:所有参数进行拼接就可以
//        Observable<ItemDetailInVO> observable = services.getPage(ParameterUtils.getHeaser(paramsMap),"packings/instore/get/"+"ba8fc8a8ea9311e992930242ac110012");
        Observable<ZxdlrDetailVO> observable = services.zxdDetail(ParameterUtils.getHeaser(paramsMap),"packings/list/get/"+id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZxdlrDetailVO>() {

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
                    public void onNext(ZxdlrDetailVO vDate) {


                        Log.d("heihie", "onNext: " + vDate.getSuccess());
                        if (vDate.getSuccess().equals("T")) {
                            mView.showSuccess(vDate);
                        }else {
                            Log.e("false",vDate.getMessage()+"");
                            mView.showwsj();
                        }
                    }
                });



    }

    @Override    //修改详情
    public void update(String id, String madeTime, String packingMaterial, String rankNum, String totalNum, String packLength, String packwidth,
                       String packHeight, String netWeight, String roughWeight, List<PackingItem> packingItem, String salesOrder, String comments, String installTime, String deliveryDate){
        SortedMap<String, Object> paramsMap = new TreeMap<>();

        paramsMap.put("id",id);
        paramsMap.put("madeTime",madeTime);
        paramsMap.put("packingMaterial",packingMaterial);
        paramsMap.put("rankNum",rankNum);
        paramsMap.put("totalNum",totalNum);
        paramsMap.put("packLength",packLength);
        paramsMap.put("packwidth",packwidth);
        paramsMap.put("packHeight",packHeight);
        paramsMap.put("netWeight",netWeight);
        paramsMap.put("roughWeight",roughWeight);
        paramsMap.put("packingListItem",packingItem);
        paramsMap.put("salesOrder",salesOrder);
        paramsMap.put("comments",comments);
        paramsMap.put("installTime",installTime);
        paramsMap.put("deliveryDate",deliveryDate);


                //这里请求修改了头布为SortedMap<String, Object> 入参，添加的时候相同
                NetInstance.getEventsService().updateDetail(ParameterUtils.getHead(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<ZxdDetailUpdateVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ZxdDetailUpdateVO vDate) {

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

    //删除
    @Override
    public void deleteThis(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //baseUrl:参数之前的部分
                .baseUrl(Api.BASE_URL).build();
        MainService services = retrofit.create(MainService.class);


        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("id",id);
        //parames1:url传空字符串就可以，但是不能不写
        Observable<ZxdDetailDeleteVO> postPage = services.postdeletePage(ParameterUtils.getHeaser(paramsMap),ParameterUtils.getJsonBody(paramsMap),"packings/list/disable/"+id+"/1");
        postPage.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZxdDetailDeleteVO>() {


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
                    public void onNext(ZxdDetailDeleteVO pageBean) {
                        Log.d("heihie", "onNext: " + pageBean.getMessage());
                        mView.showdelete(pageBean);

                        if (pageBean.getSuccess().equals("T")){//操作成功以后，刷新数据
                            getUP(id);//再查询一次
                        }
                    }
                });

    }


}
