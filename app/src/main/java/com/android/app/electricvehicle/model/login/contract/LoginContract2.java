package com.android.app.electricvehicle.model.login.contract;

import com.android.app.electricvehicle.entity.LoginResultVO;
import com.android.app.electricvehicle.entity.LoginResultVO2;
import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface LoginContract2 {

    interface View extends BaseViewInf {



        void onLoginSessce(LoginResultVO3 loginResultVO);



        void loginToken();
    }

    interface Presenter {

        void login(String userName,String passWord);



        /**
         * token登陆
         */
        void tokenLogin();




    }

}
