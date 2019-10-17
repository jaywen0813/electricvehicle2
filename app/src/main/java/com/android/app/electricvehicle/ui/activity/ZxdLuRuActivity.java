package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.PackingListItems;
import com.android.app.electricvehicle.entity.ZxdDetailAddVO;
import com.android.app.electricvehicle.model.main.contract.ZxdlrAddContract;
import com.android.app.electricvehicle.model.main.presenter.ZxdlrAddlPresenter;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.utils.Kits;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//首页的
public class ZxdLuRuActivity extends BaseMvpActivity<ZxdlrAddContract.View, ZxdlrAddlPresenter> implements ZxdlrAddContract.View, View.OnClickListener {

    private RelativeLayout titleLayoutRl;
    private LinearLayout backLayout;
    private TextView tvLayerHead;
    private LinearLayout navigationUserLayout;
    private TextView farmInputSave;
    private ScrollView scrollView;
    private EditText tvGzdh;
    private TextView tvDate;
    private EditText tvBzfs;
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

    List<PackingListItems> packingListItem =new ArrayList<>();//用来存储入参的

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
        tvBzfs = findViewById(R.id.tv_bzfs);
        tvDjx = findViewById(R.id.tv_djx);
        tvGjx = findViewById(R.id.tv_gjx);
        tvChang = findViewById(R.id.tv_chang);
        tvKuan = findViewById(R.id.tv_kuan);
        tvGao = findViewById(R.id.tv_gao);
        tvJingzhong = findViewById(R.id.tv_jingzhong);
        tvMaozhong = findViewById(R.id.tv_maozhong);
        llAdd = findViewById(R.id.ll_add);
        imgAdd = findViewById(R.id.img_add);

        backLayout.setOnClickListener(this);
        farmInputSave.setOnClickListener(this);
        imgAdd.setOnClickListener(this);

        tvLayerHead.setText("添加装箱单");
        addViewItem();//先添加一条
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

                childCount++;


                for (int i = 0; i <childCount ; i++) {
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

                String packingMaterial=tvBzfs.getText().toString().trim();//包装方式 去除多余的空隙

                String rankNum=tvDjx.getText().toString();//第几箱
                String totalNum=tvGjx.getText().toString();//共几箱
                String packLength=tvChang.getText().toString();//长
                String packwidth=tvKuan.getText().toString();//宽
                String packHeight=tvGao.getText().toString();//高
                String netWeight=tvJingzhong.getText().toString();//净重
                String roughWeight=tvMaozhong.getText().toString();//毛重


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

                    PackingListItems plist=new PackingListItems();
                    plist.setSoItem(soItem);
                    plist.setMaterial(material);
                    plist.setRl(rl);
                    plist.setAgl(agl);
                    plist.setQty(qty);

                    packingListItem.add(plist);

                }




                presenter.add(workCode,madeTime,packingMaterial,rankNum,totalNum,packLength,packwidth,packHeight,netWeight,roughWeight,packingListItem);





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

    @Override
    public Context getViewContext() {
        return this;
    }
}
