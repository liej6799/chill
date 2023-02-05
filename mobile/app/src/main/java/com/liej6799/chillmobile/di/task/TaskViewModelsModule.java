package com.liej6799.chillmobile.di.task;

import androidx.lifecycle.ViewModel;

import com.liej6799.chillmobile.di.ViewModelKey;
import com.liej6799.chillmobile.ui.task.TaskViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class TaskViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel.class)
    public abstract ViewModel bindSaleItemVieModel(TaskViewModel saleItemViewModel);

}
