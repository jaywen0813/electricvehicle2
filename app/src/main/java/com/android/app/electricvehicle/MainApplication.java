package com.android.app.electricvehicle;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDex;

import com.android.app.electricvehicle.entity.Constant;
import com.android.app.electricvehicle.entity.ContentBean;
import com.android.app.electricvehicle.entity.LoginResultVO;
import com.android.app.electricvehicle.entity.LoginResultVO2;
import com.android.app.electricvehicle.entity.LoginResultVO3;
import com.android.app.electricvehicle.entity.NotifyMessageBean;


import com.android.app.electricvehicle.ui.activity.Login2Activity;

import com.android.app.electricvehicle.utils.ActivityManager;
import com.android.app.electricvehicle.utils.Kits;
import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class MainApplication extends Application {

    private static MainApplication mainApplicaton;
    public static LoginResultVO LOGINRESULTVO = new LoginResultVO();

    public static LoginResultVO2 LOGINRESULTVO2 = new LoginResultVO2();

    public static LoginResultVO3 LOGINRESULTVO3 = new LoginResultVO3();

    public static final String TAG = MainApplication.class.getSimpleName();

    public static MainApplication getInstance() {
        return mainApplicaton;
    }

    public static Context mContext;
    private static Thread mainThread;
    private static int mainThreadId;
    private static Handler mainThreadHandler;
    public List<Activity> mActivityList;

    public List<Activity> getmActivityList() {
        return mActivityList;
    }

    //用户是否已登录
    public static boolean sIsLogin;
    private boolean isFrist;

    public static boolean isMainActivityStart = false;//是否从首页进去

    //推送的clientId
    public static String clientId = "";
    //推送相关
    public static String getClientId() {
        //如果clientid为空,则去缓存中取
        if (clientId.isEmpty()) {
            String s = PreferenceUtils.getInstance(MainApplication.getContext()).getString(Constant.KEY_CLIENTID);
            clientId = Kits.Empty.check(s) ? clientId : s;//如果缓存中clientId为空,则取clientId
        }
        return clientId;
    }

    public static void setClientId(String clientId) {

        MainApplication.clientId = clientId;
        PreferenceUtils.getInstance(MainApplication.getContext()).setString(Constant.KEY_CLIENTID, clientId);
    }

    //创建通知的id,可能收到多条消息
    private int notifyId = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mainApplicaton = this;
        mainThreadHandler = new Handler();
        mainThread = Thread.currentThread();
        mainThreadId = Process.myTid();
        //存储activity的集合
        mActivityList = new ArrayList<>();
        initLogger();
//        initActivityLifecycle();
    }

    /**
     * 初始化logger
     */
    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static Context getContext() {
        return mContext;
    }

    public static Thread getMainThread() {
        return mainThread;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    public void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
            activity.finish();
        }
    }

//    @Override
//    protected void attachBaseContext(android.content.Context base) {
//        super.attachBaseContext(base);
//        android.support.multidex.MultiDex.install(this);
//    }

    public void removeAllActivities() {
        Logger.e("结束activity----" + mActivityList.size());
        for (Activity activity : mActivityList) {
            activity.finish();
            Logger.e("finish");
        }
        mActivityList.clear();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * 初始化Activity生命周期管理
     */
    private void initActivityLifecycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Logger.d(TAG, activity + " onCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Logger.d(TAG, activity + " onStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                ActivityManager.getInstance().setCurrentActivity(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }


    public synchronized void sendMessage(String msg) {
        notifyId++;
        Logger.e(msg + "ManiApplication-------推送消息");
        try {
            NotifyMessageBean notifyMessageBean = new Gson().fromJson(msg, NotifyMessageBean.class);
            Intent intent = new Intent(this, Login2Activity.class);
            sendNotification(R.mipmap.ic_launcher_round_im, intent, notifyMessageBean);
        } catch (Exception e) {
            Logger.e(e.toString() + "-----ManiApplication");
        }

    }


    public void sendNotification(@DrawableRes int drawRes, @Nullable Intent intent, NotifyMessageBean notifyMessageBean) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager == null) {
            return;
        }
        Gson gson = new Gson();
        ContentBean contentBean = gson.fromJson(notifyMessageBean.getContent(), ContentBean.class);

        PendingIntent pendingIntent;
        if (Kits.Empty.check(contentBean)) {
            return;
        } else {
            switch (contentBean.getType()) {
                case "0": //系统消息

                    break;
                case "1": //预约消息

                    break;
                case "2": //救援消息

                    break;
                default:
                    intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setClass(MainApplication.getContext(), Login2Activity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    break;
            }
        }
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = notificationManager.getNotificationChannel(Constant.NOTIFICATION_CHANNEL_ID);
            if (channel == null) {
                channel = new NotificationChannel(Constant.NOTIFICATION_CHANNEL_ID
                        , Constant.NOTIFICATION_CHANNEL_NAME
                        , NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription(Constant.NOTIFICATION_CHANNEL_DESCRIPTION);
                channel.enableLights(true);
                channel.enableVibration(true);
                channel.setShowBadge(true);
                channel.setLightColor(Color.GREEN);
                notificationManager.createNotificationChannel(channel);
            }
            builder = new Notification.Builder(this, Constant.NOTIFICATION_CHANNEL_ID);
        } else {
            builder = new Notification.Builder(this);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        builder.setDefaults(Notification.DEFAULT_ALL);//设置默认的声音和震动
        pendingIntent = PendingIntent.getActivity(this, notifyId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setSmallIcon(R.mipmap.ic_launcher_round_im)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), drawRes))
                .setContentTitle(notifyMessageBean.getTitle())
                .setContentText(contentBean.getContent())
                .setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setColor(getResources().getColor(R.color.colorPrimary));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            builder.setGroupSummary(true);
//            builder.setGroup(Constant.NOTIFY_GROUP);
        }
        Notification notification = builder.build();
        notificationManager.notify(notifyId, notification);
    }

    public void cleanNotify(int notifyId) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.cancel(notifyId);
        }
    }

}
