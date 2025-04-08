package com.example.balancelifestyle.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface WishListDao {

    @Query("SELECT * FROM wishes WHERE typeOfCategory = :typeOfCategory AND id = :id")
    Single<List<WishList>> getWishLists(String typeOfCategory, int id); //recibe nota por su categoria

    @Insert
    Completable add(WishList wishList);//agrega nota dentro de DB

    @Query("DELETE FROM wishes WHERE typeOfCategory = :typeOfCategory AND id = :id")
    Completable remove(String typeOfCategory, int id);//Elimina nota por su categoria
}
