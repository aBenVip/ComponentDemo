package com.dgcredit.componentdemo;

import android.util.Log;

import com.dgcredit.baselib.BaseActivity;
import com.dgcredit.baselib.DataBindingActivity;
import com.dgcredit.httplib.BaseSchedulers;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/8
 * 备注:
 */

public class MainPresenter extends MainContract.IMainPresenter {

    @Override
    public void setData() {
        boolean b = getView() instanceof RxAppCompatActivity;
        Log.i("TAG", b + "++++++++++++++++++++");

        Observable.interval(2, TimeUnit.SECONDS)
                .compose(BaseSchedulers.observableActivityCompose())
                .compose(((RxAppCompatActivity) getView()).bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("TAG", "onSubscribe++++++++++++++++++++");
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.i("TAG", "onSubscribe++++++++++++++++++++" + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i("TAG", "onComplete+-----------------------");
                    }
                });
    }
}
