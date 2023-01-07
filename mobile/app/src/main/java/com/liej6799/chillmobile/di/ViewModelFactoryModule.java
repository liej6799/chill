package com.liej6799.chillmobile.di;

import androidx.lifecycle.ViewModelProvider;

import com.liej6799.chillmobile.util.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Provides
    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory factory) {
        return factory;
    }


}
