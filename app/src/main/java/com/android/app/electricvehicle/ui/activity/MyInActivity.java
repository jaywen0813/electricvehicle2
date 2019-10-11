package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.MyInVO;
import com.android.app.electricvehicle.model.main.contract.MYINContract;
import com.android.app.electricvehicle.model.main.presenter.MyINPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.adapter.MyINListAdapter;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyInActivity extends BaseListActivity<MYINContract.View, MyINPresenter> implements MYINContract.View,View.OnClickListener {


    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private RelativeLayout rllList;
    private SwipeRefreshLayout srlList;
    private RecyclerView rvList;

    private LinearLayout llKkry;//空空如也



    private List<MyInVO.DataBean.DataListBean> activityVOList=new ArrayList<>();
    MyINPresenter presenter;
    private String pageNum = "1";//分页



    @Override
    protected int getLayoutById() {
        return R.layout.activity_my_in;
    }


    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        rllList = findViewById(R.id.rll_list);
        srlList = findViewById(R.id.srl_list);
        rvList = findViewById(R.id.rv_list);

        llKkry = findViewById(R.id.ll_kkry);


        backLayout.setOnClickListener(this);

        tvLayerHead.setText("我的入库单");

        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


    }

    @Override
    protected void initDate() {
        super.initDate();
        //假数据
//        for (int i = 0; i <5 ; i++) {
//            MyInVO.DataBean.DataListBean ss=new MyInVO.DataBean.DataListBean();
//            ss.setId("11");
//            ss.setDataId("22");
//            activityVOList.add(ss);
//        }

    }

    @Override
    public void onResume() {
        super.onResume();
        onRefresh();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                finish();
                break;
        }
    }

    @Override
    protected BasePresenter getPresenter() {
        presenter=new MyINPresenter();
        return presenter;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new MyINListAdapter(activityVOList,this);
    }

    @Override
    protected void refresh() {
        loading();
        pageNum = page + "";
        presenter.getActivityList(page+"");
    }

    @Override
    protected void loadMore() {
        pageNum = page + "";
        presenter.getActivityList(page+"");
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=new Intent(this,MyINDetailActivity.class);
        intent.putExtra("id",activityVOList.get(position).getId());
        startActivity(intent);

    }

    @Override
    public void showSuccess(List<MyInVO.DataBean.DataListBean>   list) {
        srlList.setRefreshing(false);

        if (list == null || list.size() == 0) {

            llKkry.setVisibility(View.VISIBLE);
            rllList.setVisibility(View.GONE);

            if (isRefresh) {
                activityVOList.clear();
                adapter.notifyDataSetChanged();
            } else {
                adapter.loadMoreEnd();
            }
            return;
        }
        if (isRefresh) {

            llKkry.setVisibility(View.GONE);
            rllList.setVisibility(View.VISIBLE);

            //刷新
            activityVOList.clear();
            activityVOList.addAll(list);
            adapter.notifyDataSetChanged();
        } else {
            llKkry.setVisibility(View.GONE);
            rllList.setVisibility(View.VISIBLE);
            //加载更多
            activityVOList.addAll(list);
            adapter.loadMoreComplete();
        }
        adapter.disableLoadMoreIfNotFullPage();
        //刷新adapter
        adapter.notifyDataSetChanged();
        onloadSucceed();

    }

    @Override
    public void showErr(String err) {
        Log.e("error1",err);
    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
