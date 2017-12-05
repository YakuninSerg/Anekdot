package com.example.siakunin.retrofitobservable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by siakunin on 04.12.2017.
 */

public class Model {
    public static final String BASE_URL = "http://rzhunemogu.ru/";

    public static ApiAnekdot getApi() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        ApiAnekdot apiAnekdot = retrofit.create(ApiAnekdot.class);
        return apiAnekdot;

    }
}
