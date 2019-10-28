package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.DeleteInDetailVO;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.MyInVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.presenter.MyINDetailPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.adapter.MyInDetailAdapter_SoItem;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//我的入库单列表点进来的详情
public class MyINDetailActivity extends BaseMvpActivity<MyInDetailContract.View, MyINDetailPresenter> implements MyInDetailContract.View, View.OnClickListener {

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
    private ListView lv;

    private ScrollView scrollView;
    private LinearLayout ll_wsj;
    private ImageView img_delete;
    private TextView tv_delete;

    private TextView tv_order;
    private TextView tv_comments;
    private TextView tv_zzrq;
    private TextView tv_ddjhq;

    MyINDetailPresenter presenter;

    String id = "";
    String packingCode="";

    List<ItemDetailInVO.DataBean.PackingListBean.PackingListItemsBean> list = new ArrayList<>();
    MyInDetailAdapter_SoItem adapter_soItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_my_indetail;
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

        lv = findViewById(R.id.lv);
        scrollView=findViewById(R.id.scrollView);//有数据的时候显示
        ll_wsj=findViewById(R.id.ll_wsj);//无数据
        img_delete=findViewById(R.id.img_delete);//删除按钮


          tv_order=findViewById(R.id.tv_order);
          tv_comments=findViewById(R.id.tv_comments);
          tv_zzrq=findViewById(R.id.tv_zzrq);
          tv_ddjhq=findViewById(R.id.tv_ddjhq);


        backLayout.setOnClickListener(this);
        tv_delete.setOnClickListener(this);

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


        tvLayerHead.setText("入库详情");


        id = getIntent().getStringExtra("id");
        packingCode=getIntent().getStringExtra("packingCode");

//        id="5780b01ae92111e992930242ac110012";

        presenter.getUP(id,packingCode);


