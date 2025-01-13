package com.example.food_recipes_app.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.food_recipes_app.API.ApiController;
import com.example.food_recipes_app.Models.Model;
import com.example.food_recipes_app.Models.RecipesItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListViewModel extends ViewModel {
    private final MutableLiveData<List<RecipesItem>> recipes = new MutableLiveData<>();
    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();
    public LiveData<List<RecipesItem>> getRecipes() {
        return recipes;
    }

    public LiveData<String> getErrorMessage() {
        return errorMsg;
    }

    public void fetchRecipes(){
        Call<Model> call = ApiController.getInstance().getApi().getRecipes();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful() && response.body() != null){
                    recipes.setValue(response.body().getRecipes());
                }else {
                    errorMsg.setValue("Failed to fetch");
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                errorMsg.setValue(t.getMessage());
            }
        });
    }
}
