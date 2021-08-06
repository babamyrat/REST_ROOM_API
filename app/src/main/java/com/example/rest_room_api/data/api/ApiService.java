package com.example.rest_room_api.data.api;


import com.example.rest_room_api.model.CategoryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @GET("/aef8046ff2e96b200fc8")
    Observable<CategoryResponse> getCategory();



//    @Headers("Content-Type: application/json")
//    @GET("catalog/category")
//    Observable<CategoryResponse> getCategory();

    //https://api.npoint.io/0647b08d610d10edf331
}
