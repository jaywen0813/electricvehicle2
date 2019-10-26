package com.android.app.electricvehicle.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.model.main.contract.MianContract3;
import com.android.app.electricvehicle.model.main.presenter.MainPresenter3;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.ImageFilter;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;
import com.jph.takephoto.permission.PermissionManager;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends BaseMvpActivity<MianContract3.View, MainPresenter3> implements MianContract3.View,View.OnClickListener {

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
    private LinearLayout llWuliu1;
    private LinearLayout llWuliu2;
    private ImageView img_menu;
    private LinearLayout ll_myruku;
    private LinearLayout ll_mychuku;
    private ImageView img_bg;//侧滑出来部分头部背景
    private ImageView img_main_bg;//首页的背景

    private LinearLayout ll_zxdlr;//装箱单录入
    private LinearLayout ll_look_update_zxd;//装箱单的查询和修改


    // 抽屉菜单对象
    private ActionBarDrawerToggle drawerbar;
    DrawerLayout drawerLayout;
    LinearLayout main_left_drawer_layout;

    MainPresenter3 presenter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_main3;
    }

    @Override
    protected MainPresenter3 initPresenter() {
        presenter3=new MainPresenter3();
        return presenter3;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout://侧边栏
                openLeftLayout(img_menu);
                break;
            case R.id.ll_wuliu1://入库操作
                Intent intent=new Intent(this,INDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_wuliu2://出库操作
                Intent intent1=new Intent(this,OUTDetailActivity2.class);
                startActivity(intent1);
                break;
            case R.id.ll_zxdlr://装箱单录入
                Intent intent4=new Intent(this,ZxdLuRuActivity.class);
                startActivity(intent4);
                break;
            case R.id.ll_tuichu://退出帐号
                DialogUtil.showBasicDialog(this, "退出提示", "确定退出当前账号?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter3.getOutActivity();
                    }
                    dialog.dismiss();
                });
                break;
            case R.id.ll_myruku://我的入库
               Intent intent2=new Intent(this,MyInActivity.class);
               startActivity(intent2);
                break;
            case R.id.ll_mychuku://我的出库
                Intent intent3=new Intent(this,MyOutActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll_look_update_zxd://装箱单的查询和修改
                Intent intent5=new Intent(this,ZxdLookAndUpdateActivity.class);
                startActivity(intent5);
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        img_menu=findViewById(R.id.img_menu);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        llTuichu = findViewById(R.id.ll_tuichu);
        llChaxun = findViewById(R.id.ll_chaxun);
        llBack = findViewById(R.id.ll_back);
        etSousuo = findViewById(R.id.et_sousuo);
        llSousuo = findViewById(R.id.ll_sousuo);

        img_main_bg=findViewById(R.id.img_main_bg);//首页的背景

        img_bg=findViewById(R.id.img_bg);//侧滑出来的头部背景
        llWuliu1 = findViewById(R.id.ll_wuliu1);//入库
        llWuliu2 = findViewById(R.id.ll_wuliu2);//出库
        ll_zxdlr=findViewById(R.id.ll_zxdlr);//装箱单录入


        ll_myruku=findViewById(R.id.ll_myruku);//我的入库列表
        ll_mychuku=findViewById(R.id.ll_mychuku);//我的出库列表
        ll_look_update_zxd=findViewById(R.id.ll_look_update_zxd);//装箱单的查询和修改

        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        //设置菜单内容之外其他区域的背景色
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        //左边菜单
        main_left_drawer_layout = findViewById(R.id.main_left_drawer_layout);
        //左边菜单
        initEvent();


        backLayout.setOnClickListener(this);//侧边栏

        llWuliu1.setOnClickListener(this);
        llWuliu2.setOnClickListener(this);
        ll_zxdlr.setOnClickListener(this);

        ll_myruku.setOnClickListener(this);
        ll_mychuku.setOnClickListener(this);
        ll_look_update_zxd.setOnClickListener(this);

        llTuichu.setOnClickListener(this);//退出帐号的按钮

        //头部背景设置模糊
        Resources res = Main3Activity.this.getResources();
        //拿到初始图
        Bitmap bmp= BitmapFactory.decodeResource(res,R.mipmap.img_user_bg);
        //处理得到模糊效果的图
        Bitmap blurBitmap = ImageFilter.blurBitmap(this, bmp, 20f);
        img_bg.setImageBitmap(blurBitmap);


//        Bitmap bmp2= BitmapFactory.decodeResource(res,R.mipmap.img_main_bg);
//        //处理得到模糊效果的图
//        Bitmap blurBitmap2 = ImageFilter.blurBitmap(this, bmp, 0.1f);
//        img_main_bg.setImageBitmap(blurBitmap2);

        //第二种方法
        StatusBarUtils.with(this)
//                .setColor(getResources().getColor(R.color.blue))
                .setDrawable(getResources().getDrawable(R.drawable.shape_main_title))
                .init();


    }




    @Override
    public void getOutActivity() {
        T.showToastSafe("退出成功");
        PreferenceUtils.getInstance(MainApplication.getContext()).clear(MainApplication.getContext());
//        MainApplication.LOGINRESULTVO2.setToken(null);
//        MainApplication.LOGINRESULTVO2.setId(null);
//        MainApplication.LOGINRESULTVO2.setUnicomNumber(null);
        MainApplication.LOGINRESULTVO3.setAccess_token(null);
        startActivity(new Intent(this, Login2Activity.class));
        finish();
    }


    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }


    //设置开关监听
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, drawerLayout, R.mipmap.ic_launcher, R.string.open, R.string.close) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                llWuliu1.setEnabled(false);//打开的时候，屏蔽首页的按钮点击，否则会造成点击穿透
                llWuliu2.setEnabled(false);
                ll_zxdlr.setEnabled(false);
            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                llWuliu1.setEnabled(true);//关闭以后给点击事件
                llWuliu2.setEnabled(true);
                ll_zxdlr.setEnabled(true);
            }
        };

        drawerLayout.setDrawerListener(drawerbar);
    }

    //左边菜单开关事件
    public void openLeftLayout(View view) {
        if (drawerLayout.isDrawerOpen(main_left_drawer_layout)) {
            drawerLayout.closeDrawer(main_left_drawer_layout);
        } else {
            drawerLayout.openDrawer(main_left_drawer_layout);
        }
    }
}
