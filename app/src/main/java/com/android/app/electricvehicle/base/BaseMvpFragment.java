package com.android.app.electricvehicle.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(setLayoutById(),container,false);
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


}
