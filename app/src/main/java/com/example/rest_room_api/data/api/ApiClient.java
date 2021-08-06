package com.example.rest_room_api.data.api;

import android.annotation.SuppressLint;
import android.content.Context;


import com.example.rest_room_api.model.CategoryResponse;
import com.example.rest_room_api.utils.AppConstants;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private ApiService apiService;
    @SuppressLint("StaticFieldLeak")
    private static ApiClient instance;
    private Context context;

    private ApiClient(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(AppConstants.BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static ApiClient newInstance(){
        if (instance == null)
            instance = new ApiClient();
        return instance;
    }

    public Observable<CategoryResponse> getCategories(){
          return apiService.getCategory();
    }

}
