package com.example.balancelifestyle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface NoteListDao {

    @Query("SELECT * FROM notelist")
    Single<List<NoteList>> getNoteLists(); //recibe nota


    @Insert
    Completable add(NoteList noteList);//agrega nota dentro de DB


    @Query("DELETE FROM notelist WHERE id = :id")
    Completable remove(int id);//Elimina nota por su id

}
