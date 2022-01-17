package com.example.colombopizza;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class menuAdapter extends RecyclerView.Adapter<menuAdapter.ViewHolder>{

    MenuData[] menuData;
    Context context;


    public menuAdapter(MenuData[] menuData,HomeActivity activity) {
        this.menuData= menuData;
        this.context=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.menu,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  MenuData menuDataList = menuData[position];
        holder.textViewName.setText(menuDataList.getPizzaName());
        holder.textViewPrice.setText(menuDataList.getPriceDisplay());
        holder.pizzaImage.setImageResource(menuDataList.getPizzaImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pizzaImage;
        TextView textViewName;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pizzaImage = itemView.findViewById(R.id.pizzaimage);
            textViewName=itemView.findViewById(R.id.pizzaName);
            textViewPrice=itemView.findViewById(R.id.pizzaPrice);
        }
    }
}

