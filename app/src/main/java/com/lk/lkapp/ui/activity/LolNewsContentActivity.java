package com.lk.lkapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseActivity;
import com.lk.lkapp.bean.LolNewsListBean;
import com.lk.lkapp.widget.SelfLoadWebView;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;

public class LolNewsContentActivity extends BaseActivity {

    private static final String LIST_BEAN = "list_bean";

    @BindView(R.id.web_news_detail)
    SelfLoadWebView mWebNewsDetail;
    @BindView(R.id.iv_pic)
    ImageView mIvHeadPic;

    public static Intent getCallingIntent(Context context, LolNewsListBean.ListBean listBean) {
        Intent intent = new Intent(context, LolNewsContentActivity.class);
        intent.putExtra(LIST_BEAN, listBean);
        return intent;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_lol_news_content;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LolNewsListBean.ListBean listBean = getIntent().getParcelableExtra(LIST_BEAN);


        toolbar.setTitle(listBean.getTitle());
        mWebNewsDetail.loadUrl(listBean.getArticle_url());
        ImageLoader.getInstance().displayImage(listBean.getImage_url_big(), mIvHeadPic);
    }
}
