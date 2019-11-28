package com.android.app.electricvehicle.model.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.activity.Login2Activity;
import com.android.app.electricvehicle.utils.PreferenceUtils;

import com.flyco.roundview.RoundTextView;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class LoginSettingActivity extends BaseMvpActivity<LoginAddress.View, LoginAddressPresenter> implements LoginAddress.View, View.OnClickListener {

    EditText et_address;
    RoundTextView tv_sure;

    LoginAddressPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected int getLayoutById() {
        return R.layout.activity_login_setting;
    }

    @Override
    protected void initView() {
        super.initView();
        et_address=findViewById(R.id.et_address);
        tv_sure=findViewById(R.id.tv_sure);

        tv_sure.setOnClickListener(this);

        et_address.setText(MainApplication.getApiAddress());//显示缓存的地址
    }

    @Override
    protected LoginAddressPresenter initPresenter() {
        presenter=new LoginAddressPresenter();
        return presenter;
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
        switch (v.getId()){
            case R.id.tv_sure:
                String et=et_address.getText().toString();


                if (et==null||et.equals("")){
                    Toast.makeText(this,"网址不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                presenter.loginchoose(et);
                MainApplication.setApiAddress(""+et);

                PreferenceUtils.getInstance(MainApplication.getContext()).setString("api", et);




                break;
        }
    }

    @Override
    public void OFFWindow() {

        //因为网络框架是Retrofit2,不重启ip地址切换不会生效，所以这里是重启APP并跳转到对应的页面
        Intent intent = new Intent(this, Login2Activity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra(KEY_RESTART_INTENT, nextIntent);
        this.startActivity(intent);
        if (this instanceof Activity) {
            ((Activity) this).finish();
        }

        Runtime.getRuntime().exit(0);
    }
}
