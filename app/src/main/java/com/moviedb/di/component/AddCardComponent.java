package com.moviedb.di.component;

import com.moviedb.di.module.AddCardPresenterModule;
import com.moviedb.di.scope.PerActivity;
import com.moviedb.ui.test.AddCardActivity;

import dagger.Component;

/**
 * Created by Jeremy on 2017/2/7.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = AddCardPresenterModule.class)
public interface AddCardComponent {

    void inject(AddCardActivity activity);

}
