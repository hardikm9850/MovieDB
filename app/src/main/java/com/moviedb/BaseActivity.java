package com.moviedb;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.moviedb.di.component.AppComponent;

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieApplication movieApplication =MovieApplication.getMovieApplication();
        AppComponent appComponent = movieApplication.getAppComponent();
        injectDependency(movieApplication,appComponent);
    }

    public abstract void injectDependency(MovieApplication movieApplication, AppComponent appComponent);
}
