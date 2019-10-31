package com.android.app.electricvehicle.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.DialogUtil;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/13
 * 描   述：
 * 修订历史：
 * ================================================
 */
public abstract class BaseMvpFragment<V, T extends BasePresenter<V>> extends Fragment {

    public T presenter;
    //通用加载dialog
    public Dialog mLoadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutById(), container, false);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    protected abstract T initPresenter();

    protected abstract int setLayoutById();

    /**
     * 显示通用的加载中dialog
     *
     * @param text 显示的文本
     */
    public void loading(String text) {
        if (mLoadingDialog == null) {
            mLoadingDialog = DialogUtil.loading(getActivity(), text);
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

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }


    }
}
