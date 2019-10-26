package com.android.app.electricvehicle.ui.activity;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseActivity;
import com.android.app.electricvehicle.ui.adapter.TuiJianPagerAdapter;
import com.android.app.electricvehicle.ui.fragment.ZXDoutFragment;
import com.android.app.electricvehicle.ui.fragment.SOOutFragment;

import java.util.ArrayList;

public class OUTDetailActivity2 extends BaseActivity implements View.OnClickListener {

    private LinearLayout backLayout;
    private TextView tvLayerHead;

    private TextView tvTuijian1;
    private TextView tvTuijian2;
    private TextView tvZhihuan1;
    private TextView tvZhihuan2;
    private ViewPager vp;
    //数据源
    ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    TuiJianPagerAdapter adapter;

    final static int TUIJIAN=0;
    final static int ZHIHUAN=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        super.initView();
        backLayout = (LinearLayout) findViewById(R.id.back_layout);
        tvLayerHead = (TextView) findViewById(R.id.tv_layer_head);

        tvTuijian1 = (TextView) findViewById(R.id.tv_tuijian1);
        tvTuijian2 = (TextView) findViewById(R.id.tv_tuijian2);
        tvZhihuan1 = (TextView) findViewById(R.id.tv_zhihuan1);
        tvZhihuan2 = (TextView) findViewById(R.id.tv_zhihuan2);
        vp = (ViewPager) findViewById(R.id.vp);

        tvLayerHead.setText("出库单");
        backLayout.setOnClickListener(this);
        tvTuijian1.setOnClickListener(this);
        tvTuijian2.setOnClickListener(this);
        tvZhihuan1.setOnClickListener(this);
        tvZhihuan2.setOnClickListener(this);

//构建数据源
        getData();
        //创建适配器对象
        adapter=new TuiJianPagerAdapter(getSupportFragmentManager(),fragments);
        //为ViewPager设置适配器

        vp.setAdapter(adapter);
        //为vp设置页面改变监听器
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //当页面被选中时触发的方法
            @Override
            public void onPageSelected(int position) {
                clear();
                switch (position){
                    case TUIJIAN:
                        tvTuijian1.setTextColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.colorPrimary));
                        tvTuijian2.setBackgroundColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.colorPrimary));
                        tvLayerHead.setText("装箱单出库");
                        break;
                    case ZHIHUAN:
                        tvZhihuan1.setTextColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.colorPrimary));
                        tvZhihuan2.setBackgroundColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.colorPrimary));
                        tvLayerHead.setText("SO出库");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected int getLayoutById() {
        return R.layout.activity_outdetail2;
    }

    private void getData() {
        ZXDoutFragment ck=new ZXDoutFragment();
        fragments.add(ck);
        SOOutFragment pc=new SOOutFragment();
        fragments.add(pc);
    }

    private void clear() {

        tvTuijian1.setTextColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.color_3d3d3d));
        tvZhihuan1.setTextColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.color_3d3d3d));
        tvTuijian2.setBackgroundColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.white));
        tvZhihuan2.setBackgroundColor(ActivityCompat.getColor(OUTDetailActivity2.this,R.color.white));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_tuijian1:

                vp.setCurrentItem(0);

                break;
            case R.id.tv_zhihuan1:
                vp.setCurrentItem(1);

                break;
            case R.id.back_layout:
                finish();
                break;
        }
    }
}
