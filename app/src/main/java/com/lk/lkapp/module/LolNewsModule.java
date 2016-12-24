package com.lk.lkapp.module;

import com.lk.lkapp.contract.LolNewsContract;

import dagger.Module;
import dagger.Provides;

/**
 * Package：com.lk.lkapp.module
 * Created by user005 on 2016/12/16.
 * Description：.
 */

@Module
public class LolNewsModule {

    private LolNewsContract.View mView;

    public LolNewsModule(LolNewsContract.View view) {
        mView = view;
    }

    @Provides
    LolNewsContract.View provideView() {
        return mView;
    }
}
