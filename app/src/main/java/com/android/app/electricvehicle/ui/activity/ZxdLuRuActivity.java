package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.PackingItems;
import com.android.app.electricvehicle.entity.ZxdDetailAddVO;
import com.android.app.electricvehicle.model.main.contract.ZxdlrAddContract;
import com.android.app.electricvehicle.model.main.presenter.ZxdlrAddlPresenter;
import com.android.app.electricvehicle.utils.DateTimeWheelDialog;
import com.android.app.electricvehicle.utils.Kits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//首页的  已经作废  2020年7月4日 21:20:59
public class ZxdLuRuActivity extends BaseMvpActivity<ZxdlrAddContract.View, ZxdlrAddlPresenter> implements ZxdlrAddContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private ScrollView scrollView;
    private EditText tvGzdh;
    private TextView tvDate;

    private Spinner sp_bzfs;
    private EditText tvDjx;
    private EditText tvGjx;
    private EditText tvChang;
    private EditText tvKuan;
    private EditText tvGao;
    private EditText tvJingzhong;
    private EditText tvMaozhong;
    private LinearLayout llAdd;
    private ImageView imgAdd;


    ZxdlrAddlPresenter presenter;

    private int childCount = 0;//用来记录点击了几次添加下面的条目

    EditText tvSo ;
    EditText tvMaterial ;
    EditText tvRl ;
    EditText tvAgl ;
    EditText tvQty ;


    EditText tv_order;
    EditText tv_comments;
    TextView tv_zzrq;
    TextView tv_ddjhq;

    List<PackingItems> PackingItem =new ArrayList<>();//用来存储入参的



    String packingMaterial="";//包装方式

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
        return R.layout.activity_zxd_lu_ru;
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
        sp_bzfs=findViewById(R.id.sp_bzfs);
        tvDjx = findViewById(R.id.tv_djx);
        tvGjx = findViewById(R.id.tv_gjx);
        tvChang = findViewById(R.id.tv_chang);
        tvKuan = findViewById(R.id.tv_kuan);
        tvGao = findViewById(R.id.tv_gao);
        tvJingzhong = findViewById(R.id.tv_jingzhong);
        tvMaozhong = findViewById(R.id.tv_maozhong);
        llAdd = findViewById(R.id.ll_add);
        imgAdd = findViewById(R.id.img_add);


         tv_order= findViewById(R.id.tv_order);
         tv_comments= findViewById(R.id.tv_comments);
         tv_zzrq= findViewById(R.id.tv_zzrq);
         tv_ddjhq= findViewById(R.id.tv_ddjhq);

        backLayout.setOnClickListener(this);
        farmInputSave.setOnClickListener(this);
        imgAdd.setOnClickListener(this);
        tv_zzrq.setOnClickListener(this);
        tv_ddjhq.setOnClickListener(this);

        tvLayerHead.setText("添加装箱单");




        addViewItem();//先添加一条

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

    }


    @Override
    protected void initDate() {
        super.initDate();

    }

    @Override
    protected ZxdlrAddlPresenter initPresenter() {
        presenter=new ZxdlrAddlPresenter();
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                finish();
                break;
            case R.id.img_add://添加条目


                childCount++;//记录加了几条


                for (int i = 0; i <1 ; i++) {
                    View view2 = LayoutInflater.from(this).inflate(R.layout.item_zxdlr,null);
//                    final View childAt = llAdd.getChildAt(i);


//                    tvSo.setId(R.id.text_tvSo+i);//循环设置id
//                    tvMaterial.setId(R.id.text_tvMaterial+i);
//                    tvRl.setId(R.id.text_tvRl+i);
//                    tvAgl.setId(R.id.text_tvAgl+i);
//                    tvQty.setId(R.id.text_tvQty+i);

                    llAdd.addView(view2);//动态添加view


                }



                break;
            case R.id.farm_input_save://提交按钮

                String workCode=tvGzdh.getText().toString();//工作单号
                String madeTime= String.valueOf(new Date().getTime());//当前时间戳

//                String packingMaterial=tvBzfs.getText().toString().trim();//包装方式 去除多余的空隙

                String rankNum=tvDjx.getText().toString();//第几箱
                String totalNum=tvGjx.getText().toString();//共几箱
                String packLength=tvChang.getText().toString();//长
                String packwidth=tvKuan.getText().toString();//宽
                String packHeight=tvGao.getText().toString();//高
                String netWeight=tvJingzhong.getText().toString();//净重
                String roughWeight=tvMaozhong.getText().toString();//毛重
                 String salesOrder=tv_order.getText().toString(); //Sales order
                 String comments=tv_comments.getText().toString(); //comments
                 String installTime=sjc; //组装日期
                 String deliveryDate=sjc2; //订单交货期


                if (Kits.Empty.check(workCode)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写工作单号",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(packingMaterial)) {
                    Toast.makeText(ZxdLuRuActivity.this,"包装方式不能为空",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    if (packingMaterial.equals("纸箱")||packingMaterial.equals("0")){
                        packingMaterial="0";
                    }else if (packingMaterial.equals("木箱")||packingMaterial.equals("1")){
                        packingMaterial="1";
                    }else if (packingMaterial.equals("木托盘纸箱")||packingMaterial.equals("2")){
                        packingMaterial="2";
                    } else {
                        Toast.makeText(ZxdLuRuActivity.this,"包装方式填写错误",Toast.LENGTH_LONG).show();;//如果识别不了就提示
                        return;
                    }
                }


                if (Kits.Empty.check(rankNum)) {
                    Toast.makeText(ZxdLuRuActivity.this,"第几箱不能为空",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(totalNum)) {
                    Toast.makeText(ZxdLuRuActivity.this,"共几箱不能为空",Toast.LENGTH_LONG).show();
                    return;
                }



                if (Kits.Empty.check(packLength)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写长度",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(packwidth)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写宽度",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(packHeight)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写高度",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(netWeight)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写净重",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(roughWeight)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写毛重",Toast.LENGTH_LONG).show();
                    return;
                }

//------------------------
                if (Kits.Empty.check(salesOrder)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写Sales Order",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(comments)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写comments",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(installTime)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写组装日期",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(deliveryDate)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写订单交货期",Toast.LENGTH_LONG).show();
                    return;
                }



                for (int i = 0; i <childCount+1 ; i++) {//这里加1，因为一开始默认添加了一条
                    View childAt = llAdd.getChildAt(i);

                    tvSo = childAt.findViewById(R.id.tv_so);
                    tvMaterial = childAt.findViewById(R.id.tv_material);
                    tvRl = childAt.findViewById(R.id.tv_rl);
                    tvAgl = childAt.findViewById(R.id.tv_agl);
                    tvQty = childAt.findViewById(R.id.tv_qty);

                    String soItem=tvSo.getText().toString();
                    String material=tvMaterial.getText().toString();
                    String rl=tvRl.getText().toString();
                    String agl=tvAgl.getText().toString();
                    String qty=tvQty.getText().toString();

                if (Kits.Empty.check(soItem)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写SO Item",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(material)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写Material",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(rl)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写RL",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(agl)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写AGL",Toast.LENGTH_LONG).show();
                    return;
                }


                if (Kits.Empty.check(qty)) {
                    Toast.makeText(ZxdLuRuActivity.this,"请填写Qty",Toast.LENGTH_LONG).show();
                    return;
                }

                    PackingItems plist=new PackingItems();
                    plist.setSoItem(soItem);
                    plist.setMaterial(material);
                    plist.setRl(rl);
                    plist.setAgl(agl);
                    plist.setQty(qty);

                    PackingItem.add(plist);

                }


                presenter.add(workCode,madeTime,packingMaterial,rankNum,totalNum,packLength,packwidth,packHeight,netWeight,roughWeight,PackingItem,salesOrder,comments,installTime,deliveryDate);



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



    //添加ViewItem
    private void addViewItem() {
        if (llAdd.getChildCount() == 0) {//如果一个都没有，就添加一个
            View hotelEvaluateView = View.inflate(this, R.layout.item_zxdlr, null);

            llAdd.addView(hotelEvaluateView);

        }

    }


    //提交成功以后返回的
    @Override
    public void showToast(ZxdDetailAddVO result) {
        if (!Kits.Empty.check(result)){
            if (!Kits.Empty.check(result.getSuccess())){
                if (result.getSuccess().equals("T")){
                    Toast.makeText(ZxdLuRuActivity.this,"添加成功",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ZxdLuRuActivity.this,result.getMessage(),Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(ZxdLuRuActivity.this,"添加失败",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(ZxdLuRuActivity.this,"添加失败",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showErr(String err) {

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

    @Override
    public Context getViewContext() {
        return this;
    }





}
