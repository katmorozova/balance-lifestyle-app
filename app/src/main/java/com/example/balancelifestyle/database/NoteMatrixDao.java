package com.example.balancelifestyle.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface NoteMatrixDao {

    @Query("SELECT * FROM notesMatrix")
    Single<List<NoteMatrix>> getNoteMatrixs();//recibe nota

    @Insert
    Completable add(NoteMatrix noteMatrix);//agrega nota dentro de DB

    @Update
    Completable update(NoteMatrix noteMatrix);//editar la nota

    @Query("DELETE FROM notesMatrix WHERE id = :id AND category = :category")
    Completable remove(int id, String category);//Elimina nota por su id y categoria


}
