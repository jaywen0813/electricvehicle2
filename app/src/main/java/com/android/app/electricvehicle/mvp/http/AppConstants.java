package com.android.app.electricvehicle.mvp.http;

import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.entity.Constant;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;

import java.util.UUID;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class AppConstants {
    public static final String BRANDCODE = "DPAD";
    public static final String APPID = "8";
    public static final String APPVERSIONNO = Kits.Package.getVersionCode(MainApplication.getContext()) + "";
    public static final String DEVICENO = "869718026776358";
    public static final String DEVICETYPE = "00";

    //生成UUID
    public static String getMyUUID() {
        String uniqueId = "";
        if (Kits.Empty.check(PreferenceUtils.getInstance(MainApplication.getContext()).getString(Constant.DEVICEID_KEY))) {
            UUID uuid = UUID.randomUUID();
            uniqueId = uuid.toString();
            PreferenceUtils.getInstance(MainApplication.getContext()).setString(Constant.DEVICEID_KEY, uniqueId);
        } else {
            uniqueId = PreferenceUtils.getInstance(MainApplication.getContext()).getString(Constant.DEVICEID_KEY);
        }
        return uniqueId;
    }
}
