package com.android.app.electricvehicle.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.INDetailVO;
import com.android.app.electricvehicle.entity.INDetail_RuKu;
import com.android.app.electricvehicle.entity.ShowInDetailEntity;
import com.android.app.electricvehicle.model.main.contract.INContract;
import com.android.app.electricvehicle.model.main.presenter.INPresenter;
import com.android.app.electricvehicle.utils.DateTimeWheelDialog;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class INDetailActivity extends BaseMvpActivity<INContract.View, INPresenter> implements INContract.View,View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private EditText etNumber;
    private LinearLayout llSaomiao;


    private EditText etKwNumber;
    private LinearLayout llSaomiao2;


    private TextView tvTijiao;


    private EditText tvGzdh;
    private TextView tvDate;
    private Spinner spBzfs;
    private EditText tvDjx;
    private EditText tvGjx;
    private EditText tvChang;
    private EditText tvKuan;
    private EditText tvGao;
    private EditText tvJingzhong;
    private EditText tvMaozhong;
    private EditText tvOrder;
    private EditText tvComments;
    private TextView tvZzrq;
    private TextView tvDdjhq;


    private LinearLayout ll_detail;//扫码以后显示详情的
    private LinearLayout llAdd;



    int type=0;//用来区分是扫装箱单 还是扫库位   默认为0，装箱单为1，库位为2

    INPresenter inPresenter;

    String baozhuangfangshi = "";//用来记录后台返回的默认的包装方式

    String packingMaterial="";//包装方式

    int type_f=0;//默认先为0,type_f 为0的时候，代表返回了详情，为1的时候代表没有返回详情，此时提交给后台出库的数据不一样

    DateTimeWheelDialog dialog3 = null;
    DateTimeWheelDialog dialog4 = null;
    String sjc="";//
    String sjc2="";//订单交货期时间戳

    EditText tvSo ;
    EditText tvMaterial ;
    EditText tvRl ;
    EditText tvAgl ;
    EditText tvQty ;

    private int childCount = 0;//用来记录点击了几次添加下面的条目
    List<INDetail_RuKu.PackingListBean.PackingListItemsBean> packingListItem=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_in_detail;
    }

    @Override
    protected INPresenter initPresenter() {
        inPresenter=new INPresenter();
        return inPresenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                finish();
                break;
            case R.id.ll_saomiao://扫一扫  装箱单
                type=1;
                requestPermissionsCamera();
                break;
            case R.id.tv_tijiao://提交按钮
//                T.showToastSafe("提交成功");
                String instoreCode=etNumber.getText().toString().trim();
                String freeLoc=etKwNumber.getText().toString().trim();
                String workCode=tvGzdh.getText().toString().trim();//工作单号

                String madeTime = String.valueOf(new Date().getTime());//当前时间戳

                String rankNum = tvDjx.getText().toString();//第几箱
                String totalNum = tvGjx.getText().toString();//共几箱
                String packLength = tvChang.getText().toString();//长
                String packwidth = tvKuan.getText().toString();//宽
                String packHeight = tvGao.getText().toString();//高
                String netWeight = tvJingzhong.getText().toString();//净重
                String roughWeight = tvMaozhong.getText().toString();//毛重
                String salesOrder=tvOrder.getText().toString(); //Sales order
                String comments=tvComments.getText().toString(); //comments
                String installTime=sjc; //组装日期
                String deliveryDate=sjc2; //订单交货期



                if (Kits.Empty.check(instoreCode)){
                    Toast.makeText(INDetailActivity.this, "装箱单号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }


//                if (Kits.Empty.check(comments)) {
//                    Toast.makeText(INDetailActivity.this,"请填写comments",Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                if (Kits.Empty.check(installTime)) {
//                    Toast.makeText(INDetailActivity.this,"请填写组装日期",Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                if (Kits.Empty.check(deliveryDate)) {
//                    Toast.makeText(INDetailActivity.this,"请填写订单交货期",Toast.LENGTH_LONG).show();
//                    return;
//                }

                if (type_f==0){//代表查询到了详情，此时入参简单
                    //网络请求
                    inPresenter.getUP(instoreCode,freeLoc);
                }else {//代表没有查询到详情,此时获取手动的数据，然后直接入库请求

                    if (Kits.Empty.check(packingMaterial)) {
                        Toast.makeText(INDetailActivity.this, "包装方式不能为空", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(INDetailActivity.this, "第几箱不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(totalNum)) {
                        Toast.makeText(INDetailActivity.this, "共几箱不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(netWeight)) {
                        Toast.makeText(INDetailActivity.this, "请填写净重", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (Kits.Empty.check(roughWeight)) {
                        Toast.makeText(INDetailActivity.this, "请填写毛重", Toast.LENGTH_LONG).show();
                        return;
                    }
                    //------------------------
                    if (Kits.Empty.check(salesOrder)) {
                        Toast.makeText(INDetailActivity.this,"请填写Sales Order",Toast.LENGTH_LONG).show();
                        return;
                    }






//                    String instoreCode=etNumber.getText().toString().trim();
//                    String freeLoc=etKwNumber.getText().toString().trim();
//                    String workCode=tvGzdh.getText().toString().trim();//工作单号
//
//                    String madeTime = String.valueOf(new Date().getTime());//当前时间戳
//
//                    String rankNum = tvDjx.getText().toString();//第几箱
//                    String totalNum = tvGjx.getText().toString();//共几箱
//                    String packLength = tvChang.getText().toString();//长
//                    String packwidth = tvKuan.getText().toString();//宽
//                    String packHeight = tvGao.getText().toString();//高
//                    String netWeight = tvJingzhong.getText().toString();//净重
//                    String roughWeight = tvMaozhong.getText().toString();//毛重
//                    String salesOrder=tvOrder.getText().toString(); //Sales order
//                    String comments=tvComments.getText().toString(); //comments
//                    String installTime=sjc; //组装日期
//                    String deliveryDate=sjc2; //订单交货期


                    INDetail_RuKu.PackingListBean inDetail_ruKu=new INDetail_RuKu.PackingListBean();


                    inDetail_ruKu.setWorkCode(workCode);
                    inDetail_ruKu.setMadeTime(madeTime);
                    inDetail_ruKu.setRankNum(rankNum);
                    inDetail_ruKu.setTotalNum(totalNum);
                    inDetail_ruKu.setPackLength(packLength);
                    inDetail_ruKu.setPackwidth(packwidth);
                    inDetail_ruKu.setPackHeight(packHeight);
                    inDetail_ruKu.setNetWeight(netWeight);
                    inDetail_ruKu.setRoughWeight(roughWeight);

                    inDetail_ruKu.setSalesOrder(salesOrder);
                    inDetail_ruKu.setComments(comments);
                    inDetail_ruKu.setInstallTime(installTime);
                    inDetail_ruKu.setDeliveryDate(deliveryDate);




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
                            Toast.makeText(INDetailActivity.this,"请填写SO Item",Toast.LENGTH_LONG).show();
                            return;
                        }


                        if (Kits.Empty.check(material)) {
                            Toast.makeText(INDetailActivity.this,"请填写Material",Toast.LENGTH_LONG).show();
                            return;
                        }


                        if (Kits.Empty.check(rl)) {
                            Toast.makeText(INDetailActivity.this,"请填写RL",Toast.LENGTH_LONG).show();
                            return;
                        }

                        if (Kits.Empty.check(agl)) {
                            Toast.makeText(INDetailActivity.this,"请填写AGL",Toast.LENGTH_LONG).show();
                            return;
                        }


                        if (Kits.Empty.check(qty)) {
                            Toast.makeText(INDetailActivity.this,"请填写Qty",Toast.LENGTH_LONG).show();
                            return;
                        }

                        INDetail_RuKu.PackingListBean.PackingListItemsBean plist=new INDetail_RuKu.PackingListBean.PackingListItemsBean();
                        plist.setSoItem(soItem);
                        plist.setMaterial(material);
                        plist.setRl(rl);
                        plist.setAgl(agl);
                        plist.setQty(qty);

                        packingListItem.add(plist);

                    }

                    inDetail_ruKu.setPackingListItems(packingListItem);

                    inPresenter.getUP2(instoreCode,freeLoc,inDetail_ruKu);


                }



                break;
            case R.id.ll_saomiao2://库位  扫一扫
                type=2;
                requestPermissionsCamera();
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
            case R.id.farm_input_save://添加条目
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
        }
    }



    @Override
    protected void initView() {
        super.initView();


        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);
        etNumber = findViewById(R.id.et_number);//装箱单号
        llSaomiao = findViewById(R.id.ll_saomiao);//装箱单扫描


        etKwNumber = findViewById(R.id.et_kw_number);//库位号
        llSaomiao2 = findViewById(R.id.ll_saomiao2);//扫描库位

        tvTijiao = findViewById(R.id.tv_tijiao);//提交



        tvGzdh = findViewById(R.id.tv_gzdh);//工作单号
        tvDate = findViewById(R.id.tv_date);//日期
        spBzfs = findViewById(R.id.sp_bzfs);//包装方式
        tvDjx = findViewById(R.id.tv_djx);//第几箱
        tvGjx = findViewById(R.id.tv_gjx);//共几箱
        tvChang = findViewById(R.id.tv_chang);//长
        tvKuan = findViewById(R.id.tv_kuan);//宽
        tvGao = findViewById(R.id.tv_gao);//高
        tvJingzhong = findViewById(R.id.tv_jingzhong);//净重
        tvMaozhong = findViewById(R.id.tv_maozhong);//毛重
        tvOrder = findViewById(R.id.tv_order);//
        tvComments = findViewById(R.id.tv_comments);
        tvZzrq = findViewById(R.id.tv_zzrq);//组装日期
        tvDdjhq = findViewById(R.id.tv_ddjhq);//订单交货期

        ll_detail=findViewById(R.id.ll_detail);//用来显示下面的详情的

        llAdd=findViewById(R.id.ll_add);

        llSaomiao.setOnClickListener(this);
        llSaomiao2.setOnClickListener(this);
        backLayout.setOnClickListener(this);
        tvTijiao.setOnClickListener(this);
        tvZzrq.setOnClickListener(this);
        tvDdjhq.setOnClickListener(this);

        farmInputSave.setOnClickListener(this);


        tvLayerHead.setText("入库单信息");
        farmInputSave.setText("添加条目");

        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，



        spBzfs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        spBzfs.setAdapter(spinnerAdapter);


        //一开始不让修改
        chooseFlase();

    }


    //相机权限
    private void requestPermissionsCamera() {
        List<String> permissionList = new ArrayList<>();
//        允许程序打开相机
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CAMERA);
        }
//        允许程序设置内置sd卡的读取权限
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
//        }
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.VIBRATE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.VIBRATE);
//        }
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WAKE_LOCK) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.WAKE_LOCK);
//        }
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
//<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
        if (!permissionList.isEmpty()) {  //申请的集合不为空时，表示有需要申请的权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissionList.toArray(new String[permissionList.size()]), 2);
            }
        } else { //所有的权限都已经授权过了


            Intent intent = new Intent(this, ZxingActivity.class);
            /*ZxingConfig是配置类
             *可以设置是否显示底部布局，闪光灯，相册，
             * 是否播放提示音  震动
             * 设置扫描框颜色等
             * 也可以不传这个参数
             * */
            ZxingConfig config = new ZxingConfig();
            config.setPlayBeep(false);//是否播放扫描声音 默认为true
            config.setShake(true);//是否震动  默认为true
            config.setDecodeBarCode(true);//是否扫描条形码 默认为true
            config.setReactColor(R.color.colorPrimary);//设置扫描框四个角的颜色 默认为淡蓝色
            config.setFrameLineColor(R.color.colorPrimary);//设置扫描框边框颜色 默认无色
            config.setFullScreenScan(true);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
            intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);


            if (type==1){//装箱单
                startActivityForResult(intent, 1122);
            }else if (type==2){
                startActivityForResult(intent, 1123);
            }

        }
    }


    //动态申请权限部分
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) { //安全写法，如果小于0，肯定会出错了
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        if (grantResult == PackageManager.PERMISSION_DENIED) { //这个是权限拒绝
//                            T.showToastSafe("请先授权");
                            Toast.makeText(INDetailActivity.this,  "请先授权", Toast.LENGTH_SHORT).show();
                        } else { //授权成功了
                            //do Something
                            Intent intent = new Intent(this, ZxingActivity.class);
                            /*ZxingConfig是配置类
                             *可以设置是否显示底部布局，闪光灯，相册，
                             * 是否播放提示音  震动
                             * 设置扫描框颜色等
                             * 也可以不传这个参数
                             * */
                            ZxingConfig config = new ZxingConfig();
                            config.setPlayBeep(false);//是否播放扫描声音 默认为true
                            config.setShake(true);//是否震动  默认为true
                            config.setDecodeBarCode(true);//是否扫描条形码 默认为true
                            config.setReactColor(R.color.colorPrimary);//设置扫描框四个角的颜色 默认为淡蓝色
                            config.setFrameLineColor(R.color.colorPrimary);//设置扫描框边框颜色 默认无色
                            config.setFullScreenScan(true);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                            intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
//                            startActivityForResult(intent, 1122);

                            if (type==1){//装箱单
                                startActivityForResult(intent, 1122);


                            }else if (type==2){//库位
                                startActivityForResult(intent, 1123);
                            }
                        }
                    }
                }
                break;
            case 2:

                if (grantResults.length > 0) { //安全写法，如果小于0，肯定会出错了
                    for (int i = 0; i < grantResults.length; i++) {

                        int grantResult = grantResults[i];
                        if (grantResult == PackageManager.PERMISSION_DENIED) { //这个是权限拒绝
                            String s = permissions[i];
                            Toast.makeText(INDetailActivity.this, s + "请先授权", Toast.LENGTH_SHORT).show();
//                            T.showToastSafe("请先授权");
                        } else { //授权成功了
                            //do Something
                            //扫一扫
                            Intent intent = new Intent(this, ZxingActivity.class);
                            /*ZxingConfig是配置类
                             *可以设置是否显示底部布局，闪光灯，相册，
                             * 是否播放提示音  震动
                             * 设置扫描框颜色等
                             * 也可以不传这个参数
                             * */
                            ZxingConfig config = new ZxingConfig();
                            config.setPlayBeep(false);//是否播放扫描声音 默认为true
                            config.setShake(true);//是否震动  默认为true
                            config.setDecodeBarCode(true);//是否扫描条形码 默认为true
                            config.setReactColor(R.color.colorPrimary);//设置扫描框四个角的颜色 默认为淡蓝色
                            config.setFrameLineColor(R.color.colorPrimary);//设置扫描框边框颜色 默认无色
                            config.setFullScreenScan(true);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                            intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
//                            startActivityForResult(intent, 1122);
                            if (type==1){//装箱单
                                startActivityForResult(intent, 1122);
                            }else if (type==2){//库位
                                startActivityForResult(intent, 1123);
                            }

                        }
                    }
                }
                break;


            default:
                break;
        }



    }


    //返回的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // 扫描二维码/条码回传   装箱单
        if (requestCode == 1122 && resultCode == 10086) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                etNumber.setText(content);//显示出来

                //请求后台是否有装箱单的数据
                presenter.getInDetail(content);

            }
        }else if (requestCode == 1123 && resultCode == 10086){//库位
            String content = data.getStringExtra(Constant.CODED_CONTENT);
            etKwNumber.setText(content);//显示出来
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showSuccess(INDetailVO vDate) {
        if (vDate.getSuccess().equals("T")){//提交成功
//            T.showToastSafe("提交成功");
            Toast.makeText(INDetailActivity.this,"提交成功",Toast.LENGTH_LONG).show();
            finish();
        }else {
//            T.showToastSafe("提交失败");
            Toast.makeText(INDetailActivity.this,vDate.getMessage()+"",Toast.LENGTH_LONG).show();
        }

    }

    //扫码到装箱单以后，返回的结果
    @Override
    public void showInDetail(ShowInDetailEntity result) {
        if (result.getSuccess().equals("T")){//证明有数据
            ll_detail.setVisibility(View.VISIBLE);//显示出详情

             type_f=0;//type_f 为0的时候，代表返回了详情，为1的时候代表没有返回详情，此时提交给后台出库的数据不一样

            if (!Kits.Empty.check(result.getData())) {
                //证明有数据
               if (result.getData().getDataList()!=null&&result.getData().getDataList().size()>0 ){
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getWorkCode())) {
                       tvGzdh.setText(result.getData().getDataList().get(0).getWorkCode());//工作单号
                   }

                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getMadeTime())) {//日期

                       long itime = Long.parseLong(result.getData().getDataList().get(0).getMadeTime());

                       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                       String timeText = format.format(itime);
                       tvDate.setText(timeText + "");

                   }

                    //包装方式
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getPackingMaterial())){
                       switch (result.getData().getDataList().get(0).getPackingMaterial()) {
                           case "0":
//                        tvBzfs.setText("纸箱");
                               spBzfs.setSelection(0,true);
                               break;
                           case "1":
//                        tvBzfs.setText("木箱");
                               spBzfs.setSelection(1,true);
                               break;
                           case "2":
//                        tvBzfs.setText("木托盘纸箱");
                               spBzfs.setSelection(2,true);
                               break;
                           default:
//                        tvBzfs.setText("");
                               break;
                       }

                       baozhuangfangshi = result.getData().getDataList().get(0).getPackingMaterial();//用来记录后台返回的默认的包装方式
                   }


                   //第几箱
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getRankNum())) {
                       tvDjx.setText(result.getData().getDataList().get(0).getRankNum() + "");
                   }

                   //共几箱
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getTotalNum())) {
                       tvGjx.setText(result.getData().getDataList().get(0).getTotalNum() + "");
                   }

                   //长
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getPackLength())) {
                       tvChang.setText(result.getData().getDataList().get(0).getPackLength());
                   }
                   //宽
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getPackwidth())) {
                       tvKuan.setText(result.getData().getDataList().get(0).getPackwidth());
                   }
                   //高
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getPackHeight())) {
                       tvGao.setText(result.getData().getDataList().get(0).getPackHeight());
                   }
                   //净重
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getNetWeight())) {
                       tvJingzhong.setText(result.getData().getDataList().get(0).getNetWeight());
                   }
                   //毛重
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getRoughWeight())) {
                       tvMaozhong.setText(result.getData().getDataList().get(0).getRoughWeight());
                   }


                   //Sales order
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getSalesOrder())) {
                       tvOrder.setText(result.getData().getDataList().get(0).getSalesOrder());
                   }


                   //comments
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getComments())) {
                       tvComments.setText(result.getData().getDataList().get(0).getComments());
                   }

                   //组装日期
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getInstallTime())) {

                       long itimes= Long.parseLong(result.getData().getDataList().get(0).getInstallTime());

                       SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                       String timeText=format.format(itimes);
                       tvZzrq.setText(timeText+"");

                       sjc=result.getData().getDataList().get(0).getInstallTime();
                   }

                   //订单交货期
                   if (!Kits.Empty.check(result.getData().getDataList().get(0).getDeliveryDate())) {

                       long itimess= Long.parseLong(result.getData().getDataList().get(0).getDeliveryDate());

                       SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                       String timeText=format.format(itimess);
                       tvDdjhq.setText(timeText+"");
                       sjc2=result.getData().getDataList().get(0).getDeliveryDate();
                   }



               }

            }




        }else {//证明返回的F，此时是查不到详情，证明没有装箱单
            ll_detail.setVisibility(View.VISIBLE);//显示出详情//这个时候可以编辑了
            chooseTrue();//此时可以修改
            navigationUserLayout.setVisibility(View.VISIBLE);//此时显示添加SO Item按钮
             type_f=1;//type_f 为0的时候，代表返回了详情，为1的时候代表没有返回详情，此时提交给后台出库的数据不一样

        }



    }


    //可以编辑
    public void chooseTrue() {
        spBzfs.setEnabled(true);
        tvDjx.setEnabled(true);
        tvGjx.setEnabled(true);
        tvChang.setEnabled(true);
        tvKuan.setEnabled(true);
        tvGao.setEnabled(true);
        tvJingzhong.setEnabled(true);
        tvMaozhong.setEnabled(true);
        tvOrder.setEnabled(true);
        tvComments.setEnabled(true);
        tvZzrq.setEnabled(true);
        tvDdjhq.setEnabled(true);
//        tvRl.setEnabled(true);
//        tvAgl.setEnabled(true);
//        tvQty.setEnabled(true);
//        tvSo.setEnabled(true);
//        tvMaterial.setEnabled(true);
    }

    //不可以编辑
    public void chooseFlase() {
        spBzfs.setEnabled(false);
        tvDjx.setEnabled(false);
        tvGjx.setEnabled(false);
        tvChang.setEnabled(false);
        tvKuan.setEnabled(false);
        tvGao.setEnabled(false);
        tvJingzhong.setEnabled(false);
        tvMaozhong.setEnabled(false);
        tvOrder.setEnabled(false);
        tvComments.setEnabled(false);
        tvZzrq.setEnabled(false);
        tvDdjhq.setEnabled(false);
//        tvRl.setEnabled(false);
//        tvAgl.setEnabled(false);
//        tvQty.setEnabled(false);
//        tvSo.setEnabled(false);
//        tvMaterial.setEnabled(false);
    }


    @Override
    public void showErr(String err) {
        Log.e("error-out",err);
    }

    @Override
    public Context getViewContext() {
        return this;
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
                tvZzrq.setText(d+"");//显示出来的  年月日

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
                tvDdjhq.setText(d+"");//显示出来的  年月日

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
