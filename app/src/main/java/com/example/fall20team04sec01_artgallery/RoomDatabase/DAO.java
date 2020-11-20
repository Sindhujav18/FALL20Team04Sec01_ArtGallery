package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface DAO {

    // UserModel Queries

    @Insert(onConflict =  OnConflictStrategy.FAIL)
    public Long UserInsertion(UserModel userModel);

    @Query("Select * from UserModel")
    List<UserModel> getUserModel();

    @Query("Update UserModel set phoneNumber = :phone where name = :userName")
    void updateUser(String phone, String userName);

    @Query("Select * from UserModel where email=:userEnterEmail AND password=:userEnterPassword")
    List<UserModel> getInformationAndValidate(String userEnterEmail, String userEnterPassword);

    @Query("Select * from UserModel where email=:userEnterEmail")
    List<UserModel> checkEmail(String userEnterEmail);

    @Query("Update UserModel set password = :userPassword where email=:userEmail")
    void changeUserPassword(String userEmail,String userPassword);

    // ArtistModel Queries

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public Long ArtistInsertion(ArtistModel artistModel);


    @Query("Select * from ArtistModel where name =:artistName")
    public List<ArtistModel> getArtistUsingName(String artistName);

    @Query("Select * from ArtistModel")
    public List<ArtistModel> getAllArtist();

    // Art Queries

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public Long ArtInsertion(Art art);

    @Query("Select * from Art")
    public List<Art> getAllArt();

    @Query("Select * from Art where region =:regionName")
    List<Art> getArtByRegion(String regionName);

    @Update
    void updateArt(Art art);


    @Query("Select *from Art where country =:countryName")
    public List<Art> getArtByCountry(String countryName);

    @Query("Select * from Art where name =:artName")
    public List<Art> getArtByName(String artName);

    @Query("Select * from Art where artistEmail =:givenEmail")
    public List<Art> getArtistUsingEmail(String givenEmail);

    // Admin Queries
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long adminInsert(AdminCredentials adminCredentials);

    @Query("Select * from AdminCredentials")
    public List<AdminCredentials> getAdmin();

}