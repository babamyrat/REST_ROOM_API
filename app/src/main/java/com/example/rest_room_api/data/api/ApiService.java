package com.example.rest_room_api.data.api;


import com.example.rest_room_api.model.ExampleResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/1e5da9c7ebc28c3a1624")
    Observable<ExampleResponse> getCategory();

//    @Headers("Content-Type: application/json")
//    @GET("catalog/category")
//    Observable<CategoryResponse> getCategory();

    //https://api.npoint.io/0647b08d610d10edf331
}
