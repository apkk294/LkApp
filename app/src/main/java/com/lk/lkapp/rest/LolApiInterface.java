package com.lk.lkapp.rest;

import com.lk.lkapp.bean.LolNewsListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Package：com.lk.lkapp.rest
 * Created by user005 on 2016/12/17.
 * Description：.
 */

public interface LolApiInterface {

    @GET("/php_cgi/news/php/varcache_getnews.php?id=12&plat=android&version=9713")
    Observable<LolNewsListBean> loadLolNewsList(@Query("page") int page);

}
