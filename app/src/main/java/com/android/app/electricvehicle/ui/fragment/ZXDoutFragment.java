package com.android.app.electricvehicle.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpFragment;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.model.main.contract.OUTContract;
import com.android.app.electricvehicle.model.main.contract.OUTContract2;
import com.android.app.electricvehicle.model.main.presenter.OUTPresenter;
import com.android.app.electricvehicle.model.main.presenter.OUTPresenter2;
import com.android.app.electricvehicle.ui.activity.OUTDetailActivity;
import com.android.app.electricvehicle.ui.activity.OUTDetailActivity2;
import com.android.app.electricvehicle.ui.activity.ZxingActivity;
import com.android.app.electricvehicle.ui.adapter.ZXDOutAdapter_SoItem;
import com.android.app.electricvehicle.utils.DateTimeWheelDialog;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundTextView;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ZXDoutFragment extends BaseMvpFragment<OUTContract2.View, OUTPresenter2> implements OUTContract2.View, View.OnClickListener {

    View view;
    private EditText etNumber;
    private LinearLayout llSaomiao;
    private EditText etKwNumber;
    private LinearLayout llSaomiao2;
    private ScrollView scrollView;
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
    private TextView tvTijiao;
    private ListView lv;

    private RoundTextView tv_shoudong;//手动查询详情按钮
    private EditText et_number2;//二次扫描装箱单
    private LinearLayout ll_saomiao3;//扫描按钮


    int type = 0;//用来区分是扫装箱单 还是扫库位   默认为0，单据上的装箱单为1，库位为2，货物上的装箱单为3
    String packingCode_danju="";//用来记录单据上面的装箱单号

    TextView tv_order;
    TextView tv_comments;
    TextView tv_zzrq;
    TextView tv_ddjhq;


    List<ItemDetailOutVO.DataBean.PackingListBean.PackingListItemsBean> list = new ArrayList<>();
    ZXDOutAdapter_SoItem adapter_soItem;

    String outstoreCode2="";//记录输入框的

    @Override
    protected void initView(View view) {
        etNumber = view.findViewById(R.id.et_number);
        llSaomiao = view.findViewById(R.id.ll_saomiao);
        etKwNumber = view.findViewById(R.id.et_kw_number);
        llSaomiao2 = view.findViewById(R.id.ll_saomiao2);
        et_number2=view.findViewById(R.id.et_number2);//二次扫描
        ll_saomiao3=view.findViewById(R.id.ll_saomiao3);//扫描
        scrollView = view.findViewById(R.id.scrollView);
        tvZhid = view.findViewById(R.id.tv_zhid);
        tvGzdh = view.findViewById(R.id.tv_gzdh);
        tvDate = view.findViewById(R.id.tv_date);
        tvNumber = view.findViewById(R.id.tv_number);
        tvZxdid = view.findViewById(R.id.tv_zxdid);
        tvCkmc = view.findViewById(R.id.tv_ckmc);
        tvCkid = view.findViewById(R.id.tv_ckid);
        tvKwNumber = view.findViewById(R.id.tv_kw_number);
        tvDjx = view.findViewById(R.id.tv_djx);
        tvGjx = view.findViewById(R.id.tv_gjx);
        tvChang = view.findViewById(R.id.tv_chang);
        tvKuan = view.findViewById(R.id.tv_kuan);
        tvGao = view.findViewById(R.id.tv_gao);
        tvJingzhong = view.findViewById(R.id.tv_jingzhong);
        tvMaozhong = view.findViewById(R.id.tv_maozhong);
        tvZhuangtai = view.findViewById(R.id.tv_zhuangtai);
        tvDjgd = view.findViewById(R.id.tv_djgd);
        tvDjdy = view.findViewById(R.id.tv_djdy);
        tvDycs = view.findViewById(R.id.tv_dycs);
        tvBz = view.findViewById(R.id.tv_bz);
        tvTijiao = view.findViewById(R.id.tv_tijiao);

        tv_order = view.findViewById(R.id.tv_order);
        tv_comments = view.findViewById(R.id.tv_comments);
        tv_zzrq = view.findViewById(R.id.tv_zzrq);
        tv_ddjhq = view.findViewById(R.id.tv_ddjhq);
        lv = view.findViewById(R.id.lv);
        tv_shoudong=view.findViewById(R.id.tv_shoudong);

        llSaomiao.setOnClickListener(this);
        llSaomiao2.setOnClickListener(this);
        ll_saomiao3.setOnClickListener(this);
        tvTijiao.setOnClickListener(this);

        tv_zzrq.setOnClickListener(this);
        tv_ddjhq.setOnClickListener(this);
        tv_shoudong.setOnClickListener(this);

    }

    @Override
    protected OUTPresenter2 initPresenter() {
        return new OUTPresenter2();
    }

    @Override
    protected int setLayoutById() {
        return R.layout.fragment_tui_jian;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_saomiao://扫描单据上的装箱单号
                type = 1;
                requestPermissionsCamera();
                break;
            case R.id.ll_saomiao2://扫描库位号
                type = 2;
                requestPermissionsCamera();
                break;

            case R.id.ll_saomiao3://扫描货物上的装箱单号
                type = 3;
                requestPermissionsCamera();
                break;


            case R.id.tv_tijiao://提交出库按钮
                String outstoreCode = etNumber.getText().toString().trim();
                String freeLoc = etKwNumber.getText().toString().trim();
                String outstoreCode3=et_number2.getText().toString().trim();

                if (Kits.Empty.check(outstoreCode)) {
                    Toast.makeText(getContext(), "单据号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                //网络请求  提交数据

                if (Kits.Empty.check(outstoreCode3)) {
                    Toast.makeText(getContext(), "货物单号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (outstoreCode.equals(outstoreCode3)){//相同的话
                    DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将装箱单号"+outstoreCode+"的货物出库?", (dialog, confirm) -> {
                        if (confirm) {

                            presenter.getUP(outstoreCode, freeLoc);
                        }
                        dialog.dismiss();

                    });
                }else {
                    Toast.makeText(getContext(),"两次输入的装箱单号不一致",Toast.LENGTH_LONG).show();
                }






                break;
            case R.id.tv_shoudong://手动查询按钮

                 outstoreCode2 = etNumber.getText().toString().trim();

                presenter.getZXD(outstoreCode2, getContext());
                break;
        }
    }


    //相机权限
    private void requestPermissionsCamera() {
        List<String> permissionList = new ArrayList<>();
//        允许程序打开相机
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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


            Intent intent = new Intent(getContext(), ZxingActivity.class);
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
                            Toast.makeText(getContext(), "请先授权", Toast.LENGTH_SHORT).show();
                        } else { //授权成功了
                            //do Something
                            Intent intent = new Intent(getContext(), ZxingActivity.class);
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
                            Toast.makeText(getContext(), "请先授权", Toast.LENGTH_SHORT).show();
                        } else { //授权成功了
                            //do Something
                            //扫一扫
                            Intent intent = new Intent(getContext(), ZxingActivity.class);
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

                    presenter.getZXD(content, getContext());

                    packingCode_danju=content;

                } else if (type == 2) {
                    etKwNumber.setText(content);//扫码返回的库位号码

                }else if (type==3){
                    et_number2.setText(content);

                    String outstoreCode = etNumber.getText().toString().trim();//防止用户是手动输入的上面的单号


                    //当扫描货物和单据上面的装箱单号一样的时候，就可以调用出库的按钮了
                    if (content.equals(packingCode_danju) || content.equals(outstoreCode)){
                        DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将装箱单号"+content+"的货物出库?", (dialog, confirm) -> {
                            if (confirm) {
                                String freeLoc = etKwNumber.getText().toString().trim();

                                presenter.getUP(content, freeLoc);
                            }
                            dialog.dismiss();
                        });
                    }

                }

            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    //点击出库以后返回的操作
    @Override
    public void showSuccess(OutDetailVO vDate) {
        //        T.showToastSafe("提交成功");

        if (vDate.getSuccess().equals("T")) {
            Toast.makeText(getContext(), "出库成功", Toast.LENGTH_LONG).show();
//            clearAllView();//清空所有的数据
//            getActivity().finish();
            outstoreCode2 = etNumber.getText().toString().trim();

            presenter.getZXD(outstoreCode2, getContext());//刷新数据
        } else {
            Toast.makeText(getContext(), vDate.getMessage() + "", Toast.LENGTH_LONG).show();
        }
    }


    public void clearAllView(){
        etNumber.setText("");

        etKwNumber.setText("");

        et_number2.setText("");//二次扫描


        tvZhid.setText("");
        tvGzdh .setText("");
        tvDate .setText("");
        tvNumber .setText("");
        tvZxdid .setText("");
        tvCkmc.setText("");
        tvCkid .setText("");
        tvKwNumber .setText("");
        tvDjx .setText("第  箱");
        tvGjx .setText("共  箱");
        tvChang .setText("长:");
        tvKuan .setText("宽:");
        tvGao .setText("高:");
        tvJingzhong.setText("净重:");
        tvMaozhong .setText("毛重:");
        tvZhuangtai .setText("状态:");
        tvDjgd .setText("单据归档:");
        tvDjdy.setText("单据打印:");
        tvDycs .setText("打印次数:");
        tvBz .setText("");


        tv_order.setText("");
        tv_comments.setText("");
        tv_zzrq.setText("");
        tv_ddjhq.setText("");

        list.clear();
        adapter_soItem.notifyDataSetChanged();
    }



    //扫码获取装箱单号以后的详情
    @Override
    public void showDetail(ItemDetailOutVO vDate) {

        if (vDate.getSuccess().equals("T")) {

            if (!Kits.Empty.check(vDate.getData())) {

                scrollView.setVisibility(View.VISIBLE);


                if (vDate.getData().size() > 0) {

                    //库位号
                    if (!Kits.Empty.check(vDate.getData().get(0).getFreeLoc())) {
                        etKwNumber.setText(vDate.getData().get(0).getFreeLoc());
                    }


                    //状态
                    if (!Kits.Empty.check(vDate.getData().get(0).getInstoreStateText())){
                        tvZhuangtai.setText("状态:"+vDate.getData().get(0).getInstoreStateText());

                        if (vDate.getData().get(0).getInstoreStateText().equals("已入库")|| vDate.getData().get(0).getInstoreStateText().equals("未出库")){
                            tvTijiao.setVisibility(View.VISIBLE);
                        }else {
                            tvTijiao.setVisibility(View.INVISIBLE);
                        }

                    }



                    if (!Kits.Empty.check(vDate.getData().get(0).getPackingList())) {


                        //工作单号
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getWorkCode())) {
                            tvGzdh.setText(vDate.getData().get(0).getPackingList().getWorkCode());
                        }
                        //日期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getMadeTime())) {

                            long itime = Long.parseLong(vDate.getData().get(0).getPackingList().getMadeTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                            String timeText = format.format(itime);
                            tvDate.setText(timeText + "");
                        }

                        //装箱单号
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getPackingCode())) {
                            tvNumber.setText(vDate.getData().get(0).getPackingList().getPackingCode());
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
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getRankNum())) {
                            tvDjx.setText("第  " + vDate.getData().get(0).getPackingList().getRankNum() + "  箱");
                        }

                        //共几箱
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getTotalNum())) {
                            tvGjx.setText("共  " + vDate.getData().get(0).getPackingList().getTotalNum() + "  箱");
                        }

                        //长
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getPackLength())) {
                            tvChang.setText("长：" + vDate.getData().get(0).getPackingList().getPackLength());
                        }
                        //宽
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getPackwidth())) {
                            tvKuan.setText("宽：" + vDate.getData().get(0).getPackingList().getPackwidth());
                        }
                        //高
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getPackHeight())) {
                            tvGao.setText("高:" + vDate.getData().get(0).getPackingList().getPackHeight());
                        }
                        //净重
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getNetWeight())) {
                            tvJingzhong.setText("净重：" + vDate.getData().get(0).getPackingList().getNetWeight());
                        }
                        //毛重
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getRoughWeight())) {
                            tvMaozhong.setText("毛重：" + vDate.getData().get(0).getPackingList().getRoughWeight());
                        }


                        //状态(0暂存  1待入库  2已入库  3已出库)
