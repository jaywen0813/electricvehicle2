package com.android.app.electricvehicle.ui.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.GetChars;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpFragment;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutDetailVO2;
import com.android.app.electricvehicle.model.main.contract.OUTContractSO2;
import com.android.app.electricvehicle.model.main.presenter.OUTPresenterSO2;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.activity.OUTDetailActivity;
import com.android.app.electricvehicle.ui.activity.ZxingActivity;
import com.android.app.electricvehicle.ui.adapter.SOOutAdapter;

import com.android.app.electricvehicle.ui.adapter.SOOutAdapter_SoItem;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class SOOutFragment extends BaseMvpFragment<OUTContractSO2.View, OUTPresenterSO2> implements OUTContractSO2.View, View.OnClickListener {


    private EditText tvOrder;
    private EditText tvSo;
    private RoundTextView tvChaxun;
    private TextView tvGzdh;
    private TextView tvKwh;
    private TextView tvDate;
    private TextView tvNumber;
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
    private TextView tvOrder1;
    private TextView tvComments;
    private TextView tvZzrq;
    private TextView tvDdjhq;
    private TextView tvTijiao;

    private RoundLinearLayout rll_detail;//有数据的时候显示详情

    private EditText et_number2;//二次扫描装箱单
    private LinearLayout ll_saomiao3;//扫描按钮


    private ListView lv;
    ScrollView scrollView;


//    List<OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean> list=new ArrayList<>();
//    SOOutAdapter_SoItem adapter_soItem;

    ;
    List<OutDetailVO2.DataBean> list = new ArrayList<>();
    SOOutAdapter adapter;


    int type_chaxun = 0;//证明查询了数据，如果为1，代表查询到了装箱单号
    String type_PackingCode = "";//用来记录PackingCode


    //弹出框
    PopupWindow ppw;
    //弹出框界面
    View ppwView;
    LayoutInflater inflater;

    private LinearLayout llDialogClose;
    private TextView tvGzdh0;
    private TextView tvDate0;
    private TextView tv_kwh0;
    private TextView tvNumber0;
    private TextView tvKwNumber0;
    private TextView tvDjx0;
    private TextView tvGjx0;
    private TextView tvChang0;
    private TextView tvKuan0;
    private TextView tvGao0;
    private TextView tvJingzhong0;
    private TextView tvMaozhong0;
    private TextView tvZhuangtai0;
    private TextView tvDjgd0;
    private TextView tvDjdy0;
    private TextView tvDycs0;
    private TextView tvOrder0;
    private TextView tvComments0;
    private TextView tvZzrq0;
    private TextView tvDdjhq0;
    private LinearLayout tv_saomiao_zxd;
    private RoundTextView tv_chuku_zxd;
    private ListView lv_soitem;
    private EditText et_popup;

    //弹窗里面的SOitem列表
    List<OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean> list_item = new ArrayList<>();//SOitem的列表
    SOOutAdapter_SoItem adapter_soItem;


    static Handler mHandler;//进度条的计时器  这里设置静态的防止removeCallbacks无法将updateThread从message queue中移除
    static Runnable mRunnable;

    //记录上面的两个输入框的数据的
    String salesOrder;
    String soItem;

    @Override
    protected void initView(View view) {
        tvOrder = view.findViewById(R.id.tv_order);
        tvSo = view.findViewById(R.id.tv_so);
        tvChaxun = view.findViewById(R.id.tv_chaxun);
        tvGzdh = view.findViewById(R.id.tv_gzdh);
        tvKwh = view.findViewById(R.id.tv_kwh);
        tvDate = view.findViewById(R.id.tv_date);
        tvNumber = view.findViewById(R.id.tvNumber);
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
        tvOrder1 = view.findViewById(R.id.tv_order1);
        tvComments = view.findViewById(R.id.tv_comments);
        tvZzrq = view.findViewById(R.id.tv_zzrq);
        tvDdjhq = view.findViewById(R.id.tv_ddjhq);
        tvTijiao = view.findViewById(R.id.tv_tijiao);

        rll_detail = view.findViewById(R.id.rll_detail);


        scrollView = view.findViewById(R.id.scrollView);
        lv = view.findViewById(R.id.lv);

        et_number2 = view.findViewById(R.id.et_number2);//二次扫描
        ll_saomiao3 = view.findViewById(R.id.ll_saomiao3);//扫描

        tvChaxun.setOnClickListener(this);
        tvTijiao.setOnClickListener(this);
        ll_saomiao3.setOnClickListener(this);


        //切换爱车弹窗
        inflater = LayoutInflater.from(getContext());
        //实例化ppwView
        ppwView = inflater.inflate(R.layout.popupwindow_soout_fragment, null);
        //创建ppw对象
        /**
         * 第一个参数 是ppw要展示的界面的View对象
         * 第二个参数 是ppw的宽度
         * 第三个参数 是ppw的高度
         * 第四个参数 是ppw是否可以获得焦点，true表示可以
         */
        ppw = new PopupWindow(ppwView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        ppw.setFocusable(true);//设置当前的PopupWindow是否获取焦点：true-获取焦点
        ppw.setOutsideTouchable(true);//设置点击当前的popupWindow区域外的touch事件是否有效；


        llDialogClose = ppwView.findViewById(R.id.ll_dialog_close);
        tvGzdh0 = ppwView.findViewById(R.id.tv_gzdh);
        tvDate0 = ppwView.findViewById(R.id.tv_date);
        tvNumber0 = ppwView.findViewById(R.id.tvNumber);
        tvKwNumber0 = ppwView.findViewById(R.id.tv_kw_number);
        tvDjx0 = ppwView.findViewById(R.id.tv_djx);
        tvGjx0 = ppwView.findViewById(R.id.tv_gjx);
        tvChang0 = ppwView.findViewById(R.id.tv_chang);
        tvKuan0 = ppwView.findViewById(R.id.tv_kuan);
        tvGao0 = ppwView.findViewById(R.id.tv_gao);
        tvJingzhong0 = ppwView.findViewById(R.id.tv_jingzhong);
        tvMaozhong0 = ppwView.findViewById(R.id.tv_maozhong);
        tvZhuangtai0 = ppwView.findViewById(R.id.tv_zhuangtai);
        tvDjgd0 = ppwView.findViewById(R.id.tv_djgd);
        tvDjdy0 = ppwView.findViewById(R.id.tv_djdy);
        tvDycs0 = ppwView.findViewById(R.id.tv_dycs);
        tvOrder0 = ppwView.findViewById(R.id.tv_order);
        tvComments0 = ppwView.findViewById(R.id.tv_comments);
        tvZzrq0 = ppwView.findViewById(R.id.tv_zzrq);
        tvDdjhq0 = ppwView.findViewById(R.id.tv_ddjhq);
        tv_saomiao_zxd = ppwView.findViewById(R.id.tv_saomiao_zxd);
        tv_chuku_zxd = ppwView.findViewById(R.id.tv_chuku_zxd);
        tv_kwh0 = ppwView.findViewById(R.id.tv_kwh);
        lv_soitem = ppwView.findViewById(R.id.lv_soitem);
        et_popup=ppwView.findViewById(R.id.et_popup);

        llDialogClose.setOnClickListener(this);//关闭弹窗的
        tv_saomiao_zxd.setOnClickListener(this);//扫码按钮
        tv_chuku_zxd.setOnClickListener(this);//出库按钮


        popupWindowShowDetail();


    }

    //点击列表以后
    private void popupWindowShowDetail() {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                backgroundAlpha(0.3f, getActivity());
                ppw.showAtLocation(llDialogClose, Gravity.CENTER, 0, 10);


                //库位
                if (!Kits.Empty.check(list.get(position).getFreeLoc())) {
                    tv_kwh0.setText(list.get(position).getFreeLoc());
                }


                //状态
                if (!Kits.Empty.check(list.get(position).getInstoreStateText())) {
                    tvZhuangtai0.setText("状态:" + list.get(position).getInstoreStateText());


                }


                if (!Kits.Empty.check(list.get(position).getPackingList())) {
                    //工作单号
                    if (!Kits.Empty.check(list.get(position).getPackingList().getWorkCode())) {
                        tvGzdh0.setText(list.get(position).getPackingList().getWorkCode());
                    }


                    //日期
                    if (!Kits.Empty.check(list.get(position).getPackingList().getMadeTime())) {

                        long itime = Long.parseLong(list.get(position).getPackingList().getMadeTime());

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                        String timeText = format.format(itime);
                        tvDate0.setText(timeText + "");
                    }

                    //装箱单号
                    if (!Kits.Empty.check(list.get(position).getPackingList().getPackingCode())) {
                        tvNumber0.setText(list.get(position).getPackingList().getPackingCode());
                        type_PackingCode = list.get(position).getPackingList().getPackingCode();
                    }


                    //第几箱
                    if (!Kits.Empty.check(list.get(position).getPackingList().getRankNum())) {
                        tvDjx0.setText("第  " + list.get(position).getPackingList().getRankNum() + "  箱");
                    }

                    //共几箱
                    if (!Kits.Empty.check(list.get(position).getPackingList().getTotalNum())) {
                        tvGjx0.setText("共  " + list.get(position).getPackingList().getTotalNum() + "  箱");
                    }

                    //长
                    if (!Kits.Empty.check(list.get(position).getPackingList().getPackLength())) {
                        tvChang0.setText("长：" + list.get(position).getPackingList().getPackLength());
                    }
                    //宽
                    if (!Kits.Empty.check(list.get(position).getPackingList().getPackwidth())) {
                        tvKuan0.setText("宽：" + list.get(position).getPackingList().getPackwidth());
                    }
                    //高
                    if (!Kits.Empty.check(list.get(position).getPackingList().getPackHeight())) {
                        tvGao0.setText("高:" + list.get(position).getPackingList().getPackHeight());
                    }
                    //净重
                    if (!Kits.Empty.check(list.get(position).getPackingList().getNetWeight())) {
                        tvJingzhong0.setText("净重：" + list.get(position).getPackingList().getNetWeight());
                    }
                    //毛重
                    if (!Kits.Empty.check(list.get(position).getPackingList().getRoughWeight())) {
                        tvMaozhong0.setText("毛重：" + list.get(position).getPackingList().getRoughWeight());
                    }


                    //单据归档 0否  1是
                    if (!Kits.Empty.check(list.get(position).getPackingList().getBillArchived())) {
                        if (list.get(position).getPackingList().getBillArchived().equals("0")) {
                            tvDjgd0.setText("单据归档：否");
                        } else if (list.get(position).getPackingList().getBillArchived().equals("1")) {
                            tvDjgd0.setText("单据归档：是");
                        }

                    }

                    //单据打印
                    if (!Kits.Empty.check(list.get(position).getPackingList().getBillPrint())) {
                        if (list.get(position).getPackingList().getBillPrint().equals("0")) {
                            tvDjdy0.setText("单据打印：未打印");
                        } else if (list.get(position).getPackingList().getBillPrint().equals("1")) {
                            tvDjdy0.setText("单据打印：已打印");
                        } else if (list.get(position).getPackingList().getBillPrint().equals("2")) {
                            tvDjdy0.setText("单据打印：补打");
                        }

                    }
                    //打印次数
                    if (!Kits.Empty.check(list.get(position).getPackingList().getPrintTimes())) {
                        tvDycs0.setText("打印次数：" + list.get(position).getPackingList().getPrintTimes() + "次");
                    }


                    //Sales order
                    if (!Kits.Empty.check(list.get(position).getPackingList().getSalesOrder())) {
                        tvOrder0.setText(list.get(position).getPackingList().getSalesOrder());
                    }


                    //comments
                    if (!Kits.Empty.check(list.get(position).getPackingList().getComments())) {
                        tvComments0.setText(list.get(position).getPackingList().getComments());
                    }

                    //组装日期
                    if (!Kits.Empty.check(list.get(position).getPackingList().getInstallTime())) {

                        long itimes = Long.parseLong(list.get(position).getPackingList().getInstallTime());

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                        String timeText = format.format(itimes);
                        tvZzrq0.setText(timeText + "");


                    }

                    //订单交货期
                    if (!Kits.Empty.check(list.get(position).getPackingList().getDeliveryDate())) {

                        long itimess = Long.parseLong(list.get(position).getPackingList().getDeliveryDate());

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                        String timeText = format.format(itimess);
                        tvDdjhq0.setText(timeText + "");

                    }

                    adapter_soItem = new SOOutAdapter_SoItem(getContext(), list_item);
                    lv_soitem.setAdapter(adapter_soItem);


                    if (!Kits.Empty.check(list.get(position).getPackingList().getPackingListItems())) {
                        if (list.get(position).getPackingList().getPackingListItems().size() > 0) {

                            list_item.clear();
                            list_item.addAll(list.get(position).getPackingList().getPackingListItems());
                            adapter_soItem.notifyDataSetChanged();
                        }

                    }

                }
            }
        });


        //弹窗的关闭监听
        ppw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                backgroundAlpha(1f, getActivity());
                ppw.dismiss();
                ppw.setFocusable(false);

                //先清除
                if (mHandler != null) {
                    mHandler.removeCallbacksAndMessages(mRunnable);
                }

                //然后等待0.6秒再给点击事件
                mHandler = new Handler();
                mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        //弹出框以后，当关闭的时候，等待0.6秒给点击事件
