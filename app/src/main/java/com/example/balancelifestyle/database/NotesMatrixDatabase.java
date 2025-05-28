package com.example.balancelifestyle.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {NotesMatrixList.class}, version = 4)
public abstract class NotesMatrixDatabase extends RoomDatabase {

    private static NotesMatrixDatabase instance = null;
    private static final String DB_NAME = "notes_matrix_list.db";


    public static NotesMatrixDatabase getInstance(Application application){
        if(instance == null) {
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    NotesMatrixDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract NotesMatrixListDao notesMatrixListDao();

}
