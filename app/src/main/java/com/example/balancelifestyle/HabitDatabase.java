package com.example.balancelifestyle;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Habit.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {

    private static HabitDatabase instance = null;
    private static final String DB_NAME = "habits.db";

    public static HabitDatabase getInstance(Application application) {
        if(instance == null){
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    HabitDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

    public abstract HabitsDao habitsDao();
}
