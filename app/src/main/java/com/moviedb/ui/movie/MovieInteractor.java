package com.moviedb.ui.movie;


import com.moviedb.data.beans.Movie;

import io.reactivex.Observable;

public interface MovieInteractor {
    Observable<Movie> searchMovie(String name);
}
