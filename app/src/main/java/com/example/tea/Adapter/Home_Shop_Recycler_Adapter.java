package com.example.tea.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tea.Model.Home_Shop_Recycler_Model;
import com.example.tea.R;

import java.util.ArrayList;

public class Home_Shop_Recycler_Adapter extends RecyclerView.Adapter<Home_Shop_Recycler_Adapter.ShopViewHolder> {

    ArrayList<Home_Shop_Recycler_Model> modelArrayList;

    public Home_Shop_Recycler_Adapter(ArrayList<Home_Shop_Recycler_Model> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_shop_list_items, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Home_Shop_Recycler_Model model = modelArrayList.get(position);

        holder.txt1.setText(model.getName());
        holder.txt2.setText(model.getPrice());

        Glide.with(holder.itemView.getContext())
                .load(model.getImageUrl())
                .into(holder.imageView1);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {

        TextView txt1,txt2;
        ImageView imageView1;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.product_name);
            txt2 = itemView.findViewById(R.id.product_price);
            imageView1 = itemView.findViewById(R.id.product_image);

        }
    }
}

