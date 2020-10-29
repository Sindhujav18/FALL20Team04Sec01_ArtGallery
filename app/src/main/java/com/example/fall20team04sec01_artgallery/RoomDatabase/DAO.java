package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAO {

    @Insert(onConflict =  OnConflictStrategy.FAIL)
    public Long UserInsertion(UserModel userModel);

    @Query("Select * from UserModel")
    List<UserModel> getUserModel();


}
