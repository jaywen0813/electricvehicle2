package com.android.app.electricvehicle.utils;


import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.CheckUpdateAppBean;
import com.android.app.electricvehicle.entity.GetVodeBean;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.http.AppConstants;
import com.orhanobut.logger.Logger;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * ================================================
 * 作    者：
 * 版    本：1.0
 * 创建日期：2018-06-04-0004 20:03
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class RegisterClientIdUtils {

    public static void bindingClient(String clientid) {

        SortedMap<String, String> paramsMap = new TreeMap<>();
        String userName = MainApplication.LOGINRESULTVO.getUserName();
        String cid = clientid;
        String brandCode = AppConstants.BRANDCODE;
        String osType = "00";//00安卓,01 ios
        String appVersionNo = Kits.Package.getVersionCode(MainApplication.getContext()) + "";
//        paramsMap.put("userName", userName);
        paramsMap.put("cid", cid);
//        paramsMap.put("brandCode", brandCode);
//        paramsMap.put("osType", osType);
//        paramsMap.put("appVersionNo", appVersionNo);
        NetInstance.getEventsService().registClientId(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<GetVodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(GetVodeBean getVodeBean) {
                        if (getVodeBean.getCode().equals("00000")) {
                            Logger.e("clientId注册成功");
                        }else {
                            Logger.e(getVodeBean.getMessage());
                        }

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
