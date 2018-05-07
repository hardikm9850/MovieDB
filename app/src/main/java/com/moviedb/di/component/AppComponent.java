package com.moviedb.di.component;

import android.content.SharedPreferences;

import com.moviedb.api.ApiService;
import com.moviedb.di.module.ApiServiceModule;
import com.moviedb.di.module.AppModule;
import com.moviedb.di.module.SharedPreferenceModule;
import com.moviedb.ui.movie.MovieActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, SharedPreferenceModule.class})
public interface AppComponent {

    void inject(MovieActivity movieMovieActivity);

    ApiService getApiService();

    SharedPreferences getSharedPreference();
}
