package com.android.app.electricvehicle.model.login.presenter;

import android.util.Log;

import com.android.app.electricvehicle.MainApplication;

import com.android.app.electricvehicle.entity.AllEntity;
import com.android.app.electricvehicle.entity.LoginBean2;

import com.android.app.electricvehicle.entity.LoginResultVO2;

import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.model.login.contract.LoginContract2;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.MD5;
import com.android.app.electricvehicle.utils.ParameterUtils;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.T;
import com.orhanobut.logger.Logger;

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
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class LoginPresenter2 extends BasePresenter<LoginContract2.View> implements LoginContract2.Presenter {


    @Override
    public void login() {
        String userName = mView.getUserName();
        String passWord = mView.getPassword();
        SortedMap<String, String> paramsMap = new TreeMap<>();
//        paramsMap.put("username", userName);
//        paramsMap.put("password", MD5.GetMD5Code(passWord));


        paramsMap.put("client_id", "3000a5643db6eb1fbc7f839a24f0b526");
        paramsMap.put("client_secret","300364848938e580db770920c304aaf6");
        paramsMap.put("grant_type", "password");
        paramsMap.put("password", "123456");
        paramsMap.put("username", "interroll");

//        MainApplication.LOGINRESULTVO2.setUserName(userName);
//        if (userName.isEmpty()) {
//            T.showToastSafe("用户名不能为空");
//
//            return;
//        }
//        if (passWord.isEmpty()) {
//            T.showToastSafe("密码不能为空");
//
//            return;
//        }
//        MainApplication.LOGINRESULTVO2.setToken("5nAmzLfdxtSc0hIOO3d8bTtCmrnSPNC132Jk3ZLB7qFm7uS47lsGfZJw7cdNgLfd");
        MainApplication.LOGINRESULTVO3.getData().setAccess_token("");

//        MainApplication.LOGINRESULTVO2.setLdcSysUser(new LoginResultVO2.LdcSysUserBean());
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setId("");//userId
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setUnicomNumber("");//网点编码
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setLoginName(userName);


        MainDataRepository.getInstance().LoginService2(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<LoginResultVO3>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginResultVO3 stringBaseEntity) {

                        if (stringBaseEntity.getSuccess().equals("T")){
                            T.showToastSafe("登录成功");
                            mView.onLoginSessce(stringBaseEntity);
                            MainApplication.LOGINRESULTVO3.getData().setAccess_token(stringBaseEntity.getData().getAccess_token());
                        }else {
                            T.showToastSafe("登录失败");
                        }

//                        if (stringBaseEntity.getCode().equals("00000")) {
//                            mView.onLoginSessce(stringBaseEntity.getResult());
//                            MainApplication.LOGINRESULTVO2.setId(stringBaseEntity.getResult().getLdcSysUser().getId());//userID
//                            MainApplication.LOGINRESULTVO2.setUnicomNumber(stringBaseEntity.getResult().getLdcSysUser().getUnicomNumber());//网点编码
//                            MainApplication.LOGINRESULTVO2.setToken(stringBaseEntity.getResult().getToken());
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("qqqqq",e+"");
                    }

                    @Override
                    public void onComplete() {
                        //请求完成

                    }
                });
    }



    //token登录
    @Override
    public void tokenLogin() {
        SortedMap<String, String> sortedMap = new TreeMap<>();

//        MainApplication.LOGINRESULTVO2.setToken("");
//        PreferenceUtils.getInstance(mView.getContext()).setString("USERNAME", "");
//        PreferenceUtils.getInstance(mView.getContext()).setString("TOKEN", "");
//        MainApplication.LOGINRESULTVO2.setLdcSysUser(new LoginResultVO2.LdcSysUserBean());
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setId(stringBaseEntity.getResult().getLdcSysUser().getId());//userId
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setUnicomNumber("");//网点编码
      //  MainApplication.LOGINRESULTVO2.getLdcSysUser().setLoginName("");
//        MainApplication.LOGINRESULTVO2.setLdcSysUser(new LoginResultVO2.LdcSysUserBean());


        NetInstance.getEventsService().tokenLogin(ParameterUtils.getHeaser(sortedMap), ParameterUtils.getJsonBody(sortedMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginBean2>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginBean2 loginBean) {
                        if (loginBean.getCode().equals("00000")) {
                          //  MainApplication.LOGINRESULTVO2.setToken(loginBean.getResult().getToken());
                         //   MainApplication.LOGINRESULTVO2.getLdcSysUser().setUnicomNumber(loginBean.getResult().getLdcSysUser().getUnicomNumber());
//                            MainApplication.LOGINRESULTVO.setUserName(loginBean.getResult().getLdcSysUser().getLoginName());
                        //    MainApplication.LOGINRESULTVO2.getLdcSysUser().setId(loginBean.getResult().getLdcSysUser().getId());//userID
//                            MainApplication.LOGINRESULTVO.setPositionName(loginBean.getResult().getPositionName());
                            MainApplication.sIsLogin = true;
                            mView.loginToken();
                        } else {
//                            MainApplication.LOGINRESULTVO2.setToken(null);
//                            MainApplication.LOGINRESULTVO.setUserName(null);
//                            PreferenceUtils.getInstance(MainApplication.getContext()).clear(MainApplication.getContext());
//                            T.showToastSafe(loginBean.getMessage());
                            MainApplication.sIsLogin = false;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
//                        mView.loadingComplete();
//                        mView.loginFail();
                        MainApplication.sIsLogin = false;
                    }

                    @Override
                    public void onComplete() {
//                        mView.loadingComplete();
                        mView.loginToken();
                    }
                });
    }

}
