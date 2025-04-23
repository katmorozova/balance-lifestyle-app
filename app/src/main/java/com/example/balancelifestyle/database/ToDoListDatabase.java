package com.example.balancelifestyle.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.balancelifestyle.ToDoList;

@Database(entities = {ToDoList.class}, version = 2)
public abstract class ToDoListDatabase extends RoomDatabase {

    private static ToDoListDatabase instance = null;
    private static final String DB_NAME = "listNotes.db";

    public static ToDoListDatabase getInstance(Application application){
        if(instance == null){
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    ToDoListDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract ToDoListDao toDoListDao();
}
