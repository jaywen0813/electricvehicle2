package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.PackingListItem;
import com.android.app.electricvehicle.entity.ZxdDetailDeleteVO;
import com.android.app.electricvehicle.entity.ZxdDetailUpdateVO;
import com.android.app.electricvehicle.entity.ZxdlrDetailVO;
import com.android.app.electricvehicle.model.main.contract.ZxdlrDetailContract;
import com.android.app.electricvehicle.model.main.presenter.ZxdlrDetailPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.adapter.ZXDDetailAdapter;
import com.android.app.electricvehicle.utils.DateTimeWheelDialog;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ZxdlrDetailActivity extends BaseListActivity<ZxdlrDetailContract.View, ZxdlrDetailPresenter> implements ZxdlrDetailContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private ScrollView scrollView;
    private TextView tvGzdh;
    private TextView tvDate;
    private TextView tvNumber;
    private Spinner sp_bzfs;
    private EditText tvDjx;
    private EditText tvGjx;
    private EditText tvChang;
    private EditText tvKuan;
    private EditText tvGao;
    private EditText tvJingzhong;
    private EditText tvMaozhong;
    private TextView tvZhuangtai;
    //    private EditText tvRl;
//    private EditText tvAgl;
//    private EditText tvQty;
//    private EditText tvSo;
//    private EditText tvMaterial;
    private TextView tvTotalWeight;
    private TextView tvDjgd;
    private TextView tvDjdy;
    private TextView tvDycs;
    private TextView tvBz;
    private LinearLayout llWsj;
    private ImageView img_delete;
    private TextView tv_delete;

    private SwipeRefreshLayout srlList;
    private RecyclerView rvList;

    private List<ZxdlrDetailVO.DataBean.PackingListItemsBean> activityVOList = new ArrayList<>();

    List<PackingListItem> packingListItem = new ArrayList<>();//用来存储列表的数据的

    String id = "";
    String disabled = "";
    ZxdlrDetailPresenter presenter;

    boolean aa = false;//用来判断是否可以点击的编辑的

    String baozhuangfangshi = "";//用来记录后台返回的默认的包装方式

    int itemLength = 0;//记录长度


    EditText tvSo;
    EditText tvMaterial;
    EditText tvRl;
    EditText tvAgl;
    EditText tvQty;

    String packingMaterial="";//包装方式


    EditText tv_order;
    EditText tv_comments;
    TextView tv_zzrq;
    TextView tv_ddjhq;


    DateTimeWheelDialog dialog3 = null;
    DateTimeWheelDialog dialog4 = null;
    String sjc="";//
    String sjc2="";//订单交货期时间戳


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
        sp_bzfs=findViewById(R.id.sp_bzfs);
        tvDjx = findViewById(R.id.tv_djx);
        tvGjx = findViewById(R.id.tv_gjx);
        tvChang = findViewById(R.id.tv_chang);
        tvKuan = findViewById(R.id.tv_kuan);
        tvGao = findViewById(R.id.tv_gao);
        tvJingzhong = findViewById(R.id.tv_jingzhong);
        tvMaozhong = findViewById(R.id.tv_maozhong);
        tvZhuangtai = findViewById(R.id.tv_zhuangtai);
        tv_delete=findViewById(R.id.tv_delete);//作废按钮
