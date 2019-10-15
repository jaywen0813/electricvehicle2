package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
import com.android.app.electricvehicle.model.main.contract.ZxdlrDetailContract;
import com.android.app.electricvehicle.model.main.presenter.ZxdlrDetailPresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;

import java.text.SimpleDateFormat;

public class ZxdlrDetailActivity extends BaseMvpActivity<ZxdlrDetailContract.View, ZxdlrDetailPresenter> implements ZxdlrDetailContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private ScrollView scrollView;
    private TextView tvGzdh;
    private TextView tvDate;
    private TextView tvNumber;
    private EditText tvBzfs;
    private EditText tvDjx;
    private EditText tvGjx;
    private EditText tvChang;
    private EditText tvKuan;
    private EditText tvGao;
    private EditText tvJingzhong;
    private EditText tvMaozhong;
    private TextView tvZhuangtai;
    private EditText tvRl;
    private EditText tvAgl;
    private EditText tvQty;
    private EditText tvSo;
    private EditText tvMaterial;
    private TextView tvTotalWeight;
    private TextView tvDjgd;
    private TextView tvDjdy;
    private TextView tvDycs;
    private TextView tvBz;
    private LinearLayout llWsj;


    String id = "";
    ZxdlrDetailPresenter presenter;

    boolean aa=false;//用来判断是否可以点击的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_zxdlr_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        scrollView = findViewById(R.id.scrollView);
        tvGzdh = findViewById(R.id.tv_gzdh);
        tvDate = findViewById(R.id.tv_date);
        tvNumber = findViewById(R.id.tv_number);
        tvBzfs = findViewById(R.id.tv_bzfs);//包装方式
        tvDjx = findViewById(R.id.tv_djx);
        tvGjx = findViewById(R.id.tv_gjx);
        tvChang = findViewById(R.id.tv_chang);
        tvKuan = findViewById(R.id.tv_kuan);
        tvGao = findViewById(R.id.tv_gao);
        tvJingzhong = findViewById(R.id.tv_jingzhong);
        tvMaozhong = findViewById(R.id.tv_maozhong);
        tvZhuangtai = findViewById(R.id.tv_zhuangtai);
        tvRl = findViewById(R.id.tv_rl);
        tvAgl = findViewById(R.id.tv_agl);
        tvQty = findViewById(R.id.tv_qty);
        tvSo = findViewById(R.id.tv_so);
        tvMaterial = findViewById(R.id.tv_material);
        tvTotalWeight = findViewById(R.id.tv_totalWeight);
        tvDjgd = findViewById(R.id.tv_djgd);
        tvDjdy = findViewById(R.id.tv_djdy);
        tvDycs = findViewById(R.id.tv_dycs);
        tvBz = findViewById(R.id.tv_bz);
        llWsj = findViewById(R.id.ll_wsj);

        backLayout.setOnClickListener(this);
        farmInputSave.setOnClickListener(this);//修改按钮

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


        tvLayerHead.setText("装箱单详情");


        id = getIntent().getStringExtra("id");


