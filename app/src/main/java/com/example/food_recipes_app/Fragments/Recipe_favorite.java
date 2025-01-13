package com.example.food_recipes_app.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.food_recipes_app.Adapters.FavoriteAdapter;
import com.example.food_recipes_app.Database.DatabaseTable;
import com.example.food_recipes_app.Database.RoomDatabase;
import com.example.food_recipes_app.R;
import java.util.List;

public class Recipe_favorite extends Fragment {


    public Recipe_favorite() {
        // Required empty public constructor
    }

    RecyclerView fvtRecview;
    FavoriteAdapter adapter;
   @SuppressLint("MissingInflatedId")
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_favorite, container, false);
        fvtRecview = view.findViewById(R.id.fvtRecview);
        fvtRecview.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchAllData();
        return view;
    }

    private void fetchAllData() {
        RoomDatabase roomDatabase = RoomDatabase.getDB(getContext());
        List<DatabaseTable> fvtList = roomDatabase.dao().getAllFavourite();
        adapter = new FavoriteAdapter(fvtList);
        fvtRecview.setAdapter(adapter);
    }

}