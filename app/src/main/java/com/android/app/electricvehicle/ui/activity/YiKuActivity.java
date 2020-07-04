package com.android.app.electricvehicle.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.model.main.contract.YiKuContract;
import com.android.app.electricvehicle.model.main.presenter.YiKuPresenter;
import com.android.app.electricvehicle.ui.adapter.ZXDOutAdapter_SoItem;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.EChangeScrollView;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundTextView;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class YiKuActivity extends BaseMvpActivity<YiKuContract.View, YiKuPresenter> implements YiKuContract.View, View.OnClickListener {

    YiKuPresenter yiKuPresenter;
    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private EditText etNumber;
    private LinearLayout llSaomiao;
    private RoundTextView tvShoudong;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;
    private EChangeScrollView scrollView;
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
    private TextView tvOrder;
    private TextView tvComments;
    private TextView tvZzrq;
    private TextView tvDdjhq;
    private TextView tvBz;
    private ListView lv;
    private LinearLayout ll_shanchu,ll_shanchu2;//清空扫码框的内容

    List<ItemDetailOutVO.DataBean.PackingBean.PackingItemsBean> list = new ArrayList<>();
    ZXDOutAdapter_SoItem adapter_soItem;

    int type = 0;//用来区分是扫装箱单 还是扫库位    默认为0，单据上的装箱单为1，库位为2，

    String outstoreCode2="";//记录输入框的

    String id="";//修改移库的时候的id

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
        etNumber = (EditText) findViewById(R.id.et_number);
        llSaomiao = (LinearLayout) findViewById(R.id.ll_saomiao);
        tvShoudong = (RoundTextView) findViewById(R.id.tv_shoudong);
        etKwNumber = (EditText) findViewById(R.id.et_kw_number);
        llSaomiao2 = (LinearLayout) findViewById(R.id.ll_saomiao2);
        scrollView = (EChangeScrollView) findViewById(R.id.scrollView);
        tvZhid = (TextView) findViewById(R.id.tv_zhid);
        tvGzdh = (TextView) findViewById(R.id.tv_gzdh);
        tvDate = (TextView) findViewById(R.id.tv_date);
        tvNumber = (TextView) findViewById(R.id.tv_number);
        tvZxdid = (TextView) findViewById(R.id.tv_zxdid);
        tvCkmc = (TextView) findViewById(R.id.tv_ckmc);
        tvCkid = (TextView) findViewById(R.id.tv_ckid);
        tvKwNumber = (TextView) findViewById(R.id.tv_kw_number);
        tvDjx = (TextView) findViewById(R.id.tv_djx);
        tvGjx = (TextView) findViewById(R.id.tv_gjx);
        tvChang = (TextView) findViewById(R.id.tv_chang);
        tvKuan = (TextView) findViewById(R.id.tv_kuan);
        tvGao = (TextView) findViewById(R.id.tv_gao);
        tvJingzhong = (TextView) findViewById(R.id.tv_jingzhong);
        tvMaozhong = (TextView) findViewById(R.id.tv_maozhong);
        tvZhuangtai = (TextView) findViewById(R.id.tv_zhuangtai);
        tvDjgd = (TextView) findViewById(R.id.tv_djgd);
        tvDjdy = (TextView) findViewById(R.id.tv_djdy);
        tvDycs = (TextView) findViewById(R.id.tv_dycs);
        tvOrder = (TextView) findViewById(R.id.tv_order);
        tvComments = (TextView) findViewById(R.id.tv_comments);
        tvZzrq = (TextView) findViewById(R.id.tv_zzrq);
        tvDdjhq = (TextView) findViewById(R.id.tv_ddjhq);
        tvBz = (TextView) findViewById(R.id.tv_bz);
        lv = (ListView) findViewById(R.id.lv);
        ll_shanchu=findViewById(R.id.ll_shanchu);
        ll_shanchu2=findViewById(R.id.ll_shanchu2);

        llSaomiao.setOnClickListener(this);
        llSaomiao2.setOnClickListener(this);
        tvShoudong.setOnClickListener(this);

        navigationUserLayout.setOnClickListener(this);

        ll_shanchu.setOnClickListener(this);
        ll_shanchu2.setOnClickListener(this);



    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_yi_ku;
    }

    @Override
    protected YiKuPresenter initPresenter() {
        yiKuPresenter=new YiKuPresenter();
        return yiKuPresenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_saomiao://扫描单据上的装箱单号
                type = 1;
                requestPermissionsCamera();
                break;
            case R.id.ll_saomiao2://扫描库位号
                type = 2;
                requestPermissionsCamera();
                break;
            case R.id.tv_shoudong://手动查询按钮

                outstoreCode2 = etNumber.getText().toString().trim();

                presenter.getZXD(outstoreCode2, this);
                break;
            case R.id.ll_shanchu:
                etNumber.setText("");
                break;
            case R.id.ll_shanchu2:
                etKwNumber.setText("");
                break;
            case R.id.navigation_user_layout://移库提交
                if (Kits.Empty.check(etKwNumber.getText().toString())){
                    Toast.makeText(this,"库位号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getKWH(id,etKwNumber.getText().toString());//移库提交
                break;

        }
    }

    @Override
    public void showDetail(ItemDetailOutVO vDate) {
        if (vDate.getSuccess().equals("T")) {

            if (!Kits.Empty.check(vDate.getData())) {

                scrollView.setVisibility(View.VISIBLE);


                if (vDate.getData().size() > 0) {

                    //id
                    if (!Kits.Empty.check(vDate.getData().get(0).getId())) {
                        id=vDate.getData().get(0).getId();
                    }

                    //库位号
                    if (!Kits.Empty.check(vDate.getData().get(0).getFreeLoc())) {
                        etKwNumber.setText(vDate.getData().get(0).getFreeLoc());
                    }



                    if (!Kits.Empty.check(vDate.getData().get(0).getPacking())) {


                        //工作单号
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getWorkCode())) {
                            tvGzdh.setText(vDate.getData().get(0).getPacking().getWorkCode());
                        }
                        //日期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getMadeTime())) {

                            long itime = Long.parseLong(vDate.getData().get(0).getPacking().getMadeTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                            String timeText = format.format(itime);
                            tvDate.setText(timeText + "");
                        }

                        //装箱单号
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getPackingCode())) {
                            tvNumber.setText(vDate.getData().get(0).getPacking().getPackingCode());
                        }


                        //第几箱
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getRankNum())) {
                            tvDjx.setText("第  " + vDate.getData().get(0).getPacking().getRankNum() + "  箱");
                        }

                        //共几箱
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getTotalNum())) {
                            tvGjx.setText("共  " + vDate.getData().get(0).getPacking().getTotalNum() + "  箱");
                        }

                        //长
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getPackLength())) {
                            tvChang.setText("长：" + vDate.getData().get(0).getPacking().getPackLength());
                        }
                        //宽
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getPackwidth())) {
                            tvKuan.setText("宽：" + vDate.getData().get(0).getPacking().getPackwidth());
                        }
                        //高
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getPackHeight())) {
                            tvGao.setText("高:" + vDate.getData().get(0).getPacking().getPackHeight());
                        }
                        //净重
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getNetWeight())) {
                            tvJingzhong.setText("净重：" + vDate.getData().get(0).getPacking().getNetWeight());
                        }
                        //毛重
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getRoughWeight())) {
                            tvMaozhong.setText("毛重：" + vDate.getData().get(0).getPacking().getRoughWeight());
                        }





                        //单据归档 0否  1是
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getBillArchived())) {
                            if (vDate.getData().get(0).getPacking().getBillArchived().equals("0")) {
                                tvDjgd.setText("单据归档：否");
                            } else if (vDate.getData().get(0).getPacking().getBillArchived().equals("1")) {
                                tvDjgd.setText("单据归档：是");
                            }

                        }

                        //单据打印
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getBillPrint())) {
                            if (vDate.getData().get(0).getPacking().getBillPrint().equals("0")) {
                                tvDjdy.setText("单据打印：未打印");
                            } else if (vDate.getData().get(0).getPacking().getBillPrint().equals("1")) {
                                tvDjdy.setText("单据打印：已打印");
                            } else if (vDate.getData().get(0).getPacking().getBillPrint().equals("2")) {
                                tvDjdy.setText("单据打印：补打");
                            }

                        }
                        //打印次数
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getPrintTimes())) {
                            tvDycs.setText("打印次数：" + vDate.getData().get(0).getPacking().getPrintTimes() + "次");
                        }


                        //Sales order
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getSalesOrder())) {
                            tvOrder.setText(vDate.getData().get(0).getPacking().getSalesOrder());
                        }


                        //comments
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getComments())) {
                            tvComments.setText(vDate.getData().get(0).getPacking().getComments());
                        }

                        //组装日期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getInstallTime())) {

                            long itimes = Long.parseLong(vDate.getData().get(0).getPacking().getInstallTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimes);
                            tvZzrq.setText(timeText + "");


                        }

                        //订单交货期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getDeliveryDate())) {

                            long itimess = Long.parseLong(vDate.getData().get(0).getPacking().getDeliveryDate());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimess);
                            tvDdjhq.setText(timeText + "");

                        }


                        //备注
                        if (!Kits.Empty.check(vDate.getData().get(0).getPacking().getRemark())) {
                            tvBz.setText(vDate.getData().get(0).getPacking().getRemark());
                        }


                        if (vDate.getData().get(0).getPacking().getPackingItems() != null && vDate.getData().get(0).getPacking().getPackingItems().size() > 0) {
                            adapter_soItem = new ZXDOutAdapter_SoItem(this, list);
                            lv.setAdapter(adapter_soItem);
                            //刷新
                            list.clear();
                            list.addAll(vDate.getData().get(0).getPacking().getPackingItems());
                            adapter_soItem.notifyDataSetChanged();
                        }

                    }

                }
            }else {
                Toast.makeText(this, "暂未查询到装箱单信息", Toast.LENGTH_SHORT).show();
                scrollView.setVisibility(View.INVISIBLE);//隐藏下面控件
            }

        } else {
            Toast.makeText(this, vDate.getMessage(), Toast.LENGTH_SHORT).show();
            scrollView.setVisibility(View.INVISIBLE);//隐藏下面控件
        }
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

                    presenter.getZXD(content, this);



                } else if (type == 2) {
                    etKwNumber.setText(content);//扫码返回的库位号码

                }else {

                }

            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void loadingtext() {

    }

    @Override
    public void loadWanCheng() {

    }

    //移库提示成功的回调
    @Override
    public void yikuSuccess() {
        Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
    }

    //移库提示失败的回调
    @Override
    public void yikuMiss() {
        Toast.makeText(this,"修改失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
