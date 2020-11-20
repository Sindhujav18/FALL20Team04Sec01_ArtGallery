package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Art.class, parentColumns = "id", childColumns = "artId"),
        @ForeignKey(entity = UserModel.class, parentColumns = "email", childColumns = "userEmailId")
})
public class PurchaseModel {
    @PrimaryKey
    Integer _id;

    @ColumnInfo(name = "artId")
    Integer artId;

    @ColumnInfo(name = "userEmailId")
    String userEmailId;

    @ColumnInfo(name = "quantity")
    Integer quantity;