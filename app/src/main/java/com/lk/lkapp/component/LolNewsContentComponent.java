package com.lk.lkapp.component;

import com.lk.lkapp.module.LolNewsContentModule;
import com.lk.lkapp.ui.activity.LolNewsContentActivity;

import dagger.Component;

/**
 * Package：com.lk.lkapp.component
 * Created by user005 on 2016/12/29.
 * Description：.
 */

@Component(modules = LolNewsContentModule.class)
public interface LolNewsContentComponent {
    void inject(LolNewsContentActivity inject);
}
