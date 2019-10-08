package com.android.app.electricvehicle.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.android.app.electricvehicle.MainApplication;


/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/10
 * 描   述：静态页面     activity的基类。
 * 修订历史：
 * ================================================
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutById());
        //注解框架哪怕封装的再好也无法比findviewbyid更块，所有这里不适用注解框架去绑定视图
        initDate();
        initView();
        MainApplication.getInstance().addActivity(this);//强制更新时候点退出时候退出应用
    }

    /**
     * 初始化数据 （getIntent传递过来的数据等...）
     */
    protected void initDate() {
    }

    /**
     * 初始化控件
     */
    protected void initView() {
    }

    /**
     * 设置布局文件
     *
     * @return xml
     */
    protected abstract int getLayoutById();
}
