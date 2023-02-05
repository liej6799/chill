package com.liej6799.chillmobile.di;

import com.liej6799.chillmobile.di.task.TaskViewModelsModule;
import com.liej6799.chillmobile.ui.main.MainActivity;
import com.liej6799.chillmobile.ui.task.TextTaskActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(
            modules = {TaskViewModelsModule.class}
    )
    abstract TextTaskActivity contributeTextTaskActivity();
}
