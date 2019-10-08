package com.android.app.electricvehicle.model.sousuo.adapter;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.Nullable;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.entity.SouSuo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SouSuoListAdapter extends BaseQuickAdapter<ActivityVO.ResultBeanX.ResultBean, BaseViewHolder> {

    private List<ActivityVO.ResultBeanX.ResultBean> data;
    private Activity activity;

    public SouSuoListAdapter(@Nullable List<ActivityVO.ResultBeanX.ResultBean> data, Activity activity) {
        super(R.layout.item_main2, data);
        this.data = data;
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, ActivityVO.ResultBeanX.ResultBean bean) {




        //如果用户名字不为空的时候
        if (!(bean.getName()==null||bean.getName().equals(""))){
            helper.setText(R.id.tv_userName, bean.getName());
        }else {
            helper.setText(R.id.tv_userName, "");
        }

        //车牌号
        if (!(bean.getPalteNum()==null || bean.getPalteNum().equals(""))){
            helper.setText(R.id.tv_chepai, "车牌号："+bean.getPalteNum());
        }else {
            helper.setText(R.id.tv_chepai, "车牌号：");
        }

        //车架号
        if (!(bean.getBodyNum()==null || bean.getBodyNum().equals(""))){
            helper.setText(R.id.tv_vin, "车架号："+bean.getBodyNum());
        }else {
            helper.setText(R.id.tv_vin,"车架号："+"" );
        }


        //品牌型号
        if (!(bean.getModelNum()==null || bean.getModelNum().equals(""))){
            helper.setText(R.id.tv_xinghao,"品牌型号："+bean.getModelNum());

        }else {
            helper.setText(R.id.tv_xinghao,"品牌型号："+"");
        }

        //联系方式
        if (!(bean.getPhone()==null || bean.getPhone().equals(""))){
            helper.setText(R.id.tv_phone,"联系方式："+bean.getPhone());
        }else {
            helper.setText(R.id.tv_phone,"联系方式："+"");
        }


        //是否完成的状态
        if (!(bean.getStep()==null || bean.getStep().equals(""))){
            if (bean.getStep().equals("2")){//已完成   1未完成 2已完成

                helper.setText(R.id.tv_wancheng,"已完成");

                helper.setTextColor(R.id.tv_wancheng,mContext.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    helper.setBackgroundRes(R.id.tv_wancheng,R.drawable.shap_main_wwc2);
                }

//                helper.setVisible(R.id.tv_wancheng,View.VISIBLE);

            }else {//未完成
                helper.setText(R.id.tv_wancheng,"未完成");
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
