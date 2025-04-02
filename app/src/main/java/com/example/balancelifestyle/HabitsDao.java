package com.example.balancelifestyle;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;


@Dao
public interface HabitsDao {

    @Query("SELECT * FROM habits")
    LiveData<List<Habit>> getHabits(); //recibe habito

    @Insert
    Completable add(Habit habit);//agrega habito dentro de DB

    @Query("DELETE FROM habits WHERE id = :id")
    void remove(int id);//Elimina habito por su id
}
