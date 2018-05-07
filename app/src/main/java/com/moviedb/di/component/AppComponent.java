package com.moviedb.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.moviedb.api.ApiService;
import com.moviedb.di.module.ApiServiceModule;
import com.moviedb.di.module.AppModule;
import com.moviedb.di.module.SharedPreferenceModule;
import com.moviedb.ui.movie.MovieActivity;
import com.moviedb.ui.movie.MovieInteractorImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, SharedPreferenceModule.class})
public interface AppComponent {

    SharedPreferences getSharedPreference();

    Context getContext();

    ApiService getApiService();

    @Named("apiKey") String getApiKey();
}
