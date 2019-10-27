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
import android.widget.Toast;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpFragment;
import com.android.app.electricvehicle.entity.ItemDetailOutVO2;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.model.main.contract.OUTContractSO2;
import com.android.app.electricvehicle.model.main.presenter.OUTPresenterSO2;
import com.android.app.electricvehicle.mvp.presenter.BasePresenter;
import com.android.app.electricvehicle.ui.activity.OUTDetailActivity;
import com.android.app.electricvehicle.ui.adapter.SOOutAdapter;
import com.android.app.electricvehicle.utils.DialogUtil;
import com.android.app.electricvehicle.utils.Kits;
import com.flyco.roundview.RoundTextView;

import java.util.ArrayList;
import java.util.List;


public class SOOutFragment extends BaseMvpFragment<OUTContractSO2.View, OUTPresenterSO2> implements OUTContractSO2.View,View.OnClickListener {


    private EditText tvOrder;
    private EditText tvSo;
    private ListView lv;
    private RoundTextView tvChaxun;

    List<ItemDetailOutVO2.DataBean>  list=new ArrayList<>();
    SOOutAdapter adapter;



    @Override
    protected void initView(View view) {
        tvOrder = view.findViewById(R.id.tv_order);
        tvSo = view.findViewById(R.id.tv_so);
        lv = view.findViewById(R.id.lv);
        tvChaxun = view.findViewById(R.id.tv_chaxun);

        tvChaxun.setOnClickListener(this);


        adapter=new SOOutAdapter(getContext(),list);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).getStoreState().equals("2")){//只有状态为2的时候，才能出库

                    DialogUtil.showBasicDialog(getActivity(), "出库提示", "确定将此单出库?", (dialog, confirm) -> {

                        if (confirm) {
                            //退出登录
//                        loading("正在退出...");
                            presenter.getUP(list.get(position).getPackingCode(),"1");
                        }
                        dialog.dismiss();
                    });

                }else {//证明不可以出库，此时点击没有反应,不做操作
                    Toast.makeText(getContext(),"此单不可进行出库操作",Toast.LENGTH_SHORT).show();
                }

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
    public void showDetail(ItemDetailOutVO2 detailOutVO) {

        if (!(detailOutVO.getData()==null ||detailOutVO.getData().equals(""))){

            if (detailOutVO.getData().size()>0){
                //刷新
                list.clear();
                list.addAll(detailOutVO.getData());
                adapter.notifyDataSetChanged();


            }


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
