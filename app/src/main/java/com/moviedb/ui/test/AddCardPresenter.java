package com.moviedb.ui.test;

import java.util.Calendar;

import javax.inject.Inject;


/**
 * Created by Jeremy on 2017/2/7.
 */

public class AddCardPresenter implements AddCardsContract.Presenter {


    private AddCardsContract.View view;

    private Calendar mCalendar;
    private long expiredTime;

    @Inject
    AddCardPresenter(AddCardsContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
