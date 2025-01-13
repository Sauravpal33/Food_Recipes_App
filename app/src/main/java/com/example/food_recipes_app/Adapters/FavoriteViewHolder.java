package com.example.food_recipes_app.Adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.food_recipes_app.R;

public class FavoriteViewHolder extends RecyclerView.ViewHolder {

    ImageView fvtImage,delImage;
    TextView ft1,ft2,ft3,ft4;
    CardView fvtCardView;
    public FavoriteViewHolder(@NonNull View itemView) {
        super(itemView);
        fvtImage = (ImageView)itemView.findViewById(R.id.fvtImg);
        delImage = (ImageView)itemView.findViewById(R.id.deleteImage);
        ft1 = (TextView)itemView.findViewById(R.id.fvtName);
        ft2 = (TextView)itemView.findViewById(R.id.fvtDiff);
        ft3 = (TextView)itemView.findViewById(R.id.fvtRating);
        ft4 = (TextView)itemView.findViewById(R.id.fvtCuisine);
        fvtCardView = (CardView)itemView.findViewById(R.id.fvtCardView);
    }
}