//                        changeCarLl.setEnabled(true);//切换爱车

                    }
                };
                mHandler.postDelayed(mRunnable, 600);



                //关闭弹窗的时候也刷新一次数据
                salesOrder = tvOrder.getText().toString().trim();
                presenter.getSO(salesOrder, soItem);


            }

        });

    }

    @Override
    protected OUTPresenterSO2 initPresenter() {
        return new OUTPresenterSO2();
    }

    @Override
    protected int setLayoutById() {
        return R.layout.fragment_zhi_huan;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_chaxun:
                 salesOrder = tvOrder.getText().toString().trim();
                 soItem = tvSo.getText().toString().trim();

                if (Kits.Empty.check(salesOrder)) {
//                        T.showToastSafe("仓库ID不能为空");
                    Toast.makeText(getContext(), "SalesOrder不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

//                if (Kits.Empty.check(soItem)){
////                        T.showToastSafe("仓库ID不能为空");
//                    Toast.makeText(getContext(),"SoItem不能为空",Toast.LENGTH_LONG).show();
//                    return;
//                }

                presenter.getSO(salesOrder, soItem);
                break;

            case R.id.tv_tijiao:

                DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将此单出库?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter.getUP(type_PackingCode, tvKwh.getText().toString().trim());
                    }
                    dialog.dismiss();
                });
                break;
            case R.id.ll_saomiao3:
                requestPermissionsCamera();
                break;

            case R.id.ll_dialog_close://关闭弹窗
                //关闭弹窗
                backgroundAlpha(1f, getActivity());
                ppw.dismiss();
                break;

            case R.id.tv_saomiao_zxd://扫描按钮
                requestPermissionsCamera();
                break;
            case R.id.tv_chuku_zxd://出库按钮

                String et_string_pop=et_popup.getText().toString().trim();
                //当扫描货物和单据上面的装箱单号一样的时候，就可以调用出库的按钮了
                if (et_string_pop.equals(type_PackingCode)) {

                    //关闭弹窗
                    backgroundAlpha(1f, getActivity());
                    ppw.dismiss();

                    DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将装箱单号" + et_string_pop + "的货物出库?", (dialog, confirm) -> {
                        if (confirm) {


                            presenter.getUP(et_string_pop, tvKwh.getText().toString().trim());
                        }
                        dialog.dismiss();
                    });
                } else {
                    Toast.makeText(getContext(), "装箱单号不一致", Toast.LENGTH_LONG).show();
                }


                break;
        }
    }

    //点击出库以后的操作
    @Override
    public void showSuccess(OutDetailVO vDate) {
        if (vDate.getSuccess().equals("T")) {
            Toast.makeText(getContext(), "出库成功", Toast.LENGTH_LONG).show();
//            clearAllView();//清空数据
//            getActivity().finish();

            //刷新数据
            presenter.getSO(salesOrder, soItem);


            if (ppw.isShowing()){
                //关闭弹窗
                backgroundAlpha(1f, getActivity());
                ppw.dismiss();
            }


        } else {
            Toast.makeText(getContext(), vDate.getMessage() + "", Toast.LENGTH_LONG).show();
        }
    }

    public void clearAllView() {
        tvOrder.setText("");
        tvSo.setText("");
        tvGzdh.setText("");
        tvKwh.setText("");
        tvDate.setText("");
        tvNumber.setText("");

        tvKwNumber.setText("");
        tvDjx.setText("第  箱");
        tvGjx.setText("共  箱");
        tvChang.setText("长:");
        tvKuan.setText("宽:");
        tvGao.setText("高:");
        tvJingzhong.setText("净重:");
        tvMaozhong.setText("毛重:");
        tvZhuangtai.setText("状态:");
        tvDjgd.setText("单据归档:");
        tvDjdy.setText("单据打印:");
        tvDycs.setText("打印次数:");


        tvOrder1.setText("");
        tvComments.setText("");
        tvZzrq.setText("");
        tvDdjhq.setText("");


//        list.clear();
//        adapter_soItem.notifyDataSetChanged();


    }

    //SO查询详细信息后返回的信息
    @Override
    public void showDetail(OutDetailVO2 item) {

        if (item.getSuccess().equals("T")) {
            if (!(item.getData() == null || item.getData().equals(""))) {


                if (item.getData().size() > 0) {

                    scrollView.setVisibility(View.VISIBLE);
                    rll_detail.setVisibility(View.GONE);//客户要求是列表点击


                    //库位
                    if (!Kits.Empty.check(item.getData().get(0).getFreeLoc())) {
                        tvKwh.setText(item.getData().get(0).getFreeLoc());
                    }


                    //状态
                    if (!Kits.Empty.check(item.getData().get(0).getInstoreStateText())) {
                        tvZhuangtai.setText("状态:" + item.getData().get(0).getInstoreStateText());

                        if (item.getData().get(0).getInstoreStateText().equals("已入库") || item.getData().get(0).getInstoreStateText().equals("未出库")) {
//                            tvTijiao.setVisibility(View.VISIBLE);

                            tvTijiao.setVisibility(View.GONE);//2019年10月30日 17:21:40  改了需求 ，这里暂时不需要出库按钮
                        } else {
                            tvTijiao.setVisibility(View.GONE);
                        }

                    }


                    if (!Kits.Empty.check(item.getData().get(0).getPackingList())) {
                        //工作单号
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getWorkCode())) {
                            tvGzdh.setText(item.getData().get(0).getPackingList().getWorkCode());
                        }


                        //日期
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getMadeTime())) {

                            long itime = Long.parseLong(item.getData().get(0).getPackingList().getMadeTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                            String timeText = format.format(itime);
                            tvDate.setText(timeText + "");
                        }

                        //装箱单号
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackingCode())) {
                            tvNumber.setText(item.getData().get(0).getPackingList().getPackingCode());
                            type_PackingCode = item.getData().get(0).getPackingList().getPackingCode();
                        }


                        //第几箱
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getRankNum())) {
                            tvDjx.setText("第  " + item.getData().get(0).getPackingList().getRankNum() + "  箱");
                        }

                        //共几箱
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getTotalNum())) {
                            tvGjx.setText("共  " + item.getData().get(0).getPackingList().getTotalNum() + "  箱");
                        }

                        //长
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackLength())) {
                            tvChang.setText("长：" + item.getData().get(0).getPackingList().getPackLength());
                        }
                        //宽
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackwidth())) {
                            tvKuan.setText("宽：" + item.getData().get(0).getPackingList().getPackwidth());
                        }
                        //高
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackHeight())) {
                            tvGao.setText("高:" + item.getData().get(0).getPackingList().getPackHeight());
                        }
                        //净重
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getNetWeight())) {
                            tvJingzhong.setText("净重：" + item.getData().get(0).getPackingList().getNetWeight());
                        }
                        //毛重
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getRoughWeight())) {
                            tvMaozhong.setText("毛重：" + item.getData().get(0).getPackingList().getRoughWeight());
                        }


                        //状态(0暂存  1待入库  2已入库  3已出库)
