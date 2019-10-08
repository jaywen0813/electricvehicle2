package com.android.app.electricvehicle.model.login.contract;

import com.android.app.electricvehicle.entity.LoginResultVO;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

/**
 * ================================================
 * 作   者：邓浩
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface LoginContract {

    interface View extends BaseViewInf {

        String getUserName();

        String getPassword();

        void onLoginSessce(LoginResultVO loginResultVO);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {

        void login();

    }

}
