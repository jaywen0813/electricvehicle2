package com.android.app.electricvehicle.base;


import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;
import com.android.app.electricvehicle.utils.ActivityManager;
import com.android.app.electricvehicle.utils.DialogUtil;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/10
 * 描   述：MVP     View的实现类
 * 修订历史：
 * ================================================
 */
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    public T presenter;
    //通用加载dialog
    public Dialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (canSetFullScreen()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        //设置不能横竖屏切换
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MainApplication.getInstance().addActivity(this);//强制更新时候点退出时候退出应用
        setContentView(getLayoutById());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        initDate();
        initView();

    }

    /**
     * 绑定视图
     *
     * @return 布局文件
     */
    protected abstract int getLayoutById();

    /**
     * 获取presenter实例
     *
     * @return presenter
     */
    protected abstract T initPresenter();


    /**
     * 初始化数据
     */
    protected void initDate() {
    }

    /**
     * 初始化控件
     */
    protected void initView() {
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
        super.onDestroy();
    }

    /**
     * 主题用了fullscreen 不能代码设置竖屏
     *
     * @return
     */
    protected boolean canSetFullScreen() {
        return true;
    }


    /**
     * 显示通用的加载中dialog
     *
     * @param text 显示的文本
     */
    public void loading(String text) {
        if (mLoadingDialog == null) {
            mLoadingDialog = DialogUtil.loading(this, text);
        } else {
            mLoadingDialog.show();
        }
    }

    /**
     * 加载完成
     */
    public void loadingComplete() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }


}
