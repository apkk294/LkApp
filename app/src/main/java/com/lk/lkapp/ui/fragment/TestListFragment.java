package com.lk.lkapp.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者： user005
 * 时间：2017/2/13
 * Description：.
 */

public class TestListFragment extends BaseFragment {

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.test_list;
    }

    @Override
    protected void initView() {
        mRecyclerView.setAdapter(new BaseQuickAdapter<String, BaseViewHolder>
                (android.R.layout.simple_list_item_1, getData()) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, String s) {
                baseViewHolder.setText(android.R.id.text1, s);
            }
        });
    }

    private List<String> getData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add(i + "");
        }
        return strings;
    }

}
