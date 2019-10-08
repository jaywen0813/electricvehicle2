package com.android.app.electricvehicle.model.sousuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.SouSuo;
import com.android.app.electricvehicle.ui.activity.TakePhotoActivity;

import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class SouSuoAdapter extends BaseAdapter {

    private Context context;
    private List<SouSuo.ResultBeanX.ResultBean> activityVOList;

    public SouSuoAdapter(Context context, List<SouSuo.ResultBeanX.ResultBean> activityVOList) {
        this.context = context;
        this.activityVOList = activityVOList;
    }

    @Override
    public int getCount() {
        return activityVOList.size();
    }

    @Override
    public Object getItem(int position) {
        return activityVOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Holder holder;
        if (convertView == null) {
            view = View.inflate(context, R.layout.item_main2, null);
            holder = new Holder();
//            holder.tvTitle = view.findViewById(R.id.tvTitle);
//            holder.ivImage = view.findViewById(R.id.tvImage);
//            holder.tvDate = view.findViewById(R.id.tvDate);
            holder.llItem = view.findViewById(R.id.ll_item);
            holder.tvUserName = view.findViewById(R.id.tv_userName);
            holder.tvWancheng = view.findViewById(R.id.tv_wancheng);
            holder.tvChepai = view.findViewById(R.id.tv_chepai);
            holder.tvVin = view.findViewById(R.id.tv_vin);
            holder.tvXinghao = view.findViewById(R.id.tv_xinghao);
            holder.tvPhone = view.findViewById(R.id.tv_phone);


            view.setTag(holder);
        } else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
        SouSuo.ResultBeanX.ResultBean bean = activityVOList.get(position);




        //如果用户名字不为空的时候
        if (!(bean.getName()==null||bean.getName().equals(""))){
            holder.tvUserName.setText(bean.getName());
        }else {
            holder.tvUserName.setText("");
        }




        //车牌号
        if (!(bean.getPalteNum()==null || bean.getPalteNum().equals(""))){
            holder.tvChepai.setText("车牌号："+bean.getPalteNum());
        }else {
            holder.tvChepai.setText("车牌号："+"");
        }

        //车架号
        if (!(bean.getBodyNum()==null || bean.getBodyNum().equals(""))){
            holder.tvVin.setText("车架号："+bean.getBodyNum());
        }else {
            holder.tvVin.setText("车架号："+"");
        }
        //品牌型号
        if (!(bean.getModelNum()==null || bean.getModelNum().equals(""))){
            holder.tvXinghao.setText("品牌型号："+bean.getModelNum());
        }else {
            holder.tvXinghao.setText("品牌型号："+"");
        }

        //联系方式
        if (!(bean.getPhone()==null || bean.getPhone().equals(""))){
            holder.tvPhone.setText("联系方式："+bean.getPhone());
        }else {
            holder.tvPhone.setText("联系方式："+"");
        }

        //是否完成的状态
        if (!(bean.getStep()==null || bean.getStep().equals(""))){
            if (bean.getStep().equals("2")){//已完成   1未完成 2已完成
                holder.tvWancheng.setText("已完成");
                holder.tvWancheng.setTextColor(context.getResources().getColor(R.color.color_21BFBF));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.tvWancheng.setBackground(context.getDrawable(R.drawable.shap_main_wwc2));
                }

                holder.tvWancheng.setVisibility(View.VISIBLE);
            }else {//未完成
                holder.tvWancheng.setText("未完成");
                holder.tvWancheng.setTextColor(context.getResources().getColor(R.color.color_2282EE));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.tvWancheng.setBackground(context.getDrawable(R.drawable.shap_main_wwc1));
                }

                holder.tvWancheng.setVisibility(View.VISIBLE);
            }

        }else {
            holder.tvWancheng.setVisibility(View.INVISIBLE);
        }


        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,TakePhotoActivity.class);
                intent.putExtra("id",bean.getId());
                context.startActivity(intent);
            }
        });



        //            Glide.with(context).load(bean.getPicUrl()).into(holder.ivImage);
//            ILFactory.getLoader().loadNet(holder.ivImage, bean.getPicUrl());
//        if (null != bean.getBuyCarDate()) {
//            @SuppressLint("SimpleDateFormat")
//            String date = new SimpleDateFormat("MM月dd日").format(new Date(Long.parseLong(bean.getStartTime())));
////            holder.tvDate.setText(date);
//        }

        return view;
    }

    private static class Holder {
        private LinearLayout llItem;//整个item

        private TextView tvUserName;//姓名
        private TextView tvWancheng;//是否完成

        private TextView tvChepai;//车牌号
        private TextView tvVin;//车架号
        private TextView tvXinghao;//品牌型号
        private TextView tvPhone;//联系方式



    }
}
