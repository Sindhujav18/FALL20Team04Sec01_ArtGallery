package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class ArtistModel {

    @PrimaryKey
    @NonNull
    String email;

    String name, phoneNumber, country;

    public ArtistModel(String name, String email, String phoneNumber, String country) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }
}
