package com.example.balancelifestyle.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {WishList.class}, version = 1)
public abstract class WishListDatabase extends RoomDatabase {

    private static WishListDatabase instance = null;
    private static final String DB_NAME = "wishes.db";


    public static WishListDatabase getInstance(Application application){
        if(instance == null){
            //crear ejemplar base de datos:
            instance = Room.databaseBuilder(
                    application,
                    WishListDatabase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }
    //public abstract WishListDao wishListDao;
    public WishListDao wishListDao;
}
