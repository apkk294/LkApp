package com.lk.lkapp.module;

import com.lk.lkapp.contract.LolNewsContentContract;

import dagger.Module;
import dagger.Provides;

/**
 * Package：com.lk.lkapp.module
 * Created by user005 on 2016/12/29.
 * Description：.
 */

@Module
public class LolNewsContentModule {

    private LolNewsContentContract.View mView;

    public LolNewsContentModule(LolNewsContentContract.View view) {
        mView = view;
    }

    @Provides
    LolNewsContentContract.View provideView() {
        return mView;
    }
}
