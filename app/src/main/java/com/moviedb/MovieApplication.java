package com.moviedb;

import android.app.Application;

import com.moviedb.di.component.AppComponent;
import com.moviedb.di.component.DaggerAppComponent;
import com.moviedb.di.component.DaggerMovieComponent;
import com.moviedb.di.module.AppModule;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MovieApplication extends Application {

    private AppComponent appComponent;

    private static MovieApplication movieApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        movieApplication = this;
        FlowManager.init(this);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MovieApplication getMovieApplication() {
        return movieApplication;
    }
}
