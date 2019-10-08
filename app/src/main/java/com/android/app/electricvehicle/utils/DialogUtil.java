package com.android.app.electricvehicle.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.PopupWindow;

import com.android.app.electricvehicle.R;
import com.android.app.electricvehicle.entity.Constant;
import com.android.app.electricvehicle.mvp.view.BasicDialog;
import com.android.app.electricvehicle.mvp.view.LoadingDialog;


/**
 * @创建者
 * @创建时间 2017/8/10  16:16.
 * @描述 ${所有提示窗管理类}.
 */
public class DialogUtil {


    private DialogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public interface OnDialogItemClickListener {
        void onClick(View v);
    }


    public interface OnSinglePickerSelectListener {
        void onSelect(int index);
    }

    public interface OnPopListItemClickListener {
        void onItemClick(PopupWindow pop, int position);
    }

    /**
     * 基本的LoadingDialog
     *
     * @param activity
     */
    public static Dialog loading(Activity activity) {
        return loading(activity, "");
    }

    /**
     * 自定义文本的LoadingDialog
     *
     * @param activity
     * @param text
     */
    public static Dialog loading(Activity activity, String text) {
        LoadingDialog loadingDialog = new LoadingDialog(activity, R.style.basic_dialog, text);
        loadingDialog.show();
        return loadingDialog;
    }

    public static Dialog loading(Activity activity, int resId) {
        return loading(activity, UIUtils.getString(resId));
    }

    /**
     * 基本的 确定/取消 dialog
     *
     * @param activity
     * @param title
     * @param message
     * @param onCloseListener
     * @return
     */
    public static Dialog showBasicDialog(Activity activity, String title, String message, BasicDialog.OnCloseListener
            onCloseListener) {
        BasicDialog basicDialog = new BasicDialog(activity, R.style.basic_dialog, onCloseListener);
        basicDialog.setTitle(title)
                .setContent(message)
                .show();
        return basicDialog;
    }

    /**
     * 自定义 确定/取消 dialog
     *
     * @param activity
     * @param title
     * @param message
     * @param cancleText      取消文字
     * @param confirmText     确定文字
     * @param onCloseListener
     * @return
     */
    public static Dialog showBasicDialog(Activity activity, String title, String message, String cancleText,
                                         String confirmText, BasicDialog.OnCloseListener onCloseListener) {
        BasicDialog basicDialog = new BasicDialog(activity, R.style.basic_dialog, onCloseListener);
        basicDialog.setTitle(title)
                .setContent(message)
                .setPositiveButton(confirmText)
                .setNegativeButton(cancleText)
                .show();
        return basicDialog;
    }

    /**
     * 获取权限失败后 提示跳转设置页面的dialog
     *
     * @param activity
     * @param title
     * @param message
     * @return
     */
    public static Dialog showPermissionSettingDialog(final Activity activity, String title, String message, boolean needFinish) {

        Dialog dialog = showBasicDialog(activity, title, message, (dialog1, confirm) -> {
            if (confirm) {
                //跳转系统权限设置界面
                Uri packageURI = Uri.parse("package:" + activity.getPackageName());
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                activity.startActivityForResult(intent, Constant.PRESSION_REQUESTCODE);
                dialog1.dismiss();
            } else {
                if (needFinish) {
                    activity.finish();
                }
            }
        });
        return dialog;
    }

}
