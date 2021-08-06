package com.example.rest_room_api.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.rest_room_api.data.api.ApiClient;
import com.example.rest_room_api.data.local.LocalClient;
import com.example.rest_room_api.model.Category;
import com.example.rest_room_api.utils.NetworkUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DataManager {

    private Context context;
    private static DataManager instance;
    private ApiClient apiClient;
    private LocalClient localClient;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private DataManager(Context context) {
        this.context = context;
        apiClient = ApiClient.newInstance();
        localClient = LocalClient.newInstance(context);
    }

    public static DataManager newInstance(Context context) {
        if (instance == null)
            instance = new DataManager(context);
        return instance;
    }

    @SuppressLint("CheckResult")
    public void loadCategory(MutableLiveData<List<Category>> liveData) {
        if (NetworkUtils.isNetworkConnected(context)) {
            apiClient.getCategories()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(categoryResponse -> {
                        liveData.postValue(categoryResponse.getResults());
                        insertCategories(categoryResponse.getResults());
                    }, error -> Log.d("ERROR", error.getMessage()));
        } else {
            localClient.getAllCategories()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(liveData::postValue, throwable -> {
                    });
        }
    }

    public void insertCategories(List<Category> categories) {
        compositeDisposable.add(localClient.insertAll(categories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Log.d("SUCCESS", categories.size() + "categories inserted in db");
                }, throwable -> {
                    Log.d("ERROR", "error inserting movies : " + throwable.getMessage());
                }));
    }


}
