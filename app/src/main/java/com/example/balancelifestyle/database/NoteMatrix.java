package com.example.balancelifestyle.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notesMatrix")
public class NoteMatrix {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String category;
    private String text;


    public NoteMatrix(int id, String category, String text){
        this.id = id;
        this.category = category;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getText() {
        return text;
    }
}
