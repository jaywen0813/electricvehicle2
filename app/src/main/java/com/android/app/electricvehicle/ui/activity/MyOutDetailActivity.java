package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.contract.MyOutDetailContract;
import com.android.app.electricvehicle.model.main.presenter.MyINDetailPresenter;
import com.android.app.electricvehicle.model.main.presenter.MyOutDetailPresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;

//我的入库单列表点进来的详情
public class MyOutDetailActivity extends BaseMvpActivity<MyOutDetailContract.View, MyOutDetailPresenter> implements MyOutDetailContract.View, View.OnClickListener {

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

    MyOutDetailPresenter presenter;

    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_my_outdetail;
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

        id = getIntent().getStringExtra("id");

    }

    @Override
    protected MyOutDetailPresenter initPresenter() {
        presenter = new MyOutDetailPresenter();
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
    public void showSuccess(ItemDetailOutVO vDate) {
        if (!Kits.Empty.check(vDate.getData().getOutstoreCode())) {
            tvNumber.setText(vDate.getData().getOutstoreCode());
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
