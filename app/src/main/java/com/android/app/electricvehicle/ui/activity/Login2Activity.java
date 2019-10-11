package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;

import com.android.app.electricvehicle.entity.LoginResultVO2;
import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.model.login.contract.LoginContract2;
import com.android.app.electricvehicle.model.login.presenter.LoginPresenter2;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.RegisterClientIdUtils;
import com.android.app.electricvehicle.utils.T;

public class Login2Activity extends BaseMvpActivity<LoginContract2.View, LoginPresenter2> implements LoginContract2.View, View.OnClickListener {

    private EditText usernameEd;
    private ImageView showphone;
    private EditText passwordEd;
    private ImageView showpassword;
    ImageView showpassword1;
    private Button loginBt;



    @Override
    protected void initView() {

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.initView();

        usernameEd = findViewById(R.id.username_ed);//登录名
        showphone = findViewById(R.id.showphone);//清除登录名
        passwordEd = findViewById(R.id.password_ed);//密码
        showpassword = findViewById(R.id.showpassword);//密码是否显示
        loginBt = findViewById(R.id.login_bt);//登录按钮

        showpassword1=findViewById(R.id.showpassword1);

        showphone.setOnClickListener(this);
        showpassword.setOnClickListener(this);
        loginBt.setOnClickListener(this);
        showpassword1.setOnClickListener(this);


//        if (!(MainApplication.LOGINRESULTVO3.getData().getAccess_token()==null||MainApplication.LOGINRESULTVO3.getData().getAccess_token().equals(""))){
//            presenter.tokenLogin();
//        }

    }



    @Override
    public String getUserName() {
        //去掉两边的空格
        return usernameEd.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        //去掉两边的空格
        return passwordEd.getText().toString().trim();
    }

    //登录成功以后返回的方法
    @Override
    public void onLoginSessce(LoginResultVO3 resultVO3) {
//        MainApplication.LOGINRESULTVO3.getData().setAccess_token(resultVO3.getData().getAccess_token());
//        MainApplication.LOGINRESULTVO2.setUserName(resultVO2.getLdcSysUser().getLoginName());
//        PreferenceUtils.getInstance(this).setString("loginName", resultVO3.getLdcSysUser().getLoginName());
//        startActivity(new Intent(this, Main2Activity.class));
//        Log.e("qqqqq===",resultVO3.getData().getAccess_token());
        T.showToastSafe("登录成功");
        startActivity(new Intent(this, Main3Activity.class));
//        MainApplication.sIsLogin = true;
//        if (!Kits.Empty.check(MainApplication.getClientId())) {
//            RegisterClientIdUtils.bindingClient(MainApplication.getClientId());
//        }
        finish();
    }


    //加载中
    @Override
    public void showLoading() {

    }

    //加载结束
    @Override
    public void hideLoading() {

    }

    //错误
    @Override
    public void showErr(String err) {

    }

    //token登录成功以后
    @Override
    public void loginToken() {
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }


    //上下文
    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showphone:
                usernameEd.setText("");
                break;
            case R.id.showpassword:

                    passwordEd.setInputType(0x90);
                    showpassword1.setBackgroundResource(R.mipmap.showpw1);
                    showpassword1.setVisibility(View.VISIBLE);
                    showpassword.setVisibility(View.GONE);

                break;
            case R.id.showpassword1:

                passwordEd.setInputType(0x81);
                showpassword.setBackgroundResource(R.mipmap.showpw2);
                showpassword.setVisibility(View.VISIBLE);
                showpassword1.setVisibility(View.GONE);

                break;
            case R.id.login_bt:
                presenter.login();


//                startActivity(new Intent(this, Main3Activity.class));
                break;


        }
    }


    @Override
    protected int getLayoutById() {
        return R.layout.activity_login2;
    }

    @Override
    protected LoginPresenter2 initPresenter() {
        return new LoginPresenter2();
    }



    @Override
    public void onBackPressed() {
        if (MainApplication.sIsLogin) {
            finish();
        } else {
            DialogUtil.showBasicDialog(this, "退出提示", "确定退出app?", (dialog, confirm) -> {
                if (confirm) {
                    MainApplication.getInstance().removeAllActivities();
                }
                dialog.dismiss();
            });

        }
    }
}