//        tvRl = findViewById(R.id.tv_rl);
//        tvAgl = findViewById(R.id.tv_agl);
//        tvQty = findViewById(R.id.tv_qty);
//        tvSo = findViewById(R.id.tv_so);
//        tvMaterial = findViewById(R.id.tv_material);
        tvTotalWeight = findViewById(R.id.tv_totalWeight);
        tvDjgd = findViewById(R.id.tv_djgd);
        tvDjdy = findViewById(R.id.tv_djdy);
        tvDycs = findViewById(R.id.tv_dycs);
        tvBz = findViewById(R.id.tv_bz);
        llWsj = findViewById(R.id.ll_wsj);
        img_delete = findViewById(R.id.img_delete);//作废图标

        tv_order= findViewById(R.id.tv_order);
        tv_comments= findViewById(R.id.tv_comments);
        tv_zzrq= findViewById(R.id.tv_zzrq);
        tv_ddjhq= findViewById(R.id.tv_ddjhq);


        srlList = findViewById(R.id.srl_list);
        rvList = findViewById(R.id.rv_list);

        backLayout.setOnClickListener(this);
        farmInputSave.setOnClickListener(this);//修改按钮
        tv_delete.setOnClickListener(this);//作废按钮
        tv_zzrq.setOnClickListener(this);
        tv_ddjhq.setOnClickListener(this);

        //状态栏
        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，


        tvLayerHead.setText("装箱单详情");


        id = getIntent().getStringExtra("id");
        disabled = getIntent().getStringExtra("disabled");


        if (disabled.equals("true")) {//代表作废
            img_delete.setImageResource(R.mipmap.img_zuofei);
            img_delete.setVisibility(View.VISIBLE);//显示作废图标
            tv_delete.setEnabled(false);
            tv_delete.setVisibility(View.INVISIBLE);//隐藏作废按钮
            farmInputSave.setVisibility(View.INVISIBLE);//隐藏修改按钮

        } else {//代表没有作废
            img_delete.setVisibility(View.INVISIBLE);//隐藏作废图标
            tv_delete.setEnabled(true);
            tv_delete.setVisibility(View.VISIBLE);//显示作废按钮
            farmInputSave.setVisibility(View.VISIBLE);//显示修改按钮
        }

//        id="5780b01ae92111e992930242ac110012";

        presenter.getUP(id);





        sp_bzfs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.baozhuangfangshi);
