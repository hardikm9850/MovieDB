package com.moviedb.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {
    private final String SHARED_PREFERENCE_NAME = "movie_db_sp";

    @Provides
    @Singleton
    SharedPreferences provideSharedPreference(Application application) {
        return application.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor prodvideEditor(SharedPreferences sharedPreferences){
        return sharedPreferences.edit();
    }
}
