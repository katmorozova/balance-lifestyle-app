package com.example.balancelifestyle;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface HabitsDao {

    @Query("SELECT * FROM habits")
    LiveData<List<Habit>> getHabits(); //recibe habito

    @Insert
    void add(Habit habit);//agrega habito dentro de DB

    @Query("DELETE FROM habits WHERE id = :id")
    void remove(int id);//Elimina habito por su id
}
