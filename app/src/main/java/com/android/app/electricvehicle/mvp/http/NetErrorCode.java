package com.android.app.electricvehicle.mvp.http;

import android.app.Activity;
import android.content.Intent;

import com.android.app.electricvehicle.MainApplication;

import com.android.app.electricvehicle.mvp.model.BaseEntity;

import com.android.app.electricvehicle.utils.PreferenceUtils;
import com.android.app.electricvehicle.utils.T;
import com.google.gson.Gson;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public class NetErrorCode {
    /**
     * 成功码
     */
    public static final int CODE_SUCCEED = 100;

    /**
     * 未登录
     */
    public static final int CODE_NEED_LOGIN = 205;

    public static void getCodeMessageShow(String result) {
        BaseEntity cuscresult = new Gson().fromJson(result, BaseEntity.class);
//        switch (cuscresult.getCode()) {
//            case "10001":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("系统内部异常");
//                T.showToastSafe("系统内部异常");
//                break;
//            case "99999":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("非法请求");
//                T.showToastSafe("非法请求");
//                break;
//            case "00001":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("用户名或密码错误");
//                T.showToastSafe("用户名或密码错误");
//                break;
//            case "00002":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("账号被冻结，请联系管理员");
//                T.showToastSafe("账号被冻结，请联系管理员");
//                break;
//            case "00003":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("用户不存在");
//                T.showToastSafe("用户不存在");
//                break;
//            case "00004":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("token过期，请重新登录");
//                T.showToastSafe("token过期，请重新登录");
//
//                break;
//            case "00005":
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("无效的token值");
//                T.showToastSafe("无效的token值");
//                MainApplication.sIsLogin = false;
//                PreferenceUtils.getInstance(MainApplication.getInstance()).clear(MainApplication.getContext());
//                Intent intent1 = new Intent(MainApplication.getContext(), Main2Activity.class);
//                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                Intent intent2 = new Intent(MainApplication.getContext(), Login2Activity.class);
//                Intent[] intents = {intent1, intent2};
//                MainApplication.getContext().startActivities(intents);
//                break;
//            case "00006":
//                T.showToastSafe("登录设备出现变更，请重新登录");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("登录设备出现变更，请重新登录");
//                break;
//            case "00007":
//                T.showToastSafe("手机号未注册");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("手机号未注册");
//                break;
//            case "00008":
//                T.showToastSafe("验证码错误");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("验证码错误");
//                break;
//            case "00009":
//                T.showToastSafe("该品牌下该手机号已注册过了");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("该品牌下该手机号已注册过了");
//                break;
//            case "00010":
//                T.showToastSafe("原始密码输入错误");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("原始密码输入错误");
//                break;
//            case "00011":
//                T.showToastSafe("验证码已失效，请重新发送");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("验证码已失效，请重新发送");
//                break;
//            case "00012":
//                T.showToastSafe("缺少必要参");
////                com.dpad.crmclientapp.android.util.utils.T.showToastSafe("缺少必要参");
//                break;

        switch (cuscresult.getCode()) {
            case "10001":
//                T.showToastSafe("系统内部异常");
//                KLog.e("系统内部异常");
                break;
            case "00001":
                T.showToastSafe("用户名或密码错误");
                break;
            case "00002":
                T.showToastSafe("账号被冻结，请联系管理员");
                break;
            case "00003":
                T.showToastSafe("用户不存在");
                break;
            case "00004"://("00004","token过期"),
                detailToken();
                break;

            case "00005"://("00005","token无效")
                detailToken();
//                T.showToastSafe("登陆过期，请重新登录");
//                T.showToastSafe("您的账号在另一地点登录，您已被迫下线");
                break;
            case "00006"://("00006","设备变更")
                detailToken();
                T.showToastSafe("您的账号在另一地点登录，您已被迫下线");
                break;
            case "00007":
                T.showToastSafe("手机号未注册");
                break;
            case "00008":
                T.showToastSafe("验证码错误");
                break;
            case "00009":
                T.showToastSafe("该品牌下该手机号已注册过了");
                break;
            case "00010":
                T.showToastSafe("原始密码输入错误");
                break;
            case "00011":
                T.showToastSafe("验证码已失效，请重新发送");
                break;
            case "00012":
                T.showToastSafe("缺少必要参");
                break;
            case "00013":
                T.showToastSafe("被修改手机号不是本机");
                break;
            case "00014":
                T.showToastSafe("没有此VIN号");
                break;
            case "00015":
                T.showToastSafe("VIN号已关联");
                break;
            case "00016":
                T.showToastSafe("自动绑定失败，注册成功");
                break;
            case "00017":
                T.showToastSafe("手机号与合同不一致");
                break;
            case "00018":
                T.showToastSafe("城市不存在或者无该城市天气信息");
                break;
            case "00019":
                T.showToastSafe("网点不存在或者无该网点信息");
                break;
            case "00020":
                T.showToastSafe("当前账号未绑定爱车");
                break;
            case "00021":
                T.showToastSafe("账号或密码为空");
                break;
            case "00022":
                T.showToastSafe("未找到该车辆信息");
                break;
            case "00023":
                T.showToastSafe("未找到专属顾问");
                break;
            case "00024":
                T.showToastSafe("救援单已存在");
                break;
            case "00025":
                T.showToastSafe("绑定默认车辆失败，注册成功");
                break;
            case "00026":
                T.showToastSafe("互联网车型只能由车主绑定");
                break;
            case "00027":
                T.showToastSafe("已完成不可修改");
                break;
            case "00028":
                T.showToastSafe("已取消不可修改");
                break;
            case "00029":
                T.showToastSafe("只有待安排可改为已安排");
                break;
            case "00030":
                T.showToastSafe("新密码不能与旧密码相同");
                break;
            case "00031":
                T.showToastSafe("该车辆下有未完成的预约单，请勿重复提交");
                break;
            case "00032":
//                T.showToastSafe("没有用户手机号但是有openid");
                break;
            case "00033":
//                T.showToastSafe("用户user，token表脏数据");
            case "00034":
                T.showToastSafe("您所在的网点已关闭");
                break;
            case "00035":
                T.showToastSafe("您还没有设置网点，请联系管理员");
                break;

            case "00036":
                T.showToastSafe("远程调用异常，请稍后再试");
                break;
            case "00037":
                T.showToastSafe("您还没有选择一个时间，请选择一个时间");
                break;
            case "00038":
                T.showToastSafe("您还没有选择网点，请选择一个网点");
                break;
            case "00039":
                T.showToastSafe("您选择的网点没有具有预约权限的人员，请重新选择");
                break;
            case "00040":
                T.showToastSafe("该预约单无效");
                break;
            case "00041":
                T.showToastSafe("附近没有网点网点");
            case "00042":
                T.showToastSafe("该用户没有任何权限");
                break;
            case "00043":
                T.showToastSafe("该手机号下的openid和传入的openid不一致");
                break;
            case "00044":
                T.showToastSafe("手机号已存在或者系统调用异常");
                break;
            case "00045":
                T.showToastSafe("该用户手机号为空");
                break;
            case "00046":
                T.showToastSafe("用户已存在");
                break;
            case "00047":
                T.showToastSafe("该VIN绑定多个用户");
                break;
            case "00048":
                T.showToastSafe("该VIN未绑定用户");
                break;
            case "00049":
                T.showToastSafe("该VIN不是T服务车辆");
                break;
            case "00050":
                T.showToastSafe("改预约单来自于商城，取消该预约单请联系经销商");
                break;
            case "00051":
                T.showToastSafe("已经是最后一辆车了请不要删除");
                break;
            case "00052":
                T.showToastSafe("此车与您注册品牌不一致");
                break;
            case "99999":
                T.showToastSafe("非法请求");
                break;

        }
    }

    private static synchronized void detailToken() {
        Activity activity;
        MainApplication.sIsLogin = false;
        PreferenceUtils.getInstance(MainApplication.getInstance()).clear(MainApplication.getContext());
        if (MainApplication.getInstance().getmActivityList() != null && MainApplication.getInstance().getmActivityList().size() > 0) {

        }

    }

}
