package com.android.app.electricvehicle.model.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ActivityVO;
import com.android.app.electricvehicle.utils.imageloader.ILFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ================================================
 * 作   者：邓浩
 * 版   本：1.0
 * 日   期：2018/6/12
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class MainAdapter extends BaseAdapter {

    private Context context;
    private List<ActivityVO.ResultBeanX.ResultBean> activityVOList;

    public MainAdapter(Context context, List<ActivityVO.ResultBeanX.ResultBean> activityVOList) {
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
            view = View.inflate(context, R.layout.item_main, null);
            holder = new Holder();
            holder.tvTitle = view.findViewById(R.id.tvTitle);
            holder.ivImage = view.findViewById(R.id.tvImage);
            holder.tvDate = view.findViewById(R.id.tvDate);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
//        ActivityVO.ActivictBean bean = activityVOList.get(position);
//        if (null != bean.getPicUrl()) {
//            Glide.with(context).load(bean.getPicUrl()).into(holder.ivImage);
////            ILFactory.getLoader().loadNet(holder.ivImage, bean.getPicUrl());
//        }
//        if (null != bean.getStartTime()) {
//            @SuppressLint("SimpleDateFormat")
//            String date = new SimpleDateFormat("MM月dd日").format(new Date(Long.parseLong(bean.getStartTime())));
//            holder.tvDate.setText(date);
//        }
//
//        if (null != bean.getTitle()) {
//            holder.tvTitle.setText(bean.getTitle());
//        }

        return view;
    }

    private static class Holder {
        //标题
        private TextView tvTitle;
        //日期
        private TextView tvDate;
        //图片
        private ImageView ivImage;
        //查看详情
        private TextView tvCKXQ;
    }
}
