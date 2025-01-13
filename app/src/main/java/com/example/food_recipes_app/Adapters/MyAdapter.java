package com.example.food_recipes_app.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_recipes_app.Fragments.Recipe_details;
import com.example.food_recipes_app.Models.RecipesItem;
import com.example.food_recipes_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    List<RecipesItem> data;
    List<RecipesItem> backup;
    FragmentManager fm;

    public MyAdapter(List<RecipesItem> data, List<RecipesItem> backup, FragmentManager fm) {
        this.data = data;
        this.backup = backup;
        this.fm = fm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerowlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipesItem recipe = data.get(position);

        holder.text.setText(recipe.getName());
        Picasso.get().load(recipe.getImage()).into(holder.img);

        holder.cardView.setOnClickListener(view -> {
            Fragment fragment = new Recipe_details();
            Bundle bundle = new Bundle();
            bundle.putString("itemImg",recipe.getImage());
            bundle.putString("itemName",recipe.getName());
            bundle.putString("cuisine",recipe.getCuisine());
            bundle.putString("difficulty", recipe.getDifficulty());
            bundle.putFloat("rating",recipe.getRating());
            bundle.putInt("prepTme",recipe.getPrepTimeMinutes());
            bundle.putInt("prepCook",recipe.getCookTimeMinutes());
            bundle.putInt("calories",recipe.getCaloriesPerServing());
            bundle.putString("ingredients",recipe.getIngredients().toString());
            bundle.putString("instructions",recipe.getInstructions().toString());

            fragment.setArguments(bundle);

            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container,fragment);
            ft.addToBackStack(null);
            ft.commit();

        });
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            List<RecipesItem> filteredData = new ArrayList<>();
            if (keyword.toString().isEmpty())
                filteredData.addAll(backup);
            else {
                for (RecipesItem obj : backup){
                    if (obj.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filteredData.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<RecipesItem>)results.values);
            notifyDataSetChanged();
        }
    };
}
