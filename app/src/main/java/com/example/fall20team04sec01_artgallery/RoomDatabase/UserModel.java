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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
