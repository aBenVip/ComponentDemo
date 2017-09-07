package com.dgcredit.httplib;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/7/24
 * 备注:
 */

public abstract class BaseObserver<T> implements Observer<T> {

    private Object object;
    public BaseObserver(Object object){
        this.object= object;
    }
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(Throwable e) {

//        ToastUtil.showShortToast(BaseApplication.getInstance().getApplicationContext(),ExceptionHandle.handleException(e).message);
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
