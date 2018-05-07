package com.moviedb.ui.movie;

import com.moviedb.api.ApiService;
import com.moviedb.data.beans.Movie;


import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

public class MovieInteractorImpl implements MovieInteractor {
    private ApiService apiService;

    String apiKey;

    @Inject
    public MovieInteractorImpl(ApiService apiService,@Named("apiKey") String apiKey){
        this.apiService = apiService;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<Movie> searchMovie(String name) {
        return apiService.searchMovie(apiKey,name);
    }
}
