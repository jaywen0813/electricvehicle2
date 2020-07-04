package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.PanDianListVO;
import com.android.app.electricvehicle.model.main.contract.PanDianContract;
import com.android.app.electricvehicle.model.main.presenter.PanDianPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.adapter.PanDianListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class PanDianActivity extends BaseListActivity<PanDianContract.View, PanDianPresenter> implements PanDianContract.View, View.OnClickListener {


    PanDianPresenter panDianPresenter;
    private List<PanDianListVO.DataBean.DataListBean> activityVOList=new ArrayList<>();
    private String pageNum = "1";//分页


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_pan_dian;
    }

    @Override
    protected BasePresenter getPresenter() {
        panDianPresenter=new PanDianPresenter();
        return panDianPresenter;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new PanDianListAdapter(activityVOList,this);
    }

    @Override
    protected void refresh() {

    }

    @Override
    protected void loadMore() {

    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void showDetail(PanDianListVO panDianListVO) {

    }

    @Override
    public void pandianSuccess() {

    }

    @Override
    public void pandianMiss() {

    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
