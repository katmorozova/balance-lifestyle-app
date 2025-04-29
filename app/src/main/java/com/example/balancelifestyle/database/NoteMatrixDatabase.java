package com.example.balancelifestyle.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {NoteMatrix.class}, version = 4)
public abstract class NoteMatrixDatabase extends RoomDatabase {

    private static NoteMatrixDatabase instance = null;
    private static final String DB_NAME = "notesMatrix.db";


    public static NoteMatrixDatabase getInstance(Application application){
        if(instance == null) {
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    NoteMatrixDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }
    public abstract NoteMatrixDao noteMatrixDao();
}
