package com.android.app.electricvehicle.ui.activity.pandian;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseListActivity;
import com.android.app.electricvehicle.entity.PanDianListVO;
import com.android.app.electricvehicle.model.main.contract.PanDianContract;
import com.android.app.electricvehicle.model.main.presenter.PanDianPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.activity.ZXDchaxunxiugai.ZxdlrDetailActivity;
import com.android.app.electricvehicle.ui.activity.ZxingActivity;
import com.android.app.electricvehicle.ui.adapter.PanDianListAdapter;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundTextView;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

//盘点的首页
public class PanDianActivity extends BaseListActivity<PanDianContract.View, PanDianPresenter> implements PanDianContract.View, View.OnClickListener {


    PanDianPresenter panDianPresenter;
    private List<PanDianListVO.DataBean> activityVOList=new ArrayList<>();
    private String pageNum = "1";//分页

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;
    private LinearLayout llShanchu2;
    private RoundTextView tvShoudong2;
    private EditText etNumber;
    private LinearLayout llSaomiao;
    private LinearLayout llShanchu;
    private RoundTextView tvShoudong;
    private RecyclerView rvList;

    int type = 0;//用来区分是扫装箱单 还是扫库位    默认为0，装箱单为1，库位为2，

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void initView() {
        super.initView();
        titleLayoutRl = (RelativeLayout) findViewById(R.id.title_layout_rl);
        backLayout = (LinearLayout) findViewById(R.id.back_layout);
        tvLayerHead = (TextView) findViewById(R.id.tv_layer_head);
        navigationUserLayout = (LinearLayout) findViewById(R.id.navigation_user_layout);
        farmInputSave = (TextView) findViewById(R.id.farm_input_save);
        etKwNumber = (EditText) findViewById(R.id.et_kw_number);
        llSaomiao2 = (LinearLayout) findViewById(R.id.ll_saomiao2);
        llShanchu2 = (LinearLayout) findViewById(R.id.ll_shanchu2);
        tvShoudong2 = (RoundTextView) findViewById(R.id.tv_shoudong2);
        etNumber = (EditText) findViewById(R.id.et_number);
        llSaomiao = (LinearLayout) findViewById(R.id.ll_saomiao);
        llShanchu = (LinearLayout) findViewById(R.id.ll_shanchu);
        tvShoudong = (RoundTextView) findViewById(R.id.tv_shoudong);
        rvList = (RecyclerView) findViewById(R.id.rv_list);

        rvList.setNestedScrollingEnabled(false);//解决NestedScrollView滑动冲突


        backLayout.setOnClickListener(this);
        llSaomiao.setOnClickListener(this);
        llSaomiao2.setOnClickListener(this);

        llShanchu.setOnClickListener(this);
        llShanchu2.setOnClickListener(this);

        tvShoudong.setOnClickListener(this);
        tvShoudong2.setOnClickListener(this);
    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_pan_dian;
    }

    @Override
    protected BasePresenter getPresenter() {
        panDianPresenter=new PanDianPresenter();
        return panDianPresenter;
    }

    @Override
    protected BaseQuickAdapter getRecyclerAdapter() {
        return new PanDianListAdapter(activityVOList,this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_layout:
                finish();
                break;
            case R.id.ll_saomiao://扫描装箱单的
                type = 1;
                requestPermissionsCamera();
                break;
            case R.id.ll_saomiao2://扫描库位号查询的
                type = 2;
                requestPermissionsCamera();
                break;
            case R.id.ll_shanchu://删除装箱单 输入框的
                etNumber.setText("");
                break;
            case R.id.ll_shanchu2://删除库位号 输入框的
                etKwNumber.setText("");
                break;
            case R.id.tv_shoudong://手动通过 装箱单 盘点的
                String zxd =etNumber.getText().toString();

                if (Kits.Empty.check(zxd)){
                    Toast.makeText(this,"盘点的装箱单号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                panDianPresenter.getPandian(zxd);

                break;
            case R.id.tv_shoudong2://手动通过 库位号 查询装箱单列表
                String ku=etKwNumber.getText().toString();

                if (Kits.Empty.check(ku)){
                 Toast.makeText(this,"库位号不能为空",Toast.LENGTH_SHORT).show();
                 return;
                }

                panDianPresenter.getFreeLoc(ku);
                break;
        }
    }

    //通过库位号查询的装箱单列表
    @Override
    public void showDetail(PanDianListVO vData) {
            if (vData.getSuccess().equals("T")){

                if (!Kits.Empty.check(vData.getData())){
                    if (vData.getData().size()>0){
                        //刷新
                        activityVOList.clear();
                        activityVOList.addAll(vData.getData());
                        adapter.notifyDataSetChanged();
                    }
                }


            }


    }
    @Override
    protected void refresh() {

    }

    @Override
    protected void loadMore() {

    }




    @Override
    public void pandianSuccess() {
        Toast.makeText(this,"盘点成功",Toast.LENGTH_SHORT).show();
        T.showToastSafe("盘点成功");
    }

    @Override
    public void pandianMiss() {
        Toast.makeText(this,"盘点失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent=new Intent(this, ZxdlrDetailActivity.class);
        intent.putExtra("id",activityVOList.get(position).getId());
        intent.putExtra("disabled",activityVOList.get(position).getDisabled());//判断是否作废
        startActivity(intent);
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
                            Toast.makeText(this, "请先授权", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(this, "请先授权", Toast.LENGTH_SHORT).show();
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // 扫描二维码/条码回传   装箱单
        if (requestCode == 927 && resultCode == 10086) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);


//                用来区分是扫装箱单 还是扫库位   默认为0，单据上的装箱单为1，库位为2,货物上的装箱单为3
                if (type == 1) {
                    etNumber.setText(content);//显示出来

                    panDianPresenter.getPandian(content);//扫描装箱单进行盘点



                } else if (type == 2) {
                    etKwNumber.setText(content);//扫码返回的库位号码

                    //通过库位请求没有出库的装箱单列表
                    panDianPresenter.getFreeLoc(content);

                }else {

                }

            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
