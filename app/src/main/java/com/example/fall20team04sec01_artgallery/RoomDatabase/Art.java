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
    public String getArtistEmail() {
        return artistEmail;
    }

    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<String> getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(ArrayList<String> imagesPath) {
        this.imagesPath = imagesPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
