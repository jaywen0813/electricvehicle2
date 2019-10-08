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
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;

//我的入库单列表点进来的详情
public class MyINDetailActivity extends BaseMvpActivity implements View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private EditText etNumber;
    private LinearLayout llSaomiao;
    private EditText etJingzhong;
    private EditText etMaozhong;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_my_indetail;
    }

    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        etNumber = findViewById(R.id.et_number);
        llSaomiao = findViewById(R.id.ll_saomiao);
        etJingzhong = findViewById(R.id.et_jingzhong);
        etMaozhong = findViewById(R.id.et_maozhong);
        etKwNumber = findViewById(R.id.et_kw_number);
        llSaomiao2 = findViewById(R.id.ll_saomiao2);

        backLayout.setOnClickListener(this);

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                finish();
                break;
        }
    }
}
