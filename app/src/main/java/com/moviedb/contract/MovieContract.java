package com.moviedb.contract;

public class MovieContract {
    public interface Presenter {
        void subscribe();

        void unsubscribe();
    }

    public interface View {

        void setPresenter(Presenter presenter);

        void showMessage(String message);
    }
}
