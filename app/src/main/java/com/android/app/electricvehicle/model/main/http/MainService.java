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
import retrofit2.http.Url;

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
    Observable<INDetailVO> indetail(@Body RequestBody requestbody);



    //账号登录
    @POST("oauth/token")
    Observable<LoginResultVO3> mylogin(@Body RequestBody requestbody);



    //账号退出
    @POST("oauth/logout")
    Observable<OutVO2> myout(@Body RequestBody requestbody);


    //出库单接口
    @POST("packings/outstore/save")
    Observable<OutDetailVO> outdetail(@Body RequestBody requestbody);

    //我的入库单列表
    @POST("packings/instore/search")
    Observable<MyInVO> myin(@Body RequestBody requestbody);


    //我的出库单列表
    @POST("packings/outstore/search")
    Observable<MyOutVO> myoutlist(@Body RequestBody requestbody);

    //出库时的详情展示
    @POST("packings/outstore/get/")
    Observable<ItemDetailOutVO> getoutdetail(@Body RequestBody requestbody);



    //我的入库列表点击以后的详情展示
    @GET("packings/instore/get/")
    Observable<ItemDetailInVO> getMyIndetail(@Body RequestBody requestbody);


    //我的出库列表点击以后的详情展示
    @GET("packings/outstore/get/")
    Observable<ItemDetailOutVO> getMyOutdetail(@Body RequestBody requestbody);



//--------------------------------------------

    //帐号登录
    @POST("oauth/token")
    Observable<LoginResultVO3> Logintest(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);

    //账号退出
    @POST("oauth/logout")
    Observable<OutVO2> myout(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);


    //入库单接口
    @POST("packings/instore/save")
    Observable<INDetailVO> indetail(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);


    //出库单接口
    @POST("packings/outstore/save")
    Observable<OutDetailVO> outdetail(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);




    //我的入库单列表
    @POST("packings/instore/search")
    Observable<MyInVO> myin(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);

    //我的出库单列表
    @POST("packings/outstore/search")
    Observable<MyOutVO> myoutlist(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);





    //出库时通过出库号的详情展示
    @GET
    Observable<ItemDetailOutVO> getoutPage(@HeaderMap Map<String, String> headerMap,@Url String url);

    //出库时通过SO展示的详情  //2019年10月28日 14:33:59  暂时没有用上，作废了
    @GET
    Observable<ItemDetailOutVO2> getoutPage2(@HeaderMap Map<String, String> headerMap,@Url String url);

    //出库时通过SO展示的详情
    @GET
    Observable<OutDetailVO2> getoutPage3(@HeaderMap Map<String, String> headerMap,@Url String url);

    //我的入库列表点击以后的详情展示
    @GET
    Observable<ItemDetailInVO> getPage(@HeaderMap Map<String, String> headerMap,@Url String url);


    //我的出库列表点击以后的详情展示
    @GET
    Observable<MyOutDetailVO> getmyoutdetailpage(@HeaderMap Map<String, String> headerMap,@Url String url);



    //装箱单查询列表
    @POST("packings/list/search")
    Observable<ZXDListVO> zxdlist(@HeaderMap Map<String, String> headerMap, @Body RequestBody requestBody);


    //装箱单列表点击以后的详情展示
    @GET
    Observable<ZxdlrDetailVO> zxdDetail(@HeaderMap Map<String, String> headerMap,@Url String url);



    //修改装箱单详情
    @POST("packings/list/save")
    Observable<ZxdDetailUpdateVO> updateDetail(@HeaderMap Map<String, String> headerMap,@Body RequestBody requestbody);


    //装箱单详情作废
    @POST
    Observable<ZxdDetailDeleteVO> postdeletePage(@HeaderMap Map<String, String> headerMap,@Body RequestBody requestbody,@Url String url);


    //入库详情作废
    @POST
    Observable<DeleteInDetailVO> deleteInDetail(@HeaderMap Map<String, String> headerMap,@Body RequestBody requestbody,@Url String url);

    //出库详情作废
    @POST
    Observable<DeleteOUTdetailVO> deleteOutDetail(@HeaderMap Map<String, String> headerMap,@Body RequestBody requestbody,@Url String url);


    //添加装箱单信息
    @POST("packings/list/save")
    Observable<ZxdDetailAddVO> addzxdlr(@HeaderMap Map<String, String> headerMap,@Body RequestBody requestbody);

    //入库扫码以后查询详情返回数据的接口
    @GET
    Observable<ShowInDetailEntity> getINDetail(@HeaderMap Map<String, String> headerMap,@Url String url);
}
