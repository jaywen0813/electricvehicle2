package com.android.app.electricvehicle.ui.activity;

import android.content.Context;
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
import com.android.app.electricvehicle.utils.EChangeScrollView;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundTextView;

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

    List<ItemDetailOutVO.DataBean.PackingListBean.PackingListItemsBean> list = new ArrayList<>();
    ZXDOutAdapter_SoItem adapter_soItem;

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

    }

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
                            tvOrder.setText(vDate.getData().get(0).getPackingList().getSalesOrder());
                        }


                        //comments
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getComments())) {
                            tvComments.setText(vDate.getData().get(0).getPackingList().getComments());
                        }

                        //组装日期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getInstallTime())) {

                            long itimes = Long.parseLong(vDate.getData().get(0).getPackingList().getInstallTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimes);
                            tvZzrq.setText(timeText + "");


                        }

                        //订单交货期
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getDeliveryDate())) {

                            long itimess = Long.parseLong(vDate.getData().get(0).getPackingList().getDeliveryDate());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimess);
                            tvDdjhq.setText(timeText + "");

                        }


                        //备注
                        if (!Kits.Empty.check(vDate.getData().get(0).getPackingList().getRemark())) {
                            tvBz.setText(vDate.getData().get(0).getPackingList().getRemark());
                        }


                        if (vDate.getData().get(0).getPackingList().getPackingListItems() != null && vDate.getData().get(0).getPackingList().getPackingListItems().size() > 0) {
                            adapter_soItem = new ZXDOutAdapter_SoItem(this, list);
                            lv.setAdapter(adapter_soItem);
                            //刷新
                            list.clear();
                            list.addAll(vDate.getData().get(0).getPackingList().getPackingListItems());
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

    @Override
    public void loadingtext() {

    }

    @Override
    public void loadWanCheng() {

    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return null;
    }
}
