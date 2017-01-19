package com.lk.lkapp.ui.activity;

import android.os.Bundle;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseActivity;
import com.lk.lkapp.widget.SimpleChartView;

import butterknife.BindView;

/**
 * Package：com.lk.lkapp.ui.activity
 * Created by user005 on 2016/12/30.
 * Description：.
 */

public class ChartViewActivity extends BaseActivity {

    @BindView(R.id.chart)
    SimpleChartView mChart;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_chart_view;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mChart.setValues(new String[]{String.valueOf(Math.random() * 100),
                String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100),
                String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100),
                String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100)});
    }

}
