package com.lk.lkapp.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseListFragment;
import com.lk.lkapp.bean.LolNewsListBean;
import com.lk.lkapp.component.DaggerLolNewsComponent;
import com.lk.lkapp.contract.LolNewsContract;
import com.lk.lkapp.module.LolNewsModule;
import com.lk.lkapp.presenter.LolNewsPresenterImpl;
import com.lk.lkapp.ui.activity.LolNewsContentActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Package：com.lk.lkapp.ui.fragment
 * Created by user005 on 2016/12/16.
 * Description：lol news fragment.
 */

public class LolNewsFragment extends BaseListFragment<LolNewsListBean.ListBean, BaseViewHolder>
        implements LolNewsContract.View {

    @Inject
    LolNewsPresenterImpl mLolNewsPresenter;

    @Override
    protected BaseQuickAdapter<LolNewsListBean.ListBean, BaseViewHolder> setListAdapter() {
        return new BaseQuickAdapter<LolNewsListBean.ListBean, BaseViewHolder>
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
    }

    @Override
    protected void requestData() {
        mLolNewsPresenter.loadNewsList(mListPage);
    }

    @Override
    protected void initView() {
        super.initView();
        DaggerLolNewsComponent.builder().lolNewsModule(new LolNewsModule(this)).build().inject(this);
    }

    @Override
    protected void onItemClickListener(BaseQuickAdapter<LolNewsListBean.ListBean, BaseViewHolder> adapter, View itemView, int position) {
        int[] picLocation = new int[2];
        itemView.findViewById(R.id.iv_pic).getLocationOnScreen(picLocation);

        Intent intent = LolNewsContentActivity.getCallingIntent(getContext(),
                adapter.getItem(position));
        intent.putExtra("left", picLocation[0]);
        intent.putExtra("top", picLocation[1]);
        intent.putExtra("width", itemView.findViewById(R.id.iv_pic).getWidth());
        intent.putExtra("height", itemView.findViewById(R.id.iv_pic).getHeight());
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }

    @Override
    public void onLoadNewsList(LolNewsListBean newsListBean) {
        mRefresh.post(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(false);
            }
        });
        mListAdapter.setNewData(newsListBean.getList());
    }

    @Override
    public void onLoadMoreNewsList(final LolNewsListBean newsListBean) {
        mRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!newsListBean.hasNext()) {
                    //数据全部加载完毕
                    mListAdapter.loadMoreEnd();
                } else {
                    mListAdapter.addData(newsListBean.getList());
                    mListAdapter.loadMoreComplete();
                }
            }

        }, 0);
    }

}
