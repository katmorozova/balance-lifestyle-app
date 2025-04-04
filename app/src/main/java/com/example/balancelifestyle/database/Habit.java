package com.example.balancelifestyle.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habits")
public class Habit {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private int typeOfHabit;

    public Habit(int id, String text, int typeOfHabit){
        this.id = id;
        this.text = text;
        this.typeOfHabit = typeOfHabit;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getTypeOfHabit() {
        return typeOfHabit;
    }
}
