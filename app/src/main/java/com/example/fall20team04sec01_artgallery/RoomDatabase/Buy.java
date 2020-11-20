package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity( foreignKeys = {
        @ForeignKey(entity = Art.class,
                parentColumns = "id",
                childColumns = "artId"),
        @ForeignKey(entity = UserModel.class,
                parentColumns = "id",
                childColumns = "userId")
})
public class Buy {

    int userId;
    int artId;

    String buy_date;
    int quantity;
}
