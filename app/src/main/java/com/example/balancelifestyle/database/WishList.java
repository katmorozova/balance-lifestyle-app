package com.example.balancelifestyle.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "wishes")
public class WishList {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String text;


    public WishList(int id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

