package com.liej6799.chillmobile.di;

import com.liej6799.chillmobile.MainActivity;

import dagger.Module;

@Module
public abstract class ActivityBuilderModule {

    abstract MainActivity contributeMainActivity();

}
