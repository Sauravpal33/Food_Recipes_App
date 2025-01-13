package com.example.food_recipes_app.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_recipes_app.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView text;
    CardView cardView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img = (ImageView)itemView.findViewById(R.id.imageView);
        text = (TextView)itemView.findViewById(R.id.textView);
        cardView = (CardView)itemView.findViewById(R.id.cardView);
    }
}
