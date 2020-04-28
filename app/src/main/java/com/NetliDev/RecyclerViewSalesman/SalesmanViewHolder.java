package com.NetliDev.RecyclerViewSalesman;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NetliDev.R;

public class SalesmanViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView phone;
    public TextView email;
    public ImageView image;

    public SalesmanViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name_salesman);
        phone = itemView.findViewById(R.id.phone_salesman);
        email = itemView.findViewById(R.id.email_salesman);
        image = itemView.findViewById(R.id.background_image);
    }

}
