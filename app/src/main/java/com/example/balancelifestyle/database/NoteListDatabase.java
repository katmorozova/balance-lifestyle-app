package com.example.balancelifestyle.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteList.class}, version = 3)
public abstract class NoteListDatabase extends RoomDatabase {

    private static NoteListDatabase instance = null;
    private static final String DB_NAME = "notelist.db";


    public static NoteListDatabase getInstance(Application application) {
        if(instance == null){
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    NoteListDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }
    public abstract NoteListDao noteListDao();
}
