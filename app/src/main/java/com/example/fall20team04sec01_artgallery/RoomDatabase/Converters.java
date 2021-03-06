package com.example.fall20team04sec01_artgallery.RoomDatabase;

import android.util.Log;

import androidx.constraintlayout.motion.widget.Debug;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class Converters {
    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {

        if (list== null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        Log.e("Json message : ",gson.toJson(list, type)+" : "+list.get(0));
        return gson.toJson(list, type);
    }

}