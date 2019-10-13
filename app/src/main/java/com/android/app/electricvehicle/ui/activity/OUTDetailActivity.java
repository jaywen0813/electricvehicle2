package com.android.app.electricvehicle.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.model.main.contract.OUTContract;
import com.android.app.electricvehicle.model.main.presenter.OUTPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.StatusBarUtil;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//出库
public class OUTDetailActivity extends BaseMvpActivity<OUTContract.View, OUTPresenter> implements OUTContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private EditText etNumber;
    private LinearLayout llSaomiao;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;
    private TextView tvZhid;
    private TextView tvGzdh;
    private TextView tvDate;
    private TextView tvNumber;
    private TextView tvZxdid;
    private TextView tvCkmc;
    private TextView tvCkid;
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
    private TextView tvTijiao;



    private ScrollView scrollView;
    private LinearLayout ll_wsj;



    OUTPresenter outPresenter;

    int type=0;//用来区分是扫装箱单 还是扫库位   默认为0，装箱单为1，库位为2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_out_detail;
    }

    @Override
    protected OUTPresenter initPresenter() {
        outPresenter=new OUTPresenter();
        return outPresenter;
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

                String outstoreCode=etNumber.getText().toString().trim();
                String freeLoc=etKwNumber.getText().toString().trim();



                if (Kits.Empty.check(outstoreCode)){
                    Toast.makeText(OUTDetailActivity.this,  "出库号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
//
//                if (Kits.Empty.check(storehouseId)){
//                    T.showToastSafe("仓库ID不能为空");
//                    return;
//                }
//                if (Kits.Empty.check(storehouseName)){
//                    T.showToastSafe("仓库名称不能为空");
//                    return;
//                }
                if (Kits.Empty.check(freeLoc)){
                    Toast.makeText(OUTDetailActivity.this,  "库位号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if (Kits.Empty.check(packingListId)){
//                    T.showToastSafe("装箱单ID不能为空");
//                    return;
//                }

                //网络请求  提交数据

                outPresenter.getUP(outstoreCode,freeLoc);

//                T.showToastSafe("出库成功");
                break;
            case R.id.ll_saomiao2://扫一扫  库位号
                type=2;
                requestPermissionsCamera();
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
        etNumber = findViewById(R.id.et_number);
        llSaomiao = findViewById(R.id.ll_saomiao);
        etKwNumber = findViewById(R.id.et_kw_number);
        llSaomiao2 = findViewById(R.id.ll_saomiao2);
        tvZhid = findViewById(R.id.tv_zhid);
        tvGzdh = findViewById(R.id.tv_gzdh);
        tvDate = findViewById(R.id.tv_date);
        tvNumber = findViewById(R.id.tv_number);
        tvZxdid = findViewById(R.id.tv_zxdid);
        tvCkmc = findViewById(R.id.tv_ckmc);
        tvCkid = findViewById(R.id.tv_ckid);

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
        tvTijiao = findViewById(R.id.tv_tijiao);

        scrollView=findViewById(R.id.scrollView);//有数据的时候显示
        ll_wsj=findViewById(R.id.ll_wsj);//无数据

        llSaomiao.setOnClickListener(this);
        llSaomiao2.setOnClickListener(this);
        backLayout.setOnClickListener(this);
        tvTijiao.setOnClickListener(this);

        tvLayerHead.setText("出库单信息");

        //状态栏
        StatusBarUtil.transparencyBar(this);//设置状态栏全透明
        StatusBarUtil.StatusBarLightMode(this);//设置状态栏黑色文字、图标，

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

            startActivityForResult(intent, 927);







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
                            Toast.makeText(OUTDetailActivity.this,  "请先授权", Toast.LENGTH_SHORT).show();
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


                            startActivityForResult(intent, 927);
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
//                            Toast.makeText(this, s + "权限被拒绝了", Toast.LENGTH_SHORT).show();
                            Toast.makeText(OUTDetailActivity.this,  "请先授权", Toast.LENGTH_SHORT).show();
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
                          startActivityForResult(intent, 927);

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
        if (requestCode == 927 && resultCode == 10086) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);


//                用来区分是扫装箱单 还是扫库位   默认为0，装箱单为1，库位为2
                if (type==1){
                    etNumber.setText(content);//显示出来

                    presenter.getZXD(content,OUTDetailActivity.this);


                }else if (type==2){
                    etKwNumber.setText(content);//扫码返回的库位号码

                }

            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    //提交成功以后的操作
    @Override
    public void showSuccess(OutDetailVO vDate) {
//        T.showToastSafe("提交成功");

        if (vDate.getSuccess().equals("T")){
            Toast.makeText(OUTDetailActivity.this,"出库成功",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(OUTDetailActivity.this,vDate.getMessage()+"",Toast.LENGTH_LONG).show();
        }


    }
    //获取详情展示数据
    @Override
    public void showDetail(ItemDetailOutVO vDate) {




        if (!Kits.Empty.check(vDate.getData())){

            scrollView.setVisibility(View.VISIBLE);
            ll_wsj.setVisibility(View.GONE);

//        //租户ID
//        if (!Kits.Empty.check(vDate.getData().getTenantId())){
//            tvZhid.setText(vDate.getData().getTenantId());
//        }
        //工作单号
        if (!Kits.Empty.check(vDate.getData().getWorkCode())){
            tvGzdh.setText(vDate.getData().getWorkCode());
        }
        //日期
        if (!Kits.Empty.check(vDate.getData().getMadeTime())){

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
            String timeText=format.format(vDate.getData().getMadeTime());
            tvDate.setText(timeText+"");
        }

        //装箱单号
        if (!Kits.Empty.check(vDate.getData().getPackingCode())) {
            tvNumber.setText(vDate.getData().getPackingCode());
        }
//        //装箱单ID
//        if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0).get.getPackingListId())) {
//            tvZxdid.setText(vDate.get(0).getPackingListId());
//        }

        //仓库名称
//        if (!Kits.Empty.check(vDate.getData().getPackingListItems().get(0))) {
//            tvCkmc.setText(vDate.get(0).getStorehouseName());
//        }
//        //仓库ID
//        if (!Kits.Empty.check(vDate.get(0).getStorehouseId())) {
//            tvCkid.setText(vDate.get(0).getStorehouseId());
//        }

        //库位编号
//        if (!Kits.Empty.check(vDate.get(0).getFreeLoc())) {
//            tvKwNumber.setText(vDate.get(0).getFreeLoc());
//        }

        //第几箱
        if (!Kits.Empty.check(vDate.getData().getRankNum())) {
            tvDjx.setText("第  "+vDate.getData().getRankNum()+"  箱");
        }

        //共几箱
        if (!Kits.Empty.check(vDate.getData().getTotalNum())) {
            tvGjx.setText("共  "+vDate.getData().getTotalNum()+"  箱");
        }

        //长
        if (!Kits.Empty.check(vDate.getData().getPackLength())) {
            tvChang.setText("长："+vDate.getData().getPackLength());
        }
        //宽
        if (!Kits.Empty.check(vDate.getData().getPackwidth())) {
            tvKuan.setText("宽："+vDate.getData().getPackwidth());
        }
        //高
        if (!Kits.Empty.check(vDate.getData().getPackHeight())) {
            tvGao.setText("高:"+vDate.getData().getPackHeight());
        }
        //净重
        if (!Kits.Empty.check(vDate.getData().getNetWeight())) {
            tvJingzhong.setText("净重："+vDate.getData().getNetWeight());
        }
        //毛重
        if (!Kits.Empty.check(vDate.getData().getRoughWeight())) {
            tvMaozhong.setText("毛重："+vDate.getData().getRoughWeight());
        }


        //状态(0暂存  1待入库  2已入库  3已出库)
        if (!Kits.Empty.check(vDate.getData().getStoreState())) {
            switch (vDate.getData().getStoreState()){
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
        if (!Kits.Empty.check(vDate.getData().getBillArchived())) {
            if (vDate.getData().getBillArchived().equals("0")){
                tvDjgd.setText("单据归档：否");
            }else if (vDate.getData().getBillArchived().equals("1")){
                tvDjgd.setText("单据归档：是");
            }

        }

        //单据打印
        if (!Kits.Empty.check(vDate.getData().getBillPrString())) {
            if (vDate.getData().getBillPrString().equals("0")){
                tvDjdy.setText("单据打印：未打印");
            }else if (vDate.getData().getBillPrString().equals("1")){
                tvDjdy.setText("单据打印：已打印");
            }else if (vDate.getData().getBillPrString().equals("2")){
                tvDjdy.setText("单据打印：补打");
            }

        }
        //打印次数
        if (!Kits.Empty.check(vDate.getData().getPrStringTimes())) {
            tvDycs.setText("打印次数："+vDate.getData().getPrStringTimes()+"次");
        }


        //备注
        if (!Kits.Empty.check(vDate.getData().getRemark())){
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
        Log.e("error-out",err);
    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
