package com.lk.lkapp.contract;

import com.lk.lkapp.bean.LolNewsListBean;

/**
 * Package：com.lk.lkapp.contract
 * Created by user005 on 2016/12/16.
 * Description：.
 */

public interface LolNewsContract {

    interface View {
        void onLoadNewsList(LolNewsListBean newsListBean);

        void onLoadMoreNewsList(LolNewsListBean newsListBean);
    }

    interface Presenter {
        void loadNewsList(int page);
    }

    interface Model {
        void loadNewsLIst(int page);
    }


}