//                Toast.makeText(ZxdLuRuActivity.this, "你点击的是:"+languages[pos], Toast.LENGTH_LONG).show();

                packingMaterial=languages[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        String[] spinnerItems = {"纸箱","木箱","木托盘纸箱"};
        //自定义选择填充后的字体样式
        //只能是textview样式，否则报错：ArrayAdapter requires the resource ID to be a TextView
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                R.layout.item_select, spinnerItems);
        //自定义下拉的字体样式
        spinnerAdapter.setDropDownViewResource(R.layout.item_drop);
        //这个在不同的Theme下，显示的效果是不同的
        //spinnerAdapter.setDropDownViewTheme(Theme.LIGHT);
        sp_bzfs.setAdapter(spinnerAdapter);


        //一开始不让修改
        chooseFlase();

    }


    @Override
    protected BasePresenter getPresenter() {
        presenter = new ZxdlrDetailPresenter();
        return presenter;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new ZXDDetailAdapter(activityVOList, this, packingListItem, id);
    }

    @Override
    protected void refresh() {
        presenter.getUP(id);
    }

    @Override
    protected void loadMore() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.farm_input_save:
                if (aa) {
                    chooseFlase();//不能点击
                    aa = false;
                    farmInputSave.setText("修改");//文字变成修改

                    String madeTime = String.valueOf(new Date().getTime());//当前时间戳
//                    String packingMaterial = tvBzfs.getText().toString().trim();//包装方式 去除多余的空隙
                    String rankNum = tvDjx.getText().toString();//第几箱
                    String totalNum = tvGjx.getText().toString();//共几箱
                    String packLength = tvChang.getText().toString();//长
                    String packwidth = tvKuan.getText().toString();//宽
                    String packHeight = tvGao.getText().toString();//高
                    String netWeight = tvJingzhong.getText().toString();//净重
                    String roughWeight = tvMaozhong.getText().toString();//毛重
                    String salesOrder=tv_order.getText().toString(); //Sales order
                    String comments=tv_comments.getText().toString(); //comments
                    String installTime=sjc; //组装日期
                    String deliveryDate=sjc2; //订单交货期


                    if (Kits.Empty.check(packingMaterial)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "包装方式不能为空", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        if (packingMaterial.equals("纸箱") || packingMaterial.equals("0")) {
                            packingMaterial = "0";
                        } else if (packingMaterial.equals("木箱") || packingMaterial.equals("1")) {
                            packingMaterial = "1";
                        } else if (packingMaterial.equals("木托盘纸箱") || packingMaterial.equals("2")) {
                            packingMaterial = "2";
                        } else {
                            packingMaterial = baozhuangfangshi;//如果识别不了就返回后台默认的
                        }
                    }


                    if (Kits.Empty.check(rankNum)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "第几箱不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }


                    if (Kits.Empty.check(totalNum)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "共几箱不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }


                    if (Kits.Empty.check(packLength)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "请填写长度", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(packwidth)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "请填写宽度", Toast.LENGTH_LONG).show();
                        return;
                    }


                    if (Kits.Empty.check(packHeight)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "请填写高度", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(netWeight)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "请填写净重", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(roughWeight)) {
                        Toast.makeText(ZxdlrDetailActivity.this, "请填写毛重", Toast.LENGTH_LONG).show();
                        return;
                    }
                    //------------------------
                    if (Kits.Empty.check(salesOrder)) {
                        Toast.makeText(ZxdlrDetailActivity.this,"请填写Sales Order",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(comments)) {
                        Toast.makeText(ZxdlrDetailActivity.this,"请填写comments",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(installTime)) {
                        Toast.makeText(ZxdlrDetailActivity.this,"请填写组装日期",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(deliveryDate)) {
                        Toast.makeText(ZxdlrDetailActivity.this,"请填写订单交货期",Toast.LENGTH_LONG).show();
                        return;
                    }


                    //证明下面有数据，这个时候需要校验
                    if (itemLength > 0) {


                        for (int i = 0; i < rvList.getChildCount(); i++) {
                            View childAt = rvList.getChildAt(i);

                            tvSo = childAt.findViewById(R.id.tv_so);
                            tvMaterial = childAt.findViewById(R.id.tv_material);
                            tvRl = childAt.findViewById(R.id.tv_rl);
                            tvAgl = childAt.findViewById(R.id.tv_agl);
                            tvQty = childAt.findViewById(R.id.tv_qty);

                            String soItem = tvSo.getText().toString()==null?"":tvSo.getText().toString();
                            String material = tvMaterial.getText().toString()==null?"":tvMaterial.getText().toString();
                            String rl = tvRl.getText().toString()==null?"":tvRl.getText().toString();
                            String agl = tvAgl.getText().toString()==null?"":tvAgl.getText().toString();
                            String qty = tvQty.getText().toString()==null?"":tvQty.getText().toString();

                            if (Kits.Empty.check(soItem)) {
                                Toast.makeText(ZxdlrDetailActivity.this, "请填写SO Item", Toast.LENGTH_LONG).show();
                                return;
                            }


                            if (Kits.Empty.check(material)) {
                                Toast.makeText(ZxdlrDetailActivity.this, "请填写Material", Toast.LENGTH_LONG).show();
                                return;
                            }


                            if (Kits.Empty.check(rl)) {
                                Toast.makeText(ZxdlrDetailActivity.this, "请填写RL", Toast.LENGTH_LONG).show();
                                return;
                            }

                            if (Kits.Empty.check(agl)) {
                                Toast.makeText(ZxdlrDetailActivity.this, "请填写AGL", Toast.LENGTH_LONG).show();
                                return;
                            }


                            if (Kits.Empty.check(qty)) {
                                Toast.makeText(ZxdlrDetailActivity.this, "请填写Qty", Toast.LENGTH_LONG).show();
                                return;
                            }

                            PackingListItem plist = new PackingListItem();
                            plist.setId(id);
                            plist.setSoItem(soItem);
                            plist.setMaterial(material);
                            plist.setRl(rl);
                            plist.setAgl(agl);
                            plist.setQty(qty);

                            packingListItem.add(plist);


                        }

                    }


                    //修改的网络请求
                    presenter.update(id, madeTime, packingMaterial, rankNum, totalNum, packLength, packwidth, packHeight, netWeight, roughWeight, packingListItem,salesOrder,comments,installTime,deliveryDate);


                } else {
                    chooseTrue();//可以点击
                    aa = true;
                    farmInputSave.setText("完成");


                }
                break;
            case R.id.tv_delete://删除按钮
                DialogUtil.showBasicDialog(this, "作废提示", "确定作废此条装箱单?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter.deleteThis(id);
                    }
                    dialog.dismiss();
                });
                break;
            case R.id.tv_zzrq://组装日期
                if (dialog3 == null)
                    dialog3 = createDialog(3);
                else
                    dialog3.show(); //弹出自定义条件选择器
                break;
            case R.id.tv_ddjhq://订单交货期
                if (dialog4 == null)
                    dialog4 = createDialog2(3);
                else
                    dialog4.show(); //弹出自定义条件选择器
                break;
        }
    }

    @Override
    public void showSuccess(ZxdlrDetailVO vDate) {
        if (!Kits.Empty.check(vDate.getData())) {
            scrollView.setVisibility(View.VISIBLE);
            llWsj.setVisibility(View.GONE);

            srlList.setRefreshing(false);//停止刷新

            //查询此单是否作废
            if (!Kits.Empty.check(vDate.getData().getDisabled())) {
                if (vDate.getData().getDisabled().equals("true")) {//代表作废
                    img_delete.setImageResource(R.mipmap.img_zuofei);
                    img_delete.setVisibility(View.VISIBLE);//显示作废图标
                    tv_delete.setEnabled(false);
                    tv_delete.setVisibility(View.INVISIBLE);//隐藏作废按钮
                    farmInputSave.setVisibility(View.INVISIBLE);//隐藏修改按钮

                } else {
                    img_delete.setVisibility(View.INVISIBLE);//隐藏作废图标
                    tv_delete.setEnabled(true);
                    tv_delete.setVisibility(View.VISIBLE);//显示作废按钮
                    farmInputSave.setVisibility(View.VISIBLE);//显示修改按钮
                }
            }


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

            } else {
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

            } else {
                tvDjdy.setText("单据打印:");
            }
            //打印次数
            if (!Kits.Empty.check(vDate.getData().getPrintTimes())) {
                tvDycs.setText("打印次数:" + vDate.getData().getPrintTimes() + "次");
            } else {
                tvDycs.setText("打印次数:");
            }
            //Sales order
            if (!Kits.Empty.check(vDate.getData().getSalesOrder())) {
                tv_order.setText(vDate.getData().getSalesOrder());
            }


            //comments
            if (!Kits.Empty.check(vDate.getData().getComments())) {
                tv_comments.setText(vDate.getData().getComments());
            }

            //组装日期
            if (!Kits.Empty.check(vDate.getData().getInstallTime())) {

                long itimes= Long.parseLong(vDate.getData().getInstallTime());

                SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                String timeText=format.format(itimes);
                tv_zzrq.setText(timeText+"");

                sjc=vDate.getData().getInstallTime();
            }

            //订单交货期
            if (!Kits.Empty.check(vDate.getData().getDeliveryDate())) {

                long itimess= Long.parseLong(vDate.getData().getDeliveryDate());

                SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                String timeText=format.format(itimess);
                tv_ddjhq.setText(timeText+"");
                sjc2=vDate.getData().getDeliveryDate();
            }

            //装箱单号
            if (!Kits.Empty.check(vDate.getData().getPackingCode())) {
                tvNumber.setText(vDate.getData().getPackingCode());
            }

            //添加下面部分
            itemLength = vDate.getData().getPackingListItems().size();//记录长度

            if (vDate.getData().getPackingListItems() != null && vDate.getData().getPackingListItems().size() > 0) {
                //刷新
                activityVOList.clear();
                activityVOList.addAll(vDate.getData().getPackingListItems());
                adapter.notifyDataSetChanged();
            }


//            //SO Item
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getSoItem())) {
//                tvSo.setText(vDate.getData().getPackingListItems().get(0).getSoItem());
//            }
//
//            //Material
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getMaterial())) {
//                tvMaterial.setText(vDate.getData().getPackingListItems().get(0).getMaterial());
//            }
//
//
//            //RL
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getRl())) {
//                tvRl.setText(vDate.getData().getPackingListItems().get(0).getRl());
//            }
//
//            //AGL
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getAgl())) {
//                tvAgl.setText(vDate.getData().getPackingListItems().get(0).getAgl());
//            }

            //Qty
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getQty())) {
//                tvQty.setText(vDate.getData().getPackingListItems().get(0).getQty());
//            }


            //总重量
//            if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).getTotalWeight())) {
//                tvTotalWeight.setText(vDate.getData().getPackingListItems().get(0).getTotalWeight());
//            }

            //包装方式

            if (!Kits.Empty.check(vDate.getData().getPackingMaterial())) {
                switch (vDate.getData().getPackingMaterial()) {
                    case "0":
//                        tvBzfs.setText("纸箱");
                        sp_bzfs.setSelection(0,true);
                        break;
                    case "1":
//                        tvBzfs.setText("木箱");
                        sp_bzfs.setSelection(1,true);
                        break;
                    case "2":
//                        tvBzfs.setText("木托盘纸箱");
                        sp_bzfs.setSelection(2,true);
                        break;
                    default:
//                        tvBzfs.setText("");
                        break;
                }

                baozhuangfangshi = vDate.getData().getPackingMaterial();//用来记录后台返回的默认的包装方式
            }


            //备注
            if (!Kits.Empty.check(vDate.getData().getRemark())) {
                tvBz.setText(vDate.getData().getRemark());
            }
        }
    }

    //没有获取到详情数据的时候
    @Override
    public void showwsj() {
        scrollView.setVisibility(View.GONE);
        llWsj.setVisibility(View.VISIBLE);
    }

    //修改成功以后的
    @Override
    public void showToast(ZxdDetailUpdateVO zxdDetailUpdateVO) {
        if (!Kits.Empty.check(zxdDetailUpdateVO)) {
            if (!Kits.Empty.check(zxdDetailUpdateVO.getSuccess())) {
                if (zxdDetailUpdateVO.getSuccess().equals("T")) {
                    Toast.makeText(ZxdlrDetailActivity.this, "修改成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ZxdlrDetailActivity.this, zxdDetailUpdateVO.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(ZxdlrDetailActivity.this, "修改失败", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ZxdlrDetailActivity.this, "修改失败", Toast.LENGTH_LONG).show();
        }

    }

    //装箱单作废以后返回的方法
    @Override
    public void showdelete(ZxdDetailDeleteVO zxdDetailDeleteVO) {
        if (!Kits.Empty.check(zxdDetailDeleteVO)) {
            if (!Kits.Empty.check(zxdDetailDeleteVO.getSuccess())) {
                if (zxdDetailDeleteVO.getSuccess().equals("T")) {
                    Toast.makeText(ZxdlrDetailActivity.this, "此单已作废", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ZxdlrDetailActivity.this, zxdDetailDeleteVO.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(ZxdlrDetailActivity.this, "操作失败", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ZxdlrDetailActivity.this, "操作失败", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }


    //可以编辑
    public void chooseTrue() {
        sp_bzfs.setEnabled(true);
        tvDjx.setEnabled(true);
        tvGjx.setEnabled(true);
        tvChang.setEnabled(true);
        tvKuan.setEnabled(true);
        tvGao.setEnabled(true);
        tvJingzhong.setEnabled(true);
        tvMaozhong.setEnabled(true);
        tv_order.setEnabled(true);
        tv_comments.setEnabled(true);
        tv_zzrq.setEnabled(true);
        tv_ddjhq.setEnabled(true);
//        tvRl.setEnabled(true);
//        tvAgl.setEnabled(true);
//        tvQty.setEnabled(true);
//        tvSo.setEnabled(true);
//        tvMaterial.setEnabled(true);
    }

    //不可以编辑
    public void chooseFlase() {
        sp_bzfs.setEnabled(false);
        tvDjx.setEnabled(false);
        tvGjx.setEnabled(false);
        tvChang.setEnabled(false);
        tvKuan.setEnabled(false);
        tvGao.setEnabled(false);
        tvJingzhong.setEnabled(false);
        tvMaozhong.setEnabled(false);
        tv_order.setEnabled(false);
        tv_comments.setEnabled(false);
        tv_zzrq.setEnabled(false);
        tv_ddjhq.setEnabled(false);
//        tvRl.setEnabled(false);
//        tvAgl.setEnabled(false);
//        tvQty.setEnabled(false);
//        tvSo.setEnabled(false);
//        tvMaterial.setEnabled(false);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }


    //组装日期
    private DateTimeWheelDialog createDialog(int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date startDate = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2049);
        Date endDate = calendar.getTime();

        DateTimeWheelDialog dialog = new DateTimeWheelDialog(this);
//        dialog.setShowCount(7);
//        dialog.setItemVerticalSpace(24);
        dialog.show();
        dialog.setTitle("选择时间");
        int config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR_MINUTE;
        switch (type) {
            case 1:
                config = DateTimeWheelDialog.SHOW_YEAR;
                break;
            case 2:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH;
                break;
            case 3:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY;
                break;
            case 4:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR;
                break;
            case 5:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR_MINUTE;
                break;
        }
        dialog.configShowUI(config);
        dialog.setCancelButton("取消", null);
        dialog.setOKButton("确定", new DateTimeWheelDialog.OnClickCallBack() {
            @Override
            public boolean callBack(View v, @NonNull Date selectedDate) {
//                tv_zzrq.setText(SimpleDateFormat.getInstance().format(selectedDate));



                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String d = df.format(selectedDate);
                tv_zzrq.setText(d+"");//显示出来的  年月日

                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String d2 = df2.format(selectedDate);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                try {
                    date = dateFormat.parse(d2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                sjc=date.getTime()+ "";//时间戳






                return false;
            }
        });
        dialog.setDateArea(startDate, endDate, true);
        dialog.updateSelectedDate(new Date());
        return dialog;
    }


    //订单交货期
    private DateTimeWheelDialog createDialog2(int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date startDate = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2049);
        Date endDate = calendar.getTime();

        DateTimeWheelDialog dialog = new DateTimeWheelDialog(this);
//        dialog.setShowCount(7);
//        dialog.setItemVerticalSpace(24);
        dialog.show();
        dialog.setTitle("选择时间");
        int config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR_MINUTE;
        switch (type) {
            case 1:
                config = DateTimeWheelDialog.SHOW_YEAR;
                break;
            case 2:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH;
                break;
            case 3:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY;
                break;
            case 4:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR;
                break;
            case 5:
                config = DateTimeWheelDialog.SHOW_YEAR_MONTH_DAY_HOUR_MINUTE;
                break;
        }
        dialog.configShowUI(config);
        dialog.setCancelButton("取消", null);
        dialog.setOKButton("确定", new DateTimeWheelDialog.OnClickCallBack() {
            @Override
            public boolean callBack(View v, @NonNull Date selectedDate) {
//                tv_zzrq.setText(SimpleDateFormat.getInstance().format(selectedDate));



                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String d = df.format(selectedDate);
                tv_ddjhq.setText(d+"");//显示出来的  年月日

                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String d2 = df2.format(selectedDate);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Date date = new Date();
                try {
                    date = dateFormat.parse(d2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                sjc2=date.getTime()+ "";//时间戳






                return false;
            }
        });
        dialog.setDateArea(startDate, endDate, true);
        dialog.updateSelectedDate(new Date());
        return dialog;
    }
}
