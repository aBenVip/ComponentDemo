package com.dgcredit.componentdemo;

import com.dgcredit.baselib.BasePresenter;
import com.dgcredit.baselib.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.ObservableTransformer;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/8
 * 备注:
 */

public interface MainContract {
    interface MainView extends BaseView{
        void getData();
    }
    abstract class IMainPresenter extends BasePresenter<MainView>{
        public abstract void setData();
    }
}
