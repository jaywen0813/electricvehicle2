package com.android.app.electricvehicle.utils;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.android.app.electricvehicle.MainApplication;
import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.base.BaseMvpActivity;
import com.android.app.electricvehicle.entity.CheckUpdateAppBean;
import com.android.app.electricvehicle.model.main.repository.NetInstance;

import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @创建者
 * @创建时间 2017/9/5  17:00.
 * @描述 ${App}.
 */
public class AppUpdateUtil {

    private static final String TAG = AppUpdateUtil.class.getSimpleName();

    private static boolean forceUpdate = false;
    /**
     * 检查应用版本 更新
     *
     * @param activity
     * @param showLoadding 是否显示进度圈(用户主动点击检查版本)
     */
    public static void checkVersion(final BaseMvpActivity activity, final boolean showLoadding) {

        if (showLoadding) {

        }
        SortedMap<String, String> sortedMap = new TreeMap();

        NetInstance.getEventsService().checkVersion(ParameterUtils.getHeaser(sortedMap), ParameterUtils.getJsonBody(sortedMap)).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<CheckUpdateAppBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(CheckUpdateAppBean checkUpdateAppVO) {
                        if (checkUpdateAppVO.getCode().equals("00000")) {
                            if (Kits.Empty.check(checkUpdateAppVO.getResult())) {
//                                T.showToastSafe(R.string.toast_unget_version);

                                return;
                            }
                            if (Kits.Empty.check(checkUpdateAppVO.getResult().getUrl())) {

                                return;
                            }
                            showNewVersion(activity, showLoadding, checkUpdateAppVO.getResult());
                        } else {
                            T.showToastSafe(checkUpdateAppVO.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 提示新版本
     *
     * @param activity
     * @param showLoadding 是否显示进度圈(用户主动点击检查版本)
     * @param data
     */
    private static void showNewVersion(final BaseMvpActivity activity, boolean showLoadding, CheckUpdateAppBean.ResultBean data) {
        //是否强制更新
        forceUpdate = data.isForceFlag();
        final String downUrl = data.getUrl();
        String releaseNote = data.getVersDes();
        String verName = data.getVersCode();
        String content;
        String cancleText;
        String confirmText;
        String title = UIUtils.getString(R.string.dialog_new_version);
        final String fileName = Kits.Package.getAppName(activity) + "_" + verName + ".apk";
        if (forceUpdate) {
            content = "重要版本更新\n版本号: " + verName + "\n更新说明:\n" + releaseNote + ",请更新后使用.";
            cancleText = "退出";
            confirmText = "更新";
        } else {
            content = "版本号: " + verName + "\n更新说明:\n" + releaseNote + "\n" + UIUtils.getString(R.string
                    .dialog_if_update);
            cancleText = UIUtils.getString(R.string.dialog_cancel);
            confirmText = UIUtils.getString(R.string.dialog_confirm);
        }
//        long lastCheckVersionTime = (long) SPUtil.get(activity, SPConfig.APP_CHECK_NEW_VERSION_DATE, 0L);
        long currentTimeMillis = System.currentTimeMillis();
//        boolean isThreeDayAgo = (currentTimeMillis - lastCheckVersionTime) > 1000 * 60 * 60 * 24 * 3;
        Logger.d(TAG, "是否用户主动检查更新: " + showLoadding + ", 是否强制更新: " + forceUpdate);
        //如果是用户主动点击检查更新 或 强制更新 或 最后一次提醒是三天前,则提醒更新; 否则不提醒
        if (showLoadding || forceUpdate) {
//            SPUtil.put(activity, SPConfig.APP_CHECK_NEW_VERSION_DATE, currentTimeMillis);

        }
    }

    /**
     * 检查文件读写权限
     *
     * @param activity
     * @param downLoadUrl 下载地址
     * @param fileName    下载文件名
     */
    private static void checkPermission(final Activity activity, final String downLoadUrl, final String fileName) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        //                            downloadApp(activity, downLoadUrl, fileName);
                        downloadAppByService(activity, downLoadUrl, fileName);
                        if (forceUpdate){

                        }
                    } else {
                        String title = UIUtils.getString(R.string.dialog_warning_title);
                        String content = UIUtils.getString(R.string.permission_storage_error);

                    }
                });
    }

    /**
     * 开启下载服务下载App
     *
     * @param activity
     * @param downLoadUrl
     * @param fileName
     */
    private static void downloadAppByService(final Activity activity, String downLoadUrl, String fileName) {

    }

}
