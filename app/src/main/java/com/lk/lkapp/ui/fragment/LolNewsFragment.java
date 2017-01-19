package com.lk.lkapp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseFragment;
import com.lk.lkapp.bean.LolNewsListBean;
import com.lk.lkapp.component.DaggerLolNewsComponent;
import com.lk.lkapp.contract.LolNewsContract;
import com.lk.lkapp.module.LolNewsModule;
import com.lk.lkapp.presenter.LolNewsPresenterImpl;
import com.lk.lkapp.ui.activity.LolNewsContentActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Package：com.lk.lkapp.ui.fragment
 * Created by user005 on 2016/12/16.
 * Description：lol news fragment.
 */

public class LolNewsFragment extends BaseFragment implements LolNewsContract.View,
        SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @Inject
    LolNewsPresenterImpl mLolNewsPresenter;

    @BindView(R.id.rv_lol_news)
    RecyclerView       mRvLolNews;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private BaseQuickAdapter<LolNewsListBean.ListBean, BaseViewHolder> mAdapter;
    private int                                                        page;

    public static LolNewsFragment newInstance() {

        Bundle args = new Bundle();

        LolNewsFragment fragment = new LolNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_lol_news;
    }

    @Override
    protected void initView() {
        DaggerLolNewsComponent.builder().lolNewsModule(new LolNewsModule(this)).build().inject(this);

        mRefresh.setOnRefreshListener(this);
        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(true);
            }
        });

        mAdapter = new BaseQuickAdapter<LolNewsListBean.ListBean, BaseViewHolder>
                (R.layout.item_lol_news, new ArrayList<LolNewsListBean.ListBean>()) {
            @Override
            protected void convert(BaseViewHolder holder, LolNewsListBean.ListBean listBean) {
                ImageView imageView = holder.getView(R.id.iv_pic);
                ImageLoader.getInstance().displayImage(listBean.getImage_url_small(), imageView);
                holder.setText(R.id.tv_title, listBean.getTitle());
                holder.setText(R.id.tv_desc, listBean.getSummary());
                holder.setText(R.id.tv_time, listBean.getPublication_date());
                holder.setText(R.id.tv_source, listBean.getPvCountFormat());
            }
        };
        mAdapter.setOnLoadMoreListener(this);

        mRvLolNews.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int[] picLocation = new int[2];
                view.findViewById(R.id.iv_pic).getLocationOnScreen(picLocation);

                Intent intent = LolNewsContentActivity.getCallingIntent(getContext(),
                        (LolNewsListBean.ListBean) baseQuickAdapter.getItem(i));
                intent.putExtra("left", picLocation[0]);
                intent.putExtra("top", picLocation[1]);
                intent.putExtra("width", view.findViewById(R.id.iv_pic).getWidth());
                intent.putExtra("height", view.findViewById(R.id.iv_pic).getHeight());
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
            }
        });
        mRvLolNews.setAdapter(mAdapter);

        mLolNewsPresenter.loadNewsList(page);
    }

    @Override
    public void onRefresh() {
        mLolNewsPresenter.loadNewsList(page = 0);
    }

    @Override
    public void onLoadMoreRequested() {
        mLolNewsPresenter.loadNewsList(++page);
    }

    @Override
    public void onLoadNewsList(LolNewsListBean newsListBean) {
        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(false);
            }
        });
        mAdapter.setNewData(newsListBean.getList());
    }

    @Override
    public void onLoadMoreNewsList(final LolNewsListBean newsListBean) {
        mRvLolNews.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!newsListBean.hasNext()) {
                    //数据全部加载完毕
                    mAdapter.loadMoreEnd();
                } else {
                    mAdapter.addData(newsListBean.getList());
                    mAdapter.loadMoreComplete();
                }
            }

        }, 0);
    }

}
