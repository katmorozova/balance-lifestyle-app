package com.example.balancelifestyle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface ToDoListDao {

    @Query("SELECT * FROM listNotes")
    Single<List<ToDoList>> getToDoLists();

    @Insert
    Completable add(ToDoList toDoList);//agrega habito dentro de DB

    @Query("DELETE FROM listNotes WHERE id = :id")
    Completable remove(int id);//Elimina habito por su id
}
