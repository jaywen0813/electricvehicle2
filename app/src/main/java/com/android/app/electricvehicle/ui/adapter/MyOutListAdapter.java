package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.MyOutVO;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyOutListAdapter extends BaseQuickAdapter<MyOutVO.DataBean.DataListBean, BaseViewHolder> {

    private List<MyOutVO.DataBean.DataListBean> data;
    private Activity activity;

    public MyOutListAdapter(@Nullable List<MyOutVO.DataBean.DataListBean> data, Activity activity) {
        super(R.layout.item_my_out_list, data);
        this.data = data;
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, MyOutVO.DataBean.DataListBean bean) {




        //出库单号
        if (!(bean.getOutstoreCode()==null||bean.getOutstoreCode().equals(""))){
            helper.setText(R.id.tv_ckdh, bean.getOutstoreCode());
        }else {
            helper.setText(R.id.tv_ckdh, "");
        }

        //仓库ID：
        if (!(bean.getStorehouseId()==null || bean.getStorehouseId().equals(""))){
            helper.setText(R.id.tv_ckid, "仓库ID："+bean.getStorehouseId());
        }else {
            helper.setText(R.id.tv_ckid, "仓库ID：");
        }

        //仓库名称
        if (!(bean.getStorehouseName()==null || bean.getStorehouseName().equals(""))){
            helper.setText(R.id.tv_ckmc, "仓库名称："+bean.getStorehouseName());
        }else {
            helper.setText(R.id.tv_ckmc,""+"仓库名称：" );
        }


        //库位号：
        if (!(bean.getFreeLoc()==null || bean.getFreeLoc().equals(""))){
            helper.setText(R.id.tv_kwh,"库位号："+bean.getFreeLoc());

        }else {
            helper.setText(R.id.tv_kwh,"库位号："+"");
        }

        //装箱单ID
        if (!(bean.getPackingListId()==null || bean.getPackingListId().equals(""))){
            helper.setText(R.id.tv_zxdid,"装箱单ID："+bean.getPackingListId());
        }else {
            helper.setText(R.id.tv_zxdid,"装箱单ID："+"");
        }





    }
}
