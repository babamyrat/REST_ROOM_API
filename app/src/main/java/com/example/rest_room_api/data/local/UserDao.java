package com.example.rest_room_api.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.rest_room_api.model.ExampleModel;

import java.util.List;


@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ExampleModel> exampleModelList);

    @Query("SELECT * FROM categories")
    List<ExampleModel> loadAll();

}
