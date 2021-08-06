package com.example.rest_room_api.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.rest_room_api.data.DataManager;
import com.example.rest_room_api.model.Category;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private DataManager dataManager = DataManager.newInstance(getApplication());

    MutableLiveData<List<Category>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<Category>> getLiveData() {
        return liveData;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCategory(){
        dataManager.loadCategory(liveData);
    }


}
