package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {UserModel.class,ArtistModel.class,Art.class,AdminCredentials.class, PurchaseModel.class, FavouriteModel.class},version = 3, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MyDatabase extends RoomDatabase {

    public abstract DAO dao();
    public abstract PurchaseDAO purchaseDAO();
    public abstract FavouriteDAO favouriteDAO();
}
