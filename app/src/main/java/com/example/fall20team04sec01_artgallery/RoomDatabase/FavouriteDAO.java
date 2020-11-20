package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavouriteDAO {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    public void makeFavourite(FavouriteModel data);

    @Query("DELETE FROM FavouriteModel WHERE FavouriteModel.artId = :artId AND FavouriteModel.userEmailId = :userId")
    public void removeFavourite(Integer artId, String userId);

    @Query("SELECT * FROM Art WHERE Art.id IN (SELECT FavouriteModel.artId FROM FavouriteModel WHERE FavouriteModel.userEmailId = :email)")
    public List<Art> getUsersFavourites(String email);

    @Query("SELECT * FROM PurchaseModel")
    public List<FavouriteModel> getAll();
}
