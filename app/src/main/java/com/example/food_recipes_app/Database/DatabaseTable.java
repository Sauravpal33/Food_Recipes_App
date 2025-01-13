package com.example.food_recipes_app.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "favourite_recipes")
public class DatabaseTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "cuisine")
    private String cuisine;

    @ColumnInfo(name = "difficulty")
    private String difficulty;

    public DatabaseTable(int id, String name, String image, String rating, String cuisine, String difficulty) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.cuisine = cuisine;
        this.difficulty = difficulty;
    }

    @Ignore
    public DatabaseTable(String name, String image, String rating, String cuisine, String difficulty) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.cuisine = cuisine;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
