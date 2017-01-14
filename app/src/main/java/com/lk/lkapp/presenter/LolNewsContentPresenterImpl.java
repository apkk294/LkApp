package com.lk.lkapp.presenter;

import com.lk.lkapp.bean.LolNewsListBean;
import com.lk.lkapp.contract.LolNewsContentContract;

import javax.inject.Inject;

/**
 * Created by user005 on 2016/12/29
 */

public class LolNewsContentPresenterImpl implements LolNewsContentContract.Presenter {

    private LolNewsContentContract.View  mView;

    @Inject
    public LolNewsContentPresenterImpl(LolNewsContentContract.View view) {
        mView = view;
    }

    @Override
    public void getNewsDetail() {
        LolNewsListBean.ListBean listBean = mView.getNewsDetail();
        mView.setNewsTitle(listBean.getTitle());
        mView.setNewsImg(listBean.getImage_url_big());
        mView.setNewsUrl(listBean.getArticle_url());
    }
}