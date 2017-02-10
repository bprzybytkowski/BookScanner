package com.soldiersofmobile.bookscanner.api;

import com.soldiersofmobile.bookscanner.api.model.BooksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BookApi {


    //TODO add missing Retrofit annotations

    @GET("/books/v1/volumes?q=")
    Call<BooksResponse> getBook(@Query("query") String query);

}
