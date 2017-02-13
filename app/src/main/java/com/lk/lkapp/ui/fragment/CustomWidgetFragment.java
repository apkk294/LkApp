package com.lk.lkapp.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseFragment;
import com.lk.lkapp.ui.activity.ChartViewActivity;
import com.lk.lkapp.ui.activity.NestedScrollActivity;

import butterknife.OnClick;

/**
 * Package：com.lk.lkapp.ui.fragment
 * Created by user005 on 2016/12/29.
 * Description：.
 */

public class CustomWidgetFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_custom_widget;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.btn_chart, R.id.btn_nested_scroll})
    void skipChartViewActivity(View view) {
        switch (view.getId()) {
            case R.id.btn_chart:
                startActivity(new Intent(getContext(), ChartViewActivity.class));
                break;
            case R.id.btn_nested_scroll:
                startActivity(new Intent(getContext(), NestedScrollActivity.class));
                break;
        }
    }

}
