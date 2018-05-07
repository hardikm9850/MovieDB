package com.moviedb.ui.movie;

import com.moviedb.ConnectionManager;
import com.moviedb.R;
import com.moviedb.api.ApiService;
import com.moviedb.contract.MovieContract;
import com.moviedb.data.beans.Movie;
import com.moviedb.util.RxSchedulersOverrideRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresenterImplTest {

    PresenterImpl presenter;

    @Mock
    MovieContract.View view;
    @Mock
    ConnectionManager connectionManager;
    @Mock
    MovieInteractorImpl movieInteractor;

    /**
     * To alter Androidschedular and IO Schedular with Schedular.trempoline()
     */
    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setup(){
        presenter = new PresenterImpl(view,connectionManager,movieInteractor);
    }

    @Test
    public void checkValidResponseIsShownOnView(){
        Movie movie = new Movie();
        io.reactivex.Observable<Movie> movieObservable = io.reactivex.Observable.just(movie);

        when(connectionManager.isConnected()).thenReturn(true);
        doReturn(movieObservable).when(movieInteractor).searchMovie("John Wick");

        presenter.onQueryEntered("John Wick");

        verify(view).showMovies(movie);
    }

    @Test
    public void checkExceptionIsShownOnUI(){
        io.reactivex.Observable errorObservable = io.reactivex.Observable.<Movie>error(new RuntimeException());

        doReturn(errorObservable).when(movieInteractor).searchMovie("####");

        presenter.onQueryEntered("####");

        verify(view).showMovies(new Movie());
    }
}
