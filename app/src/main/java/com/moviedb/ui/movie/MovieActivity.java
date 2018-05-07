package com.moviedb.ui.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moviedb.BaseActivity;
import com.moviedb.MovieApplication;
import com.moviedb.R;
import com.moviedb.contract.MovieContract;
import com.moviedb.di.component.AppComponent;
import com.moviedb.di.component.DaggerMovieComponent;
import com.moviedb.di.component.MovieComponent;
import com.moviedb.di.module.MoviePresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends BaseActivity implements MovieContract.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edtMovie)
    EditText edtMovie;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.txtResult)
    TextView txtResult;
    @BindView(R.id.recycler_movies)
    RecyclerView recyclerMovies;

    @Inject
    PresenterImpl moviePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        DaggerMovieComponent.builder().appComponent(MovieApplication.getMovieApplication().getAppComponent())
                .moviePresenterModule(new MoviePresenterModule(this))
                .build()
                .inject(this);
        //moviePresenter.subscribe();
    }

    @Override
    public void injectDependency(MovieApplication movieApplication, AppComponent appComponent) {

    }


    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        moviePresenter = (PresenterImpl) presenter;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
