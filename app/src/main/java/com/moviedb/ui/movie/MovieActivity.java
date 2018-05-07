package com.moviedb.ui.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
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
import com.moviedb.data.beans.Movie;
import com.moviedb.di.component.AppComponent;
import com.moviedb.di.component.DaggerMovieComponent;
import com.moviedb.di.component.MovieComponent;
import com.moviedb.di.module.MoviePresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieActivity extends AppCompatActivity implements MovieContract.View {
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
        moviePresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        moviePresenter.unsubscribe();
        super.onDestroy();
    }

    @OnClick(R.id.btnSearch)
    public void onSearchClicked(){
        String query = edtMovie.getText().toString().trim();
        moviePresenter.onQueryEntered(query);
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        //...
    }

    @Override
    public void showMessage(@StringRes int message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMovies(Movie movie) {

    }
}
