package com.android.app.electricvehicle.utils;

import android.app.Activity;
import android.widget.Toast;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.utils.toast.StyleableToast;
import com.orhanobut.logger.Logger;


/**
 * @创建者 .
 * @创建时间 2017/8/3  16:38.
 * @描述 ${Toast 工具类}.
 */
public class T {

    private static final String TAG = T.class.getSimpleName();
        private static StyleableToast sToast;
//    private static Toast sToast;

    /**
     * 线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final int resId) {
        showToastSafe(UIUtils.getString(resId));
    }

    /**
     * 线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final String str) {
        if (UIUtils.isRunInMainThread()) {
            showToast(str);
        } else {
            UIUtils.post(() -> showToast(str));
        }
    }

    private static void showToast(String str) {
        Activity activity = ActivityManager.getInstance().getCurrentActivity();
        if (activity == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }


        if (sToast == null) {
            Logger.d(TAG, "toast new");
            sToast = StyleableToast.makeText(activity.getApplicationContext(), str, Toast.LENGTH_SHORT, R.style
                    .BaseToast);
        } else {
            Logger.d(TAG, "toast old");
            sToast.setText(str);
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        sToast.show();
    }
}
