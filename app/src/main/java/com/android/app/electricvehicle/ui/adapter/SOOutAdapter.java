package com.android.app.electricvehicle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.utils.Kits;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SOOutAdapter extends BaseAdapter {


    private Context context;
    private List<ItemDetailOutVO2.DataBean> list;


    public SOOutAdapter(Context context, List<ItemDetailOutVO2.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_soout_fragment,
                    parent, false);
            viewHolder=new ViewHolder();
            viewHolder.tvGzdh = convertView.findViewById(R.id.tv_gzdh);
            viewHolder.tvDate = convertView.findViewById(R.id.tv_date);
            viewHolder.tvKwNumber = convertView.findViewById(R.id.tv_kw_number);
            viewHolder.tvDjx = convertView.findViewById(R.id.tv_djx);
            viewHolder.tvGjx = convertView.findViewById(R.id.tv_gjx);
            viewHolder.tvChang = convertView.findViewById(R.id.tv_chang);
            viewHolder.tvKuan = convertView.findViewById(R.id.tv_kuan);
            viewHolder.tvGao = convertView.findViewById(R.id.tv_gao);
            viewHolder.tvJingzhong = convertView.findViewById(R.id.tv_jingzhong);
            viewHolder.tvMaozhong = convertView.findViewById(R.id.tv_maozhong);
            viewHolder.tvZhuangtai = convertView.findViewById(R.id.tv_zhuangtai);
            viewHolder.tvDjgd = convertView.findViewById(R.id.tv_djgd);
            viewHolder.tvDjdy = convertView.findViewById(R.id.tv_djdy);
            viewHolder.tvDycs = convertView.findViewById(R.id.tv_dycs);
            viewHolder.tvNumber=convertView.findViewById(R.id.tvNumber);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ItemDetailOutVO2.DataBean item = list.get(position);


        //工作单号
        if (!Kits.Empty.check(item.getWorkCode())){
            viewHolder.tvGzdh.setText(item.getWorkCode());
        }
        //日期
        if (!Kits.Empty.check(item.getMadeTime())){

            long itime= Long.parseLong(item.getMadeTime());

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
            String timeText=format.format(itime);
            viewHolder.tvDate.setText(timeText+"");
        }

        //装箱单号
        if (!Kits.Empty.check(item.getPackingCode())) {
            viewHolder.tvNumber.setText(item.getPackingCode());
        }


        //第几箱
        if (!Kits.Empty.check(item.getRankNum())) {
            viewHolder.tvDjx.setText("第  "+item.getRankNum()+"  箱");
        }

        //共几箱
        if (!Kits.Empty.check(item.getTotalNum())) {
            viewHolder.tvGjx.setText("共  "+item.getTotalNum()+"  箱");
        }

        //长
        if (!Kits.Empty.check(item.getPackLength())) {
            viewHolder.tvChang.setText("长："+item.getPackLength());
        }
        //宽
        if (!Kits.Empty.check(item.getPackwidth())) {
            viewHolder.tvKuan.setText("宽："+item.getPackwidth());
        }
        //高
        if (!Kits.Empty.check(item.getPackHeight())) {
            viewHolder.tvGao.setText("高:"+item.getPackHeight());
        }
        //净重
        if (!Kits.Empty.check(item.getNetWeight())) {
            viewHolder.tvJingzhong.setText("净重："+item.getNetWeight());
        }
        //毛重
        if (!Kits.Empty.check(item.getRoughWeight())) {
            viewHolder.tvMaozhong.setText("毛重："+item.getRoughWeight());
        }


        //状态(0暂存  1待入库  2已入库  3已出库)
        if (!Kits.Empty.check(item.getStoreState())) {
            switch (item.getStoreState()){
                case "0":
                    viewHolder.tvZhuangtai.setText("状态：暂存");
                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
                    break;

                case "1":
                    viewHolder.tvZhuangtai.setText("状态：待入库");
                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));

                    break;
                case "2":
                    viewHolder.tvZhuangtai.setText("状态：已入库");
                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.recommend_red));
                    break;
                case "3":
                    viewHolder.tvZhuangtai.setText("状态：已出库");
                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
                    break;

            }


        }

        //单据归档 0否  1是
        if (!Kits.Empty.check(item.getBillArchived())) {
            if (item.getBillArchived().equals("0")){
                viewHolder.tvDjgd.setText("单据归档：否");
            }else if (item.getBillArchived().equals("1")){
                viewHolder.tvDjgd.setText("单据归档：是");
            }

        }

        //单据打印
        if (!Kits.Empty.check(item.getBillPrint())) {
            if (item.getBillPrint().equals("0")){
                viewHolder.tvDjdy.setText("单据打印：未打印");
            }else if (item.getBillPrint().equals("1")){
                viewHolder.tvDjdy.setText("单据打印：已打印");
            }else if (item.getBillPrint().equals("2")){
                viewHolder.tvDjdy.setText("单据打印：补打");
            }

        }
        //打印次数
        if (!Kits.Empty.check(item.getPrintTimes())) {
            viewHolder.tvDycs.setText("打印次数："+item.getPrintTimes()+"次");
        }
       


       


        return convertView;
    }


    private static class ViewHolder {
        TextView tvGzdh;
        TextView tvDate;
        TextView tvKwNumber;
        TextView tvDjx;
        TextView tvGjx;
        TextView tvChang;
        TextView tvKuan;
        TextView tvGao;
        TextView tvJingzhong;
        TextView tvMaozhong;
        TextView tvZhuangtai;
        TextView tvDjgd;
        TextView tvDjdy;
        TextView tvDycs;
        TextView tvNumber;
       







    }
}
