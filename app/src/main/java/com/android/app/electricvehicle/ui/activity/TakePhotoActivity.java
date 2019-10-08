package com.android.app.electricvehicle.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.DetailVO;
import com.android.app.electricvehicle.model.detail.contract.TakePhotoContract;
import com.android.app.electricvehicle.model.detail.presenter.TakePhotoPresenter;
import com.android.app.electricvehicle.utils.ImageUtils;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.ScreenUtil2;
import com.android.app.electricvehicle.utils.StatusBarUtils;
import com.android.app.electricvehicle.utils.T;
import com.android.app.electricvehicle.utils.UIUtils;
import com.android.app.electricvehicle.utils.imageloader.ILFactory;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TakePhotoActivity extends BaseMvpActivity<TakePhotoContract.View,TakePhotoPresenter> implements TakePhotoContract.View,View.OnClickListener,TakePhoto.TakeResultListener, InvokeListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private TextView tvUserName;
    private TextView tvChepai;
    private TextView tvVin;
    private TextView tvXinghao;
    private TextView tvPhone;
    private TextView tvGps;
    private LinearLayout llSaomiao;
    private ImageView imgPhoto1;
    private ImageView imgPhoto2;
    private TextView tvTijiao;


    private Dialog dialog;
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private int type = 0;//0第一张安装好的图,1第二张全身照,


    /**
     * 第一张安装好的图
     */
    private String pic1;

    /**
     * 第二张全身照
     */
    private String pic2;


    String id="";//上传的id
    String gps="";//上传的GPS
    String motorcycleId="";//车辆ID


    //提交成功以后弹出的提示框
    //弹出框
    PopupWindow ppw;
    //弹出框界面
    View ppwView;
    LayoutInflater inflater;

    //弹出框里面的控件
    TextView tv_back;
    TextView tv_add;
    LinearLayout ll_close;

    //区分选择了相机还是文件夹的照片
    int type_carmer=2;

    @Override
    protected int getLayoutById() {
        return R.layout.activity_take_photo;
    }


    @Override
    protected void initView() {


        super.initView();
        titleLayoutRl = findViewById(R.id.title_layout_rl);
        backLayout = findViewById(R.id.back_layout);
        tvLayerHead = findViewById(R.id.tv_layer_head);
        navigationUserLayout = findViewById(R.id.navigation_user_layout);
        farmInputSave = findViewById(R.id.farm_input_save);

        tvUserName = findViewById(R.id.tv_userName);//姓名
        tvChepai = findViewById(R.id.tv_chepai);//车牌
        tvVin = findViewById(R.id.tv_vin);//车架号
        tvXinghao = findViewById(R.id.tv_xinghao);//品牌型号
        tvPhone = findViewById(R.id.tv_phone);//联系方式
        tvGps = findViewById(R.id.tv_gps);//GPS设备码
        llSaomiao = findViewById(R.id.ll_saomiao);//扫描按钮
        imgPhoto1 = findViewById(R.id.img_photo1);//设备安装好位置的照片
        imgPhoto2 = findViewById(R.id.img_photo2);//车辆全景照片
        tvTijiao = findViewById(R.id.tv_tijiao);//提交按钮


        backLayout.setOnClickListener(this);
        llSaomiao.setOnClickListener(this);//扫描
        imgPhoto1.setOnClickListener(this);//第一张照片
        imgPhoto2.setOnClickListener(this);//第二张照片
        tvTijiao.setOnClickListener(this);

        navigationUserLayout.setOnClickListener(this);//编辑按钮

        id=getIntent().getStringExtra("id");

        //沉浸式标题栏
        //第一种方法
//        StatusBarUtils.with(this)
//                .setIsActionBar(true)
//                .clearActionBarShadow()
//                .setDrawable(getResources().getDrawable(R.drawable.shape_main_title))
//                .init();
//        titleLayoutRl.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_main_title));

        //第二种方法
        StatusBarUtils.with(this)
//                .setColor(getResources().getColor(R.color.color_2192BA))
                .setDrawable(getResources().getDrawable(R.drawable.shape_takephoto_title))
                .init();

        //第三种方法
//        StatusBarUtils.with(this)
//                .init();



        //实例化inflater
        inflater = LayoutInflater.from(TakePhotoActivity.this);
        //实例化ppwView
        ppwView = inflater.inflate(R.layout.ppw_takephoto, null);
        //创建ppw对象
        /**
         * 第一个参数 是ppw要展示的界面的View对象
         * 第二个参数 是ppw的宽度
         * 第三个参数 是ppw的高度
         * 第四个参数 是ppw是否可以获得焦点，true表示可以
         */
        ppw = new PopupWindow(ppwView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        ppw.setFocusable(false);//设置当前的PopupWindow是否获取焦点：true-获取焦点
        ppw.setOutsideTouchable(false);//设置点击当前的popupWindow区域外的touch事件是否有效；


        tv_back=ppwView.findViewById(R.id.tv_back);
        tv_add=ppwView.findViewById(R.id.tv_add);
        ll_close=ppwView.findViewById(R.id.ll_close);

        tv_back.setOnClickListener(this);
        tv_add.setOnClickListener(this);
        ll_close.setOnClickListener(this);


        presenter.getDetail(id);

    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        //获取详情
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_layout:
                finish();
                break;
            case R.id.ll_saomiao:
                requestPermissionsCamera();

                break;
            case R.id.img_photo1://第一张图
                type = 0;
                initDialog();
                break;
            case R.id.img_photo2://第二张图
                type = 1;
                initDialog();
                break;
            case R.id.tv_tijiao:

//                backgroundAlpha(0.3f, this);
//                ppw.showAtLocation(ll_close, Gravity.CENTER, 0, 100);

//                if (Kits.Empty.check(vin)) {
//                    T.showToastSafeError("暂未选择车辆");
//                    return;
//                }
                if (Kits.Empty.check(gps)) {
                    T.showToastSafe("请扫描GPS设备码");
                    return;
                }
                if (Kits.Empty.check(pic1)) {
                    T.showToastSafe("请选择设备安装安好位置的照片");
                    return;
                }
                if (Kits.Empty.check(pic2)) {
                    T.showToastSafe("请选择车辆全景照片");
                    return;
                }


                presenter.getPhoto(id,motorcycleId,gps,pic1,pic2);//网络请求

                break;

            case R.id.navigation_user_layout://编辑按钮

                navigationUserLayout.setVisibility(View.INVISIBLE);//编辑按钮隐藏
                tvTijiao.setVisibility(View.VISIBLE);//提交按钮显示，并且为蓝色
                tvTijiao.setEnabled(true);
                tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_989898));

                llSaomiao.setEnabled(false);//此时不可以点击扫描按钮,只可以编辑照片
                imgPhoto1.setEnabled(true);//照片为可编辑状态
                imgPhoto2.setEnabled(true);

                break;

            case R.id.tv_back:
                Intent intent2=new Intent(this, Main2Activity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.tv_add://ppw新增按钮 已经取消
                break;
            case R.id.ll_close:
                backgroundAlpha(1f, TakePhotoActivity.this);
                ppw.dismiss();

                //获取详情
                presenter.getDetail(id);

                break;
        }
    }


    @Override
    protected TakePhotoPresenter initPresenter() {
        return new TakePhotoPresenter();
    }

    //上传成功以后返回的方法
    @Override
    public void showActivity() {
        //弹出成功的窗口
        backgroundAlpha(0.3f, this);
        ppw.showAtLocation(ll_close, Gravity.CENTER, 0, 100);

    }

    //获取到了详情以后
    @Override
    public void detail(List<DetailVO.ResultBeanX.ResultBean> lists) {

        //姓名
        if (!(lists.get(0).getName()==null ||lists.get(0).getName().equals(""))){
            tvUserName.setText(lists.get(0).getName());
        }else {
            tvUserName.setText("");
        }

        //车牌
        if (!(lists.get(0).getPalteNum()==null ||lists.get(0).getPalteNum().equals(""))){
            tvChepai.setText("车牌号："+lists.get(0).getPalteNum());
        }else {
            tvChepai.setText("车牌号：");
        }


        //车架号
        if (!(lists.get(0).getBodyNum()==null ||lists.get(0).getBodyNum().equals(""))){
            tvVin.setText("车架号："+lists.get(0).getBodyNum());
        }else {
            tvVin.setText("车架号：");
        }


        //品牌型号
        if (!(lists.get(0).getModelNum()==null ||lists.get(0).getModelNum().equals(""))){
            tvXinghao.setText("品牌型号："+lists.get(0).getModelNum());
        }else {
            tvXinghao.setText("品牌型号：");
        }

        //联系方式
        if (!(lists.get(0).getPhone()==null ||lists.get(0).getPhone().equals(""))){
            tvPhone.setText("联系方式："+lists.get(0).getPhone());
        }else {
            tvPhone.setText("联系方式：");
        }


        //GPS设备码
        if (!(lists.get(0).getGpsDeviceId()==null ||lists.get(0).getGpsDeviceId().equals(""))){
            tvGps.setText(lists.get(0).getGpsDeviceId());
            gps=lists.get(0).getGpsDeviceId();
        }else {
            tvGps.setHint("点击扫码取得GPS设备码");
        }


        //车辆ID
        if (!(lists.get(0).getMotorcycleId()==null ||lists.get(0).getMotorcycleId().equals(""))){
            //车辆ID
            motorcycleId=lists.get(0).getMotorcycleId();
        }else {
            T.showToastSafe("获取车辆信息失败");
        }



        //设备安装好位置的照片
        if (!(lists.get(0).getPartPic()==null||lists.get(0).getPartPic().equals(""))){
            ILFactory.getLoader().loadNet(imgPhoto1, lists.get(0).getPartPic() + "");
        }else {
//            imgPhoto1.setImageResource(R.mipmap.ic_launcher_round_im);
        }


        //车辆全景照片
        if (!(lists.get(0).getOverallPic()==null||lists.get(0).getOverallPic().equals(""))){
            ILFactory.getLoader().loadNet(imgPhoto2, lists.get(0).getOverallPic() + "");
        }else {
//            imgPhoto2.setImageResource(R.mipmap.ic_launcher_round_im);
        }



        if (!(lists.get(0).getStep()==null ||lists.get(0).getStep().equals(""))){
            if (lists.get(0).getStep().equals("1")){//未完成时，不显示编辑按钮，显示提交按钮，并显示灰色,此时可以扫描GPS设备码,并且可以编辑照片
                navigationUserLayout.setVisibility(View.INVISIBLE);
                navigationUserLayout.setEnabled(false);
                tvTijiao.setVisibility(View.VISIBLE);
                tvTijiao.setEnabled(true);
                tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_989898));
                llSaomiao.setEnabled(true);

                imgPhoto1.setEnabled(true);
                imgPhoto2.setEnabled(true);


            }else if (lists.get(0).getStep().equals("2")){//已完成  显示编辑按钮，不显示提交按钮，并且不可以扫描GPS设备码
                navigationUserLayout.setVisibility(View.VISIBLE);
                navigationUserLayout.setEnabled(true);
                tvTijiao.setVisibility(View.INVISIBLE);
                tvTijiao.setEnabled(false);
                llSaomiao.setEnabled(false);

                imgPhoto1.setEnabled(false);
                imgPhoto2.setEnabled(false);

            }else {//其余情况，当未完成处理
                navigationUserLayout.setVisibility(View.INVISIBLE);
                navigationUserLayout.setEnabled(false);
                tvTijiao.setVisibility(View.VISIBLE);
                tvTijiao.setEnabled(true);
                tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_989898));
                llSaomiao.setEnabled(true);

                imgPhoto1.setEnabled(true);
                imgPhoto2.setEnabled(true);
            }

        }else {//其余情况当未完成处理
            navigationUserLayout.setVisibility(View.INVISIBLE);
            navigationUserLayout.setEnabled(false);
            tvTijiao.setVisibility(View.VISIBLE);
            tvTijiao.setEnabled(true);
            tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_989898));
            llSaomiao.setEnabled(true);

            imgPhoto1.setEnabled(true);
            imgPhoto2.setEnabled(true);
        }


    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }


    private void initDialog() {
        dialog = new Dialog(this, R.style.BottomAnimDialogStyle);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.ActionSheetDialogAnimation);
        View view = View.inflate(this, R.layout.bottom_anim_dialog_layout, null);
        view.findViewById(R.id.tv_item1).setOnClickListener(v -> {//照相机
            config(1);
            dialog.dismiss();
             type_carmer=1;
        });
        view.findViewById(R.id.tv_item2).setOnClickListener(v -> {//手机相册
            config(0);
            dialog.dismiss();
             type_carmer=0;
        });
        view.findViewById(R.id.tv_item3).setOnClickListener(v -> {
            dialog.dismiss();
        });
        window.setContentView(view);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }


    private void config(int index) {
        // 初始化TakePhoto选取头像的配置
        TakePhoto takePhoto = getTakePhoto();
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(1280).setAspectY(800);
        builder.setWithOwnCrop(true);
        File file = new File(Environment.getExternalStorageDirectory(),
                "/realname/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            if (!mkdirs) {
                T.showToastSafe("文件目录创建失败");
//                Toast.makeText(PzActivity.this, "文件目录创建失败", Toast.LENGTH_SHORT).show();
            }
        }
        Uri imageUri = Uri.fromFile(file);
        CompressConfig config = new CompressConfig.Builder()
                .setMaxSize(102400)
                .setMaxPixel(400)
                .create();
        takePhoto.onEnableCompress(config, true);
        if (index == 0) {
            takePhoto.onPickFromDocumentsWithCrop(imageUri, builder.create());
        } else {
            takePhoto.onPickFromCaptureWithCrop(imageUri, builder.create());
        }
    }



    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    /**
     * 适配图片的宽高
     *
     * @param imageView
     */
    private void setImageHeight(ImageView imageView) {
        int width = (ScreenUtil2.getScreenWidth(this) - UIUtils.dip2px(40)) ;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = width * 13 / 32;
        imageView.setLayoutParams(layoutParams);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }



    @Override
    public void takeSuccess(TResult result) {
        switch (type) {
            case 0:
                String imgPath1 = result.getImages().get(0).getOriginalPath();
                ILFactory.getLoader().loadNet(imgPhoto1, imgPath1);
                pic1 = ImageUtils.bitmapToString(imgPath1).replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
//                KLog.e(pic1);
                setImageHeight(imgPhoto1);//当选取照片以后，设置动态高度
                break;
            case 1:
                String imgPath2 = result.getImages().get(0).getOriginalPath();
                ILFactory.getLoader().loadNet(imgPhoto2, imgPath2);
                pic2 = ImageUtils.bitmapToString(imgPath2).replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
                setImageHeight(imgPhoto2);
                break;

            default:
                break;
        }

        //按钮颜色改变
        if (!(pic2==null||pic1==null||pic2.equals("")||pic1.equals(""))){
            tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_2282EE));
        }else {
            tvTijiao.setBackgroundColor(getResources().getColor(R.color.color_989898));
        }



    }

    @Override
    public void takeFail(TResult result, String msg) {
        T.showToastSafe(msg);
    }

    @Override
    public void takeCancel() {
        T.showToastSafe("取消");
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)){//等待授权
            this.invokeParam = invokeParam;
        }
        return type;
    }



    //重写activity中dispatchTouchEvent，判断popupWindow是否显示来决定是否往下分发事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ppw!=null&&ppw.isShowing()){
            return false; //源码建议返回true表示自身消费这个事件，不传递给子view，这里测试过返回true-false都可以

        }

        return super.dispatchTouchEvent(ev);
    }

    //ppw背景变化
    public void backgroundAlpha(float bgAlpha, Activity context) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        context.getWindow().setAttributes(lp);
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
            startActivityForResult(intent, 1122);




        }
    }


    //动态申请权限部分
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (type_carmer==0||type_carmer==1){//证明是上传照片的权限
            PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
            PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
        }else {


        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) { //安全写法，如果小于0，肯定会出错了
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        if (grantResult == PackageManager.PERMISSION_DENIED) { //这个是权限拒绝
                            T.showToastSafe("请先授权");
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
                            startActivityForResult(intent, 1122);
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
                            T.showToastSafe("请先授权");
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
                            startActivityForResult(intent, 1122);

                        }
                    }
                }
                break;


            default:
                break;
        }

        }

    }


    //返回的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // 扫描二维码/条码回传
        if (requestCode == 1122 && resultCode == 10086) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                tvGps.setText(content);
                gps=content;
            }
        }else {
            getTakePhoto().onActivityResult(requestCode, resultCode, data);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }



}