//                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getStoreState())) {
//                            switch (item.getData().get(0).getPackingList().getStoreState()){
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
//
//                                    break;
//                                case "2":
//                                    tvZhuangtai.setText("状态：已入库");
//
//
//                                    tvTijiao.setVisibility(View.VISIBLE);//已出库的才有出库按钮
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
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getBillArchived())) {
                            if (item.getData().get(0).getPackingList().getBillArchived().equals("0")) {
                                tvDjgd.setText("单据归档：否");
                            } else if (item.getData().get(0).getPackingList().getBillArchived().equals("1")) {
                                tvDjgd.setText("单据归档：是");
                            }

                        }

                        //单据打印
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getBillPrint())) {
                            if (item.getData().get(0).getPackingList().getBillPrint().equals("0")) {
                                tvDjdy.setText("单据打印：未打印");
                            } else if (item.getData().get(0).getPackingList().getBillPrint().equals("1")) {
                                tvDjdy.setText("单据打印：已打印");
                            } else if (item.getData().get(0).getPackingList().getBillPrint().equals("2")) {
                                tvDjdy.setText("单据打印：补打");
                            }

                        }
                        //打印次数
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPrintTimes())) {
                            tvDycs.setText("打印次数：" + item.getData().get(0).getPackingList().getPrintTimes() + "次");
                        }


                        //Sales order
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getSalesOrder())) {
                            tvOrder.setText(item.getData().get(0).getPackingList().getSalesOrder());
                        }


                        //comments
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getComments())) {
                            tvComments.setText(item.getData().get(0).getPackingList().getComments());
                        }

                        //组装日期
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getInstallTime())) {

                            long itimes = Long.parseLong(item.getData().get(0).getPackingList().getInstallTime());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimes);
                            tvZzrq.setText(timeText + "");


                        }

                        //订单交货期
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getDeliveryDate())) {

                            long itimess = Long.parseLong(item.getData().get(0).getPackingList().getDeliveryDate());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText = format.format(itimess);
                            tvDdjhq.setText(timeText + "");

                        }


                        type_chaxun = 1;//证明查询到了数据


                        //listview
                        if (!(item.getData().get(0).getPackingList() != null && item.getData().get(0).getPackingList().equals(""))) {
//                            adapter_soItem=new SOOutAdapter_SoItem(getContext(),list);
//                            lv.setAdapter(adapter_soItem);
//                            //刷新
//                            list.clear();
//                            list.addAll(item.getData().get(0).getPackingList().getPackingListItems());
//                            adapter_soItem.notifyDataSetChanged();


                        }

                    }


                    adapter = new SOOutAdapter(getContext(), list);
                    lv.setAdapter(adapter);

                    list.clear();
                    list.addAll(item.getData());
                    adapter.notifyDataSetChanged();


                } else {
                    type_chaxun = 0;//证明没有查询到数据
                    rll_detail.setVisibility(View.GONE);
                    scrollView.setVisibility(View.GONE);

                }


            } else {
                type_chaxun = 0;//证明没有查询到数据
                rll_detail.setVisibility(View.GONE);
                scrollView.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(getContext(), item.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void showErr(String err) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
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

            startActivityForResult(intent, 928);


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


                            startActivityForResult(intent, 928);
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
                            startActivityForResult(intent, 928);

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
        if (requestCode == 928 && resultCode == 10086) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);


                et_number2.setText(content);
                et_popup.setText(content);

                //当扫描货物和单据上面的装箱单号一样的时候，就可以调用出库的按钮了
                if (content.equals(type_PackingCode)) {

                    //关闭弹窗
                    backgroundAlpha(1f, getActivity());
                    ppw.dismiss();


                    DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将装箱单号" + content + "的货物出库?", (dialog, confirm) -> {
                        if (confirm) {
                            String freeLoc = tvKwh.getText().toString().trim();

                            presenter.getUP(content, freeLoc);
                        }
                        dialog.dismiss();
                    });
                } else {
                    Toast.makeText(getContext(), "装箱单号不一致", Toast.LENGTH_LONG).show();
                }


            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }


    //---------------------------------------------------------------------------------------------------
    //弹窗以后的背景颜色蒙板
    public void backgroundAlpha(float bgAlpha, Activity context) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        context.getWindow().setAttributes(lp);
    }


}
