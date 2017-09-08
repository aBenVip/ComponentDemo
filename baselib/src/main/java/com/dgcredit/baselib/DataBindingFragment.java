package com.dgcredit.baselib;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/7/18
 * 备注:
 */

public abstract class DataBindingFragment<B extends ViewDataBinding> extends RxFragment  implements BaseView{
    public Context mContext;
    public B mViewBinding;
//    public BaseStatusLayoutBinding mLoadDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        mLoadDataBinding = DataBindingUtil.inflate(inflater, R.layout.base_status_layout, container, false);

        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mContext = getActivity();
        initPresenter();
        initView();
        return mViewBinding.getRoot();
    }

    protected void initPresenter() {

    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    /**
     * 跳转fragment
     *
     * @param toFragment 跳转至的fragment
     */
    public void startFragment(Fragment toFragment) {
        startFragment(toFragment, null);
    }

    /**
     * @param toFragment 跳转的fragment
     * @param tag        fragment的标签
     */
    public void startFragment(Fragment toFragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.hide(this).add(android.R.id.content, toFragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 类似Activity的OnBack
     * fragment进行回退
     */
    public void onBack() {
        getFragmentManager().popBackStack();
    }
}
