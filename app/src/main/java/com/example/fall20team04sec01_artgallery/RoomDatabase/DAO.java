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

    @Query("Update UserModel set phoneNumber = :phone where name = :userName")
    void updateUser(String phone, String userName);

    @Query("Select * from UserModel where email=:userEnterEmail AND password=:userEnterPassword")
    List<UserModel> getInformationAndValidate(String userEnterEmail, String userEnterPassword);

    @Query("Select * from ArtistModel")
    public List<ArtistModel> getAllArtist();
    @Query("Select * from UserModel where email=:userEnterEmail")
    List<UserModel> checkEmail(String userEnterEmail);
}
