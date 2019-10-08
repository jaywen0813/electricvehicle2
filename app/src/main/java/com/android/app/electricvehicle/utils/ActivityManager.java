package com.android.app.electricvehicle.utils;

import android.app.Activity;

import java.lang.ref.WeakReference;

/**
 * @创建者
 * @创建时间 2017/10/9  17:18.
 * @描述 ${Activity 管理类}.
 */
public class ActivityManager {
    private static ActivityManager sInstance = new ActivityManager();
    // 采用弱引用持有 Activity ，避免造成 内存泄露
    private WeakReference<Activity> sCurrentActivityWeakRef;


    private ActivityManager() {

    }

    public static ActivityManager getInstance() {
        return sInstance;
    }

    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (sCurrentActivityWeakRef != null) {
            currentActivity = sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        sCurrentActivityWeakRef = new WeakReference<Activity>(activity);
    }

}
