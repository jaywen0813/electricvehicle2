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


    String soItem = "";
    String material = "";
    String rl = "";
    String agl = "";
    String qty = "";
    int pos=0;

    public ZXDDetailAdapter(@Nullable List<ZxdlrDetailVO.DataBean.PackingItemsBean> data, Activity activity,List<PackingItem> PackingItem,String id) {
        super(R.layout.item_zxdlr, data);
        this.data = data;
        this.activity = activity;
        this.PackingItems=PackingItem;
        this.id=id;
    }

    public String getSoItem() {
        return soItem;
    }

    public void setSoItem(String soItem) {
        this.soItem = soItem;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRl() {
        return rl;
    }

    public void setRl(String rl) {
        this.rl = rl;
    }

    public String getAgl() {
        return agl;
    }

    public void setAgl(String agl) {
        this.agl = agl;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public int getPosition() {
        return pos;
    }

    public void setPosition(int position) {
        this.pos = position;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZxdlrDetailVO.DataBean.PackingItemsBean bean) {


        setPosition(helper.getAdapterPosition());

        //SO Item
        if (!(bean.getSoItem()==null||bean.getSoItem().equals(""))){
            helper.setText(R.id.tv_so, bean.getSoItem());
            setSoItem(bean.getSoItem());

        }else {
            helper.setText(R.id.tv_so, "");
            setSoItem("");
        }



        //material
        if (!(bean.getMaterial()==null || bean.getMaterial().equals(""))){
            helper.setText(R.id.tv_material, ""+bean.getMaterial());
            setMaterial(bean.getMaterial());
        }else {
            helper.setText(R.id.tv_material,"" );
            setMaterial("");
        }


        //RL
        if (!(bean.getRl()==null || bean.getRl().equals(""))){
            helper.setText(R.id.tv_rl,""+bean.getRl());
            setRl(bean.getRl());
        }else {
            helper.setText(R.id.tv_rl,"");
            setRl("");
        }

        //AGL
        if (!(bean.getAgl()==null || bean.getAgl().equals(""))){
            helper.setText(R.id.tv_agl,""+bean.getAgl());
            setAgl(bean.getAgl());
        }else {
            helper.setText(R.id.tv_agl,"");
            setAgl("");
        }



        //Qty
        if (!(bean.getQty()==null || bean.getQty().equals(""))){
            helper.setText(R.id.tv_qty,""+bean.getQty());
            setQty(bean.getQty());
        }else {
            helper.setText(R.id.tv_qty,"");
            setQty("");
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
