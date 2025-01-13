package com.example.food_recipes_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_recipes_app.Database.DatabaseTable;
import com.example.food_recipes_app.Database.RoomDatabase;
import com.example.food_recipes_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class Recipe_details extends Fragment {

    public Recipe_details() {
        // Required empty public constructor
    }

    ImageView detailImg;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    FloatingActionButton fBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_details, container, false);
        t1 = view.findViewById(R.id.textName);
        t2 = view.findViewById(R.id.cuisine);
        t3 = view.findViewById(R.id.difficulty);
        t4 = view.findViewById(R.id.rating);
        t5 = view.findViewById(R.id.prepTime);
        t6 = view.findViewById(R.id.cookTime);
        t7 = view.findViewById(R.id.calories);
        t8 = view.findViewById(R.id.textIngred);
        t9 = view.findViewById(R.id.textInstr);
        detailImg = view.findViewById(R.id.imageDetail);
        fBtn = view.findViewById(R.id.floatingActionButton);

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             RoomDatabase roomDatabase = RoomDatabase.getDB(getContext());
             String imageUrl = getArguments().getString("itemImg");
             roomDatabase.dao().addToFavourite(new DatabaseTable(t1.getText().toString(),imageUrl,t4.getText().toString(),t2.getText().toString(),t3.getText().toString()));
                Toast.makeText(getContext(), "Added to Favorite's", Toast.LENGTH_SHORT).show();
            }
        });

        t1.setText(getArguments().getString("itemName"));
        t2.setText("Cuisine : "+getArguments().getString("cuisine"));
        t3.setText("Difficulty : "+getArguments().getString("difficulty"));
        t4.setText("Rating : "+String.valueOf(getArguments().getFloat("rating")));
        t5.setText("PrepTime : "+String.valueOf(getArguments().getInt("prepTme")));
        t6.setText("PrepCook : "+String.valueOf(getArguments().getInt("prepCook")));
        t7.setText("Calories : "+String.valueOf(getArguments().getInt("calories")));
        t8.setText("Ingredients : "+getArguments().getString("ingredients"));
        t9.setText("Instructions : "+getArguments().getString("instructions"));
        Picasso.get().load(getArguments().getString("itemImg")).into(detailImg);

        return view;
    }
}