        adapter_soItem = new MyInDetailAdapter_SoItem(this, list);
        lv.setAdapter(adapter_soItem);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected MyINDetailPresenter initPresenter() {
        presenter = new MyINDetailPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.tv_delete://删除按钮
                DialogUtil.showBasicDialog(this, "作废提示", "确定作废此条入库单?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter.deleteThis(id,packingCode);
                    }
                    dialog.dismiss();
                });
                break;
        }
    }

    //获取到详情数据以后
    @Override
    public void showSuccess(ItemDetailInVO  vDate) {



        if (!Kits.Empty.check(vDate.getData())){
            scrollView.setVisibility(View.VISIBLE);
            ll_wsj.setVisibility(View.GONE);



            //查询此单是否作废
            if (!Kits.Empty.check(vDate.getData().getDisabled())){
                if (vDate.getData().getDisabled().equals("true")){//代表作废

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


            if (!Kits.Empty.check(vDate.getData().getPackingList())){
                //工作单号
                if (!Kits.Empty.check(vDate.getData().getPackingList().getWorkCode())){
                    tvGzdh.setText(vDate.getData().getPackingList().getWorkCode());
                }
                //日期
                if (!Kits.Empty.check(vDate.getData().getPackingList().getMadeTime())){

                    long itime= Long.parseLong(vDate.getData().getPackingList().getMadeTime());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                    String timeText=format.format(itime);
                    tvDate.setText(timeText+"");
                }

                //第几箱
                if (!Kits.Empty.check(vDate.getData().getPackingList().getRankNum())) {
                    tvDjx.setText("第  "+vDate.getData().getPackingList().getRankNum()+"  箱");
                }

                //共几箱
                if (!Kits.Empty.check(vDate.getData().getPackingList().getTotalNum())) {
                    tvGjx.setText("共  "+vDate.getData().getPackingList().getTotalNum()+"  箱");
                }

                //长
                if (!Kits.Empty.check(vDate.getData().getPackingList().getPackLength())) {
                    tvChang.setText("长："+vDate.getData().getPackingList().getPackLength());
                }
                //宽
                if (!Kits.Empty.check(vDate.getData().getPackingList().getPackwidth())) {
                    tvKuan.setText("宽："+vDate.getData().getPackingList().getPackwidth());
                }
                //高
                if (!Kits.Empty.check(vDate.getData().getPackingList().getPackHeight())) {
                    tvGao.setText("高:"+vDate.getData().getPackingList().getPackHeight());
                }
                //净重
                if (!Kits.Empty.check(vDate.getData().getPackingList().getNetWeight())) {
                    tvJingzhong.setText("净重："+vDate.getData().getPackingList().getNetWeight());
                }
                //毛重
                if (!Kits.Empty.check(vDate.getData().getPackingList().getRoughWeight())) {
                    tvMaozhong.setText("毛重："+vDate.getData().getPackingList().getRoughWeight());
                }


                //状态(0暂存  1待入库  2已入库  3已出库)
                if (!Kits.Empty.check(vDate.getData().getPackingList().getStoreState())) {
                    switch (vDate.getData().getPackingList().getStoreState()){
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
                if (!Kits.Empty.check(vDate.getData().getPackingList().getBillArchived())) {
                    if (vDate.getData().getPackingList().getBillArchived().equals("0")){
                        tvDjgd.setText("单据归档：否");
                    }else if (vDate.getData().getPackingList().getBillArchived().equals("1")){
                        tvDjgd.setText("单据归档：是");
                    }

                }

                //单据打印
                if (!Kits.Empty.check(vDate.getData().getPackingList().getBillPrint())) {
                    if (vDate.getData().getPackingList().getBillPrint().equals("0")){
                        tvDjdy.setText("单据打印：未打印");
                    }else if (vDate.getData().getPackingList().getBillPrint().equals("1")){
                        tvDjdy.setText("单据打印：已打印");
                    }else if (vDate.getData().getPackingList().getBillPrint().equals("2")){
                        tvDjdy.setText("单据打印：补打");
                    }

                }
                //打印次数
                if (!Kits.Empty.check(vDate.getData().getPackingList().getPrintTimes())) {
                    tvDycs.setText("打印次数："+vDate.getData().getPackingList().getPrintTimes()+"次");
                }



                //Sales order
                if (!Kits.Empty.check(vDate.getData().getPackingList().getSalesOrder())) {
                    tv_order.setText("Sales order："+vDate.getData().getPackingList().getSalesOrder());
                }


                //comments
                if (!Kits.Empty.check(vDate.getData().getPackingList().getComments())) {
                    tv_comments.setText("comments："+vDate.getData().getPackingList().getComments());
                }

                //组装日期
                if (!Kits.Empty.check(vDate.getData().getPackingList().getInstallTime())) {

                    long itimes= Long.parseLong(vDate.getData().getPackingList().getInstallTime());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                    String timeText=format.format(itimes);
                    tv_zzrq.setText("组装日期"+timeText+"");


                }

                //订单交货期
                if (!Kits.Empty.check(vDate.getData().getPackingList().getDeliveryDate())) {

                    long itimess= Long.parseLong(vDate.getData().getPackingList().getDeliveryDate());

                    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                    String timeText=format.format(itimess);
                    tv_ddjhq.setText("订单交货期："+timeText+"");
                }



            }

            //租户ID
//        if (!Kits.Empty.check(vDate.getData().getTenantId())){
//            tvZhid.setText(vDate.getData().getTenantId());
//        }


            //装箱单号
            if (!Kits.Empty.check(vDate.getData().getPackingCode())) {
                tvNumber.setText(vDate.getData().getPackingCode());
            }
            //装箱单ID
//        if (!Kits.Empty.check(vDate.getData().getPackingListId())) {
//            tvZxdid.setText(vDate.getData().getPackingListId());
//        }

            //仓库名称
            if (!Kits.Empty.check(vDate.getData().getStorehouseName())) {
                tvCkmc.setText(vDate.getData().getStorehouseName());
            }
            //仓库ID
//        if (!Kits.Empty.check(vDate.getData().getStorehouseId())) {
//            tvCkid.setText(vDate.getData().getStorehouseId());
//        }

            //库位编号
            if (!Kits.Empty.check(vDate.getData().getFreeLoc())) {
                tvKwNumber.setText(vDate.getData().getFreeLoc());
            }


            //备注
            if (!Kits.Empty.check(vDate.getData().getRemark())) {
                tvBz.setText(vDate.getData().getRemark());
            }

            //添加下面的列表
            if (vDate.getData().getPackingList().getPackingListItems()!=null && vDate.getData().getPackingList().getPackingListItems().size()>0){
                list.clear();
                list.addAll(vDate.getData().getPackingList().getPackingListItems());
                adapter_soItem.notifyDataSetChanged();
            }


        }





    }

    //没有查询到数据的时候
    @Override
    public void showwsj() {
        scrollView.setVisibility(View.GONE);
        ll_wsj.setVisibility(View.VISIBLE);
    }

    //删除以后返回的方法
    @Override
    public void showdelete(DeleteInDetailVO result) {
        if (!Kits.Empty.check(result)){
            if (!Kits.Empty.check(result.getSuccess())){
                if (result.getSuccess().equals("T")){
                    Toast.makeText(MyINDetailActivity.this,"此单已作废",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MyINDetailActivity.this,result.getMessage(),Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(MyINDetailActivity.this,"操作失败",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(MyINDetailActivity.this,"操作失败",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