//        id="5780b01ae92111e992930242ac110012";

        presenter.getUP(id);


        //一开始不让修改
        chooseFlase();

    }

    @Override
    protected ZxdlrDetailPresenter initPresenter() {
        presenter = new ZxdlrDetailPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.farm_input_save:
                    if (aa){
                        chooseFlase();//不能点击
                        aa=false;
                        farmInputSave.setText("修改");
                    }else {
                        chooseTrue();//可以点击
                        aa=true;
                        farmInputSave.setText("完成");
                    }
                break;
        }
    }

    @Override
    public void showSuccess(ZxdlrDetailVO vDate) {
        if (!Kits.Empty.check(vDate.getData())) {
            scrollView.setVisibility(View.VISIBLE);
            llWsj.setVisibility(View.GONE);


            //工作单号
            if (!Kits.Empty.check(vDate.getData().getWorkCode())) {
                tvGzdh.setText(vDate.getData().getWorkCode());
            }
            //日期
            if (!Kits.Empty.check(vDate.getData().getMadeTime())) {

                long itime = Long.parseLong(vDate.getData().getMadeTime());

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                String timeText = format.format(itime);
                tvDate.setText(timeText + "");
            }

            //第几箱
            if (!Kits.Empty.check(vDate.getData().getRankNum())) {
                tvDjx.setText(vDate.getData().getRankNum() + "");
            }

            //共几箱
            if (!Kits.Empty.check(vDate.getData().getTotalNum())) {
                tvGjx.setText(vDate.getData().getTotalNum() + "");
            }

            //长
            if (!Kits.Empty.check(vDate.getData().getPackLength())) {
                tvChang.setText(vDate.getData().getPackLength());
            }
            //宽
            if (!Kits.Empty.check(vDate.getData().getPackwidth())) {
                tvKuan.setText(vDate.getData().getPackwidth());
            }
            //高
            if (!Kits.Empty.check(vDate.getData().getPackHeight())) {
                tvGao.setText(vDate.getData().getPackHeight());
            }
            //净重
            if (!Kits.Empty.check(vDate.getData().getNetWeight())) {
                tvJingzhong.setText(vDate.getData().getNetWeight());
            }
            //毛重
            if (!Kits.Empty.check(vDate.getData().getRoughWeight())) {
                tvMaozhong.setText(vDate.getData().getRoughWeight());
            }


            //状态(0暂存  1待入库  2已入库  3已出库)
            if (!Kits.Empty.check(vDate.getData().getStoreState())) {
                switch (vDate.getData().getStoreState()) {
                    case "0":
                        tvZhuangtai.setText("暂存");
                        break;

                    case "1":
                        tvZhuangtai.setText("待入库");
                        break;
                    case "2":
                        tvZhuangtai.setText("已入库");
                        break;
                    case "3":
                        tvZhuangtai.setText("已出库");
                        break;

                }


            }

            //单据归档 0否  1是
            if (!Kits.Empty.check(vDate.getData().getBillArchived())) {
                if (vDate.getData().getBillArchived().equals("0")) {
                    tvDjgd.setText("单据归档:否");
                } else if (vDate.getData().getBillArchived().equals("1")) {
                    tvDjgd.setText("单据归档:是");
                }

            }else {
                tvDjgd.setText("单据归档:");
            }

            //单据打印
            if (!Kits.Empty.check(vDate.getData().getBillPrint())) {
                if (vDate.getData().getBillPrint().equals("0")) {
                    tvDjdy.setText("单据打印:未打印");
                } else if (vDate.getData().getBillPrint().equals("1")) {
                    tvDjdy.setText("单据打印:已打印");
                } else if (vDate.getData().getBillPrint().equals("2")) {
                    tvDjdy.setText("单据打印:补打");
                }

            }else {
                tvDjdy.setText("单据打印:");
            }
            //打印次数
            if (!Kits.Empty.check(vDate.getData().getPrintTimes())) {
                tvDycs.setText("打印次数:"+vDate.getData().getPrintTimes() + "次");
            }else {
                tvDycs.setText("打印次数:");
            }


            //装箱单号
            if (!Kits.Empty.check(vDate.getData().getPackingCode())) {
                tvNumber.setText(vDate.getData().getPackingCode());
            }

            //SO Item
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getSoItem())) {
                tvSo.setText(vDate.getData().getPackingListItems().get(0).getSoItem());
            }

            //Material
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getMaterial())) {
                tvMaterial.setText(vDate.getData().getPackingListItems().get(0).getMaterial());
            }


            //RL
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getRl())) {
                tvRl.setText(vDate.getData().getPackingListItems().get(0).getRl());
            }

            //AGL
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getAgl())) {
                tvAgl.setText(vDate.getData().getPackingListItems().get(0).getAgl());
            }

            //Qty
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getQty())) {
                tvQty.setText(vDate.getData().getPackingListItems().get(0).getQty());
            }


            //总重量
            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getTotalWeight())) {
                tvTotalWeight.setText(vDate.getData().getPackingListItems().get(0).getTotalWeight());
            }

            //包装方式

            if (!Kits.Empty.check(vDate.getData().getPackingMaterial())) {
                switch (vDate.getData().getPackingMaterial()) {
                    case "0":
                        tvBzfs.setText("纸箱");
                        break;
                    case "1":
                        tvBzfs.setText("木箱");
                        break;
                    case "2":
                        tvBzfs.setText("木托盘纸箱");
                        break;
                    default:
                        tvBzfs.setText("");
                        break;
                }


            }


            //备注
            if (!Kits.Empty.check(vDate.getData().getRemark())) {
                tvBz.setText(vDate.getData().getRemark());
            }
        }
    }

    @Override
    public void showwsj() {
        scrollView.setVisibility(View.GONE);
        llWsj.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }


    //可以编辑
    public void chooseTrue(){
        tvBzfs.setEnabled(true);
        tvDjx.setEnabled(true);
        tvGjx.setEnabled(true);
        tvChang.setEnabled(true);
        tvKuan.setEnabled(true);
        tvGao.setEnabled(true);
        tvJingzhong.setEnabled(true);
        tvMaozhong.setEnabled(true);
        tvRl.setEnabled(true);
        tvAgl.setEnabled(true);
        tvQty.setEnabled(true);
        tvSo.setEnabled(true);
        tvMaterial.setEnabled(true);
    }
    //不可以编辑
    public void chooseFlase(){
        tvBzfs.setEnabled(false);
        tvDjx.setEnabled(false);
        tvGjx.setEnabled(false);
        tvChang.setEnabled(false);
        tvKuan.setEnabled(false);
        tvGao.setEnabled(false);
        tvJingzhong.setEnabled(false);
        tvMaozhong.setEnabled(false);
        tvRl.setEnabled(false);
        tvAgl.setEnabled(false);
        tvQty.setEnabled(false);
        tvSo.setEnabled(false);
        tvMaterial.setEnabled(false);
    }
}
