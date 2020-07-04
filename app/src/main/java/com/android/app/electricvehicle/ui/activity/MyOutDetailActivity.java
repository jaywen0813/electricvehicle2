package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;

import com.android.app.electricvehicle.entity.DeleteOUTdetailVO;
import com.android.app.electricvehicle.entity.MyOutDetailVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.contract.MyOutDetailContract;
import com.android.app.electricvehicle.model.main.presenter.MyINDetailPresenter;
import com.android.app.electricvehicle.model.main.presenter.MyOutDetailPresenter;
import com.android.app.electricvehicle.ui.adapter.MyOutDetailAdapter_SoItem;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//我的入库单列表点进来的详情
public class MyOutDetailActivity extends BaseMvpActivity<MyOutDetailContract.View, MyOutDetailPresenter> implements MyOutDetailContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private TextView tvZhid;
    private TextView tvGzdh;
    private TextView tvDate;
    private TextView tvNumber;
    private TextView tvZxdid;
    private TextView tvCkmc;
    private TextView tvCkid;
    private TextView tvKwNumber;
    private TextView tvDjx;
    private TextView tvGjx;
    private TextView tvChang;
    private TextView tvKuan;
    private TextView tvGao;
    private TextView tvJingzhong;
    private TextView tvMaozhong;
    private TextView tvZhuangtai;
    private TextView tvDjgd;
    private TextView tvDjdy;
    private TextView tvDycs;
    private TextView tvBz;
    private TextView tv_delete;
    private ListView lv;
    private ScrollView scrollView;
    private LinearLayout ll_wsj;
    private ImageView img_delete;

    private TextView tv_order;
    private TextView tv_comments;
    private TextView tv_zzrq;
    private TextView tv_ddjhq;


    MyOutDetailPresenter presenter;

    String id = "";


    List<MyOutDetailVO.DataBean.PackingBean.PackingItemsBean> list = new ArrayList<>();
    MyOutDetailAdapter_SoItem adapter_soItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_my_outdetail;
    }

    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        tvZhid = findViewById(R.id.tv_zhid);
        tvGzdh = findViewById(R.id.tv_gzdh);
        tvDate = findViewById(R.id.tv_date);
        tvNumber = findViewById(R.id.tv_number);
        tvZxdid = findViewById(R.id.tv_zxdid);
        tvCkmc = findViewById(R.id.tv_ckmc);
        tvCkid = findViewById(R.id.tv_ckid);
        tvKwNumber = findViewById(R.id.tv_kw_number);
        tvDjx = findViewById(R.id.tv_djx);
        tvGjx = findViewById(R.id.tv_gjx);
        tvChang = findViewById(R.id.tv_chang);
        tvKuan = findViewById(R.id.tv_kuan);
        tvGao = findViewById(R.id.tv_gao);
        tvJingzhong = findViewById(R.id.tv_jingzhong);
        tvMaozhong = findViewById(R.id.tv_maozhong);
        tvZhuangtai = findViewById(R.id.tv_zhuangtai);
        tvDjgd = findViewById(R.id.tv_djgd);
        tvDjdy = findViewById(R.id.tv_djdy);
        tvDycs = findViewById(R.id.tv_dycs);
        tvBz = findViewById(R.id.tv_bz);
        tv_delete=findViewById(R.id.tv_delete);//作废按钮
        lv=findViewById(R.id.lv);
        scrollView=findViewById(R.id.scrollView);//有数据的时候显示
        ll_wsj=findViewById(R.id.ll_wsj);//无数据
        img_delete=findViewById(R.id.img_delete);//作废按钮


        tv_order=findViewById(R.id.tv_order);
        tv_comments=findViewById(R.id.tv_comments);
        tv_zzrq=findViewById(R.id.tv_zzrq);
        tv_ddjhq=findViewById(R.id.tv_ddjhq);


        backLayout.setOnClickListener(this);
        tv_delete.setOnClickListener(this);//作废按钮
        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，

        tvLayerHead.setText("出库详情");


        id = getIntent().getStringExtra("id");
        presenter.getUP(id);


        adapter_soItem = new MyOutDetailAdapter_SoItem(this, list);
        lv.setAdapter(adapter_soItem);
    }

    @Override
    protected MyOutDetailPresenter initPresenter() {
        presenter = new MyOutDetailPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tv_delete://删除按钮
                DialogUtil.showBasicDialog(this, "作废提示", "确定作废此条出库单?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter.deleteThis(id);
                    }
                    dialog.dismiss();
                });
                break;
        }
    }

    //获取到详情数据以后
    @Override
    public void showSuccess(MyOutDetailVO vDate) {



        if (!(vDate.getData()==null||vDate.getData().equals(""))){

            scrollView.setVisibility(View.VISIBLE);
            ll_wsj.setVisibility(View.GONE);


            //查询此单是否作废
            if (!Kits.Empty.check(vDate.getData().getDisabled())){
                if (vDate.getData().getDisabled().equals("true")){//代表作废
                    //显示作废的图标，并不给点击事件

                    img_delete.setImageResource(R.mipmap.img_zuofei);
                    img_delete.setVisibility(View.VISIBLE);//显示作废图标
                    tv_delete.setEnabled(false);
                    tv_delete.setVisibility(View.INVISIBLE);//隐藏作废按钮


                }else {
                    img_delete.setVisibility(View.INVISIBLE);//隐藏作废图标
                    tv_delete.setEnabled(true);
                    tv_delete.setVisibility(View.VISIBLE);//显示作废按钮


                }
            }


            if (!(vDate.getData().getPacking()==null||vDate.getData().getPacking().equals(""))){

                //租户ID
//        if (!(vDate.getData().getTenantId())){
//            tvZhid.setText(vDate.getData().getTenantId());
//        }
                //工作单号
                if (!(vDate.getData().getPacking().getWorkCode()==null||vDate.getData().getPacking().getWorkCode().equals(""))){
                    tvGzdh.setText(vDate.getData().getPacking().getWorkCode());
                }
                //日期
                if (!(vDate.getData().getPacking().getMadeTime()==null||vDate.getData().getPacking().getMadeTime().equals(""))){

                    long itime= Long.parseLong(vDate.getData().getPacking().getMadeTime());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                    String timeText=format.format(itime);
                    tvDate.setText(timeText+"");
                }





                //第几箱
                if (!(vDate.getData().getPacking().getRankNum()==null||vDate.getData().getPacking().getRankNum().equals(""))) {
                    tvDjx.setText("第  "+vDate.getData().getPacking().getRankNum()+"  箱");
                }

                //共几箱
                if (!(vDate.getData().getPacking().getTotalNum()==null||vDate.getData().getPacking().getTotalNum().equals(""))) {
                    tvGjx.setText("共  "+vDate.getData().getPacking().getTotalNum()+"  箱");
                }

                //长
                if (!(vDate.getData().getPacking().getPackLength()==null||vDate.getData().getPacking().getPackLength().equals(""))) {
                    tvChang.setText("长："+vDate.getData().getPacking().getPackLength());
                }
                //宽
                if (!(vDate.getData().getPacking().getPackwidth()==null||vDate.getData().getPacking().getPackwidth().equals(""))) {
                    tvKuan.setText("宽："+vDate.getData().getPacking().getPackwidth());
                }
                //高
                if (!(vDate.getData().getPacking().getPackHeight()==null||vDate.getData().getPacking().getPackHeight().equals(""))) {
                    tvGao.setText("高:"+vDate.getData().getPacking().getPackHeight());
                }
                //净重
                if (!(vDate.getData().getPacking().getNetWeight()==null||vDate.getData().getPacking().getNetWeight().equals(""))) {
                    tvJingzhong.setText("净重："+vDate.getData().getPacking().getNetWeight());
                }
                //毛重
                if (!(vDate.getData().getPacking().getRoughWeight()==null||vDate.getData().getPacking().getRoughWeight().equals(""))) {
                    tvMaozhong.setText("毛重："+vDate.getData().getPacking().getRoughWeight());
                }


                //状态(0暂存  1待入库  2已入库  3已出库)
                if (!(vDate.getData().getPacking().getStoreState()==null||vDate.getData().getPacking().getStoreState().equals(""))) {
                    switch (vDate.getData().getPacking().getStoreState()){
                        case "0":
                            tvZhuangtai.setText("状态：暂存");
                            break;

                        case "1":
                            tvZhuangtai.setText("状态：待入库");
                            break;
                        case "2":
                            tvZhuangtai.setText("状态：已入库");
                            break;
                        case "3":
                            tvZhuangtai.setText("状态：已出库");
                            break;

                    }


                }

                //单据归档 0否  1是
                if (!(vDate.getData().getPacking().getBillArchived()==null||vDate.getData().getPacking().getBillArchived().equals(""))) {
                    if (vDate.getData().getPacking().getBillArchived().equals("0")){
                        tvDjgd.setText("单据归档：否");
                    }else if (vDate.getData().getPacking().getBillArchived().equals("1")){
                        tvDjgd.setText("单据归档：是");
                    }

                }

                //单据打印
                if (!(vDate.getData().getPacking().getBillPrint()==null||vDate.getData().getPacking().getBillPrint().equals(""))) {
                    if (vDate.getData().getPacking().getBillPrint().equals("0")){
                        tvDjdy.setText("单据打印：未打印");
                    }else if (vDate.getData().getPacking().getBillPrint().equals("1")){
                        tvDjdy.setText("单据打印：已打印");
                    }else if (vDate.getData().getPacking().getBillPrint().equals("2")){
                        tvDjdy.setText("单据打印：补打");
                    }

                }
                //打印次数
                if (!(vDate.getData().getPacking().getPrintTimes()==null||vDate.getData().getPacking().getPrintTimes().equals(""))) {
                    tvDycs.setText("打印次数："+vDate.getData().getPacking().getPrintTimes()+"次");
                }

                //Sales order
                if (!Kits.Empty.check(vDate.getData().getPacking().getSalesOrder())) {
                    tv_order.setText("Sales order："+vDate.getData().getPacking().getSalesOrder());
                }


                //comments
                if (!Kits.Empty.check(vDate.getData().getPacking().getComments())) {
                    tv_comments.setText("comments："+vDate.getData().getPacking().getComments());
                }

                //组装日期
                if (!Kits.Empty.check(vDate.getData().getPacking().getInstallTime())) {

                    long itimes= Long.parseLong(vDate.getData().getPacking().getInstallTime());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                    String timeText=format.format(itimes);
                    tv_zzrq.setText("组装日期"+timeText+"");

                }

                //订单交货期
                if (!Kits.Empty.check(vDate.getData().getPacking().getDeliveryDate())) {

                    long itimess= Long.parseLong(vDate.getData().getPacking().getDeliveryDate());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                    String timeText=format.format(itimess);
                    tv_ddjhq.setText("订单交货期："+timeText+"");
                }

            }


            //库位编号
            if (!(vDate.getData().getFreeLoc()==null||vDate.getData().getFreeLoc().equals(""))) {
                tvKwNumber.setText(vDate.getData().getFreeLoc());
            }

            //装箱单号
            if (!(vDate.getData().getPackingCode()==null||vDate.getData().getPackingCode().equals(""))) {
                tvNumber.setText(vDate.getData().getPackingCode());
            }
            //装箱单ID
//        if (!(vDate.getData().getPackingId())) {
//            tvZxdid.setText(vDate.getData().getPackingId());
//        }

            //仓库名称
            if (!(vDate.getData().getStorehouseName()==null||vDate.getData().getStorehouseName().equals(""))) {
                tvCkmc.setText(vDate.getData().getStorehouseName());
            }
            //仓库ID
//        if (!(vDate.getData().getStorehouseId())) {
//            tvCkid.setText(vDate.getData().getStorehouseId());
//        }
            //备注
            if (!(vDate.getData().getRemark()==null||vDate.getData().getRemark().equals(""))) {
                tvBz.setText(vDate.getData().getRemark());
            }


            //添加下面的列表
            if (vDate.getData().getPacking()!=null){
                if (vDate.getData().getPacking().getPackingItems()!=null ){
                    if ( vDate.getData().getPacking().getPackingItems().size()>0){
                        list.clear();
                        list.addAll(vDate.getData().getPacking().getPackingItems());
                        adapter_soItem.notifyDataSetChanged();
                    }

                }
            }


        }



    }


    //没有查询到数据的时候
    @Override
    public void showwsj() {
        scrollView.setVisibility(View.GONE);
        ll_wsj.setVisibility(View.VISIBLE);
    }

    //作废请求以后返回的操作
    @Override
    public void showdelete(DeleteOUTdetailVO result) {
        if (!Kits.Empty.check(result)){
            if (!Kits.Empty.check(result.getSuccess())){
                if (result.getSuccess().equals("T")){
                    Toast.makeText(MyOutDetailActivity.this,"此单已作废",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MyOutDetailActivity.this,result.getMessage(),Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(MyOutDetailActivity.this,"操作失败",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(MyOutDetailActivity.this,"操作失败",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void loadingtext() {
        loading("正在加载...");
    }

    @Override
    public void loadWanCheng() {
        loadingComplete();
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
