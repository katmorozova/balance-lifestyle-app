package com.example.balancelifestyle.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wishes")
public class WishList {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private String typeOfCategory;

    public WishList(int id, String text, String typeOfCategory){
        this.id = id;
        this.text = text;
        this.typeOfCategory = typeOfCategory;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTypeOfCategory() {
        return typeOfCategory;
    }
}
