package com.example.rest_room_api.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.rest_room_api.model.Category;

import java.util.List;


@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Category> categoryList);

    @Query("SELECT * FROM categories")
    List<Category> loadAll();

}
