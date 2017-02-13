package com.lk.lkapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseActivity;
import com.lk.lkapp.custom.behavior.UcNewsHeaderPagerBehavior;
import com.lk.lkapp.ui.adapter.TestTabAdapter;

import butterknife.BindView;

/**
 * 创建者： user005
 * 时间：2017/2/9
 * Description：.
 */

public class NestedScrollActivity extends BaseActivity implements UcNewsHeaderPagerBehavior.OnPagerStateListener {


    @BindView(R.id.news_tv_header_pager)
    TextView newsTvHeaderPager;
    @BindView(R.id.id_uc_news_header_pager)
    FrameLayout idUcNewsHeaderPager;
    @BindView(R.id.news_title_tv)
    TextView newsTitleTv;
    @BindView(R.id.iv_github)
    ImageView ivGithub;
    @BindView(R.id.id_uc_news_tab)
    TabLayout idUcNewsTab;
    @BindView(R.id.id_uc_news_content)
    ViewPager idUcNewsContent;

    private UcNewsHeaderPagerBehavior mPagerBehavior;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_nested_scroll;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPagerBehavior = (UcNewsHeaderPagerBehavior) ((CoordinatorLayout.LayoutParams) findViewById(R.id.id_uc_news_header_pager).getLayoutParams()).getBehavior();
        mPagerBehavior.setPagerStateListener(this);

        TestTabAdapter tabAdapter = new TestTabAdapter(getSupportFragmentManager());
        idUcNewsContent.setAdapter(tabAdapter);

        idUcNewsTab.setupWithViewPager(idUcNewsContent);
    }


    @Override
    public void onPagerClosed() {

    }

    @Override
    public void onPagerOpened() {

    }

    @Override
    public void onBackPressed() {
        if (mPagerBehavior != null && mPagerBehavior.isClosed()) {
            mPagerBehavior.openPager();
        } else {
            super.onBackPressed();
        }
    }
}
