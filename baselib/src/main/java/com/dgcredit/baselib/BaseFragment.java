package com.dgcredit.baselib;

import android.annotation.TargetApi;
import android.databinding.ViewDataBinding;
import android.os.Build;

import java.lang.reflect.ParameterizedType;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/8
 * 备注:
 */

public abstract class BaseFragment<P extends BasePresenter, B extends ViewDataBinding> extends DataBindingFragment<B> {
    public P mPresenter;

    @SuppressWarnings("unchecked")
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void initPresenter() {
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            try {
                mPresenter = (P) mPresenterClass.newInstance();
            } catch (java.lang.InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            mPresenter.onAttach(this);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter.onDetach();
        }
    }
}

