package com.android.app.electricvehicle.mvp.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.app.electricvehicle.mvp.model.BaseEntity;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * ================================================
 * 作   者：
 * 版   本：1.0
 * 日   期：2018/6/11
 * 描   述：
 * 修订历史：
 * ================================================
 */
public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = "BaseObserver";

    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> value) {
//        if (value.isSuccess()) {
//            T t = value.getResult();
//            onHandleSuccess(t);
//        } else {
//            onHandleError(value.getMessage());
//        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError:" + e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
//        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}