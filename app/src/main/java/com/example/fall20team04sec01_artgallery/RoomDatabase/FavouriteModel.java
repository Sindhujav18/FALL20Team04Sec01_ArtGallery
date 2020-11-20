package com.example.fall20team04sec01_artgallery.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Art.class, parentColumns = "id", childColumns = "artId"),
        @ForeignKey(entity = UserModel.class, parentColumns = "email", childColumns = "userEmailId")
})
public class FavouriteModel {
    @PrimaryKey
    Integer _id;

    @ColumnInfo(name = "artId")
    Integer artId;

    @ColumnInfo(name = "userEmailId")
    String userEmailId;

    public FavouriteModel(Integer artId, String userEmailId){
        this.artId = artId;
        this.userEmailId = userEmailId;
    }

    public Integer getArtId() {
        return artId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }


    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }
}
