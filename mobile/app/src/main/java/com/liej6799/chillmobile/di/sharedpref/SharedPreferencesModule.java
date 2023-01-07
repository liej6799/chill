package com.liej6799.chillmobile.di.sharedpref;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {
    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }
}