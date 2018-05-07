package com.moviedb.di.module;

import android.app.Application;

import com.moviedb.api.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModule {

    private static final String BASE_URL = "http://api.themoviedb.org/";

    @Singleton
    @Provides
    OkHttpClient procvideOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Application application, OkHttpClient okHttpClient){
        return new Retrofit.Builder().
                baseUrl(BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    @Named("apiKey")
    String provideApiKey(){
        String API_KEY = "7c67790b259a965357bdf4b03febee52";
        return API_KEY;
    }
}
