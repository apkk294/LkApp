package com.lk.lkapp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lk.lkapp.ui.fragment.TestListFragment;

/**
 * 创建者： user005
 * 时间：2017/2/13
 * Description：.
 */

public class TestTabAdapter extends FragmentStatePagerAdapter {

    public TestTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TestListFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab " + String.valueOf(position);
    }

}
