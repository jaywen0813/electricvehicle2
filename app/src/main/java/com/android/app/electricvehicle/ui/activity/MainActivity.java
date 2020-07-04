package com.android.app.electricvehicle.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

//此页面已经作废
public class MainActivity extends BaseMvpActivity implements View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private LinearLayout llTuichu;
    private LinearLayout llChaxun;
    private LinearLayout llBack;
    private EditText etSousuo;
    private LinearLayout llSousuo;
    private LinearLayout llOut1;
    private LinearLayout llOn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


    @Override
    protected void initView() {
        super.initView();

        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        llTuichu = findViewById(R.id.ll_tuichu);
        llChaxun = findViewById(R.id.ll_chaxun);
        llBack = findViewById(R.id.ll_back);
        etSousuo = findViewById(R.id.et_sousuo);
        llSousuo = findViewById(R.id.ll_sousuo);
        llOut1 = findViewById(R.id.ll_out1);
        llOn1 = findViewById(R.id.ll_on1);


        llOut1.setOnClickListener(this);
        llOn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_out1:
                break;
            case R.id.ll_on1:
                break;
        }
    }
}
