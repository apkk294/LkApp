package com.lk.lkapp.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lk.lkapp.R;

import butterknife.BindView;

/**
 * Package：com.lk.lkapp.base
 * Created by user005 on 2017/1/20.
 * Description：.
 */

public abstract class BaseListFragment<T, K extends BaseViewHolder> extends BaseFragment {

    @BindView(R.id.recycler)
    protected RecyclerView       mRecycler;
    @BindView(R.id.refresh)
    protected SwipeRefreshLayout mRefresh;

    protected BaseQuickAdapter<T, K> mListAdapter;

    protected int mListPage;

    @Override
    protected int getLayoutResId() {
        return R.layout.base_list;
    }

    @Override
    protected void initView() {
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onRequestRefresh();
            }
        });
        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(true);
            }
        });

        mListAdapter = setListAdapter();
        mListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                onRequestLoadMore();
            }
        });

        mRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                onItemClickListener(baseQuickAdapter, view, i);
            }
        });
        mRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        configRecyclerView(mRecycler);
        mRecycler.setAdapter(mListAdapter);
    }

    protected abstract BaseQuickAdapter<T, K> setListAdapter();

    protected abstract void onRequestRefresh();

    protected abstract void onRequestLoadMore();

    protected void onItemClickListener(BaseQuickAdapter<T, K> adapter, View itemView, int position){};

    protected void configRecyclerView(RecyclerView recyclerView) {}
}
