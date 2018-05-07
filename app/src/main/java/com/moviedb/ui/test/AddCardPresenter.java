package com.moviedb.ui.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

import com.moviedb.contract.AddCardsContract;

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
