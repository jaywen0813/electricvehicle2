package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.presenter.MyINDetailPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;

//我的入库单列表点进来的详情
public class MyINDetailActivity extends BaseMvpActivity<MyInDetailContract.View, MyINDetailPresenter> implements MyInDetailContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private TextView tvNumber;
    private TextView tvCkid;
    private TextView tvCkmc;
    private TextView tvKwNumber;
    private TextView tvZxdid;
    private TextView tvBz;

    MyINDetailPresenter presenter;

    String id = "";

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
        tvNumber = findViewById(R.id.tv_number);
        tvCkid = findViewById(R.id.tv_ckid);
        tvCkmc = findViewById(R.id.tv_ckmc);
        tvKwNumber = findViewById(R.id.tv_kw_number);
        tvZxdid = findViewById(R.id.tv_zxdid);
        tvBz = findViewById(R.id.tv_bz);

        backLayout.setOnClickListener(this);

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


        tvLayerHead.setText("入库详情");


        id = getIntent().getStringExtra("id");



    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.getUP(id);
    }

    @Override
    protected MyINDetailPresenter initPresenter() {
        presenter = new MyINDetailPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
        }
    }

    //获取到详情数据以后
    @Override
    public void showSuccess(ItemDetailInVO vDate) {
        if (!Kits.Empty.check(vDate.getData().getInstoreCode())) {
            tvNumber.setText(vDate.getData().getInstoreCode());
        }


        if (!Kits.Empty.check(vDate.getData().getStorehouseId())) {
            tvCkid.setText(vDate.getData().getStorehouseId());
        }

        if (!Kits.Empty.check(vDate.getData().getStorehouseName())) {
            tvCkmc.setText(vDate.getData().getStorehouseName());
        }

        if (!Kits.Empty.check(vDate.getData().getFreeLoc())) {
            tvKwNumber.setText(vDate.getData().getFreeLoc());
        }

        if (!Kits.Empty.check(vDate.getData().getPackingListId())) {
            tvZxdid.setText(vDate.getData().getPackingListId());
        }

        if (!Kits.Empty.check(vDate.getData().getRemark())) {
            tvBz.setText(vDate.getData().getRemark());
        }


    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
