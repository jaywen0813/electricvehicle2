package com.android.app.electricvehicle.model.login.presenter;

import android.util.Log;
import android.widget.Toast;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.LoginResultVO;
import com.android.app.electricvehicle.entity.LoginResultVO2;
import com.android.app.electricvehicle.model.login.contract.LoginContract;
import com.android.app.electricvehicle.model.main.repository.MainDataRepository;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.MD5;

import com.android.app.electricvehicle.utils.T;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * ================================================
 * 作   者：邓浩
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {


    @Override
    public void login() {
        String userName = mView.getUserName();
        String passWord = mView.getPassword();
        SortedMap<String, String> paramsMap = new TreeMap<>();
        paramsMap.put("userName", userName);
        paramsMap.put("userPwd", MD5.GetMD5Code(passWord));
        MainApplication.LOGINRESULTVO.setUserName(userName);
        if (userName.isEmpty()) {
            T.showToastSafe("用户名不能为空");
//            Toast.makeText(mView.getViewContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passWord.isEmpty()) {
            T.showToastSafe("密码不能为空");
//            Toast.makeText(mView.getViewContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        MainApplication.LOGINRESULTVO.setToken("");
//        PreferenceUtils.getInstance(mView.getContext()).setString("USERNAME", "");
//        PreferenceUtils.getInstance(mView.getContext()).setString("TOKEN", "");
//        MainApplication.LOGINRESULTVO.setToken("");
//        MainApplication.LOGINRESULTVO.setUserName(userName);
//        MainApplication.sIsLogin = false;

        MainDataRepository.getInstance().LoginService(paramsMap)
                .subscribeOn(Schedulers.io())//网络是耗时操作,所以在io线程中去执行
                .observeOn(AndroidSchedulers.mainThread())//请求成功后回到主线程中
                .subscribe(new Observer<BaseEntity<LoginResultVO2>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseEntity<LoginResultVO2> stringBaseEntity) {

                        if (stringBaseEntity.getCode().equals("00000")) {
//                            mView.onLoginSessce(stringBaseEntity.getResult());
//                            MainApplication.LOGINRESULTVO.setAuthorityCode(stringBaseEntity.getResult().getAuthorityCode());
//                            MainApplication.LOGINRESULTVO.setUserId(stringBaseEntity.getResult().getUserId());
////                            MainApplication.sIsLogin = false;
//                            MainApplication.LOGINRESULTVO.setToken(stringBaseEntity.getResult().getToken());
//                            MainApplication.LOGINRESULTVO.setPositionName(stringBaseEntity.getResult().getPositionName());
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
