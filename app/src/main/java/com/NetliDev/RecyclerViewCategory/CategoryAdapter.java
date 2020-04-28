package com.NetliDev.RecyclerViewCategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.Beans.Food;
import com.NetliDev.R;
import com.NetliDev.RecyclerViewHome.HomeViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private final List<Food> items;

    public CategoryAdapter(List<Food> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_category, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//        Food item = Food.OfertasDelDia.get(position);
        Food item = items.get(position);

        Picasso.get()
                .load(item.getIdDrawable())
                .fit()
                .centerCrop()
                .into(holder.image);

        holder.name.setText(item.getNombre());
        holder.price.setText("S/." + item.getPrecio());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
