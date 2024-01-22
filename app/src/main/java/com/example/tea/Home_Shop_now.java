package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tea.Adapter.Home_Shop_Recycler_Adapter;
import com.example.tea.Model.Home_Shop_Recycler_Model;

import java.util.ArrayList;

public class Home_Shop_now extends AppCompatActivity {

    TextView latest_products,Featured_products,best_seller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_shop_now);

        latest_products = findViewById(R.id.latest_products);
        Featured_products = findViewById(R.id.Featured_products);
        best_seller = findViewById(R.id.best_seller);

        best_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Best_seller bestSeller = new Best_seller();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_recycler,bestSeller).commit();
            }
        });

        Featured_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Featured_Products  featuredProducts = new Featured_Products();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_recycler,featuredProducts).commit();
            }
        });
        latest_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Latest_Products latestProducts = new Latest_Products();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_recycler,latestProducts).commit();

            }
        });

    }
}