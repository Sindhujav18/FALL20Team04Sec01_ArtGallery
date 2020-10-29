package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserModel.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract DAO dao();

}
