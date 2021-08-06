package com.example.rest_room_api.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.rest_room_api.model.ExampleModel;


@Database(entities = {ExampleModel.class}, version = 1)
public abstract class AppDataBase  extends RoomDatabase {

    public abstract UserDao categoryDao();
}
