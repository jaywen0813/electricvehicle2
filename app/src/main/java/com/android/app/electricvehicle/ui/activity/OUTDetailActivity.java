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
    private TextView tvCkid;
    private TextView tvCkmc;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;
    private TextView tvZxdid;
    private EditText etBz;
    private TextView tvTijiao;
    private LinearLayout ll_detail;//查询详情成功以后展示





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
                String storehouseId=tvCkid.getText().toString();
                String storehouseName=tvCkmc.getText().toString();
                String freeLoc=etKwNumber.getText().toString().trim();
                String packingListId=tvZxdid.getText().toString();
                String remark=etBz.getText().toString().trim();//备注

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

                outPresenter.getUP(outstoreCode,freeLoc,remark);

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
        etNumber = findViewById(R.id.et_number);//出库单号
        llSaomiao = findViewById(R.id.ll_saomiao);//出库单扫描
        tvCkid = findViewById(R.id.tv_ckid);//仓库ID
        tvCkmc = findViewById(R.id.tv_ckmc);//仓库名称
        etKwNumber = findViewById(R.id.et_kw_number);//库位号
        llSaomiao2 = findViewById(R.id.ll_saomiao2);//库位单扫码
        tvZxdid = findViewById(R.id.tv_zxdid);//装箱单ID
        etBz = findViewById(R.id.et_bz);//备注
        tvTijiao = findViewById(R.id.tv_tijiao);//提交

        ll_detail=findViewById(R.id.ll_detail);//查询详情成功以后展示

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

                    presenter.getZXD(content);


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
    public void showDetail(ItemDetailOutVO detailOutVO) {

        ll_detail.setVisibility(View.VISIBLE);//展示详情

        if (!Kits.Empty.check(detailOutVO.getData().getStorehouseId())){
            tvCkid.setText(detailOutVO.getData().getStorehouseId());
        }

        if (!Kits.Empty.check(detailOutVO.getData().getStorehouseName())){
            tvCkmc.setText(detailOutVO.getData().getStorehouseName());
        }

        if (!Kits.Empty.check(detailOutVO.getData().getPackingListId())){
            tvZxdid.setText(detailOutVO.getData().getPackingListId());
        }

        if (!Kits.Empty.check(detailOutVO.getData().getFreeLoc())){
            etKwNumber.setText(detailOutVO.getData().getFreeLoc());
        }
        //备注
        if (!Kits.Empty.check(detailOutVO.getData().getRemark())){
            etBz.setText(detailOutVO.getData().getRemark());
        }






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
