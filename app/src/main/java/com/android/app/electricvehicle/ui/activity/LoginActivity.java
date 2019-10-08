package com.android.app.electricvehicle.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.LoginResultVO;
import com.android.app.electricvehicle.model.login.contract.LoginContract;
import com.android.app.electricvehicle.model.login.presenter.LoginPresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.RegisterClientIdUtils;

public class LoginActivity extends BaseMvpActivity<LoginContract.View, LoginPresenter> implements LoginContract.View, View.OnClickListener {

    private EditText etUserName, etPassword;
    private Button btnLogin;
    private TextView showpassword;
    //是否显示密码，默认为不显示
    private boolean isShowPsw = true;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etUserName = findViewById(R.id.username_ed);
        etPassword = findViewById(R.id.password_ed);
        //18627721862  18607130533   18062668055
//        etUserName.setText("18627721862");
//        etPassword.setText("123456");
        btnLogin = findViewById(R.id.login_bt);
        btnLogin.setOnClickListener(this);
        showpassword = findViewById(R.id.showpassword);
        showpassword.setOnClickListener(this);
    }


    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    /**
     * 当登陆成功。
     *
     * @param loginResultVO 用户实体对象
     */
    @Override
    public void onLoginSessce(LoginResultVO loginResultVO) {
        MainApplication.LOGINRESULTVO.setToken(loginResultVO.getToken());
        MainApplication.LOGINRESULTVO.setUserName(loginResultVO.getUserName());
//        PreferenceUtils.getInstance(this).setString("USERNAME", loginResultVO.getUserName());
        startActivity(new Intent(this, MainActivity.class));
        MainApplication.sIsLogin = true;
        if (!Kits.Empty.check(MainApplication.getClientId())) {
            RegisterClientIdUtils.bindingClient(MainApplication.getClientId());
        }
        finish();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt:
                presenter.login();
                break;
            case R.id.showpassword:
                if (isShowPsw) {
                    isShowPsw = false;
                    etPassword.setInputType(0x90);
                    showpassword.setBackgroundResource(R.mipmap.showpw1);
                } else {
                    isShowPsw = true;
                    etPassword.setInputType(0x81);
                    showpassword.setBackgroundResource(R.mipmap.showpw2);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (MainApplication.sIsLogin) {
            finish();
        } else {


        }
    }
}
