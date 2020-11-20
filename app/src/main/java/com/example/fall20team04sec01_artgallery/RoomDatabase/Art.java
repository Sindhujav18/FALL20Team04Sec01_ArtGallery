package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;

@Entity
public class Art {

    @PrimaryKey(autoGenerate = true)
    int id;

    String name, artistEmail, dimensions, country, price, region;

    @TypeConverters(Converters.class)
    ArrayList<String> imagesPath;

    public Art(String name, String artistEmail, String dimensions, String country, String price, String region, ArrayList<String> imagesPath) {
        this.name = name;
        this.artistEmail = artistEmail;
        this.dimensions = dimensions;
        this.country = country;
        this.price = price;
        this.region = region;
        this.imagesPath = imagesPath;
    }
}
