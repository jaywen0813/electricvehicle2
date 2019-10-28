package com.android.app.electricvehicle.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO2;

import java.util.List;

public class SOOutAdapter_SoItem extends BaseAdapter {


    private Context context;
    private List<OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean> list;


    public SOOutAdapter_SoItem(Context context, List<OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_zxdout_soitem,
                    parent, false);
            viewHolder=new ViewHolder();
            viewHolder.tvSo = convertView.findViewById(R.id.tv_so);
            viewHolder.tvMaterial = convertView.findViewById(R.id.tv_material);
            viewHolder.tvRl = convertView.findViewById(R.id.tv_rl);
            viewHolder.tvAgl = convertView.findViewById(R.id.tv_agl);
            viewHolder.tvQty = convertView.findViewById(R.id.tv_qty);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean bean = list.get(position);


        //SO Item
        if (!(bean.getSoItem()==null||bean.getSoItem().equals(""))){
            viewHolder.tvSo.setText(bean.getSoItem());
        }else {
            viewHolder.tvSo.setText("");
        }



        //material
        if (!(bean.getMaterial()==null || bean.getMaterial().equals(""))){
            viewHolder.tvMaterial.setText(bean.getMaterial());
        }else {
            viewHolder.tvMaterial.setText("" );
        }


        //RL
        if (!(bean.getRl()==null || bean.getRl().equals(""))){
            viewHolder.tvRl .setText(bean.getRl());

        }else {
            viewHolder.tvRl .setText("");
        }

        //AGL
        if (!(bean.getAgl()==null || bean.getAgl().equals(""))){
            viewHolder.tvAgl.setText(bean.getAgl());
        }else {
            viewHolder.tvAgl.setText("");
        }



        //Qty
        if (!(bean.getQty()==null || bean.getQty().equals(""))){
            viewHolder.tvQty.setText(bean.getQty());
        }else {
            viewHolder.tvQty.setText("");
        }

//        //订单交货期
//        if (!Kits.Empty.check(item.getDeliveryDate())) {
//
//            long itimess= Long.parseLong(item.getDeliveryDate());
//
//            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
//            String timeText=format.format(itimess);
//            viewHolder.tvDdjhq.setText(timeText+"");
//
//        }



        return convertView;
    }


    private static class ViewHolder {
        TextView tvSo;
        TextView tvMaterial;
        TextView tvRl;
        TextView tvAgl;
        TextView tvQty;













    }
}
