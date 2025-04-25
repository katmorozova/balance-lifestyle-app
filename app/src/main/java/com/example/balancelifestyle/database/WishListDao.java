package com.example.balancelifestyle.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface WishListDao {


    @Query("SELECT * FROM wishes")
    Single<List<WishList>> getWishLists(); //recibe nota


    @Insert
    Completable add(WishList wishList);//agrega nota dentro de DB


    @Query("DELETE FROM wishes WHERE id = :id")
    Completable remove(int id);//Elimina nota por su id
}
