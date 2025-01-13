package com.example.food_recipes_app.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {DatabaseTable.class},version = 1,exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public static final String db = "favourite_db";
    public static RoomDatabase instance;

    public static synchronized RoomDatabase getDB(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context,RoomDatabase.class,db)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract DAO dao();
}
