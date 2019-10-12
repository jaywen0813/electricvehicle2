package com.android.app.electricvehicle.utils;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.mvp.http.AppConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.*;

/**
 * ================================================
 * 作    者：
 * 版    本：1.0
 * 创建日期：2018-06-12-0012 15:17
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ParameterUtils {


    /**
     * 根据请求body生成请求头
     *
     * @param parm 请求的body
     * @return
     */
    public static TreeMap<String, String> getHeaser(SortedMap<String, String> parm) {
        Date date = new Date();
        String currentTimeStamp = date.getTime() + "";
//        parm.put("currentTimeStamp", currentTimeStamp);
//        String sign = MD5.GetMD5Code(getSecretStr(parm));

        final String key = "1eX1XqE+8aRT3IjqEqay4yJnASE=";


        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String s = gson.toJson(parm,Map.class);
        if(s.equals("{}")){
            s="";
        }

        final String sign = MD5.GetMD5Code(s+currentTimeStamp+key);
        TreeMap<String, String> map = new TreeMap();
        map.put("Content-Type", "application/json;charset=UTF-8");
        map.put("Accept-Encoding", "gzip, deflate");
//        map.put("Connection", "keep-alive");
        map.put("Accept", "*/*");
//        map.put("Cookie", "add cookies here");
        map.put("timeStamp", currentTimeStamp);
//        map.put("brandCode", AppConstants.BRANDCODE);
        map.put("sign", sign);
//        map.put("appId", AppConstants.APPID);
//        map.put("loginName", MainApplication.LOGINRESULTVO2.getLdcSysUser().getLoginName());
        map.put("appVersionNo", AppConstants.APPVERSIONNO);
//        map.put("deviceNo", AppConstants.getMyUUID());
//        map.put("deviceType", AppConstants.DEVICETYPE);
        map.put("token", MainApplication.LOGINRESULTVO3.getAccess_token());
//        map.put("userId",MainApplication.LOGINRESULTVO2.getId());
//        map.put("X-Token","3S1x6eFpMGoSfB8gi5XOphGzaONvFVhphB2cjfFxSg6YYxD6fGpiudYaeidfDxJb");
        map.put("X-Token",MainApplication.LOGINRESULTVO3.getAccess_token());
        return map;
    }


    /**
     * md5 加密
     *
     * @param parm 需要加密的集合
     * @return sign
     */
    public static String getSecretStr(Map<String, String> parm) {
        //step 1 排序
        String secretStr = "";
        if (parm.isEmpty()) {
            return secretStr;
        }
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.putAll(parm);


        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            secretStr += v.toString();
        }
        return secretStr;
    }

    /**
     * @param sortedMap 请求的body集合
     * @return
     */
    public static RequestBody getJsonBody(SortedMap sortedMap) {
        String json = "";
        if (sortedMap != null && !sortedMap.isEmpty()) {
            Gson gson = new Gson();
            json = gson.toJson(sortedMap);
        }
        return RequestBody.create(MediaType.parse("application/json"), json);
    }
}
