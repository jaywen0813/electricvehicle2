package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.MyOutVO;
import com.android.app.electricvehicle.utils.Kits;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
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

        //装箱单号
        if (!(bean.getPackingCode()==null || bean.getPackingCode().equals(""))){
            helper.setText(R.id.tv_ckid, "装箱单号："+bean.getPackingCode());
        }else {
            helper.setText(R.id.tv_ckid, "装箱单号：");
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

        //备注
        if (!(bean.getRemark()==null || bean.getRemark().equals(""))){
            helper.setText(R.id.tv_zxdid,"备注："+bean.getRemark());
        }else {
            helper.setText(R.id.tv_zxdid,"备注："+"");
        }

        //出库时间
        if (!Kits.Empty.check(bean.getPacking())){

            if (!Kits.Empty.check(bean.getPacking().getMadeTime())){

                long itime= Long.parseLong(bean.getPacking().getMadeTime());

                SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                String timeText=format.format(itime);
                helper.setText(R.id.tv_ontime,"时间："+timeText);
            }else {
                helper.setText(R.id.tv_ontime,"时间：");
            }
        }else {
            helper.setText(R.id.tv_ontime,"时间：");
        }



    }
}
