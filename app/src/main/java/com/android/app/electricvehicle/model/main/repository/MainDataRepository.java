package com.android.app.electricvehicle.model.main.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.app.electricvehicle.api.Api;
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
import com.android.app.electricvehicle.model.main.http.MainService;
import com.android.app.electricvehicle.mvp.http.RetrofitFactory;
import com.android.app.electricvehicle.mvp.model.BaseEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;

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
public class MainDataRepository implements MainDataSource {

    private static volatile MainDataRepository INSTANCE;

    private MainDataRepository() {
    }

    public static MainDataRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (MainDataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MainDataRepository();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable<ActivityVO> MainService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).splash(body);
    }

    //登录接口
    @Override
    public Observable<BaseEntity<LoginResultVO2>> LoginService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).login(body);
    }

    //上传
    @Override
    public Observable<BaseEntity<Shangchuan>> shangchuan(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).shangchuan(body);
    }

    //搜索
    @Override
    public Observable<ActivityVO> sousuo(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).sousuo(body);
    }


    //详情
    public Observable<DetailVO> detail(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).detail(body);
    }

    //退出
    @Override
    public Observable<OutVO> OutService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).out(body);
    }

    //---------------

    //添加入库单
    @Override
    public Observable<INDetailVO> INdetailService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).indetail(body);
    }



    //登录接口
    @Override
    public Observable<LoginResultVO3> LoginService2(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).mylogin(body);
    }


    //退出接口
    @Override
    public Observable<OutVO2> Outservice2(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).myout(body);
    }


    //出库单
    @Override
    public Observable<OutDetailVO> OutdetailService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).outdetail(body);
    }


    //我的入库单列表
    @Override
    public Observable<MyInVO> MyInService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).myin(body);
    }

    //我的出库单列表
    @Override
    public Observable<MyOutVO> MyOutService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).myoutlist(body);
    }

    //出库时展示的详情
    @Override
    public Observable<ItemDetailOutVO> OutDetailService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).getoutdetail(body);
    }

    //我的入库列表点击进来以后的详情
    @Override
    public Observable<ItemDetailInVO> MyInDetailService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).getMyIndetail(body);
    }

    //我的出库列表点击进来以后的详情
    @Override
    public Observable<ItemDetailOutVO> MyOutDetailService(SortedMap<String, String> pramas) {
        String str = JSONObject.parseObject(JSON.toJSONString(pramas)).toString();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"), str);
        return RetrofitFactory.initService(Api.BASE_URL, MainService.class, pramas).getMyOutdetail(body);
    }
}
