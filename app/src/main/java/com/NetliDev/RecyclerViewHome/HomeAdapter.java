package com.NetliDev.RecyclerViewHome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.Beans.Food;
import com.NetliDev.Fragments.HomeFragment;
import com.NetliDev.R;
import com.squareup.picasso.Picasso;

/**
 * Adaptador para mostrar las comidas más pedidas en la sección "Inicio"
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>  {

    public HomeAdapter() {
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(eventRecyclerViewActivity.getBaseContext());
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_home, parent,false);

        return new HomeViewHolder(view);
//        View v = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.item_lista_inicio, viewGroup, false);
//        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder viewHolder, int position) {
        Food item = Food.OfertasDelDia.get(position);

        Picasso.get()
                .load(item.getIdDrawable())
                .fit()
                .centerCrop()
                .into(viewHolder.imagen);

        viewHolder.nombre.setText(item.getNombre());
        viewHolder.precio.setText("S/." + item.getPrecio());
    }

    @Override
    public int getItemCount() {
        return Food.OfertasDelDia.size();
    }
}
