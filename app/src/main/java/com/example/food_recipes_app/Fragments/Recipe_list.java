package com.example.food_recipes_app.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telephony.RadioAccessSpecifier;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.food_recipes_app.Adapters.MyAdapter;
import com.example.food_recipes_app.R;
import com.example.food_recipes_app.Models.RecipesItem;
import com.example.food_recipes_app.ViewModel.RecipeListViewModel;

import java.util.ArrayList;
import java.util.List;


public class Recipe_list extends Fragment {

    public Recipe_list() {
        // Required empty public constructor
    }

    RecyclerView recview;
    RecipeListViewModel viewModel;
    SearchView searchView;
    MyAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        recview = view.findViewById(R.id.recview);
        searchView = view.findViewById(R.id.searchView);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        viewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);
        viewModel.getRecipes().observe(getViewLifecycleOwner(),this::updateRecyclerView);
        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.fetchRecipes();

        return view;
    }
    private void updateRecyclerView(List<RecipesItem> recipes){
        adapter = new MyAdapter(recipes,new ArrayList<>(recipes),getParentFragmentManager());
        recview.setAdapter(adapter);
    }

}