package com.android.app.electricvehicle.model.main.contract;

import com.android.app.electricvehicle.entity.ItemDetailOutVO;
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
public interface OUTContract {

    interface View extends BaseViewInf {

        //提交成功
        void showSuccess();

        //查询到详情以后返回的数据
        void  showDetail(ItemDetailOutVO detailOutVO);


    }

    interface Presenter {
        //网络请求。提交数据
        void getUP(String outstoreCode,String freeLoc,String remark);
        //通过库位查询信息
        void getZXD(String zxd);

    }
}
