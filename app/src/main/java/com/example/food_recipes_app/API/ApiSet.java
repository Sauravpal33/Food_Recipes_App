package com.example.food_recipes_app.API;

import com.example.food_recipes_app.Models.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {
    @GET("recipes")
    Call<Model> getRecipes();
}
