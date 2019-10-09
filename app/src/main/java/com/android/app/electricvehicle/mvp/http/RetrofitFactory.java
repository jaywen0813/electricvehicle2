package com.android.app.electricvehicle.mvp.http;


import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.android.app.electricvehicle.BuildConfig;
import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.api.Api;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.MD5;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.orhanobut.logger.Logger;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class RetrofitFactory {

    //default  超时时间 30S
    private static final int DEFAULT_TIME_OUT = 30;

    public static <T> T initService(String baseUrl, Class<T> clazz, SortedMap<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient(map))
                .build();
        Logger.e(MainApplication.LOGINRESULTVO.getToken()+"---token---"+MainApplication.LOGINRESULTVO.getUserName()+"----userName");
        return retrofit.create(clazz);
    }

    /**
     * 动态添加header所需的retrofit
     *
     * @param baseUrl 主要的地址
     * @return
     */
    public static Retrofit getRetrofit(String baseUrl) {
        if (Kits.Empty.check(baseUrl)) {
            throw new IllegalStateException("baseUrl can not be null");
        }
        Logger.e(MainApplication.LOGINRESULTVO.getToken()+"---token---"+MainApplication.LOGINRESULTVO.getUserName()+"----userName");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
        return retrofit;
    }

    /**
     * @return 动态添加header 所需的okHttp
     */
    private static OkHttpClient getOkHttpClient() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient;
        if (BuildConfig.DEBUG) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor(){

                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder().build();

                            Response response = chain.proceed(request);
                            ResponseBody responseBody = response.body();
                            long contentLength = responseBody.contentLength();
                            if (!bodyEncoded(response.headers())) {
                                BufferedSource source = responseBody.source();
                                source.request(Long.MAX_VALUE);
                                Buffer buffer = source.buffer();

                                Charset charset = Charset.forName("UTF-8");
                                MediaType mediaType = responseBody.contentType();
                                if (mediaType != null) {
                                    try {
                                        charset = mediaType.charset(Charset.forName("UTF-8"));
                                    } catch (UnsupportedCharsetException e) {
                                        return response;
                                    }
                                }

                                if (!isPlaintext(buffer)) {
                                    return response;
                                }

                                if (contentLength != 0) {
                                    String result = buffer.clone().readString(charset);
                                    Log.e("TAG", "-------" + result);
                                    NetErrorCode.getCodeMessageShow(result);
                                }

                            }
                            return response;
                        }
                    })
                    .build();
        } else {
            okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor(){

                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder().build();

                            Response response = chain.proceed(request);
                            ResponseBody responseBody = response.body();
                            long contentLength = responseBody.contentLength();
                            if (!bodyEncoded(response.headers())) {
                                BufferedSource source = responseBody.source();
                                source.request(Long.MAX_VALUE);
                                Buffer buffer = source.buffer();

                                Charset charset = Charset.forName("UTF-8");
                                MediaType mediaType = responseBody.contentType();
                                if (mediaType != null) {
                                    try {
                                        charset = mediaType.charset(Charset.forName("UTF-8"));
                                    } catch (UnsupportedCharsetException e) {
                                        return response;
                                    }
                                }

                                if (!isPlaintext(buffer)) {
                                    return response;
                                }

                                if (contentLength != 0) {
                                    String result = buffer.clone().readString(charset);
                                    Log.e("TAG", "-------" + result);
                                    NetErrorCode.getCodeMessageShow(result);
                                }

                            }
                            return response;
                        }
                    })
                    .build();
        }
        return okHttpClient;
    }

    private static OkHttpClient getOkHttpClient(SortedMap<String, String> map) {
        Date date = new Date();
        final String currentTimeStamp = date.getTime() + "";
//        map.put("currentTimeStamp", currentTimeStamp);
        final String key = "1eX1XqE+8aRT3IjqEqay4yJnASE=";

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String s = gson.toJson(map,Map.class);


        if(s.equals("{}")){
            s="";
        }

        final String sign = MD5.GetMD5Code(s+currentTimeStamp+key);
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient;
        if (BuildConfig.DEBUG) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder()
                                    .addHeader("Content-Type", "application/json;charset=UTF-8")
//                                    .addHeader("Accept-Encoding", "gzip, deflate")
                                    //.addHeader("Connection", "keep-alive")
                                    .addHeader("Accept", "*/*")
                                    //.addHeader("Cookie", "add cookies here")
                                    .addHeader("timeStamp", currentTimeStamp)
                                    //.addHeader("brandCode", AppConstants.BRANDCODE)
                                    .addHeader("sign", sign)
                                    //.addHeader("appId", AppConstants.APPID)
//                                    .addHeader("loginName", MainApplication.LOGINRESULTVO2.getLdcSysUser().getLoginName())
                                    .addHeader("appVersionNo", AppConstants.APPVERSIONNO)
                                   // .addHeader("deviceNo", AppConstants.getMyUUID())
                                   // .addHeader("deviceType", AppConstants.DEVICETYPE)
                                    .addHeader("token", MainApplication.LOGINRESULTVO2.getToken())
                                    .addHeader("userId", MainApplication.LOGINRESULTVO2.getId())
                                    .addHeader("siteNo", MainApplication.LOGINRESULTVO2.getUnicomNumber())
//                                    .addHeader("X-Token",MainApplication.LOGINRESULTVO3.getData().getAccess_token())
                                    .addHeader("X-Token","MSag69rfZLhGipIcPC81jtccjhroIsVsW9AlcudW766j8T8QQTAfGWGERrecNxNs")

                                    .build();
                            Response response = chain.proceed(request);
                            ResponseBody responseBody = response.body();
                            long contentLength = responseBody.contentLength();
                            if (!bodyEncoded(response.headers())) {
                                BufferedSource source = responseBody.source();
                                source.request(Long.MAX_VALUE);
                                Buffer buffer = source.buffer();

                                Charset charset = Charset.forName("UTF-8");
                                MediaType mediaType = responseBody.contentType();
                                if (mediaType != null) {
                                    try {
                                        charset = mediaType.charset(Charset.forName("UTF-8"));
                                    } catch (UnsupportedCharsetException e) {
                                        return response;
                                    }
                                }

                                if (!isPlaintext(buffer)) {
                                    return response;
                                }

                                if (contentLength != 0) {
                                    String result = buffer.clone().readString(charset);
                                    Log.e("TAG", "-------" + result);
                                    NetErrorCode.getCodeMessageShow(result);
                                }

                            }
                            return response;
                        }
                    })
                    .build();
        } else {
            okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder()
                                    .addHeader("Content-Type", "application/json;charset=UTF-8")
//                                    .addHeader("Accept-Encoding", "gzip, deflate")
                                    //.addHeader("Connection", "keep-alive")
                                    .addHeader("Accept", "*/*")
                                    //.addHeader("Cookie", "add cookies here")
                                    .addHeader("timeStamp", currentTimeStamp)
                                    //.addHeader("brandCode", AppConstants.BRANDCODE)
                                    .addHeader("sign", sign)
                                    //.addHeader("appId", AppConstants.APPID)
//                                    .addHeader("loginName", MainApplication.LOGINRESULTVO2.getLdcSysUser().getLoginName())
                                    .addHeader("appVersionNo", AppConstants.APPVERSIONNO)
                                    // .addHeader("deviceNo", AppConstants.getMyUUID())
                                    // .addHeader("deviceType", AppConstants.DEVICETYPE)
                                    .addHeader("token", MainApplication.LOGINRESULTVO2.getToken())
                                    .addHeader("userId", MainApplication.LOGINRESULTVO2.getId())
                                    .addHeader("siteNo", MainApplication.LOGINRESULTVO2.getUnicomNumber())
//                                    .addHeader("X-Token",MainApplication.LOGINRESULTVO2.getToken())
//                                    .addHeader("X-Token",MainApplication.LOGINRESULTVO3.getData().getAccess_token())
                                    .addHeader("X-Token","MSag69rfZLhGipIcPC81jtccjhroIsVsW9AlcudW766j8T8QQTAfGWGERrecNxNs")
                                    .build();

                            Response response = chain.proceed(request);
                            ResponseBody responseBody = response.body();
                            long contentLength = responseBody.contentLength();
                            if (!bodyEncoded(response.headers())) {
                                BufferedSource source = responseBody.source();
                                source.request(Long.MAX_VALUE); // Buffer the entire body.
                                Buffer buffer = source.buffer();

                                Charset charset = Charset.forName("UTF-8");
                                MediaType contentType = responseBody.contentType();
                                if (contentType != null) {
                                    try {
                                        charset = contentType.charset(Charset.forName("UTF-8"));
                                    } catch (UnsupportedCharsetException e) {
                                        return response;
                                    }
                                }

                                if (!isPlaintext(buffer)) {
                                    return response;
                                }

                                if (contentLength != 0) {
                                    String result = buffer.clone().readString(charset);
                                    //得到所需的string，开始判断是否异常
                                    //***********************do something*****************************
                                    NetErrorCode.getCodeMessageShow(result);
                                }

                            }
                            return response;
                        }
                    })
                    .build();
        }

        return okHttpClient;
    }

    private static String getSecretStr(SortedMap<String, String> map) {
        //step 1 排序
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>(map);
        String secretStr = "";
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = entry.getValue().toString();
            secretStr += v.toString();
        }
        return secretStr;
    }

    private static boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

    static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }
}
