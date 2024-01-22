package com.example.tea;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tea.Adapter.Home_Shop_Recycler_Adapter;
import com.example.tea.Model.Home_Shop_Recycler_Model;

import java.util.ArrayList;

public class Best_seller extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_best_seller, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle_best_seller);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Home_Shop_Recycler_Model> modelArrayList = new ArrayList<>();


        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/04/cinnamion-spice-400x533.png", "Winter Wellness Herbal Tea Kit","$15.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/06/hight-mountain-400x533.png", "High Mountain Oolong Tea","$16.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/05/matcha-latte-400x533.png", "Matcha Latte ","$15.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/05/matcha-1-400x533.png", "Matcha Latted Cafe Style","$40.00-$16.42"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/06/mountain-chai-400x533.png", "Mountain Chai Loose Leaf","$14.00-20.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/06/chai-400x533.png", "Chai Spiced Oolong Tea","$14.00 / month"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/04/tea-pink-400x533.png", "Rose Herbal Green Tea","$20.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/06/gift-thumbnail-2-400x533.jpg", "Glean Porcelian Teapot","$16.49"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/06/gift-400x533.png", "Gift Set Teapot","$16.49-$20.00"));
        modelArrayList.add(new Home_Shop_Recycler_Model("https://ochahouse.gavencreative.com/wp-content/uploads/2022/04/blend-400x533.png", "Chocolate vanilla Herbal Tea","$16.49"));


        Home_Shop_Recycler_Adapter adapter = new Home_Shop_Recycler_Adapter(modelArrayList);
        recyclerView.setAdapter(adapter);


        return view;
    }
}