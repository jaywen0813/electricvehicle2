package com.android.app.electricvehicle.utils.imageloader;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Imageloader 接口
 */

public interface ILoader {

    void init(Context context);

    void loadNetCircle(ImageView target, String url);

    void loadNetCircle(ImageView target, String url, Options options);

    void loadNetCircle(ImageView target, String url, Options options, int strokeColor, int strokeWidth);

    void loadPlayerLogoCircle(ImageView target, String url, Options options);

    void loadNetAutoHeight(ImageView target, String url);

    void loadNet(ImageView target, String url);

    void loadNet(ImageView target, String url, Options options);

    void loadNet(Context context, String url, Options options, LoadCallback callback);

    void loadResource(ImageView target, int resId, Options options);

    void loadAssets(ImageView target, String assetName, Options options);

    void loadFile(ImageView target, File file, Options options);

    void clearMemoryCache(Context context);

    void clearDiskCache(Context context);

    void resume(Context context);

    void pause(Context context);


    class Options {

        public int                 loadingResId   = RES_NONE;        //加载中的资源id
        public int                 loadErrorResId = RES_NONE;      //加载失败的资源id
        public ImageView.ScaleType scaleType      = null;

        public static final int RES_NONE = -1;

        public static Options defaultOptions() {
            return new Options(XDroidConf.IL_LOADING_RES, XDroidConf.IL_ERROR_RES);
        }

        public Options(int loadingResId, int loadErrorResId) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
        }

        public Options scaleType(ImageView.ScaleType scaleType) {
            this.scaleType = scaleType;
            return this;
        }
    }

}
