package com.lk.lkapp.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lk.lkapp.bean.LolNewsListBean;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Package：com.lk.lkapp.rest
 * Created by user005 on 2016/12/17.
 * Description：.
 */

public class LolRestClient {
    private final static String TAG = "LolRestClient ";

    private static LolApiInterface apiInterface;
    public static final String baseUrl = "http://qt.qq.com";

    /**
     * 构造方法私有
     */
    private LolRestClient() {
        if (apiInterface == null) {
            OkHttpClient okClient = new OkHttpClient.Builder()
                    .addInterceptor(new LolRestClient.LogInterceptor())
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder()
//                    .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
                    .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                    .serializeNulls().create();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            apiInterface = client.create(LolApiInterface.class);
        }
    }

    /**
     * 在访问RestClient时创建单例
     */
    private static class SingletonHolder {
        private static final LolRestClient INSTANCE = new LolRestClient();
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static LolRestClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.v(TAG, "request:" + request.toString());
            long     t1       = System.nanoTime();
            Response response = chain.proceed(chain.request());
            long     t2       = System.nanoTime();
            Log.v(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            MediaType mediaType = response.body().contentType();
            String    content   = response.body().string();
            Log.i(TAG, "response body:" + content);
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    }

    private <T> Subscription toSubscribe(Observable<T> o, Subscriber<T> subscriber) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription loadLolNewsList(int page, Subscriber<LolNewsListBean> subscriber) {
        Observable<LolNewsListBean> observable = apiInterface.loadLolNewsList(page);
        return toSubscribe(observable, subscriber);
    }

}
