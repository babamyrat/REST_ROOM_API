package com.example.rest_room_api.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.rest_room_api.data.DataManager;
import com.example.rest_room_api.model.ExampleModel;

import java.util.List;

public class ExampleViewModel extends AndroidViewModel {

    private DataManager dataManager = DataManager.newInstance(getApplication());

    MutableLiveData<List<ExampleModel>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<ExampleModel>> getLiveData() {
        return liveData;
    }

    public ExampleViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCategory(){
        dataManager.loadCategory(liveData);
    }


}
