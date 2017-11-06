package com.dgcredit.baselib;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/8
 * 备注:
 */

public abstract class BasePresenter<V extends BaseView> {
    private WeakReference<V> mReference = null;

    /**
     * 绑定View
     */
    public void onAttach(V view) {
        mReference = new WeakReference<>(view);
    }

    public boolean isAttach() {
        return null != mReference && null != mReference.get();
    }

    /**
     * 在V销毁的时候调用,解除绑定
     */
    public void onDetach() {
        mReference.clear();
        mReference = null;
    }

    /**
     * @return 该P层绑定的视图View
     */
    public V getView() {
        if (mReference != null) {
            return mReference.get();
        }
        return null;
    }

}
