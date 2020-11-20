package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PurchaseDAO {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    public long PurchaseInsertion(PurchaseModel data);

    @Query("SELECT * FROM Art WHERE Art.id IN (SELECT PurchaseModel.artId FROM PurchaseModel WHERE PurchaseModel.userEmailId = :email)")
    public List<Art> getUsersPurchases(String email);
}
