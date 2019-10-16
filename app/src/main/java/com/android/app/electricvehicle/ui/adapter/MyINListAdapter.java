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
            helper.setText(R.id.tv_ckmc,"仓库名称："+"" );
        }


        //库位号
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


        //状态

        if (!(bean.getPackingList()==null ||bean.getPackingList().equals(""))){



        if (!(bean.getPackingList().getStoreState()==null || bean.getPackingList().getStoreState().equals(""))){
            if (bean.getInstoreState().equals("0")){//已完成  0暂存 1待入库 2已入库 3已出库

                helper.setText(R.id.tv_wancheng,"暂存");

                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc2);
                }

//                helper.setVisible(R.id.tv_wancheng,View.VISIBLE);

            }else  if (bean.getInstoreState().equals("1")){//已完成  0暂存 1待入库 2已入库 3已出库

                helper.setText(R.id.tv_wancheng,"待入库");

                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc2);
                }

//                helper.setVisible(R.id.tv_wancheng,View.VISIBLE);

            }else  if (bean.getInstoreState().equals("2")){//已完成  0暂存 1待入库 2已入库 3已出库

                helper.setText(R.id.tv_wancheng,"已入库");

                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc2);
                }

//                helper.setVisible(R.id.tv_wancheng,View.VISIBLE);

            }else {//已出库
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
}
