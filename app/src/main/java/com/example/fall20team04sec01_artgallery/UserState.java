package com.example.fall20team04sec01_artgallery;

import com.example.fall20team04sec01_artgallery.RoomDatabase.UserModel;

public class UserState {
    private static UserModel user = null;

    public static void setUser(UserModel user) {
        UserState.user = user;
    }

    public static UserModel getUser(){
        return user;
    }
}
