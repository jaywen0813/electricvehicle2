package com.android.app.electricvehicle.utils;


/**
 * @Auther:
 * @Date: 2018/11/14 13:27
 * @Description:
 */
public class AccessUtil {

    //头部请求

    //平台统一key
   private static final String key = "1eX1XqE+8aRT3IjqEqay4yJnASE=";

    public static String generateSign (String param,String timeStamp) {
        String sign = "";

        sign = MD5.GetMD5Code(param + timeStamp + key);

        return sign;
    }

    public static String generateToken (String param,String timeStamp) {
        String token = "";

        token = MD5.GetMD5Code( param + key);

        return token;
    }
}
