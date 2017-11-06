package com.dgcredit.httplib;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 进程调度器
 */
public class BaseSchedulers {

    public static <T> FlowableTransformer<T, T> flowableCompose() {
        return upstream -> upstream
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(subscription -> {
//                    if (!NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {
//                        //EventBus发消息改变网络
//                        ToastUtil.showShortToast(BaseApplication.getInstance(), "当前无网络");
//                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> observableActivityCompose() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
//                    if (!NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {
//                        ToastUtil.showShortToast(BaseApplication.getInstance(), "当前无网络");
//                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
