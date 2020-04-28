package com.NetliDev.RecyclerViewCategory;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView price;
    public ImageView image;
    private String mItem;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.food_name);
        price = itemView.findViewById(R.id.food_price);
        image = itemView.findViewById(R.id.background_image);
    }

    public void setItem(String item) {
        mItem = item;
    }
}

