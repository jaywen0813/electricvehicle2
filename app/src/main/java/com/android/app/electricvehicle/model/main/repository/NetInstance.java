package com.android.app.electricvehicle.model.main.repository;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.mvp.http.RetrofitFactory;

/**
 * ================================================
 * 作    者：booob
 * 版    本：1.0
 * 创建日期：2018-06-12-0012 13:36
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NetInstance {

    private static MainService sEventsService;

    public static MainService getEventsService() {
        if (sEventsService == null) {
            synchronized (NetInstance.class) {
                if (sEventsService == null) {
                    sEventsService = RetrofitFactory.getRetrofit(Api.BASE_URL).create(MainService.class);
                }
            }
        }
        return sEventsService;
    }
}
