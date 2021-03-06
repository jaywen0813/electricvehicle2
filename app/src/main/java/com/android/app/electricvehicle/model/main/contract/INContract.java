package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.DetailVO;
import com.android.app.electricvehicle.entity.INDetailVO;
import com.android.app.electricvehicle.entity.INDetail_RuKu;
import com.android.app.electricvehicle.entity.ShowInDetailEntity;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface INContract {

    interface View extends BaseViewInf {

        //提交成功
        void showSuccess(INDetailVO vDate);


        //扫码以后返回的详情数据
        void showInDetail(ShowInDetailEntity showInDetailEntity);


        void loadingtext();

        void loadWanCheng();

        void toast(String  ss);
    }

    interface Presenter {
        //网络请求。提交数据 查询到有详情的时候
        void getUP(String instoreCode,String freeLoc);

        //没有详情的时候提交数据
        void getUP2(String instoreCode, String freeLoc, INDetail_RuKu.PackingBean inDetail_ruKu);



        //用来提交到后台获取详情的
        void getInDetail(String packingCode);

    }
}
