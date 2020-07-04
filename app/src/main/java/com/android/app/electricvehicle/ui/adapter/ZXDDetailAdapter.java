package com.android.app.electricvehicle.ui.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.PackingItem;
import com.android.app.electricvehicle.entity.ZXDListVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ZXDDetailAdapter extends BaseQuickAdapter<ZxdlrDetailVO.DataBean.PackingItemsBean, BaseViewHolder> {

    private List<ZxdlrDetailVO.DataBean.PackingItemsBean> data;
    private Activity activity;
    List<PackingItem> PackingItems ;//用来存储列表的数据的
    String id;

    public ZXDDetailAdapter(@Nullable List<ZxdlrDetailVO.DataBean.PackingItemsBean> data, Activity activity,List<PackingItem> PackingItem,String id) {
        super(R.layout.item_zxdlr, data);
        this.data = data;
        this.activity = activity;
        this.PackingItems=PackingItem;
        this.id=id;
    }


    @Override
    protected void convert(BaseViewHolder helper, ZxdlrDetailVO.DataBean.PackingItemsBean bean) {




        //SO Item
        if (!(bean.getSoItem()==null||bean.getSoItem().equals(""))){
            helper.setText(R.id.tv_so, bean.getSoItem());
        }else {
            helper.setText(R.id.tv_so, "");
        }



        //material
        if (!(bean.getMaterial()==null || bean.getMaterial().equals(""))){
            helper.setText(R.id.tv_material, ""+bean.getMaterial());
        }else {
            helper.setText(R.id.tv_material,"" );
        }


        //RL
        if (!(bean.getRl()==null || bean.getRl().equals(""))){
            helper.setText(R.id.tv_rl,""+bean.getRl());

        }else {
            helper.setText(R.id.tv_rl,"");
        }

        //AGL
        if (!(bean.getAgl()==null || bean.getAgl().equals(""))){
            helper.setText(R.id.tv_agl,""+bean.getAgl());
        }else {
            helper.setText(R.id.tv_agl,"");
        }



        //Qty
        if (!(bean.getQty()==null || bean.getQty().equals(""))){
            helper.setText(R.id.tv_qty,""+bean.getQty());
        }else {
            helper.setText(R.id.tv_qty,"");
        }





//        PackingItem plist=new PackingItem();
//        plist.setId(id);
//        plist.setSoItem();
//        plist.setMaterial(material);
//        plist.setRl(rl);
//        plist.setAgl(agl);
//        plist.setQty(qty);



    }
}
