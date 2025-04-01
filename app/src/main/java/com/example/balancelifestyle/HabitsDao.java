package com.example.balancelifestyle;


import androidx.room.Dao;

import java.util.ArrayList;

@Dao
public interface HabitsDao {

    ArrayList<Habit> getHabits(); //recibe habito

    void add(Habit habit);//agrega habito dentro de DB

    void remove(int id);//Elimina habito por su id
}