//                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getStoreState())) {
//                            switch (vDate.getData().get(0).getPackingList().getStoreState()) {
//                                case "0":
//                                    tvZhuangtai.setText("状态：暂存");
//
//
//                                    tvTijiao.setVisibility(View.INVISIBLE);
//                                    break;
//
//                                case "1":
//                                    tvZhuangtai.setText("状态：待入库");
//
//
//                                    tvTijiao.setVisibility(View.INVISIBLE);
//                                    break;
//                                case "2":
//                                    tvZhuangtai.setText("状态：已入库");
//
//
//                                    tvTijiao.setVisibility(View.VISIBLE);//这个时候才能显示出库按钮，否则不显示
//                                    break;
//                                case "3":
//                                    tvZhuangtai.setText("状态：已出库");
//
//
//                                    tvTijiao.setVisibility(View.INVISIBLE);
//                                    break;
//
//                            }
//
//
//                        }


                        //单据归档 0否  1是
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getBillArchived())) {
                            if (vDate.getData().get(0).getPackingList().getBillArchived().equals("0")) {
                                tvDjgd.setText("单据归档：否");
                            } else if (vDate.getData().get(0).getPackingList().getBillArchived().equals("1")) {
                                tvDjgd.setText("单据归档：是");
                            }

                        }

                        //单据打印
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getBillPrint())) {
                            if (vDate.getData().get(0).getPackingList().getBillPrint().equals("0")) {
                                tvDjdy.setText("单据打印：未打印");
                            } else if (vDate.getData().get(0).getPackingList().getBillPrint().equals("1")) {
                                tvDjdy.setText("单据打印：已打印");
                            } else if (vDate.getData().get(0).getPackingList().getBillPrint().equals("2")) {
                                tvDjdy.setText("单据打印：补打");
                            }

                        }
                        //打印次数
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getPrintTimes())) {
                            tvDycs.setText("打印次数：" + vDate.getData().get(0).getPackingList().getPrintTimes() + "次");
                        }


                        //Sales order
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getSalesOrder())) {
                            tv_order.setText(vDate.getData().get(0).getPackingList().getSalesOrder());
                        }


                        //comments
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getComments())) {
                            tv_comments.setText(vDate.getData().get(0).getPackingList().getComments());
                        }

                        //组装日期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getInstallTime())) {

                            long itimes = Long.parseLong(vDate.getData().get(0).getPackingList().getInstallTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimes);
                            tv_zzrq.setText(timeText + "");


                        }

                        //订单交货期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getDeliveryDate())) {

                            long itimess = Long.parseLong(vDate.getData().get(0).getPackingList().getDeliveryDate());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimess);
                            tv_ddjhq.setText(timeText + "");

                        }


                        //备注
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getRemark())) {
                            tvBz.setText(vDate.getData().get(0).getPackingList().getRemark());
                        }


                        if (vDate.getData().get(0).getPackingList().getPackingListItems() != null && vDate.getData().get(0).getPackingList().getPackingListItems().size() > 0) {
                            adapter_soItem = new ZXDOutAdapter_SoItem(getContext(), list);
                            lv.setAdapter(adapter_soItem);
                            //刷新
                            list.clear();
                            list.addAll(vDate.getData().get(0).getPackingList().getPackingListItems());
                            adapter_soItem.notifyDataSetChanged();
                        }

                    }

                }
            }else {
                Toast.makeText(getContext(), "暂未查询到装箱单信息", Toast.LENGTH_SHORT).show();
                scrollView.setVisibility(View.INVISIBLE);//隐藏下面控件
            }

        } else {
            Toast.makeText(getContext(), vDate.getMessage(), Toast.LENGTH_SHORT).show();
            scrollView.setVisibility(View.INVISIBLE);//隐藏下面控件
        }
    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

}
