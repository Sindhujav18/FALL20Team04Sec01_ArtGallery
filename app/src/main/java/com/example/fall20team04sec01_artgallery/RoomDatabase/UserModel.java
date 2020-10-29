package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"email" })
public class UserModel {
    int id;

    @NonNull
    String email;

    String name,phoneNumber,password;

    public UserModel(String name,String email, String phoneNumber, String password) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
