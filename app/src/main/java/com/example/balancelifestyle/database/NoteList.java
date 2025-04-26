package com.example.balancelifestyle.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "notelist")
public class NoteList {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String text;


    public NoteList(int id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
