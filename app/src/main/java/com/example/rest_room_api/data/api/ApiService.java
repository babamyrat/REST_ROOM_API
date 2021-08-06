package com.example.rest_room_api.data.api;


import com.example.rest_room_api.model.CategoryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("catalog/category")
    Observable<CategoryResponse> getCategory();

}
