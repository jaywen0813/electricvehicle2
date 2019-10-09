package com.android.app.electricvehicle.model.main.presenter;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.contract.OUTContract;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    public void getUP(String outstoreCode,String freeLoc,String remark) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("outstoreCode", outstoreCode);
//        paramsMap.put("storehouseId", storehouseId);
//        paramsMap.put("storehouseName", storehouseName);
//        paramsMap.put("freeLoc", freeLoc);
//        paramsMap.put("packingListId", packingListId);
//        paramsMap.put("remark", remark);

        paramsMap.put("outstoreCode", "20191001001");
        paramsMap.put("storehouseId", "55838525");
        paramsMap.put("storehouseName", "500");
        paramsMap.put("freeLoc", "AAA-02-002");
        paramsMap.put("packingListId", "20191001001");


        MainDataRepository.getInstance().OutdetailService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<OutDetailVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(OutDetailVO vDate) {
                        if (vDate.getSuccess().equals("T")) {//如果是200，则代表退出成功了
                            mView.showSuccess();
                        }else {//token失效等,需要手动退出
                            mView.showSuccess();
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



    //出库单号查询信息
    @Override
    public void getZXD(String zxd) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

//        paramsMap.put("currentPage", currentPage);
        paramsMap.put("outstoreCode", zxd);



        MainDataRepository.getInstance().OutDetailService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<ItemDetailOutVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(ItemDetailOutVO vDate) {
                        if (vDate.getSuccess().equals("T")) {//如果是200，则代表退出成功了
                            mView.showDetail(vDate);
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

}
