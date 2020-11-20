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

    public PurchaseModel(Integer artId, String userEmailId){
        this.artId = artId;
        this.userEmailId = userEmailId;
        this.quantity = 1;
    }

    public Integer getArtId() {
        return artId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }
}
