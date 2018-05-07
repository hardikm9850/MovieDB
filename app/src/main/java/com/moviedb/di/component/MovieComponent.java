package com.moviedb.di.component;

import com.moviedb.di.module.MoviePresenterModule;
import com.moviedb.ui.movie.MovieActivity;
import com.moviedb.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = MoviePresenterModule.class)
public interface MovieComponent {
    void inject(MovieActivity movieMovieActivity);
}
