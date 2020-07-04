package com.android.app.electricvehicle.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.model.main.adapter.MainListAdapter;
import com.android.app.electricvehicle.model.main.contract.MianContract2;
import com.android.app.electricvehicle.model.main.presenter.MainPresenter2;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

//此页面已经作废  2020年7月4日 21:14:39
public class Main2Activity extends BaseListActivity<MianContract2.View,MainPresenter2> implements MianContract2.View,View.OnClickListener {


    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private LinearLayout ll_tuichu;

    private RelativeLayout title_layout_rl;
    private LinearLayout ll_chaxun;
    LinearLayout ll_back;
    EditText et_sousuo;
    LinearLayout ll_sousuo;
    RelativeLayout rll_list;//有数据
    LinearLayout ll_kkry;//空空如也

    LinearLayout ll_popup_hide;//蒙板

//    private ListView lvMain;
//    private SwipeRefreshLayout srlList;
//    private RecyclerView rvList;

    private List<ActivityVO.ResultBeanX.ResultBean> activityVOList=new ArrayList<>();
    MainPresenter2 presenter2;
    private String pageNum = "1";//分页
    String ss="";//搜索的文字
    @Override
    protected int getLayoutById() {
        return R.layout.activity_main2;
    }




    @Override
    protected void initView() {
        super.initView();
        MainApplication.isMainActivityStart = true;

        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);//搜索
        farmInputSave = findViewById(R.id.farm_input_save);
//        lvMain = findViewById(R.id.lv_main);
        srlList=findViewById(R.id.srl_list);
        rvList=findViewById(R.id.rv_list);
        rll_list=findViewById(R.id.rll_list);//显示数据的
        ll_kkry=findViewById(R.id.ll_kkry);//空空如也

        ll_tuichu=findViewById(R.id.ll_tuichu);


        title_layout_rl=findViewById(R.id.title_layout_rl);//标题栏
        ll_chaxun=findViewById(R.id.ll_chaxun);//查询的状态栏
        ll_back=findViewById(R.id.ll_back);//搜索时的返回键
        et_sousuo=findViewById(R.id.et_sousuo);//搜索时输入的文字
        ll_sousuo=findViewById(R.id.ll_sousuo);//搜索按钮

        ll_popup_hide=findViewById(R.id.ll_popup_hide);//蒙板
//        垂直方向：
//        CommItemDecoration.createVertical(this, Color.BLUE,30);
//        水平方向：
//        CommItemDecoration.createHorizontal(this, Color.BLUE,30);

        navigationUserLayout.setOnClickListener(this);
        ll_tuichu.setOnClickListener(this);

        ll_back.setOnClickListener(this);
        ll_sousuo.setOnClickListener(this);


        //沉浸式标题栏
        //第一种方法
//        StatusBarUtils.with(this)
//                .setIsActionBar(true)
//                .clearActionBarShadow()
//                .setDrawable(getResources().getDrawable(R.drawable.shape_main_title))
//                .init();
//        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_main_title));

        //第二种方法
        StatusBarUtils.with(this)
//                .setColor(getResources().getColor(R.color.blue))
                .setDrawable(getResources().getDrawable(R.drawable.shape_main_title))
                .init();

