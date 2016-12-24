package com.lk.lkapp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseActivity;
import com.lk.lkapp.base.BaseFragment;
import com.lk.lkapp.ui.fragment.AboutFragment;
import com.lk.lkapp.ui.fragment.LolNewsFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String FRAGMENT_TAG_LOL_NEWS = "lol_news";
    private static final String FRAGMENT_TAG_ABOUT    = "about";
    private static final String FRAGMENT_TYPE         = "FRAGMENT_TYPE";

    private LolNewsFragment mLolNewsFragment;
    private AboutFragment   mAboutFragment;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private String currentFragmentType;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
        outState.putString(FRAGMENT_TYPE, currentFragmentType);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        currentFragmentType = savedInstanceState.getString(FRAGMENT_TYPE);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mToolbar.setTitle(R.string.lol_news);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mLolNewsFragment = LolNewsFragment.newInstance();
        mAboutFragment = AboutFragment.newInstance();

        currentFragmentType = currentFragmentType == null ?
                FRAGMENT_TAG_LOL_NEWS : currentFragmentType;
        setCurrentFragment(FRAGMENT_TAG_LOL_NEWS);
    }

    private void setCurrentFragment(String childFragmentTag) {
        FragmentManager     mFragmentManager     = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();

        if (currentFragmentType.equals(childFragmentTag)) {
            BaseFragment childFragment = (BaseFragment) mFragmentManager.findFragmentByTag(childFragmentTag);
            if (childFragment == null) {
                childFragment = getChildFragmentByTag(childFragmentTag);
            } else {
                if (getChildFragmentByTag(childFragmentTag) != childFragment) {
                    mFragmentTransaction.remove(childFragment);
                    childFragment = getChildFragmentByTag(childFragmentTag);
                }
            }
            if (!childFragment.isAdded()) {
                mFragmentTransaction.add(R.id.content_main, childFragment, childFragmentTag);
            }
            if (childFragment.isHidden()) {
                mFragmentTransaction.show(childFragment);
            }
        } else {
            BaseFragment childFragment = (BaseFragment) mFragmentManager.findFragmentByTag(currentFragmentType);
            if (childFragment != null) {
                mFragmentTransaction.hide(childFragment);
            }
            BaseFragment addChildFragment = (BaseFragment) mFragmentManager.findFragmentByTag(childFragmentTag);
            if (addChildFragment == null) {
                addChildFragment = getChildFragmentByTag(childFragmentTag);
            } else {
                if (getChildFragmentByTag(childFragmentTag) != addChildFragment) {
                    mFragmentTransaction.remove(addChildFragment);
                    addChildFragment = getChildFragmentByTag(childFragmentTag);
                }
            }
            if (!addChildFragment.isAdded()) {
                mFragmentTransaction.add(R.id.content_main, addChildFragment, childFragmentTag);
            }
            mFragmentTransaction.show(addChildFragment);
        }
        currentFragmentType = childFragmentTag;
        mFragmentTransaction.commit();
    }

    private BaseFragment getChildFragmentByTag(String childFragmentTag) {
        switch (childFragmentTag) {
            case FRAGMENT_TAG_ABOUT:
                return mAboutFragment;
            case FRAGMENT_TAG_LOL_NEWS:
            default:
                return mLolNewsFragment;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lol_news) {
            mToolbar.setTitle(R.string.lol_news);
            setCurrentFragment(FRAGMENT_TAG_LOL_NEWS);
        } else if (id == R.id.nav_about) {
            mToolbar.setTitle(R.string.about);
            setCurrentFragment(FRAGMENT_TAG_ABOUT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
