package com.android.app.electricvehicle.model.login.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.app.electricvehicle.BuildConfig;
import com.android.app.electricvehicle.MainApplication;


import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.LoginBean2;

import com.android.app.electricvehicle.entity.LoginResultVO2;

import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.model.login.contract.LoginContract2;
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.model.main.repository.NetInstance;
import com.android.app.electricvehicle.mvp.http.AppConstants;
import com.android.app.electricvehicle.mvp.http.NetErrorCode;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.MD5;
import com.android.app.electricvehicle.utils.ParameterUtils;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.T;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    public void login(String userName,String passWord) {

        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("username", userName);
//        paramsMap.put("password", MD5.GetMD5Code(passWord));
        paramsMap.put("password", passWord);

        paramsMap.put("client_id", "3000a5643db6eb1fbc7f839a24f0b526");
        paramsMap.put("client_secret","300364848938e580db770920c304aaf6");
        paramsMap.put("grant_type", "password");

//        paramsMap.put("password", "123456");
//        paramsMap.put("username", "interroll");

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
        MainApplication.LOGINRESULTVO3.setAccess_token("");

//        MainApplication.LOGINRESULTVO2.setLdcSysUser(new LoginResultVO2.LdcSysUserBean());
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setId("");//userId
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setUnicomNumber("");//网点编码
//        MainApplication.LOGINRESULTVO2.getLdcSysUser().setLoginName(userName);


        NetInstance.getEventsService().Logintest(ParameterUtils.getHeaser(paramsMap), ParameterUtils.getJsonBody(paramsMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginResultVO3>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginResultVO3 loginBean) {
                        if (loginBean.getSuccess().equals("T")) {

//                            T.showToastSafe("登录成功");
                            mView.onLoginSessce(loginBean);
                            MainApplication.LOGINRESULTVO3.setAccess_token(loginBean.getData().getAccess_token());


                            Log.e("qqqqq11",loginBean.getData().getAccess_token());

                            Log.e("qqq","登录正确的地址"+MainApplication.getApiAddress());
                        } else {
//                            T.showToastSafe("登录失败");
                            mView.onLoginSessce(loginBean);

                            Log.e("qqq","是否为T"+loginBean.getSuccess());
                            Log.e("qqq","登录错误的全部地址"+ Api.BASE_URL);
                            Log.e("qqq","登录错误的地址"+MainApplication.getApiAddress());
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
