package com.moviedb.ui.test;

import android.app.Activity;
import android.os.Bundle;


import com.moviedb.MovieApplication;
import com.moviedb.di.component.DaggerAddCardComponent;
import com.moviedb.di.module.AddCardPresenterModule;
import com.moviedb.contract.AddCardsContract;

import javax.inject.Inject;

/**
 * Created by Jeremy on 2016/3/28.
 */
public class AddCardActivity extends Activity implements AddCardsContract.View {

    @Inject
    AddCardPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAddCardComponent.builder()
                .appComponent(MovieApplication.getMovieApplication().getAppComponent())
                .addCardPresenterModule(new AddCardPresenterModule(this))
                .build()
                .inject(this);


        //mPresenter.subscribe();
    }


    @Override
    public void setPresenter(AddCardsContract.Presenter presenter) {
        mPresenter = (AddCardPresenter) presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}