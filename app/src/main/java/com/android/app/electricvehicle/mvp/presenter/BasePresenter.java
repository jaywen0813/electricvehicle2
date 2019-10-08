package com.android.app.electricvehicle.mvp.presenter;

import com.android.app.electricvehicle.mvp.view.BaseViewInf;
import io.reactivex.disposables.CompositeDisposable;
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
public abstract class BasePresenter<T> {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    public void attachView(T view) {
        this.mView = view;
        if (null == mCompositeDisposable) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    /**
     * 判断view是否为空
     */
    public boolean isAttachView() {
        return mView != null;
    }

    public void detachView() {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
        mView = null;
    }

    /**
     * 判断view是否绑定
     */
    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }

    /**
     * 自定义异常
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }

}
