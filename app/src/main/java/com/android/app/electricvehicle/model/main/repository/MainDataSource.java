package com.android.app.electricvehicle.model.main.repository;

import com.android.app.electricvehicle.entity.ActivityVO;

import com.android.app.electricvehicle.entity.DetailVO;
import com.android.app.electricvehicle.entity.INDetailVO;
import com.android.app.electricvehicle.entity.ItemDetailInVO;
import com.android.app.electricvehicle.entity.ItemDetailOutVO;
import com.android.app.electricvehicle.entity.LoginResultVO2;
import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.entity.MyInVO;
import com.android.app.electricvehicle.entity.MyOutVO;
import com.android.app.electricvehicle.entity.OutDetailVO;
import com.android.app.electricvehicle.entity.OutVO;
import com.android.app.electricvehicle.entity.OutVO2;
import com.android.app.electricvehicle.entity.Shangchuan;
import com.android.app.electricvehicle.entity.SouSuo;

import com.android.app.electricvehicle.mvp.model.BaseEntity;

import io.reactivex.Observable;

import java.util.List;
import java.util.SortedMap;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface MainDataSource {

    //首页列表
    Observable<ActivityVO> MainService(SortedMap<String, String> pramas);

    //登录
    Observable<BaseEntity<LoginResultVO2>> LoginService(SortedMap<String, String> pramas);


    //上传页面
    Observable<BaseEntity<Shangchuan>> shangchuan(SortedMap<String, String> pramas);

    //搜索页面
    Observable<ActivityVO> sousuo(SortedMap<String, String> pramas);

    //详情页面
    Observable<DetailVO> detail(SortedMap<String, String> pramas);


    //退出
    Observable<OutVO> OutService(SortedMap<String, String> pramas);

    //---------------------
    //入库单接口
    Observable<INDetailVO> INdetailService(SortedMap<String, String> pramas);


    //登录
    Observable<LoginResultVO3> LoginService2(SortedMap<String, String> pramas);


    //退出
    Observable<OutVO2> Outservice2(SortedMap<String, String> pramas);

    //出库单接口
    Observable<OutDetailVO> OutdetailService(SortedMap<String, String> pramas);

    //我的入库列表
    Observable<MyInVO> MyInService(SortedMap<String, String> pramas);


    //我的入库列表
    Observable<MyOutVO> MyOutService(SortedMap<String, String> pramas);


    //出库时扫码展示详情
    Observable<ItemDetailOutVO> OutDetailService(SortedMap<String, String> pramas);

    //移库的时候修改库位号
    Observable<ItemDetailOutVO> updatekwhService(SortedMap<String, String> pramas);

    //我的入库列表点击进来以后的详情
    Observable<ItemDetailInVO> MyInDetailService(SortedMap<String, String> pramas);

    //我的出库列表点击进来以后的详情
    Observable<ItemDetailOutVO> MyOutDetailService(SortedMap<String, String> pramas);
}
