package com.dgcredit.baselib;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.ObservableTransformer;


/**
 * activity基类
 */
public abstract class DataBindingActivity<B extends ViewDataBinding> extends RxAppCompatActivity implements BaseView{
    public Context mContext;
    public B mViewBinding;

//    public BaseStatusLayoutBinding mLoadDataBinding;
//    private SVPLoadUtils svpLoadUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        initStatusBar();
//        svpLoadUtils = new SVPLoadUtils(this);
//        mLoadDataBinding = DataBindingUtil.setContentView(this, R.layout.base_status_layout);
//        mViewBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), mLoadDataBinding.baseFrameLayout, true);
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mContext = this;
        initPresenter();
        initView();
//        AppManager.getAppManager().addActivity(this);
    }

    public void initStatusBar(){
//        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.colorAccent));
    }


    protected void initPresenter() {
    }

    public abstract int getLayoutId();

    public abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        AppManager.getAppManager().finishActivity(this);
    }

    public void initToolbar(String title, boolean isBack) {
//        if (title.equals("MainActivity")||title.equals("LoginActivity")){
//            mLoadDataBinding.baseToolbarLayout.toolbar.setVisibility(View.GONE);
//        }else {
//            mLoadDataBinding.baseToolbarLayout.toolbarTitle.setText(title);
//            if (isBack) {
//                mLoadDataBinding.baseToolbarLayout.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.bg_back));
//                mLoadDataBinding.baseToolbarLayout.toolbar.setNavigationOnClickListener(v -> finish());
//            }
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }
}
