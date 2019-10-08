package com.android.app.electricvehicle.model.main.http;

import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.entity.*;
import com.android.app.electricvehicle.mvp.model.BaseEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.util.List;
import java.util.Map;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public interface MainService {

    String ss="mobiles/out/user-logout";//退出的接口



    //用实体类存储数据


    //首页接口
    @POST("mobiles/mobile/motorUser-search")
    Observable<ActivityVO> splash(@Body RequestBody requestbody);


    /**
     * 版本更新
     *
     * @return
     */
    @POST("version/assistant-select-verscodes")
    Observable<CheckUpdateAppBean> checkVersion(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);

    /**
     * 注册clientId
     *
     * @return
     */
    @POST("app-assistant/cid-set")
    Observable<GetVodeBean> registClientId(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);

    //账号登录
    @POST("mobiles/login/sysuser-login")
    Observable<BaseEntity<LoginResultVO2>> login(@Body RequestBody requestbody);



    /**
     * token登陆
     *
     * @return
     */
    @POST("mobiles/login/sysuser-login")
    Observable<LoginBean2> tokenLogin(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);



    /**
     * 照片上传
     *
     * @return
     */
    @POST("mobiles/upload/update-vehicleinfo")
    Observable<BaseEntity<Shangchuan>> shangchuan(@Body RequestBody requestbody);

    //搜索页面
    @POST("mobiles/mobile/motorUser-search")
    Observable<ActivityVO> sousuo(@Body RequestBody requestbody);

    //详情
    @POST("mobiles/mobile/motorUser-search")
    Observable<DetailVO> detail(@Body RequestBody requestbody);

    //退出
    @POST(ss)
    Observable<OutVO> out(@Body RequestBody requestbody);

//------------------------------------------
    //入库单接口
    @POST("packings/instore/save")
    Observable<AllEntity> indetail(@Body RequestBody requestbody);



    //账号登录
    @POST("oauth/token")
    Observable<LoginResultVO3> mylogin(@Body RequestBody requestbody);




}
