package com.moviedb.ui.movie;

import android.util.Log;

import com.moviedb.ConnectionManager;
import com.moviedb.R;
import com.moviedb.contract.MovieContract;
import com.moviedb.data.beans.Movie;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterImpl implements MovieContract.Presenter {
    private final ConnectionManager connectionManager;
    private final MovieContract.View view;
    private final MovieInteractorImpl movieInteractor;

    @Inject
    public PresenterImpl(MovieContract.View view,ConnectionManager connectionManager,MovieInteractorImpl movieInteractor) {
        this.view = view;
        this.connectionManager = connectionManager;
        this.movieInteractor = movieInteractor;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onQueryEntered(String query) {
        if(query.isEmpty()){
            view.showMessage(R.string.empty_movie);
        }
        if(!connectionManager.isConnected()){
            view.showMessage(R.string.require_internet);
        }
        movieInteractor.searchMovie(query).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie movie) {
                        view.showMovies(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("@@@@","Error",e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
