package com.lk.lkapp.ui.fragment;

import android.os.Bundle;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseFragment;

/**
 * Package：com.lk.lkapp.ui.fragment
 * Created by user005 on 2016/12/16.
 * Description：about fragment.
 */

public class AboutFragment extends BaseFragment {

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView() {

    }
}
