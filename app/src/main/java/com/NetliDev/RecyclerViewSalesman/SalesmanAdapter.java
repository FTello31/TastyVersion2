package com.NetliDev.RecyclerViewSalesman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.Beans.Salesman;
import com.NetliDev.R;
import com.squareup.picasso.Picasso;

public class SalesmanAdapter extends RecyclerView.Adapter<SalesmanViewHolder> {

    public SalesmanAdapter() {
    }

    @NonNull
    @Override
    public SalesmanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_salesman, parent,false);
        return new SalesmanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesmanViewHolder holder, int position) {

        Salesman item = Salesman.SALESMAN_LIST.get(position);

        Picasso.get()
                .load(item.getIdImagen())
                .centerCrop()
                .fit()
                .into(holder.image);

        holder.name.setText(item.getname());
        holder.phone.setText("" + item.getphone());
        holder.email.setText(item.getEmail());

    }

    @Override
    public int getItemCount() {
        return Salesman.SALESMAN_LIST.size();
    }

}
