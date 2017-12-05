package com.example.siakunin.retrofitobservable;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by siakunin on 04.12.2017.
 */

public interface ApiAnekdot {
    @GET("/RandJSON.aspx")
    Observable<Anekdot> getContent(@Query("CType")int type);


}
