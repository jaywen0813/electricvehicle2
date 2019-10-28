package com.android.app.electricvehicle.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.GetChars;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
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
import com.android.app.electricvehicle.ui.adapter.SOOutAdapter;
import com.android.app.electricvehicle.ui.adapter.SOOutAdapter_SoItem;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class SOOutFragment extends BaseMvpFragment<OUTContractSO2.View, OUTPresenterSO2> implements OUTContractSO2.View,View.OnClickListener {


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


    private ListView lv;
    ScrollView scrollView;


    List<OutDetailVO2.DataBean.PackingListBean.PackingListItemsBean> list=new ArrayList<>();
    SOOutAdapter_SoItem adapter_soItem;


    int type_chaxun=0;//证明查询了数据，如果为1，代表查询到了装箱单号
    String type_PackingCode="";//用来记录PackingCode





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

        rll_detail=view.findViewById(R.id.rll_detail);


        scrollView=view.findViewById(R.id.scrollView);
        lv=view.findViewById(R.id.lv);


        tvChaxun.setOnClickListener(this);
        tvTijiao.setOnClickListener(this);


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
        switch (v.getId()){
            case R.id.tv_chaxun:
                String salesOrder=tvOrder.getText().toString().trim();
                String soItem=tvSo.getText().toString().trim();

                if (Kits.Empty.check(salesOrder)){
//                        T.showToastSafe("仓库ID不能为空");
                    Toast.makeText(getContext(),"SalesOrder不能为空",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Kits.Empty.check(soItem)){
//                        T.showToastSafe("仓库ID不能为空");
                    Toast.makeText(getContext(),"SoItem不能为空",Toast.LENGTH_LONG).show();
                    return;
                }

                presenter.getSO(salesOrder,soItem);
                break;

            case R.id.tv_tijiao:

                DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将此单出库?", (dialog, confirm) -> {

                    if (confirm) {
                        //退出登录
//                        loading("正在退出...");
                        presenter.getUP(type_PackingCode,"1");
                    }
                    dialog.dismiss();
                });
                break;
        }
    }

    //点击出库以后的操作
    @Override
    public void showSuccess(OutDetailVO vDate) {
        if (vDate.getSuccess().equals("T")){
            Toast.makeText(getContext(),"出库成功",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getContext(),vDate.getMessage()+"",Toast.LENGTH_LONG).show();
        }
    }

    //SO查询详细信息后返回的信息
    @Override
    public void showDetail(OutDetailVO2 item) {

        if (item.getSuccess().equals("T")){
            if (!(item.getData()==null ||item.getData().equals(""))){



                if (item.getData().size()>0){

                    scrollView.setVisibility(View.VISIBLE);
                    rll_detail.setVisibility(View.VISIBLE);

                    //库位
                    if (!Kits.Empty.check(item.getData().get(0).getFreeLoc())){
                        tvKwh.setText(item.getData().get(0).getFreeLoc());
                    }


                    if (!Kits.Empty.check(item.getData().get(0).getPackingList())){
                        //工作单号
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getWorkCode())){
                            tvGzdh.setText(item.getData().get(0).getPackingList().getWorkCode());
                        }




                        //日期
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getMadeTime())){

                            long itime= Long.parseLong(item.getData().get(0).getPackingList().getMadeTime());

                            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
                            String timeText=format.format(itime);
                            tvDate.setText(timeText+"");
                        }

                        //装箱单号
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackingCode())) {
                            tvNumber.setText(item.getData().get(0).getPackingList().getPackingCode());
                        }


                        //第几箱
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getRankNum())) {
                            tvDjx.setText("第  "+item.getData().get(0).getPackingList().getRankNum()+"  箱");
                        }

                        //共几箱
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getTotalNum())) {
                            tvGjx.setText("共  "+item.getData().get(0).getPackingList().getTotalNum()+"  箱");
                        }

                        //长
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackLength())) {
                            tvChang.setText("长："+item.getData().get(0).getPackingList().getPackLength());
                        }
                        //宽
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackwidth())) {
                            tvKuan.setText("宽："+item.getData().get(0).getPackingList().getPackwidth());
                        }
                        //高
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPackHeight())) {
                            tvGao.setText("高:"+item.getData().get(0).getPackingList().getPackHeight());
                        }
                        //净重
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getNetWeight())) {
                            tvJingzhong.setText("净重："+item.getData().get(0).getPackingList().getNetWeight());
                        }
                        //毛重
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getRoughWeight())) {
                            tvMaozhong.setText("毛重："+item.getData().get(0).getPackingList().getRoughWeight());
                        }


                        //状态(0暂存  1待入库  2已入库  3已出库)
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getStoreState())) {
                            switch (item.getData().get(0).getPackingList().getStoreState()){
                                case "0":
                                    tvZhuangtai.setText("状态：暂存");


                                    tvTijiao.setVisibility(View.INVISIBLE);
                                    break;

                                case "1":
                                    tvZhuangtai.setText("状态：待入库");


                                    tvTijiao.setVisibility(View.INVISIBLE);

                                    break;
                                case "2":
                                    tvZhuangtai.setText("状态：已入库");


                                    tvTijiao.setVisibility(View.VISIBLE);//已出库的才有出库按钮
                                    break;
                                case "3":
                                    tvZhuangtai.setText("状态：已出库");


                                    tvTijiao.setVisibility(View.INVISIBLE);
                                    break;

                            }


                        }

                        //单据归档 0否  1是
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getBillArchived())) {
                            if (item.getData().get(0).getPackingList().getBillArchived().equals("0")){
                                tvDjgd.setText("单据归档：否");
                            }else if (item.getData().get(0).getPackingList().getBillArchived().equals("1")){
                                tvDjgd.setText("单据归档：是");
                            }

                        }

                        //单据打印
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getBillPrint())) {
                            if (item.getData().get(0).getPackingList().getBillPrint().equals("0")){
                                tvDjdy.setText("单据打印：未打印");
                            }else if (item.getData().get(0).getPackingList().getBillPrint().equals("1")){
                                tvDjdy.setText("单据打印：已打印");
                            }else if (item.getData().get(0).getPackingList().getBillPrint().equals("2")){
                                tvDjdy.setText("单据打印：补打");
                            }

                        }
                        //打印次数
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getPrintTimes())) {
                            tvDycs.setText("打印次数："+item.getData().get(0).getPackingList().getPrintTimes()+"次");
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

                            long itimes= Long.parseLong(item.getData().get(0).getPackingList().getInstallTime());

                            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText=format.format(itimes);
                            tvZzrq.setText(timeText+"");


                        }

                        //订单交货期
                        if (!Kits.Empty.check(item.getData().get(0).getPackingList().getDeliveryDate())) {

                            long itimess= Long.parseLong(item.getData().get(0).getPackingList().getDeliveryDate());

                            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); //设置格式
                            String timeText=format.format(itimess);
                            tvDdjhq.setText(timeText+"");

                        }



                        type_chaxun=1;//证明查询到了数据
                        if (!Kits.Empty.check(item.getData().get(0).getPackingCode())){//记录packingcode
                            type_PackingCode=item.getData().get(0).getPackingCode();
                        }


                        //listview
                        if (item.getData().get(0).getPackingList().getPackingListItems() != null && item.getData().get(0).getPackingList().getPackingListItems().size() > 0) {
                            adapter_soItem=new SOOutAdapter_SoItem(getContext(),list);
                            lv.setAdapter(adapter_soItem);
                            //刷新
                            list.clear();
                            list.addAll(item.getData().get(0).getPackingList().getPackingListItems());
                            adapter_soItem.notifyDataSetChanged();
                        }

                    }

                }else {
                    type_chaxun=0;//证明没有查询到数据
                    rll_detail.setVisibility(View.GONE);
                    scrollView.setVisibility(View.GONE);

                }






            }else {
                type_chaxun=0;//证明没有查询到数据
                rll_detail.setVisibility(View.GONE);
                scrollView.setVisibility(View.GONE);
            }
        }else {
            Toast.makeText(getContext(),item.getMessage(),Toast.LENGTH_LONG).show();
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
