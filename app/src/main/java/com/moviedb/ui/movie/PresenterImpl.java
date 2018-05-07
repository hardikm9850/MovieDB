package com.moviedb.ui.movie;

import com.moviedb.contract.MovieContract;

import javax.inject.Inject;

public class PresenterImpl implements MovieContract.Presenter {
    MovieContract.View view;

    @Inject
    public PresenterImpl(MovieContract.View view) {
        this.view = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
