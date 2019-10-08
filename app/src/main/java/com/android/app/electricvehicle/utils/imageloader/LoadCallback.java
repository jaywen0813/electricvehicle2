package com.android.app.electricvehicle.utils.imageloader;

import android.graphics.Bitmap;

/**
 * imageloader 回调
 */

public abstract class LoadCallback {
    void onLoadFailed(Throwable e) {}

    public abstract void onLoadReady(Bitmap bitmap);

    void onLoadCanceled() {}
}
