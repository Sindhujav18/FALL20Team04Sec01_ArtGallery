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

    public Buy(int userId, int artId, String buy_date, int quantity) {
        this.userId = userId;
        this.artId = artId;
        this.buy_date = buy_date;
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
