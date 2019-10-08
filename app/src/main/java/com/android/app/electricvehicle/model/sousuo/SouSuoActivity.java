package com.android.app.electricvehicle.model.sousuo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.ui.activity.TakePhotoActivity;
import com.android.app.electricvehicle.model.sousuo.adapter.SouSuoListAdapter;
import com.android.app.electricvehicle.model.sousuo.contract.SouSuoContract;
import com.android.app.electricvehicle.model.sousuo.presenter.SouSuoPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class SouSuoActivity extends BaseListActivity<SouSuoContract.View,SouSuoPresenter> implements SouSuoContract.View,View.OnClickListener {
//搜索页面

    private LinearLayout llBack;
    private EditText etSousuo;
    private LinearLayout llSousuo;
//    private ListView lvSousuo;

    private List<ActivityVO.ResultBeanX.ResultBean> activityVOList=new ArrayList<>();


    SouSuoPresenter presenter2;
    private String pageNum = "1";//分页



    String ss="";//搜索的文字

    @Override
    protected void initView() {

        super.initView();
        llBack = findViewById(R.id.ll_back);
        etSousuo = findViewById(R.id.et_sousuo);
        llSousuo = findViewById(R.id.ll_sousuo);
//        lvSousuo = findViewById(R.id.lv_sousuo);

        //刷新的控件
        srlList=findViewById(R.id.srl_list);
        rvList=findViewById(R.id.rv_list);


        llBack.setOnClickListener(this);
        llSousuo.setOnClickListener(this);

        //设置状态栏
        StatusBarUtils.with(this)
                .setColor(getResources().getColor(R.color.color_989898))
//                .setDrawable(getResources().getDrawable(R.drawable.shape_sousuo_title))
                .init();




    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_sou_suo;
    }



    @Override
    protected BasePresenter getPresenter() {
        presenter2=new SouSuoPresenter();
        return presenter2;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new SouSuoListAdapter(activityVOList,this);
    }

    @Override
    protected void refresh() {
        loading();
        pageNum = page + "";
        presenter2.getSousuo(ss,page+"");
    }

    @Override
    protected void loadMore() {
        pageNum = page + "";
        presenter2.getSousuo(ss,page+"");
    }


    //返回的数据
    @Override
    public void showActivityList(List<ActivityVO.ResultBeanX.ResultBean> list) {

        srlList.setRefreshing(false);
        if (list == null || list.size() == 0) {
            if (isRefresh) {
                activityVOList.clear();
                adapter.notifyDataSetChanged();
            } else {
                adapter.loadMoreEnd();
            }
            return;
        }
        if (isRefresh) {
            //刷新
            activityVOList.clear();
            activityVOList.addAll(list);
            adapter.notifyDataSetChanged();
        } else {
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
        onLoadFail();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_sousuo:
                ss=etSousuo.getText().toString();

                if (Kits.Empty.check(ss)) {
                    T.showToastSafe("请输入搜索内容");
                    return;
                }
                    presenter2.getSousuo(ss,page+"");
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=new Intent(this,TakePhotoActivity.class);
        intent.putExtra("id",activityVOList.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
