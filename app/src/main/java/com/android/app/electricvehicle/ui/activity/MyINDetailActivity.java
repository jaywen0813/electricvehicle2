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
import com.android.app.electricvehicle.entity.MyInVO;
import com.android.app.electricvehicle.model.main.contract.MyInDetailContract;
import com.android.app.electricvehicle.model.main.presenter.MyINDetailPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;

import java.text.SimpleDateFormat;
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

    private ScrollView scrollView;
    private LinearLayout ll_wsj;




    MyINDetailPresenter presenter;

    String id = "";
    String packingCode="";

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

        scrollView=findViewById(R.id.scrollView);//有数据的时候显示
        ll_wsj=findViewById(R.id.ll_wsj);//无数据

        backLayout.setOnClickListener(this);

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


        tvLayerHead.setText("入库详情");


        id = getIntent().getStringExtra("id");
        packingCode=getIntent().getStringExtra("packingCode");

//        id="5780b01ae92111e992930242ac110012";

        presenter.getUP(id,packingCode);

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
        }
    }

    //获取到详情数据以后
    @Override
    public void showSuccess(ItemDetailInVO  vDate) {



        if (!Kits.Empty.check(vDate.getData())){
            scrollView.setVisibility(View.VISIBLE);
            ll_wsj.setVisibility(View.GONE);

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
        }





    }

    //没有查询到数据的时候
    @Override
    public void showwsj() {
        scrollView.setVisibility(View.GONE);
        ll_wsj.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
