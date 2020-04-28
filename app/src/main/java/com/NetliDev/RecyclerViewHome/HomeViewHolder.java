package com.NetliDev.RecyclerViewHome;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.R;

public class HomeViewHolder  extends RecyclerView.ViewHolder {

    // Campos respectivos de un item
    public TextView nombre;
    public TextView precio;
    public ImageView imagen;


    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre =  itemView.findViewById(R.id.food_name);
        precio =  itemView.findViewById(R.id.food_price);
        imagen =  itemView.findViewById(R.id.miniature_food);
    }

}
