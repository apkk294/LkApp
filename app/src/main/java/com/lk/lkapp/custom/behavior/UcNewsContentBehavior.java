package com.lk.lkapp.custom.behavior;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.lk.lkapp.App;
import com.lk.lkapp.R;
import com.lk.lkapp.custom.behavior.helper.HeaderScrollingViewBehavior;

import java.util.List;

/**
 * 创建者： user005
 * 时间：2017/2/13
 * Description：.
 */

public class UcNewsContentBehavior extends HeaderScrollingViewBehavior {

    public UcNewsContentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        offsetChildAsNeeded(parent, child, dependency);
        return false;
    }

    private void offsetChildAsNeeded(CoordinatorLayout parent, View child, View dependency) {
        child.setTranslationY((int) (-dependency.getTranslationY() / (getHeaderOffsetRange() * 1.0f) * getScrollRange(dependency)));
    }

    @Override
    protected View findFirstDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (isDependOn(view)) {
                return view;
            }
        }
        return null;
    }

    @Override
    protected int getScrollRange(View v) {
        if (isDependOn(v)) {
            return Math.max(0, v.getMeasuredHeight() - getFinalHeight());
        } else {
            return super.getScrollRange(v);
        }
    }

    private int getFinalHeight() {
        return App.getAppContext().getResources()
                .getDimensionPixelOffset(R.dimen.uc_news_tabs_height) + App.getAppContext()
                .getResources().getDimensionPixelOffset(R.dimen.uc_news_header_title_height);
    }

    private int getHeaderOffsetRange() {
        return App.getAppContext().getResources()
                .getDimensionPixelOffset(R.dimen.uc_news_header_pager_offset);
    }

    private boolean isDependOn(View dependency) {
        return dependency != null && dependency.getId() == R.id.id_uc_news_header_pager;
    }


}
