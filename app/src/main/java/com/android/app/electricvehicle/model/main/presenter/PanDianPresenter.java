package com.android.app.electricvehicle.model.main.presenter;

import android.content.Context;
import android.util.Log;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.YiKuVO;
import com.android.app.electricvehicle.model.main.contract.PanDianContract;
import com.android.app.electricvehicle.model.main.contract.YiKuContract;
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
public class PanDianPresenter extends BasePresenter<PanDianContract.View> implements PanDianContract.Presenter {


    @Override
    public void getFreeLoc(String kuwei) {

    }

    @Override
    public void getPandian(String id) {

    }
}
