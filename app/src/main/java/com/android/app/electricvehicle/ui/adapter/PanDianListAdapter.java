package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.PanDianListVO;
import com.android.app.electricvehicle.entity.ZXDListVO;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.List;

public class PanDianListAdapter extends BaseQuickAdapter<PanDianListVO.DataBean, BaseViewHolder> {

    private List<PanDianListVO.DataBean> data;
    private Activity activity;

    public PanDianListAdapter(@Nullable List<PanDianListVO.DataBean> data, Activity activity) {
        super(R.layout.item_pandian_list, data);
        this.data = data;
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, PanDianListVO.DataBean bean) {




        //工作单号
        if (!(bean.getPacking().getWorkCode()==null||bean.getPacking().getWorkCode().equals(""))){
            helper.setText(R.id.tv_gzdh, bean.getPacking().getWorkCode());
        }else {
            helper.setText(R.id.tv_gzdh, "");
        }

        //日期
        if (!(bean.getPacking().getMadeTime()==null || bean.getPacking().getMadeTime().equals(""))){

            long itime= Long.parseLong(bean.getPacking().getMadeTime());

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
            String timeText=format.format(itime);

            helper.setText(R.id.tv_date, "日期："+timeText);
        }else {
            helper.setText(R.id.tv_date, "日期：");
        }

        //单据打印
        if (!(bean.getPacking().getBillPrintText()==null || bean.getPacking().getBillPrintText().equals(""))){
            helper.setText(R.id.tv_djdy, "单据打印："+bean.getPacking().getBillPrintText());
        }else {
            helper.setText(R.id.tv_djdy,""+"单据打印：" );
        }


        //净重：
        if (!(bean.getPacking().getNetWeight()==null || bean.getPacking().getNetWeight().equals(""))){
            helper.setText(R.id.tv_jingzhong,"净重："+bean.getPacking().getNetWeight());

        }else {
            helper.setText(R.id.tv_jingzhong,"净重："+"");
        }

        //毛重
        if (!(bean.getPacking().getRoughWeight()==null || bean.getPacking().getRoughWeight().equals(""))){
            helper.setText(R.id.tv_maozhong,"毛重："+bean.getPacking().getRoughWeight());
        }else {
            helper.setText(R.id.tv_maozhong,"毛重："+"");
        }


        //状态
        if (!(bean.getPacking().getStoreState()==null || bean.getPacking().getStoreState().equals(""))){
            if (bean.getPacking().getStoreState().equals("0")){// 0暂存  1待入库 2已入库  3已出库

                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"暂存");


            }else if (bean.getPacking().getStoreState().equals("1")){
                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"待入库");

            }else if (bean.getPacking().getStoreState().equals("2")){
                helper.setVisible(R.id.tv_wancheng, true);
                helper.setText(R.id.tv_wancheng,"已入库");

            }else if (bean.getPacking().getStoreState().equals("3")){
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
