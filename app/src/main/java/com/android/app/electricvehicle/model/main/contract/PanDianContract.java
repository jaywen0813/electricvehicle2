package com.android.app.electricvehicle.model.main.contract;

import android.content.Context;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.PanDianListVO;
import com.android.app.electricvehicle.mvp.view.BaseViewInf;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface PanDianContract {

    interface View extends BaseViewInf {



        //通过库位号查询未出库的装箱单以后返回的数据
        void  showDetail(PanDianListVO panDianListVO);


        //盘点成功的回调
        void  pandianSuccess();
        //盘点失败的回调
        void  pandianMiss();
    }

    interface Presenter {


        //通过库位号查询未出库的装箱单
        void getFreeLoc(String kuwei);

        //扫描装箱单标记盘点
        void  getPandian(String id);

    }
}
