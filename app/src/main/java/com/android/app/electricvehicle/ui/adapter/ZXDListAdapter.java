package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.MyOutVO;
import com.android.app.electricvehicle.entity.ZXDListVO;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

public class ZXDListAdapter extends BaseQuickAdapter<ZXDListVO.DataBean.DataListBean, BaseViewHolder> {

    private List<ZXDListVO.DataBean.DataListBean> data;
    private Activity activity;

    public ZXDListAdapter(@Nullable List<ZXDListVO.DataBean.DataListBean> data, Activity activity) {
        super(R.layout.item_zxd_list, data);
        this.data = data;
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, ZXDListVO.DataBean.DataListBean bean) {




        //工作单号
        if (!(bean.getWorkCode()==null||bean.getWorkCode().equals(""))){
            helper.setText(R.id.tv_gzdh, bean.getWorkCode());
        }else {
            helper.setText(R.id.tv_gzdh, "");
        }

        //日期
        if (!(bean.getMadeTime()==null || bean.getMadeTime().equals(""))){

            long itime= Long.parseLong(bean.getMadeTime());

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
            String timeText=format.format(itime);

            helper.setText(R.id.tv_date, "日期："+timeText);
        }else {
            helper.setText(R.id.tv_date, "日期：");
        }

        //单据打印
        if (!(bean.getBillPrintText()==null || bean.getBillPrintText().equals(""))){
            helper.setText(R.id.tv_djdy, "单据打印："+bean.getBillPrintText());
        }else {
            helper.setText(R.id.tv_djdy,""+"单据打印：" );
        }


        //净重：
        if (!(bean.getNetWeight()==null || bean.getNetWeight().equals(""))){
            helper.setText(R.id.tv_jingzhong,"净重："+bean.getNetWeight());

        }else {
            helper.setText(R.id.tv_jingzhong,"净重："+"");
        }

        //毛重
        if (!(bean.getRoughWeight()==null || bean.getRoughWeight().equals(""))){
            helper.setText(R.id.tv_maozhong,"毛重："+bean.getRoughWeight());
        }else {
            helper.setText(R.id.tv_maozhong,"毛重："+"");
        }


        //状态
        if (!(bean.getStoreState()==null || bean.getStoreState().equals(""))){
            if (bean.getStoreState().equals("0")){// 0暂存  1待入库 2已入库  3已出库

                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"暂存");


            }else if (bean.getStoreState().equals("1")){
                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"待入库");

            }else if (bean.getStoreState().equals("2")){
                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"已入库");

            }else if (bean.getStoreState().equals("3")){
                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"已出库");

            }else {
                helper.setVisible(R.id.tv_wancheng, false);
            }

        }else {
            helper.setVisible(R.id.tv_wancheng, false);
        }




    }
}