        //第三种方法
//        StatusBarUtils.with(this)
//                .init();


    }

    @Override
    protected BasePresenter getPresenter() {
        presenter2=new MainPresenter2();
        return presenter2;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new MainListAdapter(activityVOList,this);
    }


    @Override
    public void onResume() {
        super.onResume();
        onRefresh();
    }


    @Override
    protected void refresh() {
        loading();
        pageNum = page + "";
        presenter2.getActivityList(page+"");
    }

    @Override
    protected void loadMore() {
        pageNum = page + "";
        presenter2.getActivityList(page+"");
    }

    //网络请求后返回的方法
    @Override
    public void showActivityList(List<ActivityVO.ResultBeanX.ResultBean> list) {
//        backgroundAlpha(1f, this);//隐藏蒙板
//        loadingComplete();

        if (list == null || list.size() == 0) {

            ll_kkry.setVisibility(View.VISIBLE);
            rll_list.setVisibility(View.GONE);

            if (isRefresh) {
                activityVOList.clear();
                adapter.notifyDataSetChanged();
            } else {
                adapter.loadMoreEnd();
            }
            return;
        }
        if (isRefresh) {

            ll_kkry.setVisibility(View.GONE);
            rll_list.setVisibility(View.VISIBLE);

            //刷新
            activityVOList.clear();
            activityVOList.addAll(list);
            adapter.notifyDataSetChanged();
        } else {
            ll_kkry.setVisibility(View.GONE);
            rll_list.setVisibility(View.VISIBLE);
            //加载更多
            activityVOList.addAll(list);
            adapter.loadMoreComplete();
        }
        adapter.disableLoadMoreIfNotFullPage();
        //刷新adapter
        adapter.notifyDataSetChanged();
        onloadSucceed();

    }



    public void wancheng(){
        ll_popup_hide.setVisibility(View.GONE);
        srlList.setRefreshing(false);
    }



    //点击退出以后回调的方法
    @Override
    public void getOutActivity() {

        T.showToastSafe("退出成功");
        PreferenceUtils.getInstance(MainApplication.getContext()).clear(MainApplication.getContext());
        MainApplication.LOGINRESULTVO2.setToken(null);
        MainApplication.LOGINRESULTVO2.setId(null);
        MainApplication.LOGINRESULTVO2.setUnicomNumber(null);
        MainApplication.sIsLogin = false;
        startActivity(new Intent(this, Login2Activity.class));
//        finish();

    }

    @Override
    public void showErr(String err) {

        onLoadFail();
}

    //上下文
    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigation_user_layout://默认标题栏下的搜索
//                Intent intent=new Intent(this, SouSuoActivity.class);
//                startActivity(intent);


                title_layout_rl.setVisibility(View.GONE);//隐藏默认的标题栏
                ll_chaxun.setVisibility(View.VISIBLE);//显示搜索的标题栏
//                backgroundAlpha(0.3f, this);//显示蒙板
                ll_popup_hide.setVisibility(View.VISIBLE);

                //获取焦点，并弹出键盘
                et_sousuo.setFocusable(true);
                et_sousuo.setFocusableInTouchMode(true);
                et_sousuo.requestFocus();
                //打开软键盘
                InputMethodManager imm = (InputMethodManager)Main2Activity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);    //InputMethodManager.SHOW_FORCED

                break;

            case R.id.ll_tuichu:


                DialogUtil.showBasicDialog(this, "退出提示", "确定退出当前账号?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter2.getOutActivity();
                    }
                    dialog.dismiss();
                });
                break;
            case R.id.ll_back://取消搜索状态

                et_sousuo.setFocusable(false);
                et_sousuo.setFocusableInTouchMode(false);

                //隐藏软键盘
                InputMethodManager imm2 =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm2.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);

                title_layout_rl.setVisibility(View.VISIBLE);//恢复默认的标题栏
                ll_chaxun.setVisibility(View.GONE);//取消搜索栏
//                backgroundAlpha(1f, this);//隐藏蒙板

                ll_popup_hide.setVisibility(View.GONE);


                break;
            case R.id.ll_sousuo://搜索请求

                ss=et_sousuo.getText().toString();

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
        Intent intent=new Intent(this, TakePhotoActivity.class);
        intent.putExtra("id",activityVOList.get(position).getId());
        startActivity(intent);
    }



    //    @Override
//    protected void initDate() {
//        super.initDate();
//
////        for (int i = 0; i <5 ; i++) {
////            ActivityVO.ResultBean activityVO=new ActivityVO.ResultBean();
////            activityVO.setPhone("10000"+i);
////            activityVO.setPhone("10000"+i);
////            activityVO.setBodyNum("雅迪"+i);
////            activityVO.setName("张三"+i);
////            activityVO.setModelNum(i+"");
////            activityVO.setId("20086"+i);
////
////            activityVOList.add(activityVO);
////        }
//
//
//    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        DialogUtil.showBasicDialog(this, "退出提示", "确定退出?", (dialog, confirm) -> {

            if (confirm) {
                //退出登录
//                        loading("正在退出...");
                finish();
            }
            dialog.dismiss();
        });
    }

    //蒙板
    public void backgroundAlpha(float bgAlpha, Activity context) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        context.getWindow().setAttributes(lp);
    }
}
