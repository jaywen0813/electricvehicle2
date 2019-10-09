package com.android.app.electricvehicle.model.main.presenter;

import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.MyOutVO;
import com.android.app.electricvehicle.model.main.contract.MYINContract;
import com.android.app.electricvehicle.model.main.contract.MYOutContract;
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
public class MyOutPresenter extends BasePresenter<MYOutContract.View> implements MYOutContract.Presenter {

    /**
     * 获取我的出库列表数据
     */
    @Override
    public void getActivityList(String currentPage) {
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("authorityCode", MainApplication.LOGINRESULTVO.getAuthorityCode());

        paramsMap.put("pageNo", currentPage);
        paramsMap.put("pageSize", "10");
        MainDataRepository.getInstance().MyOutService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<MyOutVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(MyOutVO vDate) {
                        if (vDate.getSuccess().equals("T")) {
                            if ((vDate.getData().getDataList() != null)&& vDate.getData().getDataList().size()>0) {

                                mView.showSuccess(vDate.getData().getDataList());

                            }

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
