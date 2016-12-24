package com.lk.lkapp.component;

import com.lk.lkapp.module.LolNewsModule;
import com.lk.lkapp.ui.fragment.LolNewsFragment;

import dagger.Component;

/**
 * Package：com.lk.lkapp.component
 * Created by user005 on 2016/12/16.
 * Description：.
 */

@Component(modules = LolNewsModule.class)
public interface LolNewsComponent {
    void inject(LolNewsFragment inject);
}
