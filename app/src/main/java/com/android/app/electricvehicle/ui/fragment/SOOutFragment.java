package com.android.app.electricvehicle.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpFragment;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;


public class SOOutFragment extends BaseMvpFragment implements View.OnClickListener {




    @Override
    protected void initView(View view) {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setLayoutById() {
        return R.layout.fragment_zhi_huan;
    }


    @Override
    public void onClick(View v) {

    }
}
