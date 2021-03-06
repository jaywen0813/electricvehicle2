package com.android.app.electricvehicle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.entity.OutDetailVO2;
import com.android.app.electricvehicle.utils.Kits;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SOOutAdapter extends BaseAdapter {


    private Context context;
    private List<OutDetailVO2.DataBean> list;

//    private List<OutDetailVO2.DataBean.PackingBean.PackingItemsBean> list_item=new ArrayList<>();//SOitem的列表
//    SOOutAdapter_SoItem adapter_soItem;


    public SOOutAdapter(Context context, List<OutDetailVO2.DataBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_soout_fragment2,
                    parent, false);
            viewHolder=new ViewHolder();
            viewHolder.tvNumber = convertView.findViewById(R.id.tvNumber);
            viewHolder.tvDate = convertView.findViewById(R.id.tv_date);
            viewHolder.tvKwNumber = convertView.findViewById(R.id.tv_kw_number);
            viewHolder.tvDjdy = convertView.findViewById(R.id.tv_djdy);
            viewHolder.tvZhuangtai = convertView.findViewById(R.id.tv_zhuangtai);
            viewHolder.tvOrder = convertView.findViewById(R.id.tv_order);
            viewHolder.tvDdjhq = convertView.findViewById(R.id.tv_ddjhq);
            viewHolder.lv=convertView.findViewById(R.id.lv);


            viewHolder.tv_soItem = convertView.findViewById(R.id.tv_soItem);
            viewHolder.tv_kwh=convertView.findViewById(R.id.tv_kwh);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final OutDetailVO2.DataBean item = list.get(position);


//        adapter_soItem=new SOOutAdapter_SoItem(context,list_item);
//        viewHolder.lv.setAdapter(adapter_soItem);
//
//        if (!Kits.Empty.check(item.getPacking().getPackingItems())){
//
//            if  (item.getPacking().getPackingItems().size()>0){
//                list_item.clear();
//                list_item.addAll(item.getPacking().getPackingItems());
//                adapter_soItem.notifyDataSetChanged();
//            }
//        }
        //库位号
        if (!Kits.Empty.check(item.getFreeLoc())){
            viewHolder.tv_kwh.setText(item.getFreeLoc());
        }

        if (!Kits.Empty.check(item.getPacking().getPackingItems())){
            if (!Kits.Empty.check(item.getPacking().getPackingItems().size()>0)){
                //SOItem
                if (!Kits.Empty.check(item.getPacking().getPackingItems().get(0).getSoItem())){
                    viewHolder.tv_soItem.setText(item.getPacking().getPackingItems().get(0).getSoItem());
                }
            }
        }



        //日期
        if (!Kits.Empty.check(item.getPacking().getMadeTime())){

            long itime= Long.parseLong(item.getPacking().getMadeTime());

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
            String timeText=format.format(itime);
            viewHolder.tvDate.setText(timeText+"");
        }

        //装箱单号
        if (!Kits.Empty.check(item.getPacking().getPackingCode())) {
            viewHolder.tvNumber.setText(item.getPacking().getPackingCode());
        }


//        //第几箱
//        if (!Kits.Empty.check(item.getPacking().getRankNum())) {
//            viewHolder.tvDjx.setText("第  "+item.getPacking().getRankNum()+"  箱");
//        }
//
//        //共几箱
//        if (!Kits.Empty.check(item.getPacking().getTotalNum())) {
//            viewHolder.tvGjx.setText("共  "+item.getPacking().getTotalNum()+"  箱");
//        }
//
//        //长
//        if (!Kits.Empty.check(item.getPacking().getPackLength())) {
//            viewHolder.tvChang.setText("长："+item.getPacking().getPackLength());
//        }
//        //宽
//        if (!Kits.Empty.check(item.getPacking().getPackwidth())) {
//            viewHolder.tvKuan.setText("宽："+item.getPacking().getPackwidth());
//        }
//        //高
//        if (!Kits.Empty.check(item.getPacking().getPackHeight())) {
//            viewHolder.tvGao.setText("高:"+item.getPacking().getPackHeight());
//        }
//        //净重
//        if (!Kits.Empty.check(item.getPacking().getNetWeight())) {
//            viewHolder.tvJingzhong.setText("净重："+item.getPacking().getNetWeight());
//        }
//        //毛重
//        if (!Kits.Empty.check(item.getPacking().getRoughWeight())) {
//            viewHolder.tvMaozhong.setText("毛重："+item.getPacking().getRoughWeight());
//        }


        //状态(0暂存  1待入库  2已入库  3已出库)
//        if (!Kits.Empty.check(item.getPacking().getStoreState())) {
//            switch (item.getPacking().getStoreState()){
//                case "0":
//                    viewHolder.tvZhuangtai.setText("状态：暂存");
//                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
//                    break;
//
//                case "1":
//                    viewHolder.tvZhuangtai.setText("状态：待入库");
//                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
//
//                    break;
//                case "2":
//                    viewHolder.tvZhuangtai.setText("状态：已入库");
//                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.recommend_red));
//                    break;
//                case "3":
//                    viewHolder.tvZhuangtai.setText("状态：已出库");
//                    viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
//                    break;
//
//            }
//
//
//        }

        //状态
        if (!Kits.Empty.check(item.getInstoreStateText())){

            viewHolder.tvZhuangtai.setText("状态："+item.getInstoreStateText());
            if (item.getInstoreStateText().equals("已入库") || item.getInstoreStateText().equals("未出库")){

                viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.recommend_red));//2019年10月30日 17:21:40  改了需求 ，这里暂时不需要出库按钮
            }else {
                viewHolder.tvZhuangtai.setTextColor(context.getResources().getColor(R.color.color_3d3d3d));
            }
        }





        //单据归档 0否  1是
