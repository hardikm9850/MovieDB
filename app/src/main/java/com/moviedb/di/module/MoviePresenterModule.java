package com.moviedb.di.module;

import com.moviedb.contract.MovieContract;
import com.moviedb.di.scope.PerActivity;
import com.moviedb.ui.movie.PresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviePresenterModule {
    private MovieContract.View view;

    public MoviePresenterModule(MovieContract.View view) {
        this.view = view;
    }

    @Provides
    public MovieContract.View providesMovieContractView(){
        return view;
    }
}
