package com.moviedb.contract;

import android.support.annotation.StringRes;

import com.moviedb.data.beans.Movie;

public class MovieContract {
    public interface Presenter {
        void subscribe();

        void unsubscribe();

        void onQueryEntered(String query);
    }

    public interface View {

        void setPresenter(Presenter presenter);

        void showMessage(@StringRes int message);

        void showMovies(Movie movie);
    }
}