//        if (!Kits.Empty.check(item.getPacking().getBillArchived())) {
//            if (item.getPacking().getBillArchived().equals("0")){
//                viewHolder.tvDjgd.setText("单据归档：否");
//            }else if (item.getPacking().getBillArchived().equals("1")){
//                viewHolder.tvDjgd.setText("单据归档：是");
//            }
//
//        }

        //单据打印
        if (!Kits.Empty.check(item.getPacking().getBillPrint())) {
            if (item.getPacking().getBillPrint().equals("0")){
                viewHolder.tvDjdy.setText("单据打印：未打印");
            }else if (item.getPacking().getBillPrint().equals("1")){
                viewHolder.tvDjdy.setText("单据打印：已打印");
            }else if (item.getPacking().getBillPrint().equals("2")){
                viewHolder.tvDjdy.setText("单据打印：补打");
            }

        }
        //打印次数
//        if (!Kits.Empty.check(item.getPacking().getPrintTimes())) {
//            viewHolder.tvDycs.setText("打印次数："+item.getPacking().getPrintTimes()+"次");
//        }



        //Sales order
        if (!Kits.Empty.check(item.getPacking().getSalesOrder())) {
            viewHolder.tvOrder.setText(item.getPacking().getSalesOrder());
        }


        //comments
//        if (!Kits.Empty.check(item.getPacking().getComments())) {
//            viewHolder.tvComments.setText(item.getPacking().getComments());
//        }

        //组装日期
//        if (!Kits.Empty.check(item.getPacking().getInstallTime())) {
//
//            long itimes= Long.parseLong(item.getPacking().getInstallTime());
//
//            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
//            String timeText=format.format(itimes);
//            viewHolder.tvZzrq.setText(timeText+"");
//
//
//        }

        //订单交货期
        if (!Kits.Empty.check(item.getPacking().getDeliveryDate())) {

            long itimess= Long.parseLong(item.getPacking().getDeliveryDate());

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
            String timeText=format.format(itimess);
            viewHolder.tvDdjhq.setText(timeText+"");

        }



        return convertView;
    }


    private static class ViewHolder {
        TextView tvNumber;
        TextView tvDate;
        TextView tvKwNumber;
        TextView tvDjdy;
        TextView tvZhuangtai;
        TextView tvOrder;
        TextView tvDdjhq;

        ListView lv;

        TextView tv_soItem;
        TextView tv_kwh;//库位号










    }
}
