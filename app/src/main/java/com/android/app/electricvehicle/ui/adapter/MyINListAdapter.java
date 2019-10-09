package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.MyInVO;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyINListAdapter extends BaseQuickAdapter<MyInVO.DataBean.DataListBean, BaseViewHolder> {

    private List<MyInVO.DataBean.DataListBean>   data;
    private Activity activity;

    public MyINListAdapter(@Nullable List<MyInVO.DataBean.DataListBean>  data, Activity activity) {
        super(R.layout.item_my_in_list, data);
        this.data = data;
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, MyInVO.DataBean.DataListBean  bean) {




        //入库单号
        if (!(bean.getInstoreCode()==null||bean.getInstoreCode().equals(""))){
            helper.setText(R.id.tv_rkdh, bean.getInstoreCode());
        }else {
            helper.setText(R.id.tv_rkdh, "");
        }

        //仓库ID
        if (!(bean.getStorehouseId()==null || bean.getStorehouseId().equals(""))){
            helper.setText(R.id.tv_ckid, "仓库ID："+bean.getStorehouseId());
        }else {
            helper.setText(R.id.tv_ckid, "仓库ID：");
        }

        //仓库名称
        if (!(bean.getStorehouseName()==null || bean.getStorehouseName().equals(""))){
            helper.setText(R.id.tv_ckmc, "仓库名称："+bean.getStorehouseName());
        }else {
            helper.setText(R.id.tv_ckmc,"仓库名称："+"" );
        }


        //库位号
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


        //状态
        if (!(bean.getInstoreState()==null || bean.getInstoreState().equals(""))){
            if (bean.getInstoreState().equals("1")){//已完成   1未出库 2已出库

                helper.setText(R.id.tv_wancheng,"未出库");

                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc2);
                }

//                helper.setVisible(R.id.tv_wancheng,View.VISIBLE);

            }else {//未完成
                helper.setText(R.id.tv_wancheng,"已出库");
                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_2282EE));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc1);
                }

//                holder.tvWancheng.setVisibility(View.VISIBLE);
            }

        }else {
//            holder.tvWancheng.setVisibility(View.INVISIBLE);
        }


    }
}
