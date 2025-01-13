package com.example.food_recipes_app.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DAO {

    @Insert
    void addToFavourite(DatabaseTable databaseTable);

    @Delete
    void deleteFavorite(DatabaseTable databaseTable);

    @Query("select * from favourite_recipes")
    List<DatabaseTable> getAllFavourite();
}
