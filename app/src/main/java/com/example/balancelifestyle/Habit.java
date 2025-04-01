package com.example.balancelifestyle;

import androidx.room.Entity;

@Entity(tableName = "notes")
public class Habit {

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
