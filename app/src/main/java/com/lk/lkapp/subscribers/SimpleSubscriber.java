package com.lk.lkapp.subscribers;

import rx.Subscriber;

/**
 * Created by user005 on 2016/8/18.
 */
public abstract class SimpleSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T data);

}
