package com.dgcredit.httplib;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BaseSubscriber<T> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }
        @Override
    public void onError(Throwable e) {
        onFail(ExceptionHandle.handleException(e));
    }

    @Override
    public void onNext(T bean) {
        onSuccess(bean);
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    public abstract void onSuccess(T t);
//
    public abstract void onFail(ExceptionHandle.ResponseThrowable e);

    public abstract void onFinish();


}
