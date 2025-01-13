package com.example.food_recipes_app.Adapters;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.food_recipes_app.Database.DatabaseTable;
import com.example.food_recipes_app.Database.RoomDatabase;
import com.example.food_recipes_app.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteViewHolder> {

    List<DatabaseTable> fvtlist;

    public FavoriteAdapter(List<DatabaseTable> fvtlist) {
        this.fvtlist = fvtlist;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favoriterowlayout,parent,false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {

        DatabaseTable currentItem = fvtlist.get(position);

        holder.ft1.setText(currentItem.getName());
        holder.ft2.setText(currentItem.getCuisine());
        holder.ft3.setText(currentItem.getDifficulty());
        holder.ft4.setText(currentItem.getRating());
        Picasso.get().load(currentItem.getImage()).into(holder.fvtImage);

        holder.fvtCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.delImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                RoomDatabase roomDatabase = RoomDatabase.getDB(view.getContext());
                roomDatabase.dao().deleteFavorite(currentItem);
                fvtlist.remove(currentItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fvtlist.size();
    }

}
