package com.android.app.electricvehicle.model.setting;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：url 接口等。
 * 修订历史：
 * ================================================
 */
public class LoginAddressPresenter extends BasePresenter<LoginAddress.View> implements LoginAddress.Presenter{


    @Override
    public void loginchoose(String net) {

        MainApplication.setApiAddress("https://"+net);

        mView.OFFWindow();
    }
}
