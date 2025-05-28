package com.example.balancelifestyle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface NotesMatrixListDao {

    @Query("SELECT * FROM notes_matrix_list WHERE typeOfMatrixList = :typeOfMatrixList")
    Single<List<NotesMatrixList>> getNotesMatrixLists(int typeOfMatrixList);

    @Insert
    Completable add(NotesMatrixList notesMatrixList);
    @Update
    Completable update(NotesMatrixList notesMatrixList);

    @Query("DELETE FROM notes_matrix_list WHERE id = :id AND typeOfMatrixList = :typeOfMatrixList")
    Completable remove(int id, int typeOfMatrixList);
}
