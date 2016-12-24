package com.lk.lkapp.presenter;

import com.lk.lkapp.bean.LolNewsListBean;
import com.lk.lkapp.contract.LolNewsContract;
import com.lk.lkapp.rest.LolRestClient;
import com.lk.lkapp.subscribers.SimpleSubscriber;

import javax.inject.Inject;

/**
 * Created by user005 on 2016/12/16
 */

public class LolNewsPresenterImpl implements LolNewsContract.Presenter {

    private LolNewsContract.View  mView;

    @Inject
    public LolNewsPresenterImpl(LolNewsContract.View view) {
        mView = view;
    }

    @Override
    public void loadNewsList(int page) {
        LolRestClient.getInstance().loadLolNewsList(page, new SimpleSubscriber<LolNewsListBean>() {
            @Override
            protected void _onNext(LolNewsListBean data) {
                if (Integer.parseInt(data.getNextpage()) != 1) {
                    mView.onLoadMoreNewsList(data);
                } else {
                    mView.onLoadNewsList(data);